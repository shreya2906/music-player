import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.sound.sampled.*;
import org.tritonus.share.sampled.file.TAudioFileFormat;

/**
 *
 * @author Sambhav
 */
public class  SongLength{
    
    public String length;
public SongLength(File file) throws UnsupportedAudioFileException, IOException {

    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
    if (fileFormat instanceof TAudioFileFormat) {
        Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
        String key = "duration";
        Long microseconds = (Long) properties.get(key);
        int mili = (int) (microseconds / 1000);
        int sec = (mili / 1000) % 60;
        int min = (mili / 1000) / 60;
        System.out.println("time = " + min + ":" + sec);
      if(sec<10)  length=  min + ":0" + sec;
      else length=  min + ":" + sec;
    } else {
        throw new UnsupportedAudioFileException();
    }

   }

    public String getLength()
    {
        return length;
    }
}