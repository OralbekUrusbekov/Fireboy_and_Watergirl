import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Pool extends Rectangle{

    public static final int POOL_DEPTH = 10;
    public int length, type;
    public int startX, startY;
    String filePath;
    Image pool;

    public Pool(int startX, int startY, int length, int type) {
        super(startX, startY, length, POOL_DEPTH);
        this.type = type;

        if(type == 0) filePath = "../Images/Acid.png";
        else if(type == 1) filePath = "../Images/Lava.png";
        else filePath = "../Images/Water.png";

        pool = new ImageIcon(filePath).getImage();
        pool = pool.getScaledInstance(length, 10, Image.SCALE_DEFAULT);


        this.startX = startX;
        this.startY = startY;
        this.length = length;
    }

    public void draw(Graphics g) {
        g.drawImage(pool, x, y, null);
    }
}