package medical.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.border.Border;
public class DocPage implements ActionListener
{
    JFrame f;
    JScrollPane s;
    JPanel pan,p1,p2,p3;
    static String un, name, add;
    static long phone;
    JButton b,bin,bup,badd;
    Connection con;
    JPanel pbutton, pbutton2;
    JButton bm1,bm2,bm3,bm4,bm5,bm6;
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);
    ImageIcon i = new ImageIcon(((new ImageIcon("doc.jpg")).getImage()).getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
    DocPage()
    {}
    DocPage(String u)
    {
        un = u;
    }
    public void Interface() throws Exception
    {
        f = new JFrame("Doctor");
        f.setLayout(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(600,400);
        
        pan = new JPanel();
        pan.setBackground(Color.RED);
        //pan.setPreferredSize(new Dimension(1346,1100));
        pan.setLayout(null);
        s = new JScrollPane(pan,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        s.setBounds(10, 10, 1346, 695);
        
        JLabel l1 = new JLabel(" Medical Assistance System");
        l1.setBounds(75,25,1200,120);
        l1.setFont(new Font(Font.SERIF,Font.BOLD,100));
        l1.setForeground(Color.black);
        pan.add(l1);
        l1.setBorder(BorderFactory.createMatteBorder(1,1,2, 2, Color.black));
        
        
        bin = new JButton("View Profile");
        bin.setBounds(1080,170,250,70);
        bin.setContentAreaFilled(true);
        bin.setFocusPainted(false);
        bin.setFocusCycleRoot(false);
        bin.setFocusable(false);
        bin.setBackground(Color.PINK);
        bin.setBorder(null);
        //pan.add(bin);
        bup = new JButton("Update Info");
        bup.setBounds(1080,241,250,70);
        bup.setContentAreaFilled(true);
        bup.setFocusPainted(false);
        bup.setBackground(Color.PINK);
        bup.setBorder(null);
        //pan.add(bup);
        
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(250,165,830,500);
        p1.setBackground(new Color(0,0,0,100));
        
        pbutton = new JPanel();
        pbutton.setLayout(null);
        pbutton.setBounds(30,130,770,170);
        pbutton.setBackground(new Color(0,0,0,100));
        
        pbutton2 = new JPanel();
        pbutton2.setBackground(new Color(0,0,0,170));        
        pbutton2.setLayout(null);
        pbutton2.setBounds(20, 300, 790, 180);
        p1.setBorder(border);
        
        bm1 = new JButton("Appointment Requests");
        bm2 = new JButton("Upcoming Appointments");
        bm3 = new JButton("Recent Appointments");
        bm4 = new JButton("Partner Medical Stores");
        bm5 = new JButton("Update Clinic Details");
        bm6 = new JButton("Online Consultation");
        bm1.setBorder(null);
        bm2.setBorder(null);
        bm3.setBorder(null);
        bm4.setBorder(null);
        bm5.setBorder(null);
        bm6.setBorder(null);
        bm1.setFocusPainted(false);
        bm2.setFocusPainted(false);
        bm3.setFocusPainted(false);
        bm4.setFocusPainted(false);
        bm5.setFocusPainted(false);
        bm6.setFocusPainted(false);
        bm1.addActionListener(this);
        bm2.addActionListener(this);
        bm3.addActionListener(this);
        bm4.addActionListener(this);
        bm5.addActionListener(this);
        bm6.addActionListener(this);
        
        bm1.setBounds(42,50,210,80);
        bm2.setBounds(279,50,210,80);
        bm3.setBounds(516,50,210,80);
        pbutton.add(bm1);
        pbutton.add(bm2);
        pbutton.add(bm3);
        
        /*bm4.setBounds(65,50,190,80);
        bm5.setBounds(300,50,190,80);
        bm6.setBounds(535,50,190,80);
        pbutton2.add(bm4);
        pbutton2.add(bm5);
        pbutton2.add(bm6);*/
        bm5.setBounds(160,350,210,80);
        bm6.setBounds(460,350,210,80);
        p1.add(bm5);
        p1.add(bm6);
        
        
        p1.add(pbutton);
        p1.add(pbutton2);
        
        pan.add(p1);
        
        JLabel l2 = new JLabel("Welcome "+name+"!!");
        l2.setForeground(new Color(255,255,0,255));
        l2.setBounds(40,40,600,40);
        l2.setFont(new Font(Font.SERIF,Font.BOLD,35));
        p1.add(l2);
        
        PreparedStatement stmt2 = con.prepareStatement("select phone, concat(concat(concat(concat(concat(concat(concat(concat(concat(concat(plot,', '),street),', '),street2),', '),locality),', '),concat(concat(concat(concat(city,', '),state),', '),country)),' '),pin) from docsign where username = ?");
        stmt2.setString(1, un);
        ResultSet rs2 = stmt2.executeQuery();
        rs2.next();
        phone = rs2.getLong(1);
        add = rs2.getString(2);
        
        JLabel back = new JLabel(i);
        back.setBounds(0, 0, 1366, 768);
        pan.add(back);
        
        f.add(s);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void Data() throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stm = con.prepareStatement("select name from docsign where username = ?");
        stm.setString(1,un);
        ResultSet rs = stm.executeQuery();
        rs.next();
        name = rs.getString(1);
    }
    public static void main(String args[])throws Exception
    {
        String str = "d.doc7";
        DocPage p = new DocPage(str);
        p.Data();
        p.Interface();
    }

    class ChatThread extends Thread
    {
        public void run()
        {
            try {
                DocChat se = new DocChat();
                se.Initiate();
            } 
            catch (Exception ex) {            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        ChatThread dc = new ChatThread();
        if(e.getSource()==bm1)
        {
            Appointment a = new Appointment(un);
            try 
            {
                a.Interface();
            } catch (Exception ex) {}
            f.dispose();
        }
        else if(e.getSource()==bm2)
        {
            try {
                comapp p = new comapp(un);
                p.Interface();
            } catch (Exception ex) {}
            f.dispose();
        }
        else if(e.getSource()==bm3)
        {
            try {
                recapp p = new recapp(un);
                p.Interface();
            } catch (Exception ex) {}
            f.dispose();
        }
        else if(e.getSource()==bm4)
        {
            
        }
        else if(e.getSource()==bm5)
        {
            Clinic c = new Clinic(un,name,add,phone);
            c.Interface();
        }
        else if(e.getSource()==bm6)
        {
            dc.start();
        }
    }
}
