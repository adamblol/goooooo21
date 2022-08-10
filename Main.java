package adam.playertrading;

import adam.playertrading.Commands.PlayerProducts;
import adam.playertrading.Commands.PlayerTrade;
import adam.playertrading.Listeners.OnInventoryClickEvent;
import adam.playertrading.Utils.Database.CreateTables;
import adam.playertrading.Utils.Database.Database;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

import static adam.playertrading.Utils.Database.Database.connectToDatabase;

/*
ideas for this
connect to sql database and store all shit there (done)
they run /myproducts if and it dont exist send a msg and create one (done)
then open gui (done)
creating a product page (done)
w their products and onclick of that product get the information like (price, amount, and item received on purchase) (done)
then add to database (done)
then
they run /playertrade <username> (done)
if player has no products return a message (done)
otherwise
when click on emerald inside "my products" make a new gui to prompt saying would you like to remove this item YES/NO (CBA TO DO)

on price increase do (Price: 1)
find a way to set the amount needed on the trade gui
make a way to send the user who the player bought off a msg once a trade is made
make it remove the item once they bought it idk how yet

bugs -
whenever i click on non custom inventory it doesnt let me click it cancels find a way to fis (FIXED)
if i put a item on the slot then go to change ore inventory the item doesnt stay to fix that
 */

public final class Main extends JavaPlugin {

    public static Main plugin;

    public Database getDatabase() {
        return database;
    }

    private Database database;


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Player Trading Plugin Loaded");

        plugin = this;

        // connect to database
        try {
            this.database = new Database();
            CreateTables.createAllTables();
        } catch (SQLException e) {
            System.out.println("Unable to connect to database");
            throw new RuntimeException(e);
        }

        getServer().getPluginManager().registerEvents(new OnInventoryClickEvent(), this);
//        getServer().getPluginManager().registerEvents(new OnVillagerTradeEvent(), this);

        getCommand("myproducts").setExecutor(new PlayerProducts());
        getCommand("playertrade").setExecutor(new PlayerTrade());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Player Trading Plugin Disabled");
    }
}
