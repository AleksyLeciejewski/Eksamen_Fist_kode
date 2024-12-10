package Actors;

public class PlayerID {
    private int playerID;
    private String characterName;
    private double goldBalance;
    private double maxWeight;
    private int level;

    public PlayerID (int playerID, String characterName, double goldBalance, double maxWeight, int level) {
        this.playerID =playerID;
        this.characterName=characterName;
        this.goldBalance=goldBalance;
        this.maxWeight=maxWeight;
        this.level=level;
    }
    public void setLevel() {
        this.level=level;
    }
    public int getLevel() {
        return level;
    }

    public double getGoldBalance(){
        return goldBalance;
    }
    public void setGoldBalance(double goldBalance){
        this.goldBalance=goldBalance;
    }
    public double getMaxWeight(){
        return maxWeight;
    }
    public void setMaxWeight(double maxWeight){
        this.maxWeight=maxWeight;
    }

    public void addExp(int exp){
        if (exp > 0) {
            System.out.println(" Spilleren har fået " + exp + " XP");
        }else {
            System.out.println("Xp skal vær positivt");
        }

        }
    @Override
    public String toString() {
        return "Here is " + characterName+ ", your level is " + level+ ", you have " + goldBalance + " gold, and a max weight of " + maxWeight + ";";
    }
    }


