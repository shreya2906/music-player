

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSlider;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sambhav
 */

public class tgui extends javax.swing.JFrame {

   public JList list;
    public DefaultListModel dlm;
     public Connection con;
    public PreparedStatement stat;
    public Statement stmt;
   public ResultSet rs;


  //  private Object jPanel3;

    
    // * Creates new form tgui
     
    public tgui() {
        initComponents();
        jLabel1.setVisible(true);
        jPanel2.setBackground(new Color(255,255,255,100));
        jPanel7.setBackground(new Color(255,255,255,100));
        jPanel8.setBackground(new Color(255,255,255,100));
        jPanel3.setBackground(new Color(255,255,255,100));
          setBounds(0,0,600,600); 
       // setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
       /* setTitle("MP3 Player");
       //jPanel4.setBackground(new Color(255,255,255,100));
        //jPanel5.setBackground(new Color(255,255,255,100));
        //jPanel6.setBackground(new Color(255,255,255,100));
        
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tgui().setVisible(true);
                new tgui().setTitle("MP3 player");
          }
        });
*/

    }

    
   /*  * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the tgui Editor.
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Bnext = new javax.swing.JButton();
        Bstop = new javax.swing.JButton();
        Bplay = new javax.swing.JButton();
        Bprev = new javax.swing.JButton();
        Bpause = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
         jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MP3 Player");
        setMinimumSize(new java.awt.Dimension(1580, 910));
        getContentPane().setLayout(null);

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(2560, 1600));
       // jPanel1.setMinimumSize(new java.awt.Dimension(2560, 1600));
        jPanel1.setPreferredSize(new java.awt.Dimension(2560, 1600));
        jPanel1.setLayout(null);

        Bnext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/next.png"))); // NOI18N
        Bnext.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // BnextActionPerformed(evt);
            }
        });

        Bstop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stop.png"))); // NOI18N

        Bplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/play.png"))); // NOI18N
        Bplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BplayMouseReleased(evt);
            }
        });
        Bplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BplayActionPerformed(evt);
            }
        });

        Bprev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/prev.png"))); // NOI18N

        Bpause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pause.png"))); // NOI18N
        
         
         jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
         jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        // jLabel6.setText("jLabel6");
         jPanel2.add(jLabel6);
          jLabel6.setBounds(400, 0, 800, 20);
          
          jPanel2.add(jSlider1);
          jSlider1.setBounds(1070,50,150,20);
          //jSlider1.setMajorTickSpacing(10);
            //    jSlider1.setPaintLabels(true);
          
         
         javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(Bpause)
                .addGap(82, 82, 82)
                .addComponent(Bprev)
                .addGap(84, 84, 84)
                .addComponent(Bplay)
                .addGap(93, 93, 93)
                .addComponent(Bnext)
                .addGap(74, 74, 74)
                .addComponent(Bstop)
                 //.addComponent(jLabel6)
                // .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(610, Short.MAX_VALUE))

                
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                    // .addComponent(jLabel6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bplay, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bnext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bstop, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bprev, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bpause, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 750, 1590, 160);

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("add playlists+");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(11, 310, 180, 50);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
@Override
public void mouseReleased(java.awt.event.MouseEvent evt){
    jLabel2MouseReleased(evt);
}
        
        });

        
        

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("YouTube");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 70, 180, 40);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
@Override
public void mouseReleased(java.awt.event.MouseEvent evt){
    jLabel3MouseReleased(evt);
}
        
        });
        
        

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Songs");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 160, 180, 50);
/*
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
@Override
public void mouseReleased(java.awt.event.MouseEvent evt){
    jLabel4MouseReleased(evt);
}
        
        });
       */   
       
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Genre");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 210, 180, 50);

           jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Recent Played");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 260, 180, 50);
        
          /*jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
@Override
public void mouseReleased(java.awt.event.MouseEvent evt){
    jLabel7MouseReleased(evt);
}
        
        });
          */
          
          
           jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Most Played");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 110, 160, 50);
     
