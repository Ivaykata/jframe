import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame{
    public GameWindow(GamePanel gamePanel) {

        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
         gamePanel.setBackground(new Color(26,29,36));
        System.out.println(getBackground());
        add(gamePanel);

        setVisible(true);

    }
}