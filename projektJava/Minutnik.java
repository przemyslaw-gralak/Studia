package javaProjekt;

import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minutnik extends JLabel implements ActionListener{
	public int minutes;
	public int seconds;
	public boolean setToZero = false;
	public boolean started = false;
	public int i = 6;
	public static Budzik b=new Budzik();
	public Timer t;
	
	public Minutnik(){
		t = new Timer(1000, this);
		t.start();	
	}
	public void Start()
	{
		t.start();
	}
	public void Pauza()
	{
		t.stop();
	}
	public void Start(int min)
	{
		minutes = min;
		seconds = min*60;
		setToZero = false;
		i = 6;
		started = true;
	}
	
	public void actionPerformed(ActionEvent ae) {
	    seconds--;
	    minutes = seconds/60;
	    if(setToZero && started)
	    {
	    	if(i==6)
	    	{
	    		b.Play();
	    	}
	    	else if(i==0)
	    	{
	    		b.Stop();
	    	}
	    	i--;
	    	setText("00:00");
	    }
	    if(seconds <= 0)
	    {
	    	setToZero = true;
	    	
	    	
	    }else
	    {
	    	if(minutes<10&&(seconds - (minutes*60)<10))
	    	{
	    		setText("0" + minutes + ":0" + (seconds - (minutes*60)));
	    	}
	    	if(minutes<10&&(seconds - (minutes*60)>=10))
	    	{
	    		setText("0" + minutes + ":" + (seconds - (minutes*60)));
	    	}
	    	if(minutes>=10&&(seconds - (minutes*60)>=10))
	    	{
	    		setText("" + minutes + ":" + (seconds - (minutes*60)));
	    	}
	    	if(minutes>=10&&(seconds - (minutes*60)<10))
	    	{
	    		setText("" + minutes + ":0" + (seconds - (minutes*60)));
	    	}
	    	
	    	
	    }
	  }
}