          /*   jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
@Override
public void mouseReleased(java.awt.event.MouseEvent evt){
    jLabel8MouseReleased(evt);
}
        
        });
        */
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 10, 180, 730);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(210, 10, 1350, 730);
        
        
        
        
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(210, 10, 1350, 730);

        
        


        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sunset-sea-wallpaper-3.png"))); // NOI18N
        jLabel2.setAlignmentY(0.0F);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(2550, 1600));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1590, 910);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1589, 912);

        pack();
    }// </editor-fold>  
    
    /* private void recentp(){
        
        try 
        {
             Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/books";
        Connection connection = DriverManager.getConnection(url, "root", "root");
            String query1="SELECT name FROM recent";
            PreparedStatement preStat = connection.prepareStatement(query1);
             ResultSet result = preStat.executeQuery();
             list=new JList();
             dlm=new DefaultListModel();
             list.setModel(dlm);
             jPanel7.add(list);
             list.setBounds(200,10,800,240);
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
     */
     
  
     
     
  /*   private void mosttp(){
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
             jPanel7.add(list);
             list.setBounds(200,10,800,240);
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
     */
     /*public void valueChanged(ListSelectionEvent ae){
         
         
         if(!ae.getValueIsAdjusting()){
             try{
                 
                  Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/books";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        
                 
                 
             }
             catch(Exception e){
                 e.printStackTrace();
             }
         }
     }*/
     /*
     private void extract(String p){
          
         try{File f=new File(p);
        File l[]=f.listFiles();
        for(File x:l){
            if(x==null) continue;
            if(x.isHidden()||!x.canRead()) continue;
            if(x.isDirectory()) extract(x.getPath());
            else if(x.getName().endsWith(".mp3"))
                System.out.println(x.getPath()+"\\"+x.getName());
     }
     }
     catch(Exception e){
    e.printStackTrace();
}}
   */  
     
     
     
     
      private void jLabel2MouseReleased(java.awt.event.MouseEvent evt){
          addplaylist a=new addplaylist();
      }
     
     
     
     
      private void jLabel3MouseReleased(java.awt.event.MouseEvent evt){
          
          SiteOpener s=new SiteOpener();
        s.open("http://www.youtube.com/");
      }
     
     /*
       private void jLabel4MouseReleased(java.awt.event.MouseEvent evt)
    {
    
       extract("c:\\");
      // jPanel4.add(list);
    // switchpanel(jPanel4);
    }
     */ 
    /*
      private void jLabel7MouseReleased(java.awt.event.MouseEvent evt)
    {
    
        recentp();
      // jPanel4.add(list);
    // switchpanel(jPanel4);
    }*/
   
      /*
        private void jLabel8MouseReleased(java.awt.event.MouseEvent evt)
    {
    
        mosttp();
      // jPanel4.add(list);
    // switchpanel(jPanel4);
    }
        */

    private void BplayMouseReleased(java.awt.event.MouseEvent evt) {                                    
   //System.out.println("........");
           // TODO add your handling code here:
      
    }                                   

    private void BplayActionPerformed(java.awt.event.ActionEvent evt) {  
    
    }                                    
       /*   InputStream music;
        try{
            
            music=new FileInputStream(new File("C:\\Users\\Sambhav\\Desktop\\music\\Shape of You by Ed Sheeran.mp3"));
            AudioStream audios=new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e){
            System.out.println("error");
        }
 */
        // TODO add your handling code here:
   // }                                     

  private void BnextActionPerformed(java.awt.event.ActionEvent evt) {                                      
/* InputStream music;
        try{
            
            music=new FileInputStream(new File("C:\\Users\\Sambhav\\Desktop\\music\\Shape of You by Ed Sheeran.mp3"));
            AudioStream audios=new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e){
            System.out.println("error");
        }
*/        
  }

// TODO add your handling code here:
 //   }                                     

    /*
     * @param args the command line arguments
     */
 
/*public static void main(String args[]) {
      tmplayer m=new tmplayer(); 
       /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        // If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        // * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
  /*       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tgui().setVisible(true);
                new tgui().setTitle("MP3 player");
            }
        });
        
    }
*/
public JButton getNextButton(){
    return Bnext;
    }
public JButton getPauseButton(){
    return Bpause;
    }
public JButton getPlayButton(){
    return Bplay;
    }
public JButton getPrevButton(){
    return Bprev;
    }
public JButton getStopButton(){
    return Bstop;
    }
public JLabel getjLabel6(){
    return jLabel6;
    }


public JLabel getjLabel7(){
    return jLabel7;
    }

public JLabel getjLabel8(){
    return jLabel8;
    }
public JLabel getjLabel4(){
    return jLabel4;
    }

public JSlider getvolumeslider(){
    return jSlider1;
}



    //private javax.swing.JLabel jLabel1;
    // Variables declaration - do not modify                     
    private javax.swing.JButton Bnext;
    private javax.swing.JButton Bpause;
    private javax.swing.JButton Bplay;
    private javax.swing.JButton Bprev;
    private javax.swing.JButton Bstop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
     private JLabel jLabel7;
     private JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSlider jSlider1;
// End of variables declaration                   
}
