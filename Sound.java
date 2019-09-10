/**
 * Sound.java
 * Programmed by Bill Song, Tiffany Wu and Nicholas Wang
 * Programmed on Jan.21st, 2018
 * This program plays music
 */
import javax.sound.sampled.*;

public class Sound {
  
  private Clip clip;
  
    /*
   *Create a new sound and set it as the name of the wav file
   *Credits: https://www.youtube.com/watch?v=NmCCQxVBfyM
   */
  public static Sound backgroundMusic = new Sound("Original_Tetris_theme_Tetris_Soundtrack_.wav");
  
    /*
   *Create an audio input stream which is an input stream with a specified audio format and length
   *Obtain an audio input stream from an external audio file
   *Open the sound clip and throw an exception
   * Trace the exception if there is an error
   */
  public Sound (String fileName) {
    try {
      
      AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(fileName));
      clip = AudioSystem.getClip();
      clip.open(ais);
    } catch (Exception e) {
      
      e.printStackTrace();
    }
  }
  
    /*
   *If the clip is null then create a new thread and run it again 
   * This will loop it continuously as the user plays the game 
   * LOOP_CONTINUOUSLY is a static int that will indicate that looping will continue infinitely
   */ 
  
  public void loop() {
    try {
      if (clip != null) {
        new Thread() {
          public void run() {
            synchronized (clip) {
              clip.setFramePosition(0);
              clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
          }
        }.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public boolean isActive(){
    return clip.isActive();
  }
}
