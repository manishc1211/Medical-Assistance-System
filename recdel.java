package medical.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class recdel extends MouseAdapter
{
    JFrame f;
    JScrollPane s;
    static String un;
    String name, smail;
    JButton b,bin,bup,badd,b2;
    Connection con;
    JButton bcon,bsel;
    JTextField t1,t2;
    static JTable tab;
    static DefaultTableModel tm;
    ImageIcon i = new ImageIcon(((new ImageIcon("med.jpg")).getImage()).getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);
    recdel()
    {}
    recdel(String u)
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
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stmn = con.prepareStatement("select name from medsign where username = ?");
        stmn.setString(1,un);
        ResultSet rsn = stmn.executeQuery();
        rsn.next();
        name = rsn.getString(1);
        JLabel l2 = new JLabel("Welcome "+name+"!!");
        l2.setBounds(66,180,620,30);
        l2.setFont(new Font(Font.SERIF,Font.BOLD,30));
        f.add(l2);
        
        JLabel l3 = new JLabel("Recent Deliveries: ");
        l3.setBounds(66,225,620,40);
        l3.setFont(new Font(Font.SERIF,Font.BOLD,30));
        f.add(l3);
        
        tab = new JTable();
        
        s = new JScrollPane(tab);
        s.setBounds(66,280, 1244, 373);
        
        tm = new DefaultTableModel(new Object[] {},0);
        tm.addTableModelListener(tab);
        /*tm.addColumn("Name");
        tm.addColumn("Contact No.");
        tm.addColumn("Mail ID");
        tm.addColumn("Address");
        tm.addColumn("Medicine");
        tm.addColumn("Quantity");
        tm.addColumn("Amount");
        tm.addColumn("Delivery Date");
        tm.addColumn("Time");*/
        tm.addColumn("");
        tm.addColumn("");
        tm.addColumn("");
        tm.addColumn("");
        tm.addColumn("");
        tm.addColumn("");
        tm.addColumn("");
        tm.addColumn("");
        tm.addColumn("");
        tab.setModel(tm);
        
        tab.setSelectionMode(0);
                
        String name2, mail, add, phone, medname,deldate,time;
        int amount, quantity;
        long p;
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stm = con.prepareStatement("select * from recdel where medid = ?");
        stm.setString(1,un);
        ResultSet rs = stm.executeQuery();
        while(rs.next())
        {
            name2 = rs.getString(1);
            p = rs.getLong(2);
            phone = String.valueOf(p);
            mail = rs.getString(3);
            add = rs.getString(4);
            medname = rs.getString(5);
            amount = rs.getInt(7);
            quantity = rs.getInt(6);
            deldate = rs.getString(9);
            time = rs.getString(8);
            
            tm.addRow(new Object[] {name2,phone,mail,add,medname,quantity,amount,deldate,time});
        }
        
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
    
    public static void main(String args[])throws Exception
    {
        String str = "m.muname";
        recdel p = new recdel(str);
        p.Interface();
    }

    
}
