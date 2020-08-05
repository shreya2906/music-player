

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
//import org.apache.tika.parser.mp3.LyricsHandler;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;


import java.sql.SQLException;

import javazoom.jl.player.Player;
import java.util.*;
import java.io.*;
//import javax.swing.awt.*;
import java.awt.event.*;
import java.net.URL.*;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.event.ChangeEvent;
//import javax.media.Player;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
//import javazoom.jl.decoder.JavaLayerException;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
 class tmplayer extends Thread implements ActionListener,ChangeListener {
   //Musicplayer music=new Musicplayer();
     public tgui myframe;
    public int currentSongIndex;
    public int curentPlaylistIndex;
    private Player player;
    private boolean isItplaying;
        public FileInputStream fis;
        public BufferedInputStream bis;
    //    public Player player;
        public long currentlocation;
       public long songtotallength;
        public String path;
        
         public JList list;
  //  public DefaultListModel dlm;
     public Connection con;
    public PreparedStatement stat;
    public Statement stmt;
   public ResultSet rs;
    public ArrayList<String> arlist;
   public ArrayList<String> arlistpath;

        
                //="C:\\Users\\Sambhav\\Desktop\\music\\Shape of You by Ed Sheeran.mp3";
                public String filepath;
    public DefaultListModel dlm;
    public File myfile;
    
    
    public tmplayer(){
        this.myframe=new tgui();
    addActionListeners();
   this.addMouseListener();
   
addChangeListener();


isItplaying=false;
        currentSongIndex = 0;
        curentPlaylistIndex=0; 
        arlist = new ArrayList<>();
        arlistpath = new ArrayList<String>();
      
         //  initializeplayer(currentplaylist,currentsongindex);
    } 

    private void addActionListeners() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   myframe.getNextButton().addActionListener(this);
   myframe.getPauseButton().addActionListener(this);
   myframe.getPlayButton().addActionListener(this);
   myframe.getPrevButton().addActionListener(this);
   myframe.getStopButton().addActionListener(this);
   //myframe.getjLabel7().addMouseListener((MouseListener) this);
  // myframe.getjLabel8().addMouseListener((MouseListener) this);
   
    }
    
    
    
    public void addChangeListener(){
        myframe.getvolumeslider().addChangeListener(this);
    }
     
    
    
 
    public void addMouseListener(){
        myframe.getjLabel7().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
public void mouseReleased(java.awt.event.MouseEvent evt){
    jLabel7MouseReleased(evt);

}
    });
        
        
myframe.getjLabel8().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
public void mouseReleased(java.awt.event.MouseEvent evt){
    jLabel8MouseReleased(evt);

}
    });

 myframe.getjLabel4().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
