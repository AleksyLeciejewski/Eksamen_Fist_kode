package GUI;

import Items.Inventory;
import Items.Item;
import Items.ItemFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShopkeeperFrame extends JFrame {
    JButton inventoryButton = new JButton("Inventory");
    JButton sellItemButton = new JButton("Sell Item");
    JButton buyItemButton = new JButton("Buy Item");
    
    public ShopkeeperFrame() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.gray);
        buttonPanel.setBounds(0, 0, 900, 100);
        buttonPanel.setLayout(null);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(buyItemButton);
        buttonPanel.add(sellItemButton);

        inventoryButton.setBounds(150, 25, 100, 50);
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new InventoryFrame();
            }
        });

        buyItemButton.setBounds(400, 25, 100, 50);
        buyItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyItem();
            }
        });

        sellItemButton.setBounds(650, 25, 100, 50);
        sellItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemBySlot();
            }
        });

        this.setTitle("Shopkeeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.add(buttonPanel);

        ImageIcon icon = new ImageIcon("src/GUI/logoNoBG.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.lightGray);
        this.setLocationRelativeTo(null); // Center the frame
        this.setVisible(true);

    }

    private void buyItem() {
        Item randomItem = ItemFactory.getRandomItem(); // Get a random item
        Inventory.addItem(randomItem);
        System.out.println("Random item added to inventory: " + randomItem.getName());
    }

    private void removeItemBySlot() {
        try {
            int slot = Integer.parseInt(JOptionPane.showInputDialog("Slot number to be deleted:"));
            Inventory.removeItemBySlot(slot);
            JOptionPane.showMessageDialog(null, "Item has been deleted!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid slot.");
        }
    }
}
