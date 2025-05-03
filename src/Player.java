import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Player extends Rectangle {

	public static final int PlayerWidth = 26, PlayerHeight = 50;
	public static final int HorozontalSPEED = 5, VerticalSPEED = 15;

	int yVelocity, xVelocity;
	int startX, startY;
	public char upButton, leftButton, rightButton;
	public boolean inAir;
	Color colour;
	Door destination;
	Image image;
	String imageFilePath;

	public Player(char upButton, char leftButton, char rightButton, int startX, int startY, Color colour, int doorX, int doorY) {
		super(startX, startY, PlayerWidth, PlayerHeight);
		this.startX = startX;
		this.startY = startY;

		if (colour == Color.red) imageFilePath = "./Images/Fireboy.png";
		else imageFilePath = "./Images/Watergirl.png";
		image = new ImageIcon(imageFilePath).getImage();

		this.upButton = upButton;
		this.leftButton = leftButton;
		this.rightButton = rightButton;
		this.colour = colour;
		destination = new Door(doorX, doorY, this.colour);

		xVelocity = 0;
		yVelocity = 0;
		inAir = true;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == leftButton || e.getKeyChar() == leftButton) {
			xVelocity = -HorozontalSPEED;
			move();
		}
		if (e.getKeyCode() == rightButton || e.getKeyChar() == rightButton) {
			xVelocity = HorozontalSPEED;
			move();
		}
		if (e.getKeyCode() == upButton || e.getKeyChar() == upButton) {
			if (!inAir) {
				inAir = true;
				yVelocity = -VerticalSPEED;
			}
			move();
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == leftButton || e.getKeyChar() == leftButton) {
			xVelocity = 0;
			move();
		}
		if (e.getKeyCode() == rightButton || e.getKeyChar() == rightButton) {
			xVelocity = 0;
			move();
		}
	}

	public boolean atDestination() {
		if (xVelocity != 0 || yVelocity != 0) return false;
		if (x < destination.x) return false;
		if (y < destination.y) return false;
		if (x + PlayerWidth > destination.x + Door.DOOR_WIDTH) return false;
		if (y + PlayerHeight > destination.y + Door.DOOR_HEIGHT) return false;
		return true;
	}

	public void resetPosition() {
		x = startX;
		y = startY;
		inAir = true;
		yVelocity = 0;
		xVelocity = 0;
	}

	public void move() {
		y += yVelocity;
		if (yVelocity >= 2) inAir = true;
		yVelocity++;
		x += xVelocity;
	}

	public void draw(Graphics2D g2D) {
		g2D.drawImage(image, x, y, null);
	}
}
