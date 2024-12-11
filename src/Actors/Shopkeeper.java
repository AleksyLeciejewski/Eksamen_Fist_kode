package Actors;

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
        return "Actors.Shopkeeper " +  shopKeeperId + "Shopkeepers Gold " + goldBalance;
    }


    public void addGold (double amount){
        this.goldBalance += amount;

        if ( amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        } this.goldBalance += amount;
        }

        public void removeGold (double amount){
        if (amount <= 0 || amount > this.goldBalance){
            throw new IllegalArgumentException("Amount must be greater than 0");
        } if (amount > this.goldBalance){
            throw new IllegalArgumentException("Not enough gold in balance");
            }
        this.goldBalance -= amount;
        }
}

