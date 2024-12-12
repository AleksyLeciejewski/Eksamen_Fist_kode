package Items;

import java.util.Scanner;

public abstract class Item {

  public Item(String name,int itemID,double weight,boolean isStackable,int maxStack, double price, String ItemType){
    this.itemID = itemID;
    this.isStackable = isStackable;
    this.name = name;
    this.weight = weight;
    this.maxStack = maxStack;
    this.price = price;
    this.ItemType = ItemType;
  }
  private String ItemType;
  private double price;
  private int itemID;
  private String name;
  private double weight;
  private boolean isStackable;
  private int maxStack;

  Scanner brugerinput = new Scanner(System.in);

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isStackable() {
        if(isStackable == false){
            setMaxStack(1);
        }
        return false;
    }

    public void setStackable(boolean stackable) {
        isStackable = stackable;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }


    //Forslag: set boolean = false som standard, og override til true i subklasserne, hvis nødvendigt


    public String toString() {
        return String.format("name: %s, maxStack: %d, weight: %f, isStackable: %b",
                name, maxStack, weight, isStackable);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemType() {
        return ItemType;
    }
}



