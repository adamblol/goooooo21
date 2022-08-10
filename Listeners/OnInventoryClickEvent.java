package adam.playertrading.Listeners;

import adam.playertrading.Inventory.ChoseOrePage;
import adam.playertrading.Inventory.CreatingItemInventory;
import adam.playertrading.Inventory.PlayerTradeItems;
import adam.playertrading.Utils.Database.CreatePlayerTrading;
import adam.playertrading.Utils.Database.Models.PlayerTradingItems;
import adam.playertrading.Utils.InventoryClicks.ChoseYourOreClicks;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.SQLException;

public class OnInventoryClickEvent implements Listener {
    @EventHandler
    public void InventoryClick(InventoryClickEvent event) throws SQLException {

        Player player = (Player) event.getWhoClicked();

        // add this so we can take shit out of the bottom inventory
        if(event.getClickedInventory() != event.getView().getTopInventory()) {
            return;
        }

        if(ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Items for Sale")) {
            event.setCancelled(true);
            // if clicked on create item
            if(event.getSlot() == 49) {
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.DIAMOND)));
                return;
            }
        }

//        // creating a product page
        if(ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Creating A Product")) {
            // the slot to place items in
            if(event.getSlot() == 22) {
                return;
            }

            event.setCancelled(true);
            // if clicked on change ore
            if(event.getSlot() == 39) {
                player.openInventory(ChoseOrePage.choseOreInventory(player));
                return;
            }

            // if clicked on the increase amount
            if(event.getSlot() == 41) {
                int currentPrice = event.getInventory().getItem(41).getAmount();
                ItemStack amountOfOreNeeded = new ItemStack(Material.SNOWBALL, currentPrice + 1);
                ItemMeta amountMeta = amountOfOreNeeded.getItemMeta();
                amountMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Click on this to increase the price");
                amountOfOreNeeded.setItemMeta(amountMeta);
                event.getInventory().setItem(41, amountOfOreNeeded);
                return;
            }

            // if clicked on finish product
            if(event.getSlot() == 49) {
                if(event.getInventory().getItem(22) == null) {
                    player.sendMessage(ChatColor.RED + "You have to put in a item");
                    return;
                }

                // if item now get the basic information
                String uuid = player.getUniqueId().toString();
                int price = event.getInventory().getItem(41).getAmount();
                String ore = event.getInventory().getItem(39).getType().toString();
                String itemGiven = event.getInventory().getItem(22).getType().toString();

                // add to database
                PlayerTradingItems stats = new PlayerTradingItems(uuid, ore, price, itemGiven);
                CreatePlayerTrading.createPlayerTradingItems(stats);
                player.closeInventory();
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Your item has now been created.");
                return;
            }
        }

        // chosing ur ore page
        if(ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Chose Your Ore")) {
            event.setCancelled(true);
            ChoseYourOreClicks.choseOre(event.getSlot(), player);
            return;
        }
    }
}
