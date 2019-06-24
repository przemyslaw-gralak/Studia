package javaProjekt;
//import java.awt.FlowLayout;


import javax.swing.*;

public class Window extends JFrame {
	
	public Window() {
		JPanel buttonPanel = new Buttons();
		add(buttonPanel);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
