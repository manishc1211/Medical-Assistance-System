package medical.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.border.Border;
public class PatPage implements ActionListener, ItemListener
{
    JFrame f;
    JScrollPane s;
    JPanel pan,p1,p2,p3,pquote,pbutton,pbutton2,papp;
    static JPanel papp1;
    JTextArea ta,ta1;
    JTextField t1, t2;
    static String un, add, dun, mun;
    String name;
    static int quantity, amount;
    JButton b,bin,bup,badd,bm1,bm2,bm3,bm4,bm5,bm6,bsub,bnext,bnext1,bpro,bpro1,bsub1;
    Connection con;
    Choice c,c2,c3,c1,c21,c31,c41;
    static JLabel quote;
    
    ImageIcon i = new ImageIcon(((new ImageIcon("pat.jpg")).getImage()).getScaledInstance(1366, 1180, Image.SCALE_SMOOTH));
    static ArrayList<String> med = new ArrayList<>();
    static ArrayList<String> medicname = new ArrayList<>();
    static ArrayList<String> medicuname = new ArrayList<>();
    static ArrayList<String> doc = new ArrayList<>();
    static ArrayList<String> docun = new ArrayList<>();
    
    Border border = BorderFactory.createLineBorder(Color.black, 1);
    PatPage()
    {}
    PatPage(int qu, int am)
    {
        quantity = qu;
        amount = am;
    }
    PatPage(String u)
    {
        un = u;
    }
    public void Interface() throws Exception
    {
        f = new JFrame();
        f.setLayout(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(600,400);
        
        pan = new JPanel();
        pan.setBackground(Color.RED);
        pan.setPreferredSize(new Dimension(1346,720));
        pan.setLayout(null);
        s = new JScrollPane(pan,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        s.getVerticalScrollBar().setUnitIncrement(16);
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
        pan.add(p1);
        
        JLabel l2 = new JLabel("Welcome "+name+"!!");
        l2.setBounds(40,40,600,40);
        l2.setFont(new Font(Font.SERIF,Font.BOLD,35));
        p1.add(l2);
        
        b = new JButton("");
        b.setBounds(673, 695, 40, 20);
       
        pquote = new JPanel();
        pquote.setBackground(new Color(255,255,0));
        pquote.setLayout(null);
        pquote.setBounds(40, 100, 750, 160);
        pquote.setBorder(border);
        
        
        JLabel quohead = new JLabel("Health Tip:-");
        quohead.setFont(new Font(Font.SERIF,Font.BOLD,18));
        quohead.setBounds(20,20,500,20);
        quote = new JLabel();
        quote.setText("<html>Prevent low blood sugar as it stresses you out. Eat regular and small healthy meals and keep fruit and veggies handy. Herbal teas will also soothe you frazzled nerves.<br>Eating unrefined carbohydrates, nuts and banans bosts the formation of serotonin, another feel-good drug. Small amounts of protien containing the amino acid tryptamine can give you boost when stress tires you out.</html>");
        quote.setBounds(20,50,710,80);
        quote.setMaximumSize(new Dimension(710,80));
        pquote.add(quohead);
        pquote.add(quote);
        
        pbutton = new JPanel();
        pbutton.setLayout(null);
        //pbutton.setBounds(30,250,770,180);
        pbutton.setBounds(30,120,770,180);
        pbutton.setBackground(new Color(0,0,0,150));
        //pbutton.setBorder(border);
        
        pbutton2 = new JPanel();
        pbutton2.setBackground(new Color(0,0,0,200));
        pbutton2.setLayout(null);
        //pbutton2.setBounds(20, 410, 790, 180);
        pbutton2.setBounds(20, 300, 790, 180);
        p1.setBorder(border);
        
        bm1 = new JButton("Fix Appointment");
        bm2 = new JButton("Online Consultation");
        bm3 = new JButton("Order Medicine");
        bm4 = new JButton("Find Hospitals");
        bm5 = new JButton("Find Clinics");
        bm6 = new JButton("Find Medical Stores");
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
        
        
        papp = new JPanel();
        papp.setLayout(null);
        
        JLabel ls = new JLabel("Select Specialisation: ");
        c = new Choice();
        c.setBackground(Color.darkGray);
        c.setForeground(Color.white);
        c.add("Heart");
        c.add("Surgeon");
        c.add("Neurologist");
        c.add("Orthopaedic");
        c.setFocusable(false);
        ls.setBounds(30,110,150,20);
        c.setBounds(30,140,150,20);
        c.addItemListener(this);
        
        JLabel la = new JLabel("Search doctors in your: ");
        c2 = new Choice();
        c2.setBackground(Color.darkGray);
        c2.setForeground(Color.white);
        c2.add("Locality");
        c2.add("City");
        c2.add("State");
        c2.setFocusable(false);
        la.setBounds(30,30,150,20);
        c2.setBounds(30,60,150,20);
        c2.addItemListener(this);
        
        JLabel ld = new JLabel("Select Doctor: ");
        c3 = new Choice();
        c3.setBackground(Color.darkGray);
        c3.setForeground(Color.white);
        c3.setFocusable(false);
        c3.disable();
        ld.setBounds(220,30,150,20);
        c3.setBounds(220,60,150,20);
        
        
        JLabel lp = new JLabel("Doctor's Profile: ");

        ta = new JTextArea("");
        ta.setBorder(border);
        ta.setBackground(Color.darkGray);
        ta.setForeground(Color.white);
        lp.setBounds(410,30,150,20);
        ta.setBounds(412,62,296,296);
        ta.setMaximumSize(new Dimension(296,296));
        ta.setLineWrap(true);
        
        
        bnext = new JButton("View Doctors");
        bnext.setFocusPainted(false);
        bnext.setBounds(65,215,90,20);
        bnext.setMargin(new Insets(0,0,0,0));
        bnext.addActionListener(this);
        
        bpro = new JButton("View Profile");
        bpro.setFocusPainted(false);
        bpro.setBounds(250,215,90,20);
        bpro.setMargin(new Insets(0,0,0,0));
        bpro.addActionListener(this);
        
        bsub = new JButton("Submit");
        bsub.setFocusPainted(false);
        bsub.setBounds(165,290,80,40);
        bsub.addActionListener(this);
        
        papp.add(ls);
        papp.add(c);
        papp.add(la);
        papp.add(c2);
        papp.add(ld);
        papp.add(c3);
        papp.add(lp);
        papp.add(ta);
        papp.add(bsub);
        papp.add(bpro);
        papp.add(bnext);
        
        
        
        papp1 = new JPanel();
        papp1.setLayout(null);
        
        JLabel ls1 = new JLabel("Select Category: ");
        c1 = new Choice();
        c1.setBackground(Color.darkGray);
        c1.setForeground(Color.white);
        c1.setFocusable(false);
        //ls1.setBounds(30,110,150,20);
        ls1.setBounds(143,110,150,20);
        //c1.setBounds(30,140,150,20);
        c1.setBounds(143,140,150,20);
        c1.addItemListener(this);
        try
            {
                PreparedStatement st = con.prepareStatement("select category from medicine group by category");
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                    c1.add(rs.getString(1));
                }
            }
            catch(Exception ex){}
        
        JLabel la1 = new JLabel("Medical Stores in Your: ");
        c21 = new Choice();
        c21.setBackground(Color.darkGray);
        c21.setForeground(Color.white);
        c21.add("Locality");
        c21.add("City");
        c21.setFocusable(false);
        //la1.setBounds(30,30,150,20);
        la1.setBounds(143,30,150,20);
        //c21.setBounds(37,60,150,20);
        c21.setBounds(143,60,150,20);
        c21.addItemListener(this);
        
        JLabel ld1 = new JLabel("Select Medicine: ");
        c31 = new Choice();
        c31.setBackground(Color.darkGray);
        c31.setForeground(Color.white);
        c31.setFocusable(false);
        c31.disable();
        //ld1.setBounds(220,30,150,20);
        ld1.setBounds(441,30,150,20);
        //c31.setBounds(220,60,150,20);
        c31.setBounds(441,60,150,20);
        
        JLabel ld41 = new JLabel("Select Medical Store: ");
        c41 = new Choice();
        c41.setBackground(Color.darkGray);
        c41.setForeground(Color.white);
        c41.setFocusable(false);
        c41.disable();
        //ld41.setBounds(220,110,200,20);
        ld41.setBounds(441,110,200,20);
        //c41.setBounds(220,140,150,20);
        c41.setBounds(441,140,150,20);
        
        
        /*JLabel lp1 = new JLabel("Doctor's Profile: ");
        ta1 = new JTextArea("Address: C-159, Alpha 1, G.Noida UP");
        ta1.setBorder(border);
        ta1.setBackground(Color.darkGray);
        ta1.setForeground(Color.white);
        lp1.setBounds(410,30,150,20);
        ta1.setBounds(412,62,296,296);
        ta1.setMaximumSize(new Dimension(296,296));
        ta1.setLineWrap(true);*/
        
        bnext1 = new JButton("View Medicines & Stores");
        bnext1.setFocusPainted(false);
        bnext1.setBounds(143,215,150,20);
        bnext1.setMargin(new Insets(0,0,0,0));
        bnext1.addActionListener(this);
        
        bpro1 = new JButton("Medicine Details & Quantity");
        bpro1.setFocusPainted(false);
        bpro1.setBounds(433,215,170,20);
        bpro1.setMargin(new Insets(0,0,0,0));
        bpro1.addActionListener(this);
        
        bsub1 = new JButton("Submit");
        bsub1.setFocusPainted(false);
        bsub1.setBounds(335,290,80,40);
        bsub1.addActionListener(this);
        
        papp1.add(ls1);
        papp1.add(c1);
        papp1.add(la1);
        papp1.add(c21);
        papp1.add(ld1);
        papp1.add(ld41);
        papp1.add(c31);
        papp1.add(c41);
        //papp1.add(lp1);
        //papp1.add(ta1);
        papp1.add(bsub1);
        papp1.add(bpro1);
        papp1.add(bnext1);
        
        l2.setForeground(new Color(255,255,0,240));
        
        
        p1.add(papp);
        p1.add(papp1);
        //p1.add(pquote);
        p1.add(pbutton);
        p1.add(pbutton2);
        
        //p1.add(b);
        f.add(s);

        JLabel back = new JLabel(i);
        back.setBounds(0, 0, 1366, 1180);
        pan.add(back);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void Data() throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
        PreparedStatement stm = con.prepareStatement("select name from patsign where username = ?");
        stm.setString(1,un);
        ResultSet rs = stm.executeQuery();
        rs.next();
        name = rs.getString(1);
        
    }
    class ChatThread extends Thread
    {
        @Override
        public void run()
        {
            try {
                PatChat se = new PatChat();
                se.Initiate();
            } 
            catch (Exception ex) {            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        ChatThread ct = new ChatThread();
        if(e.getSource()==bm1)
        {
            pan.setPreferredSize(new Dimension(1346,1180));
            p1.setSize(830,980);
            papp1.setBounds(0,0,0,0);
            papp.setBounds(40,540,750,400);
        }
        else if(e.getSource()==bm2)
        {
            ct.start();
        }
        else if(e.getSource()==bm3)
        {
            pan.setPreferredSize(new Dimension(1346,1180));
            p1.setSize(830,980);
            papp.setBounds(0,0,0,0);
            papp1.setBounds(40,540,750,400);
        }
        /*else if(e.getSource()==bm4)
        {
            
        }*/
        else if(e.getSource()==bm5)
        {
            ViewClinicDial vcd = new ViewClinicDial(un);
            vcd.Interface();
            f.dispose();
        }
        else if(e.getSource()==bm6)
        {
            ViewMedicalDial vcd = new ViewMedicalDial(un);
            vcd.Interface();
            f.dispose();
        }
        else if(e.getSource()==bnext)
        {
            try
            {
                c3.removeAll();
                String a = c2.getSelectedItem();
                String sp = c.getSelectedItem();
                ResultSet rs1;
                PreparedStatement stmt = con.prepareStatement("select "+a+" from patsign where username = ?");
                stmt.setString(1, un);
                rs1 = stmt.executeQuery();
                rs1.next();
                String area = rs1.getString(1);                
                ta.setText(area+sp);
                
                ResultSet rs;
                PreparedStatement stm;
                System.out.println("Sp: "+sp);
                System.out.println("Area: "+area);
                stm = con.prepareStatement("select name, username from docsign where specialisation = ? and "+a+" = ?");
                stm.setString(1,sp);
                stm.setString(2,area);
                rs = stm.executeQuery();
                
                
                int i = 0;
                doc.clear();
                docun.clear();
                while(rs.next())
                {
                    doc.add(rs.getString(1));
                    docun.add(rs.getString(2));
                    System.out.println("this: "+rs.getString(1)+" "+doc.get(i));
                    c3.add(doc.get(i));
                    i++;
                    
                    System.out.println(rs.getString(1)+" "+rs.getString(2));
                }
                
                c3.enable();
            }
            catch(SQLException x)
            {
                System.out.println(e);
            }
        }
        
        else if(e.getSource()==bpro) 
        {
            int di = c3.getSelectedIndex();
            String name2, gender, age, qual,pro;
            
            try
            {
                PreparedStatement stmt = con.prepareStatement("select name, gender, age from docsign where username = ?");
                stmt.setString(1, docun.get(di));
                dun = docun.get(di);
                ResultSet rs = stmt.executeQuery();
                
                rs.next();
                int a = rs.getInt(3);
                name2 = rs.getString(1);
                gender = rs.getString(2);
                age = String.valueOf(a);
                
                PreparedStatement stmt2 = con.prepareStatement("select concat(concat(concat(concat(concat(concat(concat(concat(concat(concat(plot,', '),street),', '),street2),', '),locality),', '),concat(concat(concat(concat(city,', '),state),', '),country)),' '),pin) from docsign where username = ?");
                stmt2.setString(1, docun.get(di));
                ResultSet rs2 = stmt2.executeQuery();
                rs2.next();
                add = rs2.getString(1);
                
                ta.setLineWrap(true);
                
                ta.setText("Name:    "+name2+"\nGender:  "+gender+"\nAge:          "+age+"\nAddress:\n"+add);
            }
            catch(SQLException ex){System.out.println(e);}
            
            
            System.out.println(doc.get(di)+"  "+docun.get(di));
        }
        
        
else if(e.getSource()==bsub)
        {
            try
            {
                String gender, age, mail,add2;
                long phone;
                Statement stm = con.createStatement();
                System.out.println("2");
                ResultSet rs = stm.executeQuery("select age, gender, phone, mail from patsign where username = "+"'"+un+"'");
                System.out.println("3");
                rs.next();
                System.out.println("4");
                age = rs.getString(1);
                gender = rs.getString(2);
                mail = rs.getString(4);
                phone = rs.getLong(3);
                
                PreparedStatement stmt2 = con.prepareStatement("select concat(concat(concat(concat(concat(concat(concat(concat(concat(concat(plot,', '),street),', '),street2),', '),locality),', '),concat(concat(concat(concat(city,', '),state),', '),country)),' '),pin) from patsign where username = ?");
                stmt2.setString(1, un);
                ResultSet rs2 = stmt2.executeQuery();
                rs2.next();
                add2 = rs2.getString(1);
                
                
                PreparedStatement st = con.prepareStatement("insert into appoint values(?,?,?,?,?,?,?,?)");
                st.setString(1, name);
                st.setString(2, age);
                st.setString(3, gender);
                st.setString(4, add2);
                st.setLong(5, phone);
                st.setString(6, mail);
                st.setString(7, dun);
                st.setString(8, un);
                System.out.println("3");
                
                st.executeUpdate();
                
            }
            catch(Exception ex){}
        }

        else if(e.getSource()==bpro1) 
        {
            int di = c31.getSelectedIndex();
            String name, gender, age, qual,pro;
            
            try
            {
                int sel = c41.getSelectedIndex();
                String selmed = c31.getSelectedItem();
                String selmedic = medicuname.get(sel);
                
                SelQuant sq;
                
                PreparedStatement stmt21 = con.prepareStatement("select * from medicine where name = ? and username = ?");
                stmt21.setString(1, selmed);
                stmt21.setString(2, selmedic);
                
                ResultSet rs21 = stmt21.executeQuery();
                if(rs21.next())
                {
                    sq = new SelQuant(rs21.getString(1),rs21.getString(2),rs21.getString(3),rs21.getString(4),rs21.getInt(5));
                    sq.Interface();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, selmed+" not available at this store.");
                }                
            }
            catch(Exception ex){System.out.println(e);}
        }
        
        else if(e.getSource()==bnext1)
        {
            try
            {
                String a = c21.getSelectedItem();
                String cat = c1.getSelectedItem();
                
                PreparedStatement stmt = con.prepareStatement("select "+a+" from patsign where username = ?");
                stmt.setString(1, un);
                ResultSet rs1 = stmt.executeQuery();
                rs1.next();
                String area = rs1.getString(1);                

                
                PreparedStatement stmt2 = con.prepareStatement("select name, username from medsign where "+a+" = ?");
                stmt2.setString(1, area);
                ResultSet rs2 = stmt2.executeQuery();
                medicname.clear();
                medicuname.clear();
                c41.removeAll();
                int i=0;
                while(rs2.next())
                {
                    medicname.add(rs2.getString(1));
                    medicuname.add(rs2.getString(2));
                    c41.add(rs2.getString(1));
                    System.out.println("Name: "+rs2.getString(1)+" Uname: "+medicuname.get(i));i++;
                }
                
                PreparedStatement stm = con.prepareStatement("select name from medicine where category = ? group by name");
                stm.setString(1,cat);
                ResultSet rs = stm.executeQuery();
                c31.removeAll();
                med.clear();
                while(rs.next())
                {
                    med.add(rs.getString(1));
                    c31.add(rs.getString(1));
                }
                
                c31.enable();
                c41.enable();
                
            }
            catch(Exception x)
            {
                System.out.println(e);
            }
        }

        else if(e.getSource()==bsub1)
        {
            try
            {
                String gender, age, mail,add2;
                long phone;
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select age, gender, phone, mail from patsign where username = "+"'"+un+"'");
                rs.next();
                age = rs.getString(1);
                gender = rs.getString(2);
                mail = rs.getString(4);
                phone = rs.getLong(3);
                
                mun =  medicuname.get(c41.getSelectedIndex());
                String medname =  c31.getSelectedItem();
                
                PreparedStatement stmt2 = con.prepareStatement("select concat(concat(concat(concat(concat(concat(concat(concat(concat(concat(plot,', '),street),', '),street2),', '),locality),', '),concat(concat(concat(concat(city,', '),state),', '),country)),' '),pin) from patsign where username = ?");
                stmt2.setString(1, un);
                ResultSet rs2 = stmt2.executeQuery();
                rs2.next();
                add2 = rs2.getString(1);
                
                
                PreparedStatement st = con.prepareStatement("insert into medreq values(?,?,?,?,?,?,?,?,?,?,?)");
                st.setString(1, name);
                st.setString(2, age);
                st.setString(3, gender);
                st.setString(4, add2);
                st.setLong(5, phone);
                st.setString(6, mail);
                st.setString(7, mun);
                st.setString(8, un);
                st.setString(9, medname);
                st.setInt(10, amount);
                st.setInt(11, quantity);
                
                st.executeUpdate();                
            }
            catch(Exception ex){}
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if(e.getSource()==c21)  
        {
            
        }
    }
    
    
    
    public static void main(String args[])throws Exception
    {
        String str = "p.pat1";
        PatPage p = new PatPage(str);
        p.Data();
        p.Interface();
    }
}
