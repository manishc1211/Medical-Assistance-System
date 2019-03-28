package medical.management;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class OTP3 implements ActionListener
{
    static JButton b;
    static JTextField t1;
    static JLabel l1,l2;
    static JFrame f;
    static String otp;
    static long ran;
    static Connection con;
    public OTP3()
    {
    }

    public OTP3(String o)
    {
        otp = o;
        f = new JFrame("OTP");
        f.setLayout(null);
        f.setSize(300,180);
        f.setLocation(575,300);
        f.setResizable(false);
        f.setBackground(new Color(0,0,0,200));
        
        l1 = new JLabel("Enter OTP : ");
        l1.setBounds(30,30,100,20);
        l1.setForeground(Color.lightGray);
        
        t1 = new JTextField();
        t1.setBounds(100,30,155,17);
        t1.setBorder(null);
        
        l2 = new JLabel();
        l2.setForeground(Color.red);
        l2.setBounds(95,65,150,20);
        l2.setFont(new Font(Font.DIALOG,Font.BOLD,15));
        
        b = new JButton("Submit");
        b.setFocusPainted(false);
        b.setMargin(new Insets(0,0,0,0));
        b.setBounds(118,95,60,30);
        b.addActionListener(this);
        
        f.add(t1);
        f.add(l1);
        f.add(l2);
        f.add(b);
        System.out.println("Added");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable(){@Override public void run() {
            OTP3 o = new OTP3("H");
        }});
    }

    /*public int check()
    {
        return 1;
    }*/
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int c=5;
        if(e.getSource()==b)
        {
            System.out.println("INb");
            String o = t1.getText();
            if(o.equals(otp))
            {

                try {
                    l2.setText("");
                    f.dispose();

                    PatientSignUp ps = new PatientSignUp(c);
                    System.out.println("01");
                } catch (Exception ex) {System.out.println("OTCatch");           }
            }
            else
            {
                l2.setText("* Invalid OTP *");
            }
        }
    }
}
