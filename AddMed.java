package medical.management;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.border.Border;
public class AddMed extends MouseAdapter implements ActionListener
{
    JFrame f;
    JPanel pan,p1;
    static String un;
    String name;
    Connection con;
    JTextField t1,t2,t3,t4,t5;
    JLabel l1,l2,l3,l4,l5;
    JButton b,b2;
    ImageIcon i = new ImageIcon(((new ImageIcon("med.jpg")).getImage()).getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);
    
    AddMed()
    {}
    AddMed(String u)
    {
        un = u;
    }
    
    public void Interface()
    {
        f = new JFrame("Add Medicine");
        f.setLayout(null);
        f.setResizable(false);
        f.setSize(390,500);
        f.setLocation(480, 100);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,390,500);
        p1.setBackground(Color.white);
        
        ImageIcon bi2 = new ImageIcon(((new ImageIcon("prev.png")).getImage()).getScaledInstance(25,25,Image.SCALE_SMOOTH));
        Insets in = new Insets(0,0,0,0);
        
        b2 = new JButton(bi2);
        b2.setMargin(new Insets(0,0,0,0));
        b2.setBounds(10,10,30,30);
        b2.setMargin(in);
        b2.setBorder(null);
        b2.setContentAreaFilled(false);
        b2.addMouseListener(this);
        f.add(b2);
        
        JLabel l = new JLabel("Add Medicine");
        l.setBounds(70,20,250,70);
        l.setFont(new Font(Font.SERIF,Font.BOLD,40));
        l.setForeground(Color.black);
        p1.add(l);
        
        l1 = new JLabel("Name: ");
        l2 = new JLabel("Category:");
        l3 = new JLabel("Power (in mg):");
        l4 = new JLabel("Type:");
        l5 = new JLabel("Cost Per Unit:");
        l1.setBounds(40,130,100,20);
        l2.setBounds(40,170,100,20);
        l3.setBounds(40,210,100,20);
        l4.setBounds(40,250,100,20);
        l5.setBounds(40,290,100,20);
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t1.setBounds(140,130,200,17);
        t2.setBounds(140,170,200,17);
        t3.setBounds(140,210,200,17);
        t4.setBounds(140,250,200,17);
        t5.setBounds(140,290,200,17);
        t1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        b = new JButton("ADD");
        b.setMargin(new Insets(0,0,0,0));
        b.setFocusPainted(false);
        b.setBounds(160,370,70,30);
        b.addActionListener(this);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);
        p1.add(b);
                
        f.add(p1);
        
        JLabel back = new JLabel(i);
        back.setBounds(0, 0, 1366, 768);
        p1.add(back);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main (String args[])
    {
        AddMed a = new AddMed("m.muname");
        a.Interface();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            if(e.getSource()==b)
            {
                String name, cat, pow, type, c;
                int cost;
                name = t1.getText();
                cat = t2.getText();
                pow = t3.getText();
                type = t4.getText();
                c = t5.getText();
                cost = Integer.valueOf(c);
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
                PreparedStatement stm = con.prepareStatement("insert into medicine values(?,?,?,?,?,?)");
                stm.setString(1,name);
                stm.setString(2,cat);
                stm.setString(3,pow);
                stm.setString(4,type);
                stm.setInt(5,cost);
                stm.setString(6,un);
                stm.executeQuery();
                con.close();
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
            }
        } 
        catch (Exception  ex) {        }
    }
    @Override
    public void mousePressed(MouseEvent me)
    {
        if(me.getSource()==b2)
        {
             b2.setBounds(8,8,30,30);
        }
        
    }
    @Override
    public void mouseReleased(MouseEvent me)
    {
        if(me.getSource()==b2)
        {
            b2.setBounds(10,10,30,30);
            f.dispose();
        }
    }
}
