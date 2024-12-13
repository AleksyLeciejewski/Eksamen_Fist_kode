package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginFrame() {
        super("Login");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Add logo
        ImageIcon icon = new ImageIcon("src/GUI/logoNoBG.png");
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setBounds(50, 10, 200, 100);
        add(logoLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 120, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 120, 160, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 160, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 160, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 200, 80, 25);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginManager LoginManager = new LoginManager();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // login logic here
                if (LoginManager.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    setVisible(false);
                    new InventoryFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials.");
                }
            }
        });

        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}