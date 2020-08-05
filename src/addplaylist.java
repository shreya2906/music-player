import java.util.regex.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addplaylist extends JFrame implements ActionListener
{
   // private  List<String> addplaylists;
JTextField txnm;
JLabel nm;
JButton submit,cancel;

public addplaylist(){
//addplaylists=new ArrayList<>();
setLayout(null);


nm=new JLabel("Name");
nm.setBounds(10,10,100,30);
nm.setFont(new java.awt.Font("Verdana", 1, 18));


txnm=new JTextField();
txnm.setBounds(150,10,300,30);

submit=new JButton("submit");
submit.setBounds(150,80,100,30);

cancel=new JButton("cancel");
cancel.setBounds(280,80,100,30);

setVisible(true);
//setSize(500,200);
setBounds(650,300,500,200);
setTitle("New Playlist");
setResizable(false);
//setBackground(new Color(0,0,0));

add(nm);
add(txnm);
add(submit);
add(cancel);

submit.addActionListener(this);
cancel.addActionListener(this);

}

public void actionPerformed(ActionEvent e){

if(e.getSource()==submit){
Pattern mypattern1=Pattern.compile("^[a-zA-Z0-9]+$");
Matcher mymatcher1=mypattern1.matcher(txnm.getText());
Boolean myboolean=mymatcher1.matches();
    System.out.println(txnm.getText());
if(myboolean){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/books";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        String plist=txnm.getText();
           
    
      String sql = "CREATE TABLE "+plist+"("+"id INT(64) NOT NULL AUTO_INCREMENT,"+"name VARCHAR(500),"+"time VARCHAR(20),"+"most_played INT(64),"+"PRIMARY KEY(id))";
       Statement s = connection.createStatement();
       
      s.executeUpdate(sql);
            System.out.println("CreateTable sucessfully");    


    }
    catch(Exception a){
        a.printStackTrace();
    }
JOptionPane.showMessageDialog(this,"playlist added");


}
else{
JOptionPane.showMessageDialog(this,"add a valid playlist title");
}
}

if(e.getSource()==cancel){

this.dispose();
}
}
}


