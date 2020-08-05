
import java.io.IOException;
import javax.swing.JOptionPane;



public class SiteOpener {
    public void open(String link){
        try{
            Process p;
            p=Runtime.getRuntime().exec("cmd /c start "+link);
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "error");
        }
    }
    
}


