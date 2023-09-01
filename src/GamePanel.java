import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {


    private Player player;

    public GamePanel(Player player) {
        this.player = player;
        addKeyListener(new KeyboardInput(this, player));

        setFocusable(true);
        requestFocusInWindow();

        //moveObj();
        player.setPanel(this);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.drawImage(this.player.getPlayerImage(), this.player.getX(),this.player.getY(), this);
    }

    public void movePlayerUp() {
        this.player.setY(this.player.getY() - this.player.getPlSpeed());
    }
    public void movePlayerDown() {
        this.player.setY(this.player.getY() + this.player.getPlSpeed());
    }
    public void movePlayerLeft() {
        this.player.setX(this.player.getX() - this.player.getPlSpeed());
    }
    public void movePlayerRight() {
        this.player.setX(this.player.getX() + this.player.getPlSpeed());
    }
}