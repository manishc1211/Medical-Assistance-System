package medical.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class ViewMed extends MouseAdapter implements ActionListener
{
    JFrame f;
    JScrollPane s;
    static String un;
    String name, smail;
    JButton b,bin,bup,badd;
    Connection con;
    JButton bcon,bsel,b2;
    static JTable tab;
    JTextField t1,t2;
    static DefaultTableModel tm;
    ImageIcon i = new ImageIcon(((new ImageIcon("med.jpg")).getImage()).getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);
    ViewMed()
    {}
    ViewMed(String u)
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
        l2.setBounds(66,180,620,30);
        l2.setFont(new Font(Font.SERIF,Font.BOLD,30));
        f.add(l2);
        
        JLabel l3 = new JLabel("Coming Appointments: ");
        l3.setBounds(66,225,620,40);
        l3.setFont(new Font(Font.SERIF,Font.BOLD,30));
        f.add(l3);
        
        tab = new JTable();
        
        s = new JScrollPane(tab);
        s.setBounds(66,280, 1244, 373);
        
        tm = new DefaultTableModel(new Object[] {},0);
        tm.addTableModelListener(tab);
        tm.addColumn("Name");
        tm.addColumn("Category");
        tm.addColumn("Power (in mg)");
        tm.addColumn("Type");
        tm.addColumn("Cost per Unit (in Rs)");
        
        tab.setModel(tm);
        
        System.out.println();
        
        tab.setSelectionMode(0);
                
        String name2, cat, pow, type, cost;
        int c;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stm = con.prepareStatement("select * from medicine where username = ?");
        stm.setString(1,un);
        ResultSet rs = stm.executeQuery();
        while(rs.next())
        {
            name2 = rs.getString(1);
            cat = rs.getString(2);
            pow = rs.getString(3);
            type = rs.getString(4);
            c = rs.getInt(5);
            cost = String.valueOf(c);
            tm.addRow(new Object[] {name2,cat,pow,type,cost});
        }
        bsel  = new JButton("Remove Medicine");
        bsel.setBounds(625,665,110,20);
        bsel.setFocusPainted(false);
        bsel.setMargin(new Insets(0,0,0,0));
        bsel.addActionListener(this);
        
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
        ViewMed p = new ViewMed(str);
        p.Interface();
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
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==bsel)
        {
            String name2;
            int selr = tab.getSelectedRow();
            name2 = tab.getModel().getValueAt(selr,0).toString();
            tm.removeRow(selr);
            try
            {
                PreparedStatement stm = con.prepareStatement("delete from medicine where name = ? and username = ?");
                stm.setString(1,name2);
                stm.setString(2,un);
                stm.executeUpdate();
            }
            catch(Exception ex){}
       }
    }

}
