package adam.playertrading.Utils.Database;

/*
uuid - item needed - amount needed - item received on purchase
 */

import java.sql.SQLException;
import java.sql.Statement;

import static adam.playertrading.Utils.Database.Database.connectToDatabase;

public class CreateTables {

    public static void createAllTables() throws SQLException {
        createPlayerTrading();
        createPlayersAbleToTrade();
    }

    public static void createPlayerTrading() throws SQLException {
        String playerStatsTable = "CREATE TABLE IF NOT EXISTS player_trading_items(uuid varchar(36), item_needed varchar(36), amount int, item_received varchar(36))";

        // make a table
        Statement statement = connectToDatabase().createStatement();
        statement.execute(playerStatsTable);
    }

    public static void createPlayersAbleToTrade() throws SQLException {
        String playerStatsTable = "CREATE TABLE IF NOT EXISTS player_trading_created(uuid varchar(36))";

        // make a table
        Statement statement = connectToDatabase().createStatement();
        statement.execute(playerStatsTable);
    }
}
