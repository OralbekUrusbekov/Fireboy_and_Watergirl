package GameCode;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface MovementStrategy {
    void move(Player player);
    void keyPressed(Player player, KeyEvent e);
    void keyReleased(Player player, KeyEvent e);
    Image getImage();
}