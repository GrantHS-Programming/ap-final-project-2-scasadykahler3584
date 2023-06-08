import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class PongFrame extends JFrame    {
    PongPanel panel = new PongPanel();
    PongFrame(){
        panel = new PongPanel();
        this.add(panel);
        this.setTitle("pong game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
