package medical.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Clinic extends MouseAdapter implements ActionListener
{
    static String un,name,add;
    static long phone;
    static String xray,bone,blood,eye,surgery,neurology,gynecology,newborn,ultrasound,sonography;
    ImageIcon i = new ImageIcon(((new ImageIcon("doc.jpg")).getImage()).getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
    Clinic()
    {
        
    }
    Clinic(String u,String n, String a,long p)
    {
        un = u;
        name = n;
        add = a;
        phone = p;
    }
    JFrame f;
    JPanel p1,p,p0;
    JRadioButton c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    ButtonGroup bg1,bg2,bg3,bg4,bg5,bg6,bg7,bg8,bg9,bg10;
    JButton b;
    public void Interface()
    {
        f = new JFrame("Clinic Details");
        f.setSize(505,700);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocation(420,15);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        p1.setBounds(0,0,505,700);
        
        JLabel l0 = new JLabel("Clinic Details");
        l0.setBounds(110,20,400,50);
        l0.setFont(new Font(Font.SERIF,Font.BOLD,50));
        l0.setForeground(Color.black);
        p1.add(l0);
        
        JLabel l02 = new JLabel("Select Facilities Available in Your Clinic: ");
        l02.setBounds(50,100,300,20);
        p1.add(l02);
        
        p0 = new JPanel();
        p0.setBounds(50, 125, 400, 25);
        p0.setLayout(null);
        p0.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        p = new JPanel();
        p.setBounds(50, 145, 400, 430);
        p.setLayout(null);
        p.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        JLabel lf = new JLabel("Facility");
        JLabel la = new JLabel("Availablity");
        lf.setFont(new Font("",Font.BOLD,15));
        la.setFont(new Font("",Font.BOLD,15));
        
        lf.setBounds(50,5,100,15);
        la.setBounds(240,5,100,15);
        p0.add(lf);
        p0.add(la);
        
        l1 = new JLabel("X-Ray");
        l1.setBounds(20,20,200,20);
        p.add(l1);
        l2 = new JLabel("Bone Setting");
        l2.setBounds(20,60,200,20);
        p.add(l2);
        l3 = new JLabel("Blood Testing");
        l3.setBounds(20,100,200,20);
        p.add(l3);
        l4 = new JLabel("Eye Testing");
        l4.setBounds(20,140,200,20);
        p.add(l4);
        l5 = new JLabel("Surgery");
        l5.setBounds(20,180,200,20);
        p.add(l5);
        l6 = new JLabel("Neurology");
        l6.setBounds(20,220,200,20);
        p.add(l6);
        l7 = new JLabel("Gynecology");
        l7.setBounds(20,260,200,20);
        p.add(l7);
        l8 = new JLabel("Newborn Screening");
        l8.setBounds(20,300,200,20);
        p.add(l8);
        l9 = new JLabel("Ultrasound");
        l9.setBounds(20,340,200,20);
        p.add(l9);
        l10 = new JLabel("Sonography");
        l10.setBounds(20,380,200,20);
        p.add(l10);
        
        bg1 = new  ButtonGroup();
        bg2 = new  ButtonGroup();
        bg3 = new  ButtonGroup();
        bg4 = new  ButtonGroup();
        bg5 = new  ButtonGroup();
        bg6 = new  ButtonGroup();
        bg7 = new  ButtonGroup();
        bg8 = new  ButtonGroup();
        bg9 = new  ButtonGroup();
        bg10 = new  ButtonGroup();
        
        c1 = new JRadioButton("Yes");
        c2 = new JRadioButton("No");
        c1.setBounds(210,20,50,20);
        c2.setBounds(290,20,50,20);
        c1.setFocusPainted(false);
        c2.setFocusPainted(false);
        bg1.add(c1);
        bg1.add(c2);
        p.add(c1);
        p.add(c2);
        
        c3 = new JRadioButton("Yes");
        c4 = new JRadioButton("No");
        c3.setBounds(210,60,50,20);
        c4.setBounds(290,60,50,20);
        c3.setFocusPainted(false);
        c4.setFocusPainted(false);
        bg2.add(c3);
        bg2.add(c4);
        p.add(c3);
        p.add(c4);
        
        c5 = new JRadioButton("Yes");
        c6 = new JRadioButton("No");
        c5.setBounds(210,100,50,20);
        c6.setBounds(290,100,50,20);
        c5.setFocusPainted(false);
        c6.setFocusPainted(false);
        bg3.add(c5);
        bg3.add(c6);
        p.add(c5);
        p.add(c6);
        
        c7 = new JRadioButton("Yes");
        c8 = new JRadioButton("No");
        c7.setBounds(210,140,50,20);
        c8.setBounds(290,140,50,20);
        c7.setFocusPainted(false);
        c8.setFocusPainted(false);
        bg4.add(c7);
        bg4.add(c8);
        p.add(c7);
        p.add(c8);
        
        c9 = new JRadioButton("Yes");
        c10 = new JRadioButton("No");
        c9.setBounds(210,180,50,20);
        c10.setBounds(290,180,50,20);
        c9.setFocusPainted(false);
        c10.setFocusPainted(false);
        bg5.add(c9);
        bg5.add(c10);
        p.add(c9);
        p.add(c10);
        
        c11 = new JRadioButton("Yes");
        c12 = new JRadioButton("No");
        c11.setBounds(210,220,50,20);
        c12.setBounds(290,220,50,20);
        c11.setFocusPainted(false);
        c12.setFocusPainted(false);
        bg6.add(c11);
        bg6.add(c12);
        p.add(c11);
        p.add(c12);
        
        c13 = new JRadioButton("Yes");
        c14 = new JRadioButton("No");
        c13.setBounds(210,260,50,20);
        c14.setBounds(290,260,50,20);
        c13.setFocusPainted(false);
        c14.setFocusPainted(false);
        bg7.add(c13);
        bg7.add(c14);
        p.add(c13);
        p.add(c14);
        
        c15 = new JRadioButton("Yes");
        c16 = new JRadioButton("No");
        c15.setBounds(210,300,50,20);
        c16.setBounds(290,300,50,20);
        c15.setFocusPainted(false);
        c16.setFocusPainted(false);
        bg8.add(c15);
        bg8.add(c16);
        p.add(c15);
        p.add(c16);
        
        c17 = new JRadioButton("Yes");
        c18 = new JRadioButton("No");
        c17.setBounds(210,340,50,20);
        c18.setBounds(290,340,50,20);
        c17.setFocusPainted(false);
        c18.setFocusPainted(false);
        bg9.add(c17);
        bg9.add(c18);
        p.add(c17);
        p.add(c18);
        
        c19 = new JRadioButton("Yes");
        c20 = new JRadioButton("No");
        c19.setBounds(210,380,50,20);
        c20.setBounds(290,380,50,20);
        c19.setFocusPainted(false);
        c20.setFocusPainted(false);
        bg10.add(c19);
        bg10.add(c20);
        p.add(c19);
        p.add(c20);
        
        
        b = new JButton("Submit");
        b.setBounds(220,600,60,30);
        b.setFocusPainted(false);
        b.setMargin(new Insets(0,0,0,0));
        b.addActionListener(this);
        
        p1.add(p0);
        p1.add(p);
        p1.add(b);
                
        f.add(p1);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main(String args[])
    {
        Clinic c = new Clinic();
        c.Interface();
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if (e.getSource()==b)
        {
            if(c1.isSelected())
            {
                xray = "Yes";
            }
            else if(c2.isSelected())
            {
                xray = "No";
            }
            if(c3.isSelected())
            {
                bone = "Yes";
            }
            else if(c4.isSelected())
            {
                bone = "No";
            }
            if(c5.isSelected())
            {
                blood = "Yes";
            }
            else if(c6.isSelected())
            {
                blood = "No";
            }
            if(c7.isSelected())
            {
                eye = "Yes";
            }
            else if(c8.isSelected())
            {
                eye = "No";
            }
            if(c9.isSelected())
            {
                surgery = "Yes";
            }
            else if(c10.isSelected())
            {
                surgery = "No";
            }
            if(c11.isSelected())
            {
                neurology = "Yes";
            }
            else if(c12.isSelected())
            {
                neurology = "No";
            }
            if(c13.isSelected())
            {
                gynecology = "Yes";
            }
            else if(c14.isSelected())
            {
                gynecology = "No";
            }
            if(c15.isSelected())
            {
                newborn = "Yes";
            }
            else if(c16.isSelected())
            {
                newborn = "No";
            }
            if(c17.isSelected())
            {
                ultrasound = "Yes";
            }
            else if(c18.isSelected())
            {
                ultrasound = "No";
            }
            if(c19.isSelected())
            {
                sonography = "Yes";
            }
            else if(c20.isSelected())
            {
                sonography = "No";
            }
            
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
                PreparedStatement stmn = con.prepareStatement("insert into clinic values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stmn.setString(1,name);
                stmn.setString(2,add);
                stmn.setString(3,xray);
                stmn.setString(4,bone);
                stmn.setString(5,blood);
                stmn.setString(6,eye);
                stmn.setString(7,surgery);
                stmn.setString(8,neurology);
                stmn.setString(9,gynecology);
                stmn.setString(10,newborn);
                stmn.setString(11,ultrasound);
                stmn.setString(12,sonography);
                stmn.setString(13,un);
                stmn.setLong(14,phone);
                stmn.executeQuery();
            }
            catch(Exception x){}
            f.dispose();
        }
    }
}