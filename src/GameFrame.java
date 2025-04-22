import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{

	GamePanel level1;
	
	public GameFrame() {
		level1 = new GamePanel(1);
		this.add(level1);
		this.setTitle("Fireboy and Lavagirl");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}