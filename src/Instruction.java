import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Instruction extends Rectangle {

	String text;
	boolean unlocked;
	int x1, x2, y1, y2;
	boolean clickable;

	public Instruction(int x, int y, String text, int x1, int y1, int x2, int y2, boolean unlocked) {
		this.x = x;
		this.y = y;
		this.text = text;
		this.unlocked = unlocked;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		clickable = true;
	}

	public Instruction(int x, int y, String text) {
		this.x = x;
		this.y = y;
		this.text = text;
		clickable = false;
		unlocked = true;
	}

	public boolean clicked(MouseEvent e) {
		if (!unlocked || !clickable) return false;
		return (e.getX() > x1 && e.getX() < x2) && (e.getY() > y1 && e.getY() < y2);
	}

	public void draw(Graphics g) {
		if (unlocked) g.setColor(Color.white);
		else g.setColor(Color.lightGray);
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString(text, x, y);
		if (clickable) g.drawRect(x1, y1, x2 - x1, y2 - y1);
	}
}
