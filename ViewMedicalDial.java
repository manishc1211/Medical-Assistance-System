package medical.management;

import java.awt.event.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ViewMedicalDial implements ActionListener
{
    JFrame f;
    JButton b;
    JLabel l;
    Choice c;
    JPanel p;
    static String un; 
    ViewMedicalDial()
    {
        
    }
    ViewMedicalDial(String s)
    {
        un = s;
    }
    public void Interface()
    {
        f = new JFrame("Medical Stores");
        f.setLayout(null);
        f.setSize(300,300);
        f.setLocation(450,150);
        
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(0,0,300,400);
        p.setBackground(Color.white);
        
        l = new JLabel("View Stores in Your:");
        l.setFont(new Font("",Font.BOLD,15));
        l.setBounds(70,30,150,20);
        p.add(l);
        
        c = new Choice();
        c.setFocusable(false);
        c.setBackground(Color.darkGray);
        c.setForeground(Color.lightGray);
        c.add("Locality");
        c.add("City");
        c.add("State");
        c.add("Country");
        c.setBounds(95, 70, 100, 17);
        p.add(c);
        
        b = new JButton("Submit");
        b.setBounds(105, 180, 80, 30);
        b.setMargin(new Insets(0,0,0,0));
        b.setFocusPainted(false);
        b.addActionListener(this);
        p.add(b);
        
        f.add(p);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main(String args[])
    {
        ViewMedicalDial vcd = new ViewMedicalDial();
        vcd.Interface();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b)
        {
            String area = c.getSelectedItem();
            try 
            {
                ViewMedical p = new ViewMedical(area,un);
                p.Interface();
            } 
            catch (Exception ex) {System.out.println(e);}
            f.dispose();
        }
    }
}
