import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame(){
        this.setTitle("Inventory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);

        ImageIcon icon = new ImageIcon("src/logo.jpg");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.lightGray);
    }

}