public void mouseReleased(java.awt.event.MouseEvent evt){
    jLabel4MouseReleased(evt);

}
    });

        
        
    }
    
   
   public void jLabel7MouseReleased(java.awt.event.MouseEvent evt)
    {
    
        recentplayed();
      // jPanel4.add(list);
    // switchpanel(jPanel4);
    }
   
   public void jLabel8MouseReleased(java.awt.event.MouseEvent evt)
    {
    
        mostplayed();
      // jPanel4.add(list);
    // switchpanel(jPanel4);
    }
   
    public void jLabel4MouseReleased(java.awt.event.MouseEvent evt)
    {
    
         extract("c:\\");
         
          for(String str: arlist)
       {   System.out.println(str);
           dlm.addElement(str);
       }
          
          list=new JList();
             dlm=new DefaultListModel();
             list.setModel(dlm);
             myframe.jPanel7.add(list);
          
       //list = new JList<>(dlm);              //list.setModel(dm);
       list.setBounds(200,10,800,600);
       list.addListSelectionListener(new ListSelectionListener (){
           public void valueChanged(ListSelectionEvent lv){
               System.out.println(list.getSelectedValue()); 
               System.out.println(list.getSelectedIndex());
               int index = list.getSelectedIndex();
               System.out.println(arlistpath.get(index));
               
               try {
                   String songpath =arlistpath.get(index);
                   songpath = songpath.replaceAll("\\\\","\\\\\\\\");           
                   System.out.println(songpath);
                   startit(songpath);
               } 
               catch (FileNotFoundException ex) {
                   Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SAXException ex) {
                   Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
               } catch (TikaException ex) {
                   Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
               } catch (UnsupportedAudioFileException ex) {
                   Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
           }
           
       });
         
         
         
         
      // jPanel4.add(list);
    // switchpanel(jPanel4);
    }
  
   
     private void recentplayed(){
        
        try 
        {
             Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/books";
        Connection connection = DriverManager.getConnection(url, "root", "root");
            String query1="SELECT name FROM recent ORDER BY time DESC";
            PreparedStatement preStat = connection.prepareStatement(query1);
             ResultSet result = preStat.executeQuery();
             list=new JList();
             dlm=new DefaultListModel();
             list.setModel(dlm);
             myframe.jPanel7.add(list);
             list.setBounds(200,10,800,600);
             while(result.next()){
                 String name=result.getString("name");
             String name2=name.substring(44);
             System.out.println(name2);
                 dlm.addElement(name2);
                             
             }
             con.close();
            
        } catch (Exception e) 
        {
            System.out.println("Error : " + e);
        }
      
    }
     
     
     
     private void mostplayed(){
         try{
             
             Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/books";
        Connection connection = DriverManager.getConnection(url, "root", "root");
            String query1="SELECT name FROM recent ORDER BY most_played DESC ";
            PreparedStatement preStat = connection.prepareStatement(query1);
             ResultSet result = preStat.executeQuery();
             list=new JList();
             dlm=new DefaultListModel();
             list.setModel(dlm);
             //list.addListSelectionListener((ListSelectionListener) this);   
             myframe.jPanel7.add(list);
             list.setBounds(200,10,800,600);
             while(result.next()){
                 String name=result.getString("name");
             String name2=name.substring(44);
             System.out.println(name2);
                 dlm.addElement(name2);
             
                 
             }
             
             
         }
         catch(Exception e){
             e.printStackTrace();
         }
         
     }
     
       private void extract(String p){
          
         try{File f=new File(p);
        File l[]=f.listFiles();
        if(l==null) return;
        for(File x:l){
            if(x==null) continue;
            if(x.isHidden()||!x.canRead()) continue;
            if(x.isDirectory()) extract(x.getPath());
            else if(x.getName().endsWith(".mp3,.mp4"))
                System.out.println(x.getPath()+"\\"+x.getName());
            arlist.add(x.getName());
            arlistpath.add(x.getPath());
     }
     }
     catch(Exception e){
    e.printStackTrace();
}}
   
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==myframe.getPlayButton()){
            try {
                if(player==null){
                    startit(path);
                }
                else
                    resumesong();
                //changeplaytopause();
                }
                 //else{
                //stopcurrentsong();
                //changepausetoplay();
                //}

             catch (Exception ex) {
               
            } 
        }
        if(e.getSource()==myframe.getNextButton()){
            try {
                next();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==myframe.getPauseButton()){
            pause();
            
        }
        if(e.getSource()==myframe.getPrevButton()){
            try{
            prev();
            
        }
            catch(Exception ex){
                
            }
        }
        if(e.getSource()==myframe.getStopButton()){
            stopit();
        }
    }
    
    
  //  private final static String songLyricsURL = "http://www.songlyrics.com";
 
 /*
   public static ArrayList<String> getSongLyrics( String band, String songTitle) throws IOException {
     ArrayList<String> lyrics= new ArrayList<String>();
     
     String songLyricsURL = "http:/www.songlyrics.com";
     Document doc = Jsoup.connect(songLyricsURL+ "/"+band.replace(" ", "-").toLowerCase()+"/"+songTitle.replace(" ", "-").toLowerCase()+"-lyrics/").get();
    // String title = doc.title();
     //System.out.println(title);
     Element p = doc.select("p.songLyricsV14").get(0);
      for (Node e: p.childNodes()) {
          if (e instanceof TextNode) {
            lyrics.add(((TextNode)e).getWholeText());
          }
      }
      
     // while(lyrics.hasNext())
       //   System.out.println(lyrics.next());
     
      
     return lyrics;
   }
   */

    
     /*
     * @throws FileNotFoundException
     * @throws JavaLayerException
     
    */
    public void startit(String path) throws FileNotFoundException, SAXException, TikaException, UnsupportedAudioFileException{
        try{
            fis=new FileInputStream(path);
            bis=new BufferedInputStream(fis);
            songtotallength = fis.available();
             player=new Player(bis);
            //player.play();

        
        new Thread(){
            @Override
        public void run(){
            try{
                player.play();
            }
            catch(JavaLayerException e){
                System.out.println("erreo");
            }
        }
            
            }.start();
        String name3=path.substring(44);
        SongLength d= new SongLength(myfile);
        SongLength name4;
            name4 =  d;
        myframe.getjLabel6().setText(name3+" "+name4.getLength());
        
        
         BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File(path));
      ParseContext pcontext = new ParseContext();
      
      //Mp3 parser
     Mp3Parser  Mp3Parser = new  Mp3Parser();
      Mp3Parser.parse(inputstream, handler, metadata, pcontext);
  //    LyricsHandler lyrics = new LyricsHandler(inputstream,handler);
      
      /*while(lyrics.hasLyrics()) {
    	  System.out.println(lyrics.toString());
      }
    */
      
      File file = new File(path);
        System.out.println(file.getName());
     //   String result = file.substring(0, file.indexOf("."));
  System.out.println("Contents of the document:" + handler.toString());
  String author = handler.toString();
      System.out.println("Metadata of the document:");
      String[] metadataNames = metadata.names();
String[] data = null;
int i=0;
      for(String name : metadataNames) {		        
    	  System.out.println(name + ": " + metadata.get(name));
         // data[0]=metadata.get(name);
                  //break;
      }
      
         System.out.println("Hey1");
  ///   ArrayList<String> arr  =   getSongLyrics(author,file.getName());
      
         System.out.println("Hey2");
        
    }
        catch(FileNotFoundException | JavaLayerException e){
            System.out.println("error");
        } catch (IOException ex) {
            Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hey");
        }
    }
    
    private void next() throws FileNotFoundException, ClassNotFoundException, SQLException{
        //FileFilter filter;
      FileNameExtensionFilter  filter = new FileNameExtensionFilter("mp3","MP3 Files","mp3eg","mp4");
      JFileChooser chooser=new JFileChooser("C:\\Users\\Sambhav\\Desktop\\music player");
      chooser.addChoosableFileFilter((javax.swing.filechooser.FileFilter) filter);
      int returnval=chooser.showOpenDialog(null);
      if(returnval==JFileChooser.APPROVE_OPTION){
          
          try{
                    
          myfile=chooser.getSelectedFile();
          path=myfile+"";
          if(player!=null)
              stopit();
          
          startit(path);
          
          Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/books";
              try (Connection connection = DriverManager.getConnection(url, "root", "root")) {
                  String query6 = "SELECT name FROM recent where name=(?);";
                  PreparedStatement preStat = connection.prepareStatement(query6);
                  
                  preStat.setString(1, path);
                  System.out.println("Query6: "+query6);
                  ResultSet result = preStat.executeQuery();
                  if(result.next()) {
                      String name1 = result.getString("name");
                      System.out.println("Before if"+name1);
                      if((name1.equalsIgnoreCase(path))){
                          System.out.println("In if");
                          // String query5 = " UPDATE recent SET most_played = most_played + 1 WHERE name = '"+path+"';";
                          String query5 = "UPDATE recent SET most_played = most_played + 1,time=NOW() WHERE name = (?);";
                          //preStat.setString(2,0)
                          preStat = connection.prepareStatement(query5);
                          preStat.setString(1,path);
                          preStat.executeUpdate();
                          //break;
                      }
                      
                  }
                  else{
                      try{
                          System.out.println("in else");
                          String query1 = "INSERT INTO recent (name,most_played) VALUES ( ?, ?)";
                          /*preStat = connection.prepareStatement(query1);
                          // preStat.setInt(1, 20175154);
                          preStat.setString(1, path);
                          preStat.setInt(2, 1);
                          preStat.executeUpdate();
                          */
                          
                          //String query1 = "INSERT INTO recent (name,most_played) VALUES ('"+path+"',0)";
                          
                          preStat = connection.prepareStatement(query1);
//         preStat.executeUpdate();
//
preStat.setString(1, path);
preStat.setInt(2, 0);

preStat.executeUpdate();

                      }catch(Exception e){
                          e.printStackTrace();
                      }
                      //break;
                  }    }
          
               } 

                catch (Exception e) 
                {
                    System.out.println("Error : " + e);
                }

        //  con.close();
          
      }
         // catch(Exception e){
    
      }
    
    
    @Override
      public void stateChanged(ChangeEvent ce){
     
         try {
             VolumeController v=new VolumeController(path);
             
             /*int value = slider.getValue();
             str = Integer.toString(value);
             label.setText(str);
             strCommand = new String("mixerctl -q outputs.master=" + str + "," + str );
             SubmitProcess UserCommand = new SubmitProcess(strCommand);*/
         } catch (UnsupportedAudioFileException ex) {
             Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
         } catch (LineUnavailableException ex) {
             Logger.getLogger(tmplayer.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    

    
    

       private void stopit(){
       
        if(player!=null){
            player.close();
            player=null;
        }
   }
    
    private void prev(){
        
    }
    
    private void pause(){
     try{
         if(player!=null){
             currentlocation=fis.available();
             player.close();
            // player=null;
         }
     }
     catch(Exception e){
         
     }
    }
    private void resumesong() throws FileNotFoundException{
        try{
            filepath=path+"";
            fis= new FileInputStream(filepath);
            bis=new BufferedInputStream(fis);
            player=new Player(bis);
            fis.skip(songtotallength-currentlocation);
        new Thread(){
            @Override
        public void run(){
            try{
                player.play();
            }
            catch(JavaLayerException e){
                System.out.println("erreo");
            }
        }
            
            }.start();
        }
    
        catch(FileNotFoundException | JavaLayerException e){
            System.out.println("error");
        }
        catch(IOException e){
            
        }
           
        
    }
 }
	//public static void main(String args[]){
	//	tmplayer music=new tmplayer();
//	}

  