package GUI;

import Items.Inventory;
import Items.Item;
import Items.ItemFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryFrame extends JFrame {

    JButton button1 = new JButton("Add Item");
    Inventory inventory = new Inventory(32, 0.0); // Create an instance of Items.Inventory

    public InventoryFrame() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.gray);
        buttonPanel.setBounds(0, 0, 800, 100);
        buttonPanel.setLayout(null);
        buttonPanel.add(button1);
        button1.setBounds(25, 25, 100, 50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        this.setTitle("Items.Inventory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);
        this.add(buttonPanel);

        ImageIcon icon = new ImageIcon("src/logo.jpg");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.lightGray);
        this.setVisible(true);
    }

    // Method to add an item to the inventory
    private void addItem() {
        Item randomItem = ItemFactory.getRandomItem(); // Get a random item
        inventory.addItem(randomItem);
        System.out.println("Random item added to inventory: " + randomItem.getName());
    }
}
