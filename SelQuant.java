package medical.management;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.Border;
public class SelQuant extends KeyAdapter implements ActionListener
{
    JFrame f;
    JPanel pan,p1;
    static String un;
    String name,mname,category,power,type;
    Connection con;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b;
    int quantity, amount;
    static int price;
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);
    
    SelQuant()
    {}
    SelQuant(String n,String c, String pow, String t, int p)
    {
        mname = n;
        category = c;
        power = pow;
        type = t;
        price = p;
    }
    
    public void Interface()
    {
        f = new JFrame();
        f.setLayout(null);
        f.setResizable(false);
        f.setSize(390,540);
        f.setLocation(480, 50);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,390,540);
        p1.setBackground(Color.white);
        
        JLabel l = new JLabel("Select Quantity");
        l.setBounds(60,20,350,70);
        l.setFont(new Font(Font.SERIF,Font.BOLD,40));
        l.setForeground(Color.black);
        p1.add(l);
        
        l1 = new JLabel("Name: ");
        l2 = new JLabel("Category:");
        l3 = new JLabel("Power (in mg):");
        l4 = new JLabel("Type:");
        l5 = new JLabel("Cost Per Unit:");
        l6 = new JLabel("Quantity:");
        l6.setForeground(Color.red);
        l7 = new JLabel("Net Amount:");
        l1.setBounds(40,130,100,20);
        l2.setBounds(40,170,100,20);
        l3.setBounds(40,210,100,20);
        l4.setBounds(40,250,100,20);
        l5.setBounds(40,290,100,20);
        l6.setBounds(40,330,100,20);
        l7.setBounds(40,370,100,20);
        
        t1 = new JTextField(mname);
        t2 = new JTextField(category);
        t3 = new JTextField(power);
        t4 = new JTextField(type);
        t5 = new JTextField(String.valueOf(price));
        t6 = new JTextField();
        t6.addKeyListener(this);
        t7 = new JTextField();
        t7.setForeground(Color.red);
        t1.setBounds(140,130,200,17);
        t2.setBounds(140,170,200,17);
        t3.setBounds(140,210,200,17);
        t4.setBounds(140,250,200,17);
        t5.setBounds(140,290,200,17);
        t6.setBounds(140,330,200,17);
        t7.setBounds(140,370,200,17);
        t1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t7.setEditable(false);
        
        
        b = new JButton("Confirm");
        b.setMargin(new Insets(0,0,0,0));
        b.setFocusPainted(false);
        b.setBounds(160,450,70,30);
        b.addActionListener(this);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);
        p1.add(t6);
        p1.add(t7);
        p1.add(b);
                
        f.add(p1);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main (String args[])
    {
        SelQuant s = new SelQuant("","","","",5);
        s.Interface();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        String qs = t6.getText();
        
        if(qs.equals(""))
        {
            t7.setText("");
            amount = 0;
        }
        else
        {
            quantity = Integer.parseInt(qs);
            amount = quantity * price;
            t7.setText(String.valueOf(amount));
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        PatPage pp;
        try 
        {
            pp = new PatPage(quantity,amount);
        } 
        catch (Exception  ex) {        }
    }
}
