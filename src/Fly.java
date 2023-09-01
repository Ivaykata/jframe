import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fly {
    private int x;
    private int y;
    private int distanseFromFrog;
    private BufferedImage FlyImage;

    private Player player;

    public Fly(int x, int y, Player player)  throws IOException {
        this.x = x;
        this.y = y;
        this.player = player;

        this.FlyImage = ImageIO.read(new File("resources/images/fly1.png"));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDistanseFromFrog() {
        return distanseFromFrog;
    }

    public BufferedImage getFlyImage() {
        return FlyImage;
    }

    public void calculateDistanceFromFrom() {
        this.distanseFromFrog = (int) Math.floor(Math.sqrt(
                Math.pow((this.x - this.player.getX()), 2) +
                Math.pow(this.y - this.player.getY(), 2)));
    }
}
