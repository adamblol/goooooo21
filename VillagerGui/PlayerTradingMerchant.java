package adam.playertrading.VillagerGui;

import adam.playertrading.Utils.Database.GetTables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerTradingMerchant {
    public static Merchant playerTradingMerch(Player player) throws SQLException {
        Merchant merchant = Bukkit.createMerchant(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + " Trades");

        // get all trades
        ResultSet results = GetTables.findPlayerTradingItems(player.getUniqueId().toString());
        List<MerchantRecipe> recipes = new ArrayList<>();

        // for each trade we create a new trading thing
        while(results.next()) {
            MerchantRecipe recipe = new MerchantRecipe(new ItemStack(Material.getMaterial(results.getString("item_received"))), 1);
            recipe.addIngredient(new ItemStack(Material.getMaterial(results.getString("item_needed"))));
            recipes.add(recipe);
        }

        merchant.setRecipes(recipes);

        return merchant;
    }
}
