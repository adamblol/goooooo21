package adam.playertrading.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
lapis
coal
iron
gold
redstone
diamond
emerald
netherrite

total - 8 (for now)
 */

public class ChoseOrePage {
    public static Inventory choseOreInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, ChatColor.AQUA + "" + ChatColor.BOLD + "Chose Your Ore");

        ItemStack lapis = new ItemStack(Material.LAPIS_LAZULI);
        ItemStack coal = new ItemStack(Material.COAL);
        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemStack redstone = new ItemStack(Material.REDSTONE);
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemStack nether = new ItemStack(Material.NETHERITE_INGOT);

        ItemMeta lapisMeta = lapis.getItemMeta();
        ItemMeta coalMeta = coal.getItemMeta();
        ItemMeta ironMeta = iron.getItemMeta();
        ItemMeta goldMeta = gold.getItemMeta();
        ItemMeta redstoneMeta = redstone.getItemMeta();
        ItemMeta diamondMeta = diamond.getItemMeta();
        ItemMeta emeraldMeta = emerald.getItemMeta();
        ItemMeta netherMeta = nether.getItemMeta();

        lapisMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cick to set ore to lapis");
        coalMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cick to set ore to coal");
        ironMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cick to set ore to iron");
        goldMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cick to set ore to gold");
        redstoneMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cick to set ore to redstone");
        diamondMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cick to set ore to diamond");
        emeraldMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cick to set ore to emerald");
        netherMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cick to set ore to netherite");

        lapis.setItemMeta(lapisMeta);
        coal.setItemMeta(coalMeta);
        iron.setItemMeta(ironMeta);
        gold.setItemMeta(goldMeta);
        redstone.setItemMeta(redstoneMeta);
        diamond.setItemMeta(diamondMeta);
        emerald.setItemMeta(emeraldMeta);
        nether.setItemMeta(netherMeta);

        inventory.setItem(0, lapis);
        inventory.setItem(1, coal);
        inventory.setItem(2, iron);
        inventory.setItem(3, gold);
        inventory.setItem(4, redstone);
        inventory.setItem(5, diamond);
        inventory.setItem(6, emerald);
        inventory.setItem(7, nether);

        return inventory;
    }
}
