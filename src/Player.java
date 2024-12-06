public class Player {

    private int playerID;
    private String characterName;
    private double goldbalance;
    private double maxWeight;
    private int level;
    private double addexp;

    public Player(int playerID, String characterName, double goldbalance, double maxWeight, int level, double addexp) {
        this.playerID = playerID;
        this.characterName = characterName;
        this.goldbalance = goldbalance;
        this.maxWeight = maxWeight;
        this.level = level;
        this.addexp = 0;
    }

    public int getPlayerID() {
        return playerID;
    }
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

}
