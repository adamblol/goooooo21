package adam.playertrading.Inventory;

import adam.playertrading.Utils.Database.GetTables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerTradeItems {
    public static Inventory inventoryTradeItems(Player player) throws SQLException {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.RED + "Items for Sale");

        ItemStack createItem = new ItemStack(Material.OAK_SIGN);
        ItemMeta createItemMeta = createItem.getItemMeta();
        createItemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Create An Item");
        createItem.setItemMeta(createItemMeta);

        // for each receipe add a new "EMERALD" icon
        ResultSet results = GetTables.findPlayerTradingItems(player.getUniqueId().toString());


        int counter = 0;
        while(results.next()) {
            ItemStack em = new ItemStack(Material.EMERALD);
            ItemMeta emMeta = em.getItemMeta();
            int tradeCount = counter + 1;
            emMeta.setDisplayName(ChatColor.YELLOW + "Trade #" + tradeCount);
            em.setItemMeta(emMeta);
            inventory.setItem(counter, em);
            counter++;
        }

        inventory.setItem(49, createItem);

        return inventory;
    }
}
