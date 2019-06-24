package javaProjekt;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Budzik{
	File file;
	URL url;
	AudioClip clip;
	void setup() {
	    try {
	    	file = new File("alarm.wav");
	        url = null;
	        if (file.canRead()) 
	        {
	        	url = file.toURI().toURL();
	        }
	        clip = Applet.newAudioClip(url);
	    }
	    catch (MalformedURLException ex) 
	    {
	        throw new RuntimeException(ex);
	    }
	}
	public Budzik()
	{
        setup();
	}
  public void Play()
  {
	  clip.play();
      System.out.println("should've played by now");
  }
  public void Stop()
  {
	  clip.stop();
      System.out.println("should've stopped by now");
  }
      
    
        

}
