import java.awt.*;
import javax.swing.*;
import java.io.*;

public class GameFrame extends JFrame{

	GamePanel level;

	public GameFrame() throws IOException{
		level = new GamePanel();
		this.add(level);
		this.setTitle("Fireboy and Watergirl");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}