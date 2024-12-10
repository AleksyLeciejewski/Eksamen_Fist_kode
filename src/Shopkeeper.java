public class Shopkeeper {

    private String shopKeeperId;
    private Double goldBalance = 0.0;

    public Shopkeeper(String shopKeeperId, Double goldBalance) {
        this.shopKeeperId = shopKeeperId;
        this.goldBalance = goldBalance;
    }

    public String getShopKeeperId(){
        return shopKeeperId;
    }
    public void setShopKeeperId(){
        this.shopKeeperId = shopKeeperId;
    }
    public Double getGoldBalance(){
        return goldBalance;
    }
    public void setGoldBalance(){
        this.goldBalance = goldBalance;
    }
    @Override
    public String toString(){
        return "Shopkeeper " +  shopKeeperId + "Shopkeepers Gold " + goldBalance;
    }

}
