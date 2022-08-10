package adam.playertrading.Utils.Database;

import adam.playertrading.Utils.Database.Models.PlayerTradingCreated;
import adam.playertrading.Utils.Database.Models.PlayerTradingItems;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatePlayerTrading {
    public static void createPlayerTradingCreated(PlayerTradingCreated stats) throws SQLException {
        PreparedStatement statement = Database.connectToDatabase().prepareStatement("INSERT INTO player_trading_created(uuid) VALUES (?)");
        statement.setString(1, stats.getUuid());

        // create the table
        statement.executeUpdate();

        statement.close();
    }

    public static void createPlayerTradingItems(PlayerTradingItems stats) throws SQLException {
        PreparedStatement statement = Database.connectToDatabase().prepareStatement("INSERT INTO player_trading_items(uuid, item_needed, amount, item_received) VALUES (?, ?, ?, ?)");
        statement.setString(1, stats.getUuid());
        statement.setString(2, stats.getItem_needed());
        statement.setInt(3, stats.getAmount());
        statement.setString(4, stats.getItem_received());

        // create the table
        statement.executeUpdate();

        statement.close();
    }
}
