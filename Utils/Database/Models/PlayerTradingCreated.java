package adam.playertrading.Utils.Database.Models;

public class PlayerTradingCreated {
    private String uuid;

    public PlayerTradingCreated(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
