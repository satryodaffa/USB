/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FinalProject;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Music {
    
   void playMusic(String musicLocation)
   {
   try
   {
   File musicPath = new File(musicLocation);
   if(musicPath.exists())
   {
       AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
       Clip clip = AudioSystem.getClip();
       clip.open(audioInput);
       clip.start();
       clip.loop(Clip.LOOP_CONTINUOUSLY);
   }
   else
   {
       System.out.println("Can't find file");
   }
   }
    catch(Exception ex)
    {
   ex.printStackTrace(); 
}
}
}
