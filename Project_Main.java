/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

/**
 *
 * @author myash
 */
//import end_project.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Project_Main extends JFrame  implements ActionListener
{
JButton employee;
JButton reserve,train_info;
JButton reserved_status;
JButton Reserve,reset,cancel;
JLabel title,l3;
JButton ticket,profile;
Container c;
JLabel label;
ImageIcon img;

public Project_Main()
{
    
    setTitle("Admin Page");
        setBounds(0, 0, 1550, 850);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("icon/pexels-leslie-toh-880929.jpg"));
        Image i1=ic.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(i1);
        l3=new JLabel(ic1);
        l3.setBounds(1550, 850, Image.SCALE_DEFAULT, Image.SCALE_DEFAULT);
        
        add(l3);
        
       // c = getContentPane();
        //c.setLayout(null);
        
        label = new JLabel("User Control");
        label.setFont(new Font("Arial", Font.BOLD, 42));
     label.setBounds(300, 30, 300, 100);
       label.setForeground(Color.WHITE);
      label.setBackground(Color.black);
     label.setLocation(500, 30);
     add(label);
           
          reset=new JButton("Logout");
        reset.setFont(new Font("Arial", Font.BOLD, 20));
       reset.setSize(200, 60);
       reset.setForeground(Color.WHITE);
       reset.setBackground(Color.black);
       reset.setLocation(10, 500);
       reset.addActionListener(this);
       add(reset);
        
        

        reserved_status=new JButton(" Image Status");
        reserved_status.setFont(new Font("Arial", Font.BOLD, 20));
       reserved_status.setSize(200, 60);
       reserved_status.setForeground(Color.WHITE);
       reserved_status.setBackground(Color.black);
       reserved_status.setLocation(10, 200);
       reserved_status.addActionListener(this);
       add(reserved_status);
       
        ticket=new JButton("Enter to Get your Ticket");
        ticket.setFont(new Font("Arial", Font.BOLD, 20));
      ticket.setSize(380, 60);
       ticket.setForeground(Color.WHITE);
       ticket.setBackground(Color.black);
       ticket.setLocation(10, 300);
      ticket.addActionListener(this);
       add(ticket);
       setLayout(new BorderLayout());
       setVisible(true);
       
       
       Reserve=new JButton("Book Tickets !! Enter Here");
        Reserve.setFont(new Font("Arial", Font.BOLD, 20));
       Reserve.setSize(350, 60);
       Reserve.setForeground(Color.WHITE);
       Reserve.setBackground(Color.black);
       Reserve.setLocation(10, 400);
       Reserve.addActionListener(this);
       add(Reserve);
       
       
        profile=new JButton("Profile");
        profile.setFont(new Font("Arial", Font.BOLD, 20));
      
       profile.setForeground(Color.WHITE);
       profile.setBackground(Color.black);
       profile.setBounds(1430, 10, 100, 40);
       profile.addActionListener(this);
       add(profile);
       
       cancel=new JButton("Ticket cancellation");
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
       cancel.setSize(350, 60);
       cancel.setForeground(Color.WHITE);
       cancel.setBackground(Color.black);
       cancel.setLocation(10, 600);
       cancel.addActionListener(this);
       add(cancel);
       
       
       
       setLayout(new BorderLayout());
       setVisible(true);
       getContentPane().add(l3);
       

}//end of constructor()

public void actionPerformed(ActionEvent e)
{
//String s=e.getActionCommand();
        if(e.getSource()==Reserve)
            { 
            //move to the page from where user can change the train details
            Reserve_Train et = new Reserve_Train();
            et.setVisible(true);
            this.setVisible(false);
 
            } 
        if(e.getSource() == ticket)
        {
           Ticket_Generation j = new Ticket_Generation();
            j.setVisible(true);
            this.setVisible(false);
        }
        String s=e.getActionCommand();
        if(s.equals("Logout"))
        {
            JOptionPane.showConfirmDialog(this, "Logout SuccessFully");
        	LoginPage p=new LoginPage();
        	this.setVisible(false);
        	p.setVisible(true);
        }
        if(e.getSource() == profile)
        {
           
            Profile s1 = new Profile();
            s1.setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource() == reserved_status)
        {
              JOptionPane.showConfirmDialog(this, "Sendind you to Status");
            Status g = new Status();
            g.setVisible(true);
            g.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setVisible(false);
           
        }
        
        if(e.getSource() == cancel)
        {
           Ticket_Cancellation g = new Ticket_Cancellation();
            g.setVisible(true);
            this.setVisible(false);
        } 
        }
public static void main (String args[])
{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new Project_Main();
			}
		});	
	
}
}