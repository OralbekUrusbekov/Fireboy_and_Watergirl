package GameCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

// Fireboy Strategy with Command Pattern
public class FireboyMovementStrategy implements MovementStrategy {
    private Image image;
    private MoveLeftCommand moveLeft;
    private MoveRightCommand moveRight;
    private JumpCommand jump;
    private StopCommand stop;

    public FireboyMovementStrategy() {
        image = new ImageIcon("./Images/Fireboy.png").getImage();
        moveLeft = new MoveLeftCommand(Player.HorizontalSPEED + 2);
        moveRight = new MoveRightCommand(Player.HorizontalSPEED + 2);
        jump = new JumpCommand(Player.VerticalSPEED);
        stop = new StopCommand();
    }

    @Override
    public void move(Player player) {
        player.y += player.yVelocity;
        if (player.yVelocity >= 2) player.inAir = true;
        player.yVelocity++;
        player.x += player.xVelocity;
    }

    @Override
    public void keyPressed(Player player, KeyEvent e) {
        if (e.getKeyCode() == player.leftButton || e.getKeyChar() == player.leftButton) {
            moveLeft.setPlayer(player);
            moveLeft.execute();
        }
        if (e.getKeyCode() == player.rightButton || e.getKeyChar() == player.rightButton) {
            moveRight.setPlayer(player);
            moveRight.execute();
        }
        if (e.getKeyCode() == player.upButton || e.getKeyChar() == player.upButton) {
            jump.setPlayer(player);
            jump.execute();
        }
    }

    @Override
    public void keyReleased(Player player, KeyEvent e) {
        if (e.getKeyCode() == player.leftButton || e.getKeyChar() == player.leftButton ||
                e.getKeyCode() == player.rightButton || e.getKeyChar() == player.rightButton) {
            stop.setPlayer(player);
            stop.execute();
        }
    }

    @Override
    public Image getImage() {
        return image;
    }
}