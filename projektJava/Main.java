package javaProjekt;
import java.awt.EventQueue;

public class Main {

	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			
			public void run() {
				new Window();
			//	if(Window.buttonPanel)
			}
		});
	}
}
