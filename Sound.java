import java.io.*;
import sun.audio.*;

public class Sound
{
  public static void main(String[] args) 
  throws Exception
  {
      playMusic("Minecraft Theme (Earrape).mp4");
  }
  public static void playMusic(String file)
  {
   try{
   AudioData data=new AudioStream(new FileInputStream(file)).getData();
   ContinuousAudioDataStream sound=new ContinuousAudioDataStream(data);
   AudioPlayer.player.start(sound);
   
  
   }
   catch(Exception e)
   {
   }
}
}