package GUI;
import Items.Inventory;
import Items.Item;
import Items.ItemFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryFrame extends JFrame {

    JButton addItemButton = new JButton("Add Item");
    JButton removeItemButton = new JButton("Remove Item");
    JButton addSlotButton = new JButton("Add Slot");
    Inventory inventory = new Inventory(32, 0.0); // Create an instance of Items.Inventory

    public InventoryFrame() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.gray);
        buttonPanel.setBounds(0, 0, 900, 100);
        buttonPanel.setLayout(null);
        buttonPanel.add(addItemButton);
        buttonPanel.add(removeItemButton);
        buttonPanel.add(addSlotButton);
        addItemButton.setBounds(150, 25, 100, 50);
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });
        removeItemButton.setBounds(400, 25, 100, 50);
        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemBySlot();
            }


        });

        addSlotButton.setBounds(650, 25, 100, 50);

        this.setTitle("Inventory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setResizable(false);
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
//
//    private void removeItem() {
//        try {
//            int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Account Number to be deleted:"));
//            repository.deleteAccounts(accountNumber);
//            JOptionPane.showMessageDialog(null, "Account has been deleted!");
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid account number.");
//        }
//    }
}
