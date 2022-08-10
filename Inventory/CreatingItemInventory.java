package adam.playertrading.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
rn its only ores but make inventory so they can do block aswell
*/

public class CreatingItemInventory {
    public static Inventory createItemInventory(ItemStack ore) {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Creating A Product");

        // 0-0
        for(int i = 0; i < 54; i++) {
            if(i != 22 && i != 39 && i != 41 && i != 49) {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
        }

        ItemStack finishProduct = new ItemStack(Material.OAK_SIGN);
        ItemMeta oreMeta = ore.getItemMeta();
        ItemMeta finishProductMeta = finishProduct.getItemMeta();

        // the amount
        ItemStack amountOfOreNeeded = new ItemStack(Material.SNOWBALL, 1);
        ItemMeta amountMeta = amountOfOreNeeded.getItemMeta();

        oreMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click To Change Ore");
        finishProductMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Finish Product");
        amountMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Click on this to increase the price");

        ore.setItemMeta(oreMeta);
        finishProduct.setItemMeta(finishProductMeta);
        amountOfOreNeeded.setItemMeta(amountMeta);

        inventory.setItem(39, ore);
        inventory.setItem(49, finishProduct);
        inventory.setItem(41, amountOfOreNeeded);

        return inventory;
    }
}
