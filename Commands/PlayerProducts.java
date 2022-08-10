package adam.playertrading.Commands;

import adam.playertrading.Inventory.PlayerTradeItems;
import adam.playertrading.Main;
import adam.playertrading.Utils.Database.GetTables;
import adam.playertrading.Utils.Database.Models.PlayerTradingCreated;
import adam.playertrading.VillagerGui.TestGui;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class PlayerProducts implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player;

        if(sender instanceof Player) {
            player = (Player) sender;
        } else {
            return true;
        }

        // check to see if they exist if not then create a table
        PlayerTradingCreated ifCreated;
        try {
            ifCreated = GetTables.findPlayerTradingCreated(player.getUniqueId().toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(ifCreated == null) {
            player.sendMessage(ChatColor.RED + "You havent created a trading merchant yet");
            player.sendMessage(ChatColor.RED + "Creating one for you");
            ifCreated = new PlayerTradingCreated(player.getUniqueId().toString());
            try {
                Main.plugin.getDatabase().returnCreatePlayerTradingCreated(ifCreated);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            player.sendMessage(ChatColor.GREEN + "Merchant created. Rerun the command");
            return true;
        }

        try {
            player.openInventory(PlayerTradeItems.inventoryTradeItems(player));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
