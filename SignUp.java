package medical.management;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class SignUp implements ActionListener
{
    GridBagConstraints gbc;
    Choice c;
    JLabel l1,l2;
    JButton b1,b2;
    JFrame f;
    ImageIcon i = new ImageIcon(((new ImageIcon("bg1.jpg")).getImage()).getScaledInstance(1366,768,Image.SCALE_SMOOTH));
    ImageIcon h = new ImageIcon(((new ImageIcon("h2.png")).getImage()).getScaledInstance(70,70,Image.SCALE_SMOOTH));

    int north = GridBagConstraints.NORTH;
    int west = GridBagConstraints.WEST;
    int vertical = GridBagConstraints.VERTICAL;
    int horizontal = GridBagConstraints.HORIZONTAL;
    Insets in2 = new Insets(70,0,0,0);
    Insets in3 = new Insets(0,70,0,0);
    
    SignUp() 
    {
        f = new JFrame("Sign Up");
        f.setLayout(new GridBagLayout());
        f.setSize(470,600);
        f.setResizable(false);        
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(0,0,0,200));
        
            l1 = new JLabel("Select User Type:");
            l1.setFont(new Font(Font.SERIF,Font.BOLD,25));
            l1.setBounds(30,35,220,30);
            l1.setForeground(Color.lightGray);
            
            c = new Choice();
            c.setBackground(Color.darkGray);
            c.setForeground(Color.white);
            c.add("Patient");
            c.add("Doctor");
            c.add("Medical Store Owner");
            c.setFocusable(false);
            
            c.setBounds(75, 120,150, 20);
                        
            b1 = new JButton("Submit");
            b1.setMargin(new Insets(15,0,15,0));
            b1.setBounds(122,220,48,24);
            l2 = new JLabel("Already user?");
            l2.setBounds(110,290,120,20);
            b2 = new JButton("LogIn");
            b2.setMargin(new Insets(0,0,2,1));
            b2.setBounds(127,315,40,20);
            l2.setForeground(Color.lightGray);
            
            b1.addActionListener(this);
            b2.addActionListener(this);
           
        p.add(c);     
        p.add(l1);   
        p.add(b1);   
        p.add(l2);   
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
        
        JLabel lh = new JLabel(h);
        gbc = new GridBagConstraints(0,0,0,0,1,1,GridBagConstraints.NORTHWEST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0);
        f.add(lh,gbc);
        JLabel l = new JLabel(i);
        gbc = new GridBagConstraints(0,0,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,0,0,0),450,600);
        f.add(l,gbc);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==b1)
        {
            switch (c.getSelectedIndex()) {
                case 0:
                    PatientSignUp pl = new PatientSignUp();
                    pl.Interface();
                    f.dispose();
                    break;
                case 1:
                    DoctorSignUp dl = new DoctorSignUp();
                    dl.Interface();
                    f.dispose();
                    break;
                case 2:
                    MedicalStoreSignUp ml = new MedicalStoreSignUp();
                    ml.Interface();
                    f.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Select user type first.");
                    break;
            }
        }
        else if(ae.getSource()==b2)
        {
            f.dispose();
            MedicalManagement m = new MedicalManagement();
            f.dispose();
        }
    }
    public static void main(String[] args) {
        SignUp su = new SignUp();
    }   
}