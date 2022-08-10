package adam.playertrading.VillagerGui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class TestGui {
    public static Merchant ss() {
        Merchant merchant = Bukkit.createMerchant("Test");

        MerchantRecipe recipe = new MerchantRecipe(new ItemStack(Material.WOODEN_AXE), 3);
        recipe.addIngredient(new ItemStack(Material.DIAMOND));

        List<MerchantRecipe> recipes = new ArrayList<>();
        recipes.add(recipe);
        merchant.setRecipes(recipes);

        return merchant;
    }
}
