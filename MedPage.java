package medical.management;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;


public class MedPage implements ActionListener
{
    JFrame f;
    JScrollPane s;
    JPanel pan,p1,p2,p3;
    //JTextArea p1;
    static String un;
    String name;
    JButton b,bin,bup,badd,bm1,bm2,bm3,bm4,bm5,bm6;
    Connection con;
    JPanel pbutton, pbutton2;
    ImageIcon i = new ImageIcon(((new ImageIcon("med.jpg")).getImage()).getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);
    MedPage()
    {}
    MedPage(String u)
    {
        un = u;
    }
    public void InterFace() throws Exception
    {
        f = new JFrame("Medical Store");
        f.setLayout(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(600,400);
        
        pan = new JPanel();
        pan.setBackground(Color.RED);
        pan.setPreferredSize(new Dimension(1346,1100));
        pan.setLayout(null);
        pan.setBounds(10, 10, 1346, 695);
        
        JLabel l1 = new JLabel(" Medical Assistance System");
        l1.setBounds(80,25,1200,120);
        l1.setFont(new Font(Font.SERIF,Font.BOLD,100));
        l1.setForeground(Color.black);
        f.add(l1);
        l1.setBorder(BorderFactory.createMatteBorder(1,1,2, 2, Color.black));
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(250,165,830,500);
        p1.setBackground(new Color(0,0,0,130));
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stm = con.prepareStatement("select name from medsign where username = ?");
        stm.setString(1,un);
        ResultSet rs = stm.executeQuery();
        rs.next();
        name = rs.getString(1);

        JLabel l2 = new JLabel("Welcome "+name+"!!");
        l2.setBounds(40,40,600,40);
        l2.setFont(new Font(Font.SERIF,Font.BOLD,35));
        p1.add(l2);
        
        pbutton = new JPanel();
        pbutton.setLayout(null);
        pbutton.setBounds(30,130,770,170);
        pbutton.setBackground(new Color(0,0,0,130));
        p1.setBorder(border);
        
        pbutton2 = new JPanel();
        pbutton2.setBackground(new Color(0,0,0,170));        
        pbutton2.setLayout(null);
        pbutton2.setBounds(20, 300, 790, 180);
        
        bm1 = new JButton("Home Delivery Requests");
        bm2 = new JButton("Delivery Requests in Progress");
        bm3 = new JButton("Recent Deliveries");
        bm1.setBorder(null);
        bm2.setBorder(null);
        bm3.setBorder(null);
        bm1.setFocusPainted(false);
        bm2.setFocusPainted(false);
        bm3.setFocusPainted(false);
        bm1.addActionListener(this);
        bm2.addActionListener(this);
        bm3.addActionListener(this);
        bm1.setBounds(42,50,210,80);
        bm2.setBounds(279,50,210,80);
        bm3.setBounds(516,50,210,80);
        pbutton.add(bm1);
        pbutton.add(bm2);
        pbutton.add(bm3);
        
        
        bm4 = new JButton("View Medicines in Store");
        bm5 = new JButton("Add Medicines");
        bm4.setBorder(null);
        bm5.setBorder(null);
        bm4.setFocusPainted(false);
        bm5.setFocusPainted(false);
        bm4.addActionListener(this);
        bm5.addActionListener(this);
        bm4.setBounds(160,350,210,80);
        bm5.setBounds(460,350,210,80);
        
        p1.add(bm4);
        p1.add(bm5);
        p1.add(pbutton);
        p1.add(pbutton2);
        
        pan.add(p1);
        f.add(pan);

        l1.setForeground(new Color(255,0,0,200));
        l2.setForeground(new Color(255,255,0,255));
        
        JLabel back = new JLabel(i);
        back.setBounds(0, 0, 1366, 768);
        pan.add(back);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) throws Exception
    {
        String un1 = "m.muname";
        MedPage m = new MedPage(un1);
        m.InterFace();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==bm1)
        {
            try 
            {
                MedReq p = new MedReq(un);
                p.Interface();
                f.dispose();
            } catch (Exception ex) {}
        }
        if (e.getSource()==bm2)
        {
            try 
            {
                condel p = new condel(un);
                p.Interface();
                f.dispose();
            } catch (Exception ex) {}
        }
        if (e.getSource()==bm3)
        {
            try 
            {
                recdel p = new recdel(un);
                p.Interface();
                f.dispose();
            } catch (Exception ex) {}
        }
        if (e.getSource()==bm4)
        {
            try 
            {
                ViewMed p = new ViewMed(un);
                p.Interface();
                f.dispose();
            } catch (Exception ex) {}
        }
        if (e.getSource()==bm5)
        {
            AddMed a = new AddMed(un);
            a.Interface();
        }
    }
}