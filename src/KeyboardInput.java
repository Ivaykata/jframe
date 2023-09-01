
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    private Player player;
    private  GamePanel panel;
    public KeyboardInput(GamePanel panel, Player player) {
        this.player = player;
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            this.player.setMoveUp(true);
        }
        if (key == KeyEvent.VK_S) {
            this.player.setMoveDown(true);
        }
        if (key == KeyEvent.VK_A) {
            this.player.setMoveLeft(true);
        }
        if (key == KeyEvent.VK_D) {
            this.player.setMoveRight(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            this.player.setMoveUp(false);
        }
        if (key == KeyEvent.VK_S) {
            this.player.setMoveDown(false);
        }
        if (key == KeyEvent.VK_A) {
            this.player.setMoveLeft(false);
        }
        if (key == KeyEvent.VK_D) {
            this.player.setMoveRight(false);
        }

        if (key == KeyEvent.VK_SPACE) {
            player.setLick(true);
        }
    }
}
