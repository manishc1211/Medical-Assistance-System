package medical.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class Appointment extends MouseAdapter implements ActionListener
{
    JFrame f;
    JScrollPane s;
    static String un,puname;
    String name, smail;
    JButton b2,bin,bup,badd;
    Connection con;
    JButton bcon,bsel;
    static JTable tab;
    JTextField t1,t2;
    static DefaultTableModel tm;
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);
    ImageIcon i = new ImageIcon(((new ImageIcon("doc.jpg")).getImage()).getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
    Appointment()
    {}
    Appointment(String u)
    {
        un = u;
    }
    public void Interface() throws Exception
    {
        f = new JFrame("Doctor");
        f.setLayout(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(600,400);
        
        JLabel l1 = new JLabel(" Medical Assistance System");
        l1.setBounds(80,25,1200,120);
        l1.setFont(new Font(Font.SERIF,Font.BOLD,100));
        l1.setForeground(Color.black);
        f.add(l1);
        l1.setBorder(BorderFactory.createMatteBorder(1,1,2, 2, Color.black));

        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stmn = con.prepareStatement("select name from docsign where username = ?");
        stmn.setString(1,un);
        ResultSet rsn = stmn.executeQuery();
        rsn.next();
        name = rsn.getString(1);
        JLabel l2 = new JLabel("Welcome "+name+"!!");
        l2.setBounds(66,180,620,30);
        l2.setFont(new Font(Font.SERIF,Font.BOLD,30));
        f.add(l2);
        
        JLabel l3 = new JLabel("Appointment Requests: ");
        l3.setBounds(66,225,620,40);
        l3.setFont(new Font(Font.SERIF,Font.BOLD,30));
        f.add(l3);
        
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
        
        tab = new JTable();
        
        s = new JScrollPane(tab);
        s.setBounds(66,270, 1244, 230);
        
        tm = new DefaultTableModel(new Object[] {},0);
        tm.addTableModelListener(tab);
        tm.addColumn("Name");
        tm.addColumn("Age");
        tm.addColumn("Gender");
        tm.addColumn("Contact No.");
        tm.addColumn("Email ID");
        tm.addColumn("Address");
        tab.setModel(tm);
        
        
        tab.setSelectionMode(0);
                
        String name2, age, gender, mail, add, phone;
        long p;
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stm = con.prepareStatement("select * from appoint where docid = ?");
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
            puname = rs.getString(8);
            tm.addRow(new Object[] {name2,age,gender,phone,mail,add});
        }
        bsel  = new JButton("Confirm");
        bsel.setBounds(650,620,60,20);
        bsel.setFocusPainted(false);
        bsel.setMargin(new Insets(0,0,0,0));
        bsel.addActionListener(this);
        
        //JLabel l4 = new JLabel("Appointment Date: ");
        JLabel l4 = new JLabel("Appointment Date: ");
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
        
        f.add(b2);
        f.add(t1);
        f.add(t2);
        
        f.add(bsel);
        f.add(s);

        tab.setBackground(new Color(0,0,0,200));
        tab.setForeground(Color.white);
        JLabel back = new JLabel(i);
        back.setBounds(0, 0, 1366, 768);
        f.add(back);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //con.close();
    }
    
    public static void main(String args[])throws Exception
    {
        String str = "d.doc6";
        Appointment p = new Appointment(str);
        p.Interface();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==bsel)
        {
            int selr = tab.getSelectedRow();
            String name2, age, gender, p, mail, add,date,time;
            long phone;
            
            name2 = tab.getModel().getValueAt(selr,0).toString();
            age = tab.getModel().getValueAt(selr,1).toString();
            gender = tab.getModel().getValueAt(selr,2).toString();
            p = tab.getModel().getValueAt(selr,3).toString();
            phone = Long.valueOf(p);
            mail = tab.getModel().getValueAt(selr,4).toString();
            add = tab.getModel().getValueAt(selr,5).toString();
            date = t1.getText();
            time = t2.getText();
            
            try
            {
                PreparedStatement stm = con.prepareStatement("insert into conapp values(?,?,?,?,?,?,?,?,?)");
                stm.setString(1,name2);
                stm.setString(2,age);
                stm.setString(3,gender);
                stm.setLong(4,phone);
                stm.setString(5,mail);
                stm.setString(6,add);
                stm.setString(7,date);
                stm.setString(8,time);
                stm.setString(9,un);
                stm.executeUpdate();
            }
            catch(Exception x){}
            tm.removeRow(selr);
            
            try
            {
                PreparedStatement stm = con.prepareStatement("delete from appoint where mail = ?");
                stm.setString(1,mail);
                stm.executeUpdate();
            }
            catch(Exception ex){}
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
            try {
                b2.setBounds(10,10,30,30);
                DocPage p = new DocPage(un);
                p.Data();
                p.Interface();
                f.dispose();
            } catch (Exception ex) {  }
        }
    }
}
