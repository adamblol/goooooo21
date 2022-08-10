package adam.playertrading.Commands;

import adam.playertrading.Utils.Database.GetTables;
import adam.playertrading.VillagerGui.PlayerTradingMerchant;
import adam.playertrading.VillagerGui.TestGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerTrade implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player;

        if(sender instanceof Player) {
            player = (Player) sender;
        } else {
            return true;
        }

        if(args.length != 1) {
            player.sendMessage(ChatColor.RED + "Provide a username of the player you want to trade with");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if(target == null) {
            player.sendMessage(ChatColor.RED + "The username you provided is either offline or doesnt exist");
            return true;
        }

        // if online check if they have 0 items
        ResultSet results;
        try {
            results = GetTables.findPlayerTradingItems(target.getUniqueId().toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // no trades available
        try {
            if(!results.next()) {
                player.sendMessage(ChatColor.RED + "The user " + target.getDisplayName() + " has no available trades.");
                player.sendMessage(ChatColor.RED + "Check back at a later time");
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // if exist and online open up villager menu w the guys stuff
        try {
            player.openMerchant(PlayerTradingMerchant.playerTradingMerch(target), true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
