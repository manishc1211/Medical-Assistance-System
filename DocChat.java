package medical.management;
import java.awt.Color;
import java.net.Socket;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class DocChat extends WindowAdapter implements ActionListener 
{
    JFrame f;
    JTextField t;
    JTextArea ta;
    JButton b;
    String str1="",str2="";
    DataInputStream din;
    DataOutputStream dout;
    Socket s;
    DocChat()
    {
        f = new JFrame("Doctor");
        f.setLayout(null);
        f.setSize(400,588);
        
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
        b.setBounds(305,10,70,30);
        b.addActionListener(this);
        sp2.add(b);
        
        f.add(sp1);
        f.add(sp2);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws Exception
    {
        DocChat c = new DocChat(); 
        c.Initiate();
        
    }
    void Initiate()
    {
        try
        {
            System.out.println("Connecting to Server..");
            s = new Socket("localhost",4769); 
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Connected to Server..");
            f.addWindowListener(this);
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
                ta.setText(ta.getText()+"\nPatient: "+str2);
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
            din.close();
            dout.close();
        }
        catch(IOException ex){}
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b)
        {
            try
            {                
                str1 = t.getText();
                dout.writeUTF(str1);
                ta.setText(ta.getText()+"\nDoctor: "+str1);
                t.setText("");
            }
            catch(IOException exc){}
        }       
    }   
}