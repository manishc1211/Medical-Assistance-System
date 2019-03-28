package medical.management;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import javax.swing.*;


public class PatChat extends WindowAdapter implements ActionListener
{
    JTextField t;
    JTextArea ta;
    JButton b;
    ServerSocket ss;
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    String str1="",str2="";
    Connection con;
    int sno=0;
    PatChat()
    {
        JFrame f = new JFrame("Patient");
        f.setLayout(null);
        f.setSize(400,588);
        f.setLocation(700, 0);
        
        JPanel sp1 = new JPanel();
        sp1.setLayout(null);
        sp1.setBounds(0,0,400,500);
        sp1.setBackground(Color.PINK);
        
        JPanel sp2 = new JPanel();
        sp2.setLayout(null);
        sp2.setBounds(0,500,400,50);
        sp2.setBackground(Color.ORANGE);
        
        ta = new JTextArea();
        ta.setBackground(Color.PINK);
        ta.setBounds(0,0,400,550);
        sp1.add(ta);
        
        t = new JTextField();
        t.setBounds(10,10,290,30);
        sp2.add(t);
        
        b = new JButton("Send");
        b.addActionListener(this);
        b.setBounds(305,10,70,30);
        sp2.add(b);
        
        f.add(sp1);
        f.add(sp2);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws Exception
    {
        PatChat se = new PatChat();
        se.Initiate();
    }
    void Initiate() throws Exception
    {
        try
        {
            ss = new ServerSocket(4769);
            System.out.println("Waiting For Client.."); 
            s = ss.accept();             
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Client Connected..");
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
            ReadThread rt = new ReadThread();
            rt.start();
        }
        catch(IOException exc){}
    }
    class ReadThread extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                str2 = (String)din.readUTF();
                ta.setText(ta.getText()+"\nDoctor: "+str2);
            }
            catch(IOException e){}
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e)
    {
        try
        {
            s.close();
            ss.close();
            try{con.close();}
            catch(Exception ex){}
            din.close();
            dout.close();
        }
        catch(IOException ex){}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
            try
            {
                str1=t.getText();
                dout.writeUTF(str1);
                ta.setText(ta.getText()+"\nPatient: "+str1);
                t.setText("");
                
            }
            catch(IOException ex){}
        }
    }
    
}
