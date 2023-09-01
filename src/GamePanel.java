import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {


    private Player player;
    private List<Fly> flies;
    private boolean frogLick = false;
    private int closestFly;
    private final Random random = new Random();
    public GamePanel(Player player, List<Fly> flies) throws IOException {
        this.player = player;
        this.flies = flies;
        for(int i = 0; i < 10; i++){
            this.flies.add(new Fly(random.nextInt(1230), random.nextInt(640), player));
        }
        addKeyListener(new KeyboardInput(this, player));

        setFocusable(true);
        requestFocusInWindow();

        player.setPanel(this);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.player.getPlayerImage(), this.player.getX(),this.player.getY(), this);

        flies.forEach(element -> {
            g.drawImage(element.getFlyImage(), element.getX(), element.getY(), this);
        });

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(255, 34, 96));

        Stroke oldStroke = g2d.getStroke();
        float lineWight = 10;

        g2d.setStroke(new BasicStroke(lineWight));

        if (this.frogLick) {
            g2d.draw(new Line2D.Double(player.getX() + 15, player.getY() + 35, flies.get(closestFly).getX() + 35, flies.get(closestFly).getY() + 35));
        }

        g2d.setStroke(oldStroke);
    }

    public List<Fly> getFlies() {
        return flies;
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

    public boolean isFrogLick() {
        return frogLick;
    }

    public void setFrogLick(boolean frogLick) {
        this.frogLick = frogLick;
    }

    public void setClosestFly(int closestFly) {
        this.closestFly = closestFly;
    }
}