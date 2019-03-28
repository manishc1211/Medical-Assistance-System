package medical.management;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PatientSignUp extends Thread implements ActionListener
{
    
    GridBagConstraints gbc;
    JPanel p;
    static JLabel lhead,lback,lname,lgender,lage,lmail,lcontact,ladd,lplot,lstreet,lstreet2,llocality,lcity,lstate,lpin,lcountry,ldob,luname,lpwd,lcpwd;
    static JTextField tname,tgender,tage,tmail,tcontact,tplot,tstreet,tstreet2,tlocality,tcity,tstate,tpin,tcountry,tdob1,tdob2,tdob3,tuname,tpwd,tcpwd;
    JButton b1;
    static boolean b; 
    static String name,gender,mail,dob1,dob2,dob3,plot,loc,street,street2,state,city,country,uname,pwd,cpwd,temp;
    static int age;
    static long phone,pin;
    ImageIcon i = new ImageIcon(((new ImageIcon("pat1.jpg")).getImage()).getScaledInstance(1366,768,Image.SCALE_SMOOTH));
    ImageIcon hb = new ImageIcon(((new ImageIcon("hb.png")).getImage()).getScaledInstance(30,30,Image.SCALE_SMOOTH));
    JFrame f;
    Connection con;
    
    public PatientSignUp(int c) 
    {
        try {
            System.out.println("ip1");
            PreparedStatement ps = con.prepareStatement("insert into patsign values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println("ip2");
            ps.setString(1,name);
            ps.setString(2,dob1);
            ps.setString(3,dob2);
            ps.setString(4,dob3);
            ps.setString(5,gender);
            ps.setInt(6,age);
            ps.setLong(7,phone);
            ps.setString(8,mail);
            ps.setString(9,plot);
            ps.setString(10,loc);
            ps.setString(11,street);
            ps.setString(18,street2);
            ps.setString(12,city);
            ps.setString(13,state);
            ps.setString(14,country);
            ps.setLong(15,pin);
            ps.setString(16,uname);
            ps.setString(17,pwd);
            ps.executeUpdate();System.out.println("1");
            Statement s = con.createStatement();
            System.out.println("2");
            con.close();
            
            MedicalManagement mg = new MedicalManagement();
            f.dispose();
        } catch (SQLException ex) {System.out.println("Catch");        }
    }
    PatientSignUp()
    {
        
    }
    
    public void Interface()
    {
        int a;
        f = new JFrame("Patient SignUp");
        f.setSize(1400,800);
        f.setLayout(new GridBagLayout());
        f.setLocation(0,0);
        
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(0,0,0,120));
            
            lhead = new JLabel("Sign Up");
            lhead.setFont(new Font(Font.SERIF,Font.BOLD,50));
            lhead.setBounds(170,30,190,60);
            lhead.setForeground(new Color(255,215,0,200));
            
            lname = new JLabel("Full Name: ");
            lgender = new JLabel("Gender: ");
            lage = new JLabel("Age: ");
            lmail = new JLabel("Email Address: ");
            lcontact = new JLabel("Contact No.: ");
            ladd = new JLabel("Address: ");
            lplot = new JLabel("Plot no.: ");
            llocality = new JLabel("Locality: ");
            lstreet = new JLabel("Street 1: ");
            lstreet2 = new JLabel("Street 2: ");
            lcity = new JLabel("City: ");
            lstate = new JLabel("State: ");
            lpin = new JLabel("Pin Code: ");
            lcountry = new JLabel("Country: ");
            ldob = new JLabel("DOB(dd/mm/yy): ");
            luname = new JLabel("Username: ");
            lpwd = new JLabel("Password: ");
            lcpwd = new JLabel("Confirm Password: ");
            
            tname = new JTextField();
            tgender = new JTextField();
            tage = new JTextField();
            tmail = new JTextField();
            tcontact = new JTextField();
            tdob1 = new JTextField();
            tdob2 = new JTextField();
            tdob3 = new JTextField();
            tplot = new JTextField();
            tlocality = new JTextField();
            tstreet = new JTextField();
            tstreet2 = new JTextField();
            tcity = new JTextField();
            tstate = new JTextField();
            tpin = new JTextField();
            tcountry = new JTextField();
            tuname = new JTextField();
            tpwd = new JTextField();
            tcpwd = new JTextField();
            
            lname.setBounds(50, 120, 115, 20);
            lgender.setBounds(50, 180, 80, 20);
            lage.setBounds(280, 180, 80, 20);
            ldob.setBounds(50, 150, 115, 20);           
            lcontact.setBounds(50, 210, 115, 20);  
            lmail.setBounds(50, 240, 115, 20);
            ladd.setBounds(50, 275,115, 20);
            lplot.setBounds(50, 300, 80, 20);
            llocality.setBounds(230, 300, 80, 20);
            lstreet.setBounds(50, 325, 80, 20);
            lstreet2.setBounds(230, 325, 80, 20);
            lcity.setBounds(50, 350, 80, 20);
            lstate.setBounds(230, 350, 80, 20);
            lpin.setBounds(230, 375, 80, 20);
            lcountry.setBounds(50, 375, 80, 20);
            luname.setBounds(50, 435, 115, 20);
            lpwd.setBounds(50, 465, 115, 20);
            lcpwd.setBounds(50, 495, 115, 20);
            
            
            tname.setForeground(Color.white);
            tname.setBackground(Color.DARK_GRAY);
            lname.setForeground(Color.lightGray);
            tgender.setBackground(Color.DARK_GRAY);
            lgender.setForeground(Color.LIGHT_GRAY);
            tgender.setForeground(Color.white);
            tage.setBackground(Color.DARK_GRAY);
            lage.setForeground(Color.lightGray);
            tage.setForeground(Color.white);
            tmail.setBackground(Color.DARK_GRAY);
            lmail.setForeground(Color.lightGray);
            tmail.setForeground(Color.white);
            tcontact.setBackground(Color.DARK_GRAY);
            lcontact.setForeground(Color.lightGray);
            tcontact.setForeground(Color.white);
            ldob.setForeground(Color.lightGray);
            tdob1.setBackground(Color.DARK_GRAY);
            tdob1.setForeground(Color.white);
            tdob2.setBackground(Color.DARK_GRAY);
            tdob2.setForeground(Color.white);
            tdob3.setBackground(Color.DARK_GRAY);
            tdob3.setForeground(Color.white); 
            tplot.setBackground(Color.DARK_GRAY);
            lplot.setForeground(Color.lightGray);
            tplot.setForeground(Color.white);
            tlocality.setBackground(Color.DARK_GRAY);
            llocality.setForeground(Color.lightGray);
            tlocality.setForeground(Color.white);
            tstreet.setBackground(Color.DARK_GRAY);
            lstreet.setForeground(Color.lightGray);
            tstreet.setForeground(Color.white);
            tstreet2.setBackground(Color.DARK_GRAY);
            lstreet2.setForeground(Color.lightGray);
            tstreet2.setForeground(Color.white);
            tcity.setBackground(Color.DARK_GRAY);
            lcity.setForeground(Color.lightGray);
            tcity.setForeground(Color.white);
            tstate.setBackground(Color.DARK_GRAY);
            lstate.setForeground(Color.lightGray);
            tstate.setForeground(Color.white);
            tpin.setBackground(Color.DARK_GRAY);
            lpin.setForeground(Color.lightGray);
            tpin.setForeground(Color.white);
            tcountry.setBackground(Color.DARK_GRAY);
            lcountry.setForeground(Color.lightGray);
            tcountry.setForeground(Color.white);
            
            tuname.setBackground(Color.DARK_GRAY);
            luname.setForeground(Color.lightGray);
            tuname.setForeground(Color.white);
            tpwd.setBackground(Color.DARK_GRAY);
            lpwd.setForeground(Color.lightGray);
            tpwd.setForeground(Color.white);
            tcpwd.setBackground(Color.DARK_GRAY);
            lcpwd.setForeground(Color.lightGray);
            tcpwd.setForeground(Color.white);
            ladd.setForeground(Color.lightGray);
            
            tname.setBorder(null);
            tgender.setBorder(null);
            tage.setBorder(null);
            tmail.setBorder(null);
            tcontact.setBorder(null);
            tplot.setBorder(null);
            tlocality.setBorder(null);
            tstreet.setBorder(null);
            tstreet2.setBorder(null);
            tcity.setBorder(null);
            tstate.setBorder(null);
            tpin.setBorder(null);
            tcountry.setBorder(null);
            tpwd.setBorder(null);
            tuname.setBorder(null);
            tcpwd.setBorder(null);
            tdob1.setBorder(null);
            tdob2.setBorder(null);
            tdob3.setBorder(null);
            
            tpwd.setCaretColor(Color.white);
            tstreet.setCaretColor(Color.white);
            tstreet2.setCaretColor(Color.white);
            tstate.setCaretColor(Color.white);
            tplot.setCaretColor(Color.white);
            tpin.setCaretColor(Color.white);
            tname.setCaretColor(Color.white);
            tmail.setCaretColor(Color.white);
            tlocality.setCaretColor(Color.white);
            tcountry.setCaretColor(Color.white);
            tdob1.setCaretColor(Color.white);
            tdob2.setCaretColor(Color.white);
            tdob3.setCaretColor(Color.white);
            tgender.setCaretColor(Color.white);
            tcpwd.setCaretColor(Color.white);
            tcontact.setCaretColor(Color.white);
            tcity.setCaretColor(Color.white);
            tage.setCaretColor(Color.white);
            tuname.setCaretColor(Color.white);
            
            tname.setBounds(145, 120, 280, 17);
            tgender.setBounds(145, 180, 110, 17);
            tage.setBounds(315, 180, 110, 17);
            tdob1.setBounds(145, 150, 50, 17);
            tdob2.setBounds(210, 150, 50, 17);
            tdob3.setBounds(275, 150, 50, 17);
            tcontact.setBounds(145, 210, 280, 17);           
            tmail.setBounds(145, 240, 280, 17);
            tplot.setBounds(105, 300, 120, 17);
            tlocality.setBounds(285, 300, 140, 17);
            tstreet.setBounds(105, 325, 120, 17);
            tstreet2.setBounds(285, 325, 140, 17);
            tcity.setBounds(105, 350, 120, 17);
            tstate.setBounds(285, 350, 140, 17);
            tpin.setBounds(285, 375, 140, 17);
            tcountry.setBounds(105, 375, 120, 17);
            tuname.setBounds(175, 435, 250, 17);
            tpwd.setBounds(175, 465, 250, 17);
            tcpwd.setBounds(175, 495, 250, 17);
            tuname.setText("p.");
            
            b1 = new JButton("Submit");
            b1.setMargin(new Insets(15,0,15,0));
            b1.setBorder(BorderFactory.createEmptyBorder());
            b1.setBounds(220,560,60,30);
            b1.addActionListener(this);
            
        p.add(lhead);
        p.add(lname);
        p.add(lgender);
        p.add(lage);
        p.add(lmail);
        p.add(lcontact);
        p.add(ladd);
        p.add(lplot);
        p.add(llocality);
        p.add(lstreet);
        p.add(lstreet2);
        p.add(lcity);
        p.add(lstate);
        p.add(lpin);
        p.add(lcountry);
        p.add(ldob);
        p.add(luname);
        p.add(lpwd);
        p.add(lcpwd);
        
        p.add(tname);
        p.add(tgender);
        p.add(tage);
        p.add(tmail);
        p.add(tcontact);
        p.add(tplot);
        p.add(tlocality);
        p.add(tstreet);
        p.add(tstreet2);
        p.add(tcity);
        p.add(tstate);
        p.add(tpin);
        p.add(tcountry);
        p.add(tdob1);
        p.add(tdob2);
        p.add(tdob3);
        p.add(tuname);
        p.add(tpwd);
        p.add(tcpwd);
        p.add(b1);
        
        p.add(tname);
        gbc = new GridBagConstraints(0,0,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),500,630);
        f.add(p,gbc);
        f.setLocation(1,3);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lback = new JLabel();
        lback.setIcon(i);
        gbc = new GridBagConstraints(0,0,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),1366,768);
        f.add(lback,gbc);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource()==b1)
        {
            try{System.out.println("ap");Data();}
            catch(Exception exc){}
        } 
    }
    void Data() throws Exception
    {
        b=false;
        name = tname.getText();
        gender = tgender.getText();
        mail = tmail.getText();
        dob1 = tdob1.getText();
        dob2 = tdob2.getText();
        dob3 = tdob3.getText();
        plot = tplot.getText();
        loc = tlocality.getText();
        street = tstreet.getText();
        street2 = tstreet2.getText();
        state = tstate.getText();
        city = tcity.getText();
        country = tcountry.getText();
        uname = tuname.getText();
        pwd = tpwd.getText();
        cpwd = tcpwd.getText();
        temp = tage.getText();
        age = Integer.valueOf(temp);
        temp = tcontact.getText();
        phone = Long.valueOf(temp);
        temp = tpin.getText();
        pin = Long.valueOf(temp);
        //System.out.println("Name: "+name+"\nGender: "+gender+"\nMail: "+mail+"\nDOB: "+dob1+"-"+dob2+""+dob3+"\nPlot: "+plot+"\nLoc: "+loc+"\nStreet: "+street+"\nCity: "+city+"\nState: "+state+"\nCountry: "+country+"\nUName: "+uname+"\npwd: "+pwd+"\nAge: "+age+"\nPhone: "+phone+"\nPin: "+pin);   
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from patsign");
        while(rs.next())
        {
            try
            {
                if(phone==rs.getLong(7))
                {
                    con.close();
                    b=true;
                    throw new Check(1);
                }
                else if(mail.equals(rs.getString(8)))
                {
                    con.close();
                    b=true;
                    throw new Check(2);
                }
                else if(uname.equals(rs.getString(16)))
                {
                    con.close();
                    b=true;
                    throw new Check(3);
                }
                else if(!pwd.equals(cpwd))
                {
                    con.close();
                    b=true;
                    throw new Check(4);
                }
                else if(!uname.substring(0,2).equals("p."))
                {
                    con.close();
                    b=true;
                    throw new Check(5);
                }
            }
            catch(Check ex1)
            {
                ex1.myException();
            }
        }
        if(!b)
        {
            Random random = new Random();
            long ran = 100000+random.nextInt(99999);
            String otp = String.valueOf(ran);
            System.out.println("OTP: "+otp);
            try
            {
                String apikey = "Nbzll5pjXkOohcAT8Z6d5g";
                String senderid = "TESTIN";
                String channel = "2";
                String DCS = "0";
                String flashsms = "0";
                String mobile = tcontact.getText();
                String message = "Your OTP for SignUp as Doctor is: "+otp;
                String route = "13";

                String requestUrl = "https://www.smsgatewayhub.com/api/mt/SendSMS?" +
                "APIKey=" + URLEncoder.encode(apikey, "UTF-8") +
                "&senderid=" + URLEncoder.encode(senderid, "UTF-8") +
                "&channel=" + URLEncoder.encode(channel, "UTF-8") +
                "&DCS=" + URLEncoder.encode(DCS, "UTF-8") +
                "&flashsms=" + URLEncoder.encode(flashsms, "UTF-8") +
                "&number=" + URLEncoder.encode(mobile, "UTF-8") +
                "&text=" + URLEncoder.encode(message, "UTF-8") +
                "&route=" + URLEncoder.encode(route, "UTF-8");

                URL url = new URL(requestUrl);
                HttpURLConnection uc = (HttpURLConnection)url.openConnection();

                System.out.println(uc.getResponseMessage());

                uc.disconnect();

            } catch(Exception ex){System.out.println(ex.getMessage());}

            System.out.println("OTP Sent");
            JFrame.setDefaultLookAndFeelDecorated(true);
            SwingUtilities.invokeLater(new Runnable(){@Override public void run() {
            OTP3 o = new OTP3(otp);
            }});
            
        }
    }
    public static void main(String[] args) {
        PatientSignUp pl = new PatientSignUp();
        pl.Interface();
    }
}
class Check extends Exception
{
    int err;
    JButton b;
    PatientSignUp p = new PatientSignUp(); 
    Check(int e)
    {
        err=e;
    }
    public void myException()
    {
        switch(err)
        {
            case 1:
            {
                JOptionPane.showMessageDialog(null,"Phone number already registered.");
                try{p.Data();}
                catch(Exception ex){}
                break;
            }
            case 2:
            {
                JOptionPane.showMessageDialog(null,"Mail already registered.");
                try{p.Data();}
                catch(Exception ex){}
                break;
            }
            case 3:
            {
                JOptionPane.showMessageDialog(null,"Username already taken.");
                try{p.Data();}
                catch(Exception ex){}
                break;
            }
            case 4:
            {
                JOptionPane.showMessageDialog(null,"Passwords do not match.");
                try{p.Data();}
                catch(Exception ex){}
                break;
            }
            case 5:
            {
                JOptionPane.showMessageDialog(null,"Username should start with 'p.'");
                try{p.Data();}
                catch(Exception ex){}
                break;
            }
        }
    }
}