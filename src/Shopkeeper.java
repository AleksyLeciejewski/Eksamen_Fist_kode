public class Shopkeeper {

    private int shopKeeperID;
    private double goldBalance;

    public Shopkeeper(int shopKeeperID, double goldBalance) {
        this.shopKeeperID = shopKeeperID;
        this.goldBalance = goldBalance;
    }
    public int getShopKeeperID() {
        return shopKeeperID;
    }
    public double getgoldBalance() {
        return goldBalance;
    }
    public void setShopKeeperID(int shopkeeperID){
        this.shopKeeperID=shopkeeperID;
    }
    public void setGoldBalance(double goldBalance){
        this.goldBalance=goldBalance;
    }

    @Override
    public String toString(){
        return "Shopkeeper ID: " + shopKeeperID + ", Gold Balance:" + goldBalance;
    }
}
