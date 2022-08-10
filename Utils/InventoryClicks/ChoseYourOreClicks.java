package adam.playertrading.Utils.InventoryClicks;

import adam.playertrading.Inventory.CreatingItemInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

        /*
lapis
coal
iron
gold
redstone
diamond
emerald
netherrite

         */

public class ChoseYourOreClicks {
    public static void choseOre(int slot, Player player) {
        switch (slot) {
            case 0:
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.LAPIS_LAZULI)));
                break;
            case 1:
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.COAL)));
                break;
            case 2:
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.IRON_INGOT)));
                break;
            case 3:
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.GOLD_INGOT)));
                break;
            case 4:
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.REDSTONE)));
                break;
            case 5:
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.DIAMOND)));
                break;
            case 6:
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.EMERALD)));
                break;
            case 7:
                player.openInventory(CreatingItemInventory.createItemInventory(new ItemStack(Material.NETHERITE_INGOT)));
                break;
            case 8:
                // null
                break;
        }
    }
}
