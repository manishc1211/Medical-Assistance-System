package medical.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class MedicalManagement implements ActionListener
{
    JFrame f;
    GridBagConstraints gbc;
    JTextField t1,t2;
    JButton b,b2;
    JLabel l,lh;
    
    static String u,p;
    
    int north = GridBagConstraints.NORTH;
    int west = GridBagConstraints.WEST;
    int vertical = GridBagConstraints.VERTICAL;
    int horizontal = GridBagConstraints.HORIZONTAL;
    Insets in2 = new Insets(70,0,0,0);
    Insets in3 = new Insets(0,70,0,0);
    ImageIcon i = new ImageIcon(((new ImageIcon("bg1.jpg")).getImage()).getScaledInstance(1366,768,Image.SCALE_SMOOTH));
    ImageIcon h = new ImageIcon(((new ImageIcon("h2.png")).getImage()).getScaledInstance(70,70,Image.SCALE_SMOOTH));
    
    MedicalManagement()
    {
        f = new JFrame("Login");
        f.setLayout(new GridBagLayout());
        f.setSize(470,600);
        f.setResizable(false);
        f.setLocation(400, 70);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(0,0,0,200));
                
            JLabel lhead = new JLabel("Login");
            lhead.setFont(new Font(Font.SERIF,Font.BOLD,40));
            lhead.setBounds(110,20,190,60);
            lhead.setForeground(new Color(255,215,0,200));
         
            JLabel l1 = new JLabel("Not yet User?");
            JLabel l2 = new JLabel("Username:");
            l2.setFont(new Font("",Font.BOLD,14));
            JLabel l3 = new JLabel("Password:");
            l3.setFont(new Font("",Font.BOLD,14));
            l1.setForeground(Color.lightGray);
            l2.setForeground(Color.lightGray);
            l3.setForeground(Color.lightGray);
            
            t1 = new JTextField();
            t2 = new JPasswordField();
            t1.setBackground(Color.DARK_GRAY);
            t2.setBackground(Color.DARK_GRAY);
            t1.setBorder(null);
            t2.setBorder(null);
            t1.setCaretColor(Color.WHITE);
            t2.setCaretColor(Color.WHITE);
            t1.setBackground(Color.DARK_GRAY);
            t2.setBackground(Color.DARK_GRAY);
            t1.setForeground(Color.white);
            t2.setForeground(Color.white);
            
            
            l2.setBounds(20, 120, 80, 20);
            t1.setBounds(100, 123, 170, 18);
            l3.setBounds(20, 160, 80, 20);
            t2.setBounds(100, 163, 170, 18);
            
            
            b = new JButton("Login");
            b.setMargin(new Insets(0,0,0,0));
            b.setBounds(135,225,50,25);
            b.addActionListener(this);
            
            l1.setBounds(122,280,100,20);
            b2 = new JButton("SignUp");
            b2.setMargin(new Insets(0,0,0,0));
            b2.setBounds(135,305,50,20);
            b2.addActionListener(this);
        
        p.add(lhead);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(t1);
        p.add(t2);
        
        p.add(b);
        p.add(b2);
            
        Color bcol = new Color(42,32,72,240);
        JPanel P1 = new JPanel();
        P1.setBackground(bcol);
        gbc = new GridBagConstraints(20,40,7,10,2.5,1.5,north,horizontal,in2,0,30);
        f.add(P1,gbc);  
        JPanel P2 = new JPanel();
        P2.setBackground(bcol);
        gbc = new GridBagConstraints(0,0,0,0,1,1,west,vertical,in3,30,0);
        f.add(P2,gbc);
        
        gbc = new GridBagConstraints(0,0,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(58,55,0,0),300,410);
        f.add(p,gbc);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lh = new JLabel(h);
        gbc = new GridBagConstraints(0,0,0,0,1,1,GridBagConstraints.NORTHWEST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0);
        f.add(lh,gbc);
        l = new JLabel(i);
        gbc = new GridBagConstraints(0,0,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),450,600);
        f.add(l,gbc);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        u = t1.getText();
        p = t2.getText();
        if (e.getSource()==b)
        {
            int bool;
            switch (u.substring(0, 2)) {
                case "p.":
                    bool=0;
                    PatPage ps;
                    try
                    {
                        bool = Authenticate();
                    } catch (Exception ex) {}
                    switch (bool) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Username not registered.");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Password Incorrect.");
                            break;
                        case 3:
                            try
                            {
                                ps = new PatPage(u);
                                ps.Data();
                                ps.Interface();
                                f.dispose();
                            } catch (Exception ex){}
                            break;
                        default:
                            break;
                    }   break;
                case "d.":
                    System.out.println("Doc Sec");
                    bool=0;
                    DocPage ds;
                    try
                    {
                        bool = Authenticate();
                    } catch (Exception ex) {}
                    switch (bool) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Username not registered.");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Password Incorrect.");
                            break;
                        case 3:
                            try
                            {
                                ds = new DocPage(u);
                                ds.Data();
                                ds.Interface();
                                f.dispose();
                            } catch (Exception ex){}
                            break;
                        }
                    break;
                case "m.":
                    break;
                default:
                    break;
            }
        }
        else if(e.getSource()==b2)
        {
            SignUp s = new SignUp();
            f.dispose();
        }
    }
    public int Authenticate() throws Exception 
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stm = null;
        System.out.println("Auth");
        String type="";
        if(t1.getText().substring(0,2).equals("p."))
        {
            stm = con.prepareStatement("select password from patsign where username = ?");
            
        }
        else if(t1.getText().substring(0,2).equals("d."))
        {
            System.out.println("Doc Sec2");
            stm = con.prepareStatement("select password from docsign where username = ?");
        }
        else if(t1.getText().substring(0,2).equals("m."))
        {
            stm = con.prepareStatement("select password from medsign where username = ?");
        }
        
        stm.setString(1,u);
        ResultSet rs = stm.executeQuery();
        int bool;
        try
        {
                rs.next();
                rs.getString(1);
                if(!p.equals(rs.getString(1)))
                    bool = 2;
                else 
                    bool = 3;
        return bool;
        }
        catch(Exception e)
        {
            return 1;
        }
        
    }
    public static void main(String[] args) {
        MedicalManagement m = new MedicalManagement();
    }

}

