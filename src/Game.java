import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Game implements Runnable {
    private Player player;
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private Timer timer;

    public Game() throws IOException {
        this.player = new Player(1280 / 2, 720 / 2);
        this.gamePanel = new GamePanel(this.player);
        this.gameWindow = new GameWindow(gamePanel);

        startGameLoop();
    }

    public void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long count = 0;

        final int FPS_SET = 120;
        double timePerFrame = 1000000000 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while (true) {
            if (this.player.isMoveUp() && count % 16000 == 0 && this.player.getY() != 0){
                this.gamePanel.movePlayerUp();
                count = 0;
                gamePanel.repaint();
            }
            if (this.player.isMoveDown() && count % 16000 == 0 && this.player.getY() != 663){
                this.gamePanel.movePlayerDown();
                count = 0;
                gamePanel.repaint();
            }
            if (this.player.isMoveLeft() && count % 16000 == 0 && this.player.getX() != 0){
                this.gamePanel.movePlayerLeft();
                count = 0;
                gamePanel.repaint();
            }
            if (this.player.isMoveRight() && count % 16000 == 0 && this.player.getX() != 1246){
                this.gamePanel.movePlayerRight();
                count = 0;
                gamePanel.repaint();
            }


            if (count % 1000000 ==0)
                count = 0;

            count++;
            System.out.print("");
        }
    }
}

