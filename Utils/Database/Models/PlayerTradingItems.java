package adam.playertrading.Utils.Database.Models;

public class PlayerTradingItems {
    private String uuid;
    private String item_needed;
    private int amount;
    private String item_received;

    public PlayerTradingItems(String uuid, String item_needed, int amount, String item_received) {
        this.uuid = uuid;
        this.item_needed = item_needed;
        this.amount = amount;
        this.item_received = item_received;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getItem_needed() {
        return item_needed;
    }

    public void setItem_needed(String item_needed) {
        this.item_needed = item_needed;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItem_received() {
        return item_received;
    }

    public void setItem_received(String item_received) {
        this.item_received = item_received;
    }

//    public String getItem_received() {
//        return item_received;
//    }
//
//    public void setItem_received(String item_received) {
//        this.item_received = item_received;
//    }
}
