package medical.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.net.*;

public class MedicalStoreSignUp implements ActionListener
{
        GridBagConstraints gbc;
    JFrame f;
    JPanel p;
    JLabel lhead,lback,lname,lgender,lage,lmail,lcontact,ladd,lplot,lstreet,lstreet2,llocality,lcity,lstate,lpin,lcountry,ltin,lid,lidtype,lidnum,luname,lpwd,lcpwd;
    JTextField tname,tgender,tage,tmail,tcontact,tplot,tstreet,tstreet2,tlocality,tcity,tstate,tpin,tcountry,ttin,tidtype,tidnum,tuname,tpwd,tcpwd;
    JButton b1;
    ImageIcon i = new ImageIcon(((new ImageIcon("med.jpg")).getImage()).getScaledInstance(1366,768,Image.SCALE_SMOOTH));
    boolean b;
    int age;
    long phone,pin;
    static String name,gender,mail,tin,plot,loc,street,street2,state,city,country,idtype,idnum,uname,pwd,cpwd,temp;
    Connection con;
    MedicalStoreSignUp(){}
    MedicalStoreSignUp(int c)
    {
        try
        {
            PreparedStatement ps = con.prepareStatement("insert into medsign values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,name);          
            ps.setString(2,gender);
            ps.setInt(3,age);
            ps.setLong(4,phone);
            ps.setString(6,tin);
            ps.setString(5,mail);
            ps.setString(7,plot);
            ps.setString(8,loc);
            ps.setString(9,street);
            ps.setString(10,street2);
            ps.setString(11,city);
            ps.setString(12,state);
            ps.setString(13,country);
            ps.setLong(14,pin);
            ps.setString(15,idtype);
            ps.setString(16,idnum);
            ps.setString(17,uname);
            ps.setString(18,pwd);
            ps.executeQuery();
            con.close();
            
            MedicalManagement mg = new MedicalManagement();
            f.dispose();
        }
        catch(Exception x){}
    }
    
    public void Interface()
    {
        f = new JFrame("Medical Store SignUp");
        f.setSize(1400,800);
        f.setLayout(new GridBagLayout());
        f.setLocation(0,0);
        
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(0,0,0,200));
            
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
            ltin = new JLabel("TIN Number: ");
            lid = new JLabel("Any nationalised ID proof: ");
            lidtype = new JLabel("ID Type: ");
            lidnum = new JLabel("ID Number: ");
            luname = new JLabel("Username: ");
            lpwd = new JLabel("Password: ");
            lcpwd = new JLabel("Confirm Password: ");
            
            tname = new JTextField();
            tgender = new JTextField();
            tage = new JTextField();
            tmail = new JTextField();
            tcontact = new JTextField();
            ttin = new JTextField();
            tplot = new JTextField();
            tlocality = new JTextField();
            tstreet = new JTextField();
            tstreet2 = new JTextField();
            tcity = new JTextField();
            tstate = new JTextField();
            tpin = new JTextField();
            tcountry = new JTextField();
            tidtype = new JTextField();
            tidnum = new JTextField();
            tuname = new JTextField();
            tpwd = new JTextField();
            tcpwd = new JTextField();
            
            lname.setBounds(50, 120, 115, 20);
            lgender.setBounds(50, 150, 80, 20);
            lage.setBounds(280, 150, 80, 20);
            lmail.setBounds(50, 180, 115, 20);
            lcontact.setBounds(50, 210, 115, 20);
            ltin.setBounds(50, 240, 115, 20);
            ladd.setBounds(50, 275,115, 20);
            lplot.setBounds(50, 300, 80, 20);
            llocality.setBounds(235, 300, 80, 20);
            lstreet.setBounds(50, 325, 80, 20);
            lstreet2.setBounds(230, 325, 80, 20);            
            lcity.setBounds(50, 350, 80, 20);
            lstate.setBounds(235, 350, 80, 20);
            lpin.setBounds(230, 375, 80, 20);
            lcountry.setBounds(50, 375, 80, 20);
            lid.setBounds(50, 415, 350, 20);
            lidtype.setBounds(50, 440, 80, 20);
            lidnum.setBounds(50, 470, 80, 20);
            luname.setBounds(50, 515, 115, 20);
            lpwd.setBounds(50, 545, 115, 20);
            lcpwd.setBounds(50, 575, 115, 20);
            
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
            ttin.setBackground(Color.DARK_GRAY);
            ltin.setForeground(Color.lightGray);
            ttin.setForeground(Color.white);
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
            tidtype.setBackground(Color.DARK_GRAY);
            lidtype.setForeground(Color.lightGray);
            tidtype.setForeground(Color.white);
            tidnum.setBackground(Color.DARK_GRAY);
            lidnum.setForeground(Color.lightGray);
            tidnum.setForeground(Color.white);
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
            lid.setForeground(Color.lightGray);
            
            tname.setBorder(null);
            tgender.setBorder(null);
            tage.setBorder(null);
            tmail.setBorder(null);
            tcontact.setBorder(null);
            ttin.setBorder(null);
            tplot.setBorder(null);
            tlocality.setBorder(null);
            tstreet.setBorder(null);
            tstreet2.setBorder(null);
            tcity.setBorder(null);
            tstate.setBorder(null);
            tpin.setBorder(null);
            tcountry.setBorder(null);
            tidnum.setBorder(null);
            tidtype.setBorder(null);
            tpwd.setBorder(null);
            tuname.setBorder(null);
            tcpwd.setBorder(null);
            
            tpwd.setCaretColor(Color.white);
            tstreet.setCaretColor(Color.white);
            tstreet2.setCaretColor(Color.white);
            tstate.setCaretColor(Color.white);
            ttin.setCaretColor(Color.white);
            tplot.setCaretColor(Color.white);
            tpin.setCaretColor(Color.white);
            tname.setCaretColor(Color.white);
            tmail.setCaretColor(Color.white);
            tlocality.setCaretColor(Color.white);
            tcountry.setCaretColor(Color.white);
            tidtype.setCaretColor(Color.white);
            tidnum.setCaretColor(Color.white);
            tgender.setCaretColor(Color.white);
            tcpwd.setCaretColor(Color.white);
            tcontact.setCaretColor(Color.white);
            tcity.setCaretColor(Color.white);
            tage.setCaretColor(Color.white);
            tuname.setCaretColor(Color.white);
            
            tname.setBounds(145, 120, 280, 17);
            tgender.setBounds(145, 150, 110, 17);
            tage.setBounds(315, 150, 110, 17);
            tmail.setBounds(145, 180, 280, 17);
            tcontact.setBounds(145, 210, 280, 17);
            ttin.setBounds(145, 240, 280, 17);
            tplot.setBounds(105, 300, 120, 17);
            tlocality.setBounds(285, 300, 140, 17);
            tstreet.setBounds(105, 325, 120, 17);
            tstreet2.setBounds(285, 325, 140, 17);
            tcity.setBounds(105, 350, 120, 17);
            tstate.setBounds(285, 350, 140, 17);
            tpin.setBounds(285, 375, 140, 17);
            tcountry.setBounds(105, 375, 120, 17);
            tidtype.setBounds(125, 440, 140, 17);
            tidnum.setBounds(125, 470, 140, 17);
            tuname.setBounds(175, 515, 250, 17);
            tpwd.setBounds(175, 545, 250, 17);
            tcpwd.setBounds(175, 575, 250, 17);         
            tuname.setText("m.");
            ttin.setText("TIN ");
            
            b1 = new JButton("Submit");
            b1.setMargin(new Insets(15,0,15,0));
            b1.setBounds(220,620,60,30);
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
        p.add(ltin);
        p.add(lid);
        p.add(lidtype);
        p.add(lidnum);
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
        p.add(ttin);
        p.add(tidtype);
        p.add(tidnum);
        p.add(tuname);
        p.add(tpwd);
        p.add(tcpwd);
        p.add(b1);
        
        p.add(tname);
        gbc = new GridBagConstraints(0,0,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),500,680);
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
            try{Data();}
            catch(Exception exc){}
        } 
    }
    void Data() throws Exception
    {
        b=false;
        name = tname.getText();
        gender = tgender.getText();
        mail = tmail.getText();
        tin = ttin.getText();
        plot = tplot.getText();
        loc = tlocality.getText();
        street = tstreet.getText();
        street2 = tstreet2.getText();
        state = tstate.getText();
        city = tcity.getText();
        country = tcountry.getText();
        idtype = tidtype.getText();
        idnum = tidnum.getText();
        uname = tuname.getText();
        pwd = tpwd.getText();
        cpwd = tcpwd.getText();
        temp = tage.getText();
        age = Integer.valueOf(temp);
        temp = tcontact.getText();
        phone = Long.valueOf(temp);
        temp = tpin.getText();
        pin = Long.valueOf(temp);
        //System.out.println("Name: "+name+"\nGender: "+gender+"\nMail: "+mail+"\nSpec: "+specialisation+"\nPlot: "+plot+"\nLoc: "+loc+"\nStreet: "+street+"\nCity: "+city+"\nState: "+state+"\nCountry: "+country+"\nIDType: "+idtype+"\nUName: "+uname+"\npwd: "+pwd+"\nAge: "+age+"\nPhone: "+phone+"\nPin: "+pin+"\nIdnum: "+idnum+"\nGender: "+gender);       
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from medsign");
        while(rs.next())
        {
            try
            {
                if(!pwd.equals(cpwd))
                {
                    con.close();
                    b=true;
                    throw new CheckM(4);
                }
                else if(phone==rs.getLong(4))
                {
                    con.close();
                    b=true;
                    throw new CheckM(1);
                }
                else if(mail.equals(rs.getString(5)))
                {
                    con.close();
                    b=true;
                    throw new CheckM(2);
                }
                else if(uname.equals(rs.getString(17)))
                {
                    con.close();
                    b=true;
                    throw new CheckM(3);
                }
                
                
            }
            catch(CheckM ex1)
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
            OTP o = new OTP(otp);
            }});
        }
    }
    public static void main(String[] args) {
        MedicalStoreSignUp ml = new MedicalStoreSignUp();
        ml.Interface();
    }
}
class CheckM extends Exception
{
    int err;
    JButton b;
    MedicalStoreSignUp p = new MedicalStoreSignUp(); 
    CheckM(int e)
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
        }
    }
}