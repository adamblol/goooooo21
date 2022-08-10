package adam.playertrading.Utils.Database;

import adam.playertrading.Utils.Database.Models.PlayerTradingCreated;
import adam.playertrading.Utils.Database.Models.PlayerTradingItems;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTables {
    public static PlayerTradingCreated findPlayerTradingCreated(String uuid) throws SQLException {

        PreparedStatement statement = Database.connectToDatabase().prepareStatement("SELECT * FROM player_trading_created WHERE uuid = ?");
        statement.setString(1, uuid);

        ResultSet results = statement.executeQuery();

        if(results == null) {
            return null;
        }

        if(results.next()) {
            PlayerTradingCreated stats = new PlayerTradingCreated(uuid);
            statement.close();
            return stats;
        }

        return null;
    }

    public static ResultSet findPlayerTradingItems(String uuid) throws SQLException {

        PreparedStatement statement = Database.connectToDatabase().prepareStatement("SELECT * FROM player_trading_items WHERE uuid = ?");
        statement.setString(1, uuid);

        ResultSet results = statement.executeQuery();

        if(results == null) {
            return null;
        }

        return results;
    }
 }
