/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sambhav
 */
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
public class VolumeController {
    public VolumeController(String p) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
    new File(p));
Clip clip = AudioSystem.getClip();
clip.open(audioInputStream);
FloatControl gainControl = 
    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
clip.start();
    }
    
}
