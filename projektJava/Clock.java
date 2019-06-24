package javaProjekt;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock extends JLabel implements ActionListener{
	
	SimpleDateFormat sdf;
	public Clock(){
		sdf = new SimpleDateFormat("hh:mm:ss a");
		Timer t = new Timer(1000, this);
		t.start();
	}
	
	
	public void actionPerformed(ActionEvent ae) {
	    Date d = new Date();
	    setText(sdf.format(d));
	  }
	
}
