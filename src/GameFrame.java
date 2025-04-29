import java.awt.*;
import javax.swing.*;
import java.io.*;

public class GameFrame extends JFrame{

	GamePanel level1;
	//HomeScreen homescreen;
	//Thread frameThread;
	
	//boolean inGame = false, inHome = true;
	
	public GameFrame() throws IOException{
		//homescreen = new HomeScreen();
		level1 = new GamePanel();
		this.add(level1);
		//this.add(homescreen);
		this.setTitle("Fireboy and Watergirl"); 
		this.setResizable(false); 
		this.setBackground(Color.black); // background is black
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.pack();
		this.setVisible(true);
		//level1.setVisible(false);
		this.setLocationRelativeTo(null);
		
		//frameThread = new Thread(this);
		//frameThread.start();
	}
	
	/*public void checkStatus() {
		if(inHome) {
			if(homescreen.levelSelected) {
				level1 = new GamePanel(1);
				//level1 = new GamePanel(1);
				//homescreen.setVisible(false);
				homescreen.setVisible(false);
				//this.remove(homescreen);
				this.add(level1);
				level1.setVisible(true);
				
				inGame = true;
				inHome = false;
			}
		}
		else if(inGame) {
			
		}
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long now;

		while (true) { // this is the infinite game loop
			now = System.nanoTime();
			delta = delta + (now - lastTime) / ns;
			lastTime = now;

			if (delta >= 1) {
				
				checkStatus();
				
				delta--;
			}
		}
		
	}*/
}