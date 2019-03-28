package medical.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class MedReq extends MouseAdapter implements ActionListener
{
    JFrame f;
    JScrollPane s;
    static String un,puname;
    String name, smail;
    JButton b,bin,bup,badd,b2;
    Connection con;
    JButton bcon,bsel;
    static JTable tab;
    static int selr;
    JTextField t1,t2;
    static DefaultTableModel tm;
    ImageIcon i = new ImageIcon(((new ImageIcon("med.jpg")).getImage()).getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);
    MedReq()
    {}
    MedReq(String u)
    {
        un = u;
    }
    public void Interface() throws Exception
    {
        f = new JFrame("Medical Store");
        f.setLayout(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(600,400);
        
        JLabel l1 = new JLabel(" Medical Assistance System");
        l1.setBounds(80,25,1200,120);
        l1.setFont(new Font(Font.SERIF,Font.BOLD,100));
        l1.setForeground(Color.black);
        f.add(l1);
        l1.setBorder(BorderFactory.createMatteBorder(1,1,2, 2, Color.black));
        
        ImageIcon bi2 = new ImageIcon(((new ImageIcon("prev.png")).getImage()).getScaledInstance(50,50,Image.SCALE_SMOOTH));
        Insets in = new Insets(0,0,0,0);
        
        b2 = new JButton(bi2);
        b2.setMargin(new Insets(0,0,0,0));
        b2.setBounds(10,10,30,30);
        b2.setMargin(in);
        b2.setBorder(null);
        b2.setContentAreaFilled(false);
        b2.addMouseListener(this);
        f.add(b2);
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stmn = con.prepareStatement("select name from medsign where username = ?");
        stmn.setString(1,un);
        ResultSet rsn = stmn.executeQuery();
        rsn.next();
        name = rsn.getString(1);
        JLabel l2 = new JLabel("Welcome "+name+"!!");
        l2.setBounds(66,170,620,30);
        l2.setFont(new Font(Font.SERIF,Font.BOLD,30));
        f.add(l2);
        
        JLabel l3 = new JLabel("Delivery Requests: ");
        l3.setBounds(66,225,620,40);
        l3.setFont(new Font(Font.SERIF,Font.BOLD,30));
        f.add(l3);
        
        tab = new JTable();
        
        s = new JScrollPane(tab);
        s.setBounds(66,270, 1244, 230);
        
        tm = new DefaultTableModel(new Object[] {},0);
        tm.addTableModelListener(tab);
        tm.addColumn("Name");
        tm.addColumn("Contact No.");
        tm.addColumn("Email ID");
        tm.addColumn("Address");
        tm.addColumn("Medicine");
        tm.addColumn("Quantity");
        tm.addColumn("Amount");
        tab.setModel(tm);
        
        tab.setSelectionMode(0);
                
        String name2,age, gender, mail, add, phone,medid,username, medname;
        int amount, quantity;
        long p;
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stm = con.prepareStatement("select * from medreq where medid = ?");
        stm.setString(1,un);
        ResultSet rs = stm.executeQuery();
        while(rs.next())
        {
            name2 = rs.getString(1);
            age = rs.getString(2);
            gender = rs.getString(3);
            add = rs.getString(4);
            p = rs.getLong(5);
            phone = String.valueOf(p);
            mail = rs.getString(6);
            medid = rs.getString(7);
            username = rs.getString(8);
            medname = rs.getString(9);
            amount = rs.getInt(10);
            quantity = rs.getInt(11);
            
            tm.addRow(new Object[] {name2,phone,mail,add,medname,quantity,amount});
        }
        
        bsel  = new JButton("Confirm");
        bsel.setBounds(650,620,60,20);
        bsel.setFocusPainted(false);
        bsel.setMargin(new Insets(0,0,0,0));
        bsel.addActionListener(this);
        
        //JLabel l4 = new JLabel("Appointment Date: ");
        JLabel l4 = new JLabel("Est. Delivery Date: ");
        l4.setBounds(543,530,150,20);
        l4.setFont(new Font(Font.SERIF,Font.BOLD,15));
        f.add(l4);
        JLabel l5 = new JLabel("Time: ");
        l5.setBounds(630,570,70,20);
        l5.setFont(new Font(Font.SERIF,Font.BOLD,15));
        f.add(l5);
        
        t1 = new JTextField("(dd/mm/yyyy)");
        t1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t1.setBounds(685,530,150,20);
        t2 = new JTextField("(24 hr Format)");
        t2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        t2.setBounds(685,570,150,20);
        t1.setForeground(Color.lightGray);
        t2.setForeground(Color.lightGray);
        t1.addMouseListener(this);
        t2.addMouseListener(this);
        
        f.add(t1);
        f.add(t2);
        
        f.add(bsel);
        f.add(s);

        f.add(b2);
        f.add(s);

        l1.setForeground(new Color(255,0,0,200));
        l2.setForeground(new Color(255,0,0,200));
        l3.setForeground(new Color(255,0,0,240));
        
        tab.setBackground(new Color(0,0,0,200));
        tab.setForeground(Color.lightGray);
        JLabel back = new JLabel(i);
        back.setBounds(0, 0, 1366, 768);
        f.add(back);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //con.close();
    }
    
    public static void main(String args[])throws Exception
    {
        String str = "m.muname";
        MedReq p = new MedReq(str);
        p.Interface();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        selr = tab.getSelectedRow();
        String temp,name2, p, mail, add,date,time,medname,q, am;
        int quantity,amount;
        long phone;
        if(e.getSource()==bsel)
        {
            temp = tab.getModel().getValueAt(3,0).toString();
            name2 = tab.getModel().getValueAt(selr,0).toString();
            p = tab.getModel().getValueAt(selr,1).toString();
            phone = Long.valueOf(p);
            mail = tab.getModel().getValueAt(selr,2).toString();
            add = tab.getModel().getValueAt(selr,3).toString();
            medname = tab.getModel().getValueAt(selr,4).toString();
            q = tab.getModel().getValueAt(selr,5).toString();
            am = tab.getModel().getValueAt(selr,6).toString();
            quantity = Integer.valueOf(q);
            amount = Integer.valueOf(am);
            date = t1.getText();
            time = t2.getText();

            try 
            {
                PreparedStatement stm = con.prepareStatement("insert into condel values(?,?,?,?,?,?,?,?,?,?)");
                stm.setString(1,name2);
                stm.setLong(2,phone);
                stm.setString(3,mail);
                stm.setString(4,add);
                stm.setString(5,medname);
                stm.setInt(6,quantity);
                stm.setInt(7,amount);
                stm.setString(8,date);
                stm.setString(9,time);
                stm.setString(10,un);
                stm.executeQuery();
            
                tm.removeRow(selr);
                
            } catch (Exception ex) {
            }
            try
                {
                PreparedStatement stm = con.prepareStatement("delete from medreq where mail = ? and medname = ?");
                stm.setString(1,mail);
                stm.setString(2,medname);
                stm.executeUpdate();
                }
                catch(Exception ex){System.out.println("Catch Del");}
            
       }
    }
    
    @Override
    public void mouseClicked(MouseEvent m)
    {
        if(m.getSource()==t1)
        {
            t1.setText("");
            t1.setForeground(Color.black);
        }
        if(m.getSource()==t2)
        {
            t2.setText("");
            t2.setForeground(Color.black);
        }
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
            String str = "m.muname";
            MedPage p = new MedPage(un);
            try {
                p.InterFace();
            } catch (Exception ex) {}
            f.dispose();
        }
    }
}
