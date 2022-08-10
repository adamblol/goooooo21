package adam.playertrading.Utils.Database;

import adam.playertrading.Utils.Database.Models.PlayerTradingCreated;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;

    // create the actual connection to the database
    public static Connection connectToDatabase() throws SQLException {

        // means already has a connection
        if(connection != null) {
            return connection;
        }

        // connect to MYSQL database
        String url = "jdbc:mysql://localhost:3306/player_trading";
        String user = "root";
        String password = "adamb213";

        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to database");

        return connection;
    }

    public void returnCreatePlayerTradingCreated(PlayerTradingCreated stats) throws SQLException {
        CreatePlayerTrading.createPlayerTradingCreated(stats);
    }
}
