import java.awt.*;

public class Instruction extends Rectangle {

	public static final int WIDTH = 30;
	String text;

	public Instruction(int x, int y, String text) {
		this.x = x;
		this.y = y;
		this.text = text;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white); // Set font colour
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString(text, x, y);
	}
}