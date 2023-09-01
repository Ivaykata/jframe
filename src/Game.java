import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.*;

public class Game implements Runnable {
    private Player player;
    private List<Fly> flies;
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private Timer timer;

    public Game() throws IOException {
        this.player = new Player(1280 / 2, 720 / 2);
        this.flies = new ArrayList<>();
        this.gamePanel = new GamePanel(this.player, flies);
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

        while (true) {
            //makes the frog move and doesn`t give alow the frog to leav the screan
            //uper wall
            if (this.player.isMoveUp() && count % 18000 == 0 && this.player.getY() != -20){
                this.gamePanel.movePlayerUp();
                count = 0;
                gamePanel.repaint();
            }
            //lower wall
            if (this.player.isMoveDown() && count % 18000 == 0 && this.player.getY() != 623){
                this.gamePanel.movePlayerDown();
                count = 0;
                gamePanel.repaint();
            }
            //left wall
            if (this.player.isMoveLeft() && count % 18000 == 0 && this.player.getX() != -10){
                this.gamePanel.movePlayerLeft();
                count = 0;
                gamePanel.repaint();
            }
            //right wall
            if (this.player.isMoveRight() && count % 18000 == 0 && this.player.getX() != 1206){
                this.gamePanel.movePlayerRight();
                count = 0;
                gamePanel.repaint();
            }

            if (player.isLick()) {
                for (int i = 0; i < flies.size(); i++)
                    flies.get(i).calculateDistanceFromFrom();

                Collections.sort(flies, Comparator.comparing(Fly::getDistanseFromFrog));

                gamePanel.setFrogLick(true);
                gamePanel.setClosestFly(0);

                gamePanel.repaint();

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                gamePanel.getFlies().remove(0);

                player.setLick(false);
                gamePanel.setFrogLick(false);

                gamePanel.repaint();
            }


            if (count % 1000000 ==0)
                count = 0;

            count++;
            System.out.print("");
        }
    }
}

