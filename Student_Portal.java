import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.security.InvalidAlgorithmParameterException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class Student_Portal   implements ActionListener{
    // declare those components on which u want to add actionlistener
    private JButton button;
    private JTextField input_name;
    private JPasswordField pass;
    private  JFrame Main_frame; 
    private String selectedSemester;
    private JList <String> list;



    public static void main(String args[]) throws InvalidAlgorithmParameterException,MalformedURLException{

        Student_Portal staff=new Student_Portal();

        JOptionPane.showMessageDialog(null, "Welcome to Java Project "+"\n"+"  Name: Jatin Kaushik"+"\n"+"  Roll No:220011015009"+"\n"+"  Btech 6th Sem");  //Welcome msg

        
        // Main window frame
        ImageIcon img=new ImageIcon("logo.jpg");

        staff.Main_frame=new JFrame();
        staff.Main_frame.setTitle("Student Record Portal"); 
        staff.Main_frame.setSize(420,420); 
        staff.Main_frame.setIconImage(img.getImage());                  
        staff.Main_frame.getContentPane().setBackground(new Color(123,50,250));      

        // Multiple Components in frame1

        // Component 1

        JPanel head=new JPanel();
        head.setPreferredSize(new Dimension(420,50));
        head.setBackground(new Color(0x2C3E50));

        JLabel label_head=new JLabel();
        label_head.setText("Welcome to the staff Mangement System");
        label_head.setForeground(new Color(0xECF0F1));
        label_head.setFont(new Font("Segoe UI",Font.BOLD,20));
        head.add(label_head);

        // Component 2
        JPanel bottom=new JPanel();
        bottom.setPreferredSize(new Dimension(420,50));
        bottom.setBackground(new Color(0x2C3E50));
        

        staff.button=new JButton();
        staff.button.setBackground(new Color(0x3498DB));
        staff.button.setFocusPainted(false);
        staff.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        staff.button.setText("Enter");
        staff.button.setFocusable(false);
        staff.button.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        staff.button.addActionListener(staff);

        bottom.add(staff.button);


        // Component 3
        JPanel center =new JPanel();
        center.setLayout(new GridBagLayout());
        center.setBackground(new Color(0xECF0F1));
        center.setPreferredSize(new Dimension(200,400));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components fill horizontally
       
        JLabel center_label1=new JLabel();
        center_label1.setText("Enter Your Name sir");
        center_label1.setVerticalTextPosition(JLabel.BOTTOM);
        center_label1.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        center.add(center_label1,gbc);



        staff.input_name=new JTextField();
        staff.input_name.setPreferredSize(new Dimension(80,30));
        staff.input_name.setToolTipText("Staff only");

        gbc.gridx = 0;
        gbc.gridy = 1;
        center.add(staff.input_name,gbc);

        JLabel center_label2=new JLabel();
        center_label2.setText("Enter your Password");
        center_label2.setVerticalTextPosition(JLabel.BOTTOM);
        gbc.gridx = 0;
        gbc.gridy = 2;
        center.add(center_label2,gbc);

        JLabel center_Label3=new JLabel();
        center_Label3.setText("Select Your Semester");
        gbc.gridx=0;
        gbc.gridy=4;
        center.add(center_Label3,gbc);


        // Options for Semester
        String [] sem={"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6","Semester 7","Semester 8"};
        staff.list=new JList<>(sem);
        staff.list.setVisibleRowCount(4);
        gbc.gridx=0;
        gbc.gridy=5;
        JScrollPane jcp=new JScrollPane(staff.list);
        staff.list.setVisibleRowCount(1);
        center.add(jcp,gbc);
        

        staff.pass=new JPasswordField();
        staff.pass.setPreferredSize(new Dimension(80,30));
        staff.pass.setToolTipText("Enter four digit password");
        gbc.gridx = 0;
        gbc.gridy = 3;
        center.add(staff.pass,gbc);



        

        staff.Main_frame.add(head,BorderLayout.NORTH);
        staff.Main_frame.add(bottom,BorderLayout.SOUTH);
        staff.Main_frame.add(center,BorderLayout.CENTER);
        // Main_frame.setResizable(false);
        staff.Main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staff.Main_frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
    if(e.getSource()==button ){
        String name=input_name.getText();
       char[] passwordChars = pass.getPassword();
       String pass = new String(passwordChars); // Convert char[] to String
       try {
           selectedSemester = list.getSelectedValue();
       } catch (Exception ex) {
        JOptionPane.showMessageDialog(button, "Please set the semester");
       }
       
       
       if(name.isEmpty()){
        JOptionPane.showMessageDialog(button, "Please fill the name field");
       }
       else if (pass.isBlank()) {
           JOptionPane.showMessageDialog(button, "Please fill the password field");
       }
       
       else if (!name.equalsIgnoreCase("Jatin Kaushik")) {
           JOptionPane.showMessageDialog(button, "Name not matched");
       }
       else if (!pass.equals("7685")) {
           JOptionPane.showMessageDialog(button, "Wrong password");
       }
       
       else if (name.equalsIgnoreCase("Jatin Kaushik") && pass.equals("7685")) {
        if(selectedSemester.equalsIgnoreCase("Semester 1")){
        Main_frame.dispose();
        JFrame frame2=new JFrame();
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Student Result");
        frame2.setSize(500,420);

        JPanel sub_panel1=new JPanel();
        sub_panel1.setPreferredSize(new Dimension(420,50));
        sub_panel1.setBackground(new Color(0x2C3E50));

        JLabel sub_label1=new JLabel();
        sub_label1.setText("Welcome "+name+" To Result Portal("+selectedSemester+")");
        sub_label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        sub_label1.setForeground(Color.GREEN);


        sub_panel1.add(sub_label1);


        frame2.add(sub_panel1,BorderLayout.NORTH);

        if(selectedSemester.equals("Semester 1")){

            JPanel Sub_panel2=new JPanel();
            Sub_panel2.setPreferredSize(new Dimension(420,50));
            Sub_panel2.setBackground(new Color(0xA28089));

            

            


            


            frame2.add(Sub_panel2,BorderLayout.CENTER);




            
        }

        }

           
       }
    }   

    }

        
}
