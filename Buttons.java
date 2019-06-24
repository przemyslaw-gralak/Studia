package javaProjekt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Buttons extends JPanel implements ActionListener{
	public static final int HEIGHT = 400;
	public static final int WIDTH = 300;
	public static Budzik b=new Budzik();
	public static boolean soundOn = false;
	public static boolean paused = false;
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JButton fourthButton;
	private JTextField t1;  
	public Clock timeLabel = new Clock();
	public Minutnik minut = new Minutnik();
	public enum whichOne{
		ONE,
		TWO,
		THREE,
		FOUR
	}
	public Buttons() {
		JPanel nested2 = new JPanel(new GridLayout(0,2)); 
		firstButton = new JButton("Start");
		secondButton = new JButton("Pauza");
		thirdButton = new JButton("Stop");
		fourthButton = new JButton("Dzwiek");

		firstButton.addActionListener(this);
		secondButton.addActionListener(this);
		thirdButton.addActionListener(this);
		fourthButton.addActionListener(this);

		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
 
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		t1=new JTextField("15");
		JLabel t2 = new JLabel(" minut");
		t1.setPreferredSize(new Dimension( 30, 24 ));
		minut.setText("00:00");
		nested2.add(t1);
		nested2.add(t2);
		
		nested2.add(firstButton);
		nested2.add(secondButton);
		
		nested2.add(thirdButton);   
		nested2.add(fourthButton);
		
		nested2.add(timeLabel);
		nested2.add(minut);
		
		add(nested2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if(source == firstButton)
		{
			//setBackground(Color.GREEN);
			String textFieldValue = t1.getText();
			int minutes = Integer.parseInt(textFieldValue);
			minut.Start(minutes);
			minut.Start();
		}
			

		else if(source == secondButton)
		{
			if(paused)
			{
				minut.Start();
				paused = false;
			}else
			{
				minut.Pauza();
				paused = true;
			}
			
		}

		else if(source == thirdButton)
		{
			minut.setToZero = false;
			minut.minutes = 0;
			minut.seconds = 0;
			minut.setText("00:00");
			minut.Pauza();
		}
		
		else if(source == fourthButton)
		{
			if(soundOn)
			{
				//setBackground(Color.PINK);
				soundOn = false;
				b.Stop();
			}
			else if(!soundOn)
			{
				//setBackground(Color.YELLOW);
				soundOn = true;
				b.Play();
			}
			
		}
	}
}

