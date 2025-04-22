import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle{

	public static final int PlayerWidth = 20, PlayerHeight = 40;

	public static final int HorozontalSPEED = 5, VerticalSPEED = 15;
	int yVelocity, xVelocity;
	public char upButton, leftButton, rightButton;
	public boolean inAir;
	Color colour;
	Door destination;

	public Player(char upButton, char leftButton, char rightButton, int startX, int startY, Color colour, int doorX, int doorY) {
		super(startX, startY, PlayerWidth, PlayerHeight);
		x = startX; y = startY;

		this.upButton = upButton;
		this.leftButton = leftButton;
		this.rightButton = rightButton;
		this.colour = colour;
		destination = new Door(doorX, doorY, this.colour);

		xVelocity = 0; yVelocity = 0;
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
			if(!inAir) {
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
		if(x < destination.x) return false;
		if(y < destination.y) return false;
		if(x + PlayerWidth > destination.x + Door.DOOR_WIDTH) return false;
		if(y + PlayerHeight > destination.y + Door.DOOR_HEIGHT) return false;
		return true;
	}

	public void move() {
		y += yVelocity;
		yVelocity++;
		x += xVelocity;
	}

	public void draw(Graphics g) {
		g.setColor(colour);
		g.fillRect(x, y, PlayerWidth, PlayerHeight);
		destination.draw(g);
	}
}