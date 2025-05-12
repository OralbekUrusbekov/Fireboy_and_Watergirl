package GameCode;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Rectangle implements Drawable {
	// Жаңа өріс:
	private List<PlayerObserver> observers = new ArrayList<>();

	Door destination;
	MovementStrategy movementStrategy;

	public static final int PlayerWidth = 26, PlayerHeight = 50;
	public static final int HorizontalSPEED = 5, VerticalSPEED = 15;

	int xVelocity, yVelocity;
	int startX, startY;
	public char upButton, leftButton, rightButton;
	public boolean inAir;
	Color colour;


	public void addObserver(PlayerObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(PlayerObserver observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		notifyLevelComplete();
	}


	public void notifyLevelComplete() {
		for (PlayerObserver observer : observers) {
			observer.onLevelComplete(this);
		}
	}



	public Player(char upButton, char leftButton, char rightButton, int startX, int startY, Color colour, int doorX, int doorY) {
		super(startX, startY, PlayerWidth, PlayerHeight);
		this.startX = startX;
		this.startY = startY;
		this.upButton = upButton;
		this.leftButton = leftButton;
		this.rightButton = rightButton;
		this.colour = colour;

		if (colour == Color.red) {
			movementStrategy = new FireboyMovementStrategy();
		} else {
			movementStrategy = new WatergirlMovementStrategy();
		}

		destination = new Door(doorX, doorY, this.colour);
		xVelocity = 0;
		yVelocity = 0;
		inAir = true;
	}

	public void keyPressed(KeyEvent e) {
		movementStrategy.keyPressed(this, e);
	}

	public void keyReleased(KeyEvent e) {
		movementStrategy.keyReleased(this, e);
	}

	public void move() {
		movementStrategy.move(this);
		if (atDestination()) {
			notifyLevelComplete();
		}
	}


	public boolean atDestination() {
		if (Math.abs(xVelocity) > 1 || Math.abs(yVelocity) > 1) return false;


		int tolerance = 5;

		if (x + PlayerWidth < destination.x - tolerance) return false;
		if (x > destination.x + Door.DOOR_WIDTH + tolerance) return false;
		if (y + PlayerHeight < destination.y - tolerance) return false;
		if (y > destination.y + Door.DOOR_HEIGHT + tolerance) return false;

		return true;
	}


	public void resetPosition() {
		x = startX;
		y = startY;
		inAir = true;
		yVelocity = 0;
		xVelocity = 0;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(movementStrategy.getImage(), x, y, null);
	}
}
