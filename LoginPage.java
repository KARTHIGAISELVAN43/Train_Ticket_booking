/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

/**
 *
 * @author myash
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//package com.mycompany.registrationform;
import com.mycompany.edittraininfo.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.mycompany.edittraininfo.*;
import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import javax.swing.JFrame;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

/**
 *
 * @author myash
 */
public class LoginPage extends JFrame implements ActionListener 
{
 
    // Components of the Form
    Container c;
    int logid;
    String logidi;
    Connection con;
    Statement statement;
    ResultSet result;
     JLabel title;
     JLabel name;
     JLabel pass;
     JTextField tname;
     JLabel mno;
    JTextField tmno;
     JLabel lsignup;
     JButton signup;
     JButton Reload;
     JRadioButton male;
     JRadioButton female;
     ButtonGroup gengp;
     JLabel dob;
     JComboBox date;
     JComboBox month;
     JButton Login;
     JComboBox year;
     JLabel add;
      String s;
     JTextArea tadd;
     JCheckBox Admin,User;
     JButton sub;
     JButton reset;
    JTextArea tout;
    String hew;
    JLabel Captcha;
    JTextField tCaptcha,tCaptcha1;
     JLabel res,l3;
    JTextArea resadd;
    JPasswordField tpass;
    int ut;
    public int getId()
    {
        String hew = tname.getText();
                       ut= Integer.parseInt(hew);
                       return ut;
    }
    public LoginPage()
    {
        
         setTitle("Admin Page");
        setBounds(0, 0, 1550, 850);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("icon/LoginPage.jpg"));
        Image i1=ic.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(i1);
        l3=new JLabel(ic1);
        l3.setBounds(1550, 850, Image.SCALE_DEFAULT, Image.SCALE_DEFAULT);
        
        add(l3);
        title = new JLabel("Login Page");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        add(title);
 
        name = new JLabel("User ID ");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        add(name);
 
       tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 40);
        tname.setLocation(290, 100);
        add(tname);
        
         pass = new JLabel("Password ");
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100, 20);
        pass.setLocation(100, 200);
        add(pass);
        
        tpass = new JPasswordField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 15));
        tpass.setSize(190, 40);
        tpass.setLocation(290, 200);
        add(tpass);
        
        Captcha = new JLabel("Enter the Captcha ");
        Captcha.setFont(new Font("Arial", Font.PLAIN, 20));
        Captcha.setSize(200, 20);
        Captcha.setLocation(100, 300);
        add(Captcha);
        
        tCaptcha = new JTextField();
        Login l = new Login();
         s = l.Captcha();
        tCaptcha.setFont(new Font("Arial", Font.PLAIN, 15));
        tCaptcha.setText(s);
         tCaptcha.setEditable(false);
        tCaptcha.setSize(100, 40);
        tCaptcha.setLocation(290, 350);
        add(tCaptcha);
       
        tCaptcha1 = new JTextField();
        tCaptcha1.setFont(new Font("Arial", Font.PLAIN, 15));
        tCaptcha1.setSize(100, 40);
        tCaptcha1.setLocation(460, 350);
        add(tCaptcha1);
        
        Reload = new JButton("Reload");
        Reload.setFont(new Font("Arial", Font.PLAIN, 15));
        Reload.setSize(100, 40);
        Reload.setLocation(600, 350);
        
        Reload.addActionListener(this);
        add(Reload);
        
         User = new JCheckBox("User");
        User.setFont(new Font("Arial", Font.PLAIN, 20));
        User.setSize(70, 20);
        User.setLocation(190, 400);
        User.setBackground(Color.WHITE);
        add(User);
        
        Admin = new JCheckBox("Admin");
        Admin.setFont(new Font("Arial", Font.PLAIN, 20));
        Admin.setSize(100, 20);
        Admin.setLocation(350, 400);
         Admin.setBackground(Color.WHITE);
        add(Admin);
        
        
        Login = new JButton("Login");
        Login.setFont(new Font("Arial", Font.PLAIN, 15));
        Login.setSize(200, 40);
        Login.setLocation(190, 500);
        Login.addActionListener(this);
        add(Login);
        
        lsignup = new JLabel("Don't Have Account Sign Up ");
        lsignup.setFont(new Font("Arial", Font.PLAIN, 20));
        lsignup.setSize(290, 40);
        lsignup.setLocation(100, 600);
        add(lsignup);
        
        signup = new JButton("Sign Up");
        signup.setFont(new Font("Arial", Font.PLAIN, 15));
        signup.setSize(200, 40);
       signup.setLocation(390, 600);
        signup.addActionListener(this);
        add(signup);
         
          setLayout(new BorderLayout());
       setVisible(true);
       getContentPane().add(l3);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getSource());
        if (e.getSource() == Login && tCaptcha.getText().equals(tCaptcha1.getText())) {
            if(tname.getText().equals("") || tpass.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Enter All Fields !!!!!","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
            if (User.isSelected()) 
            {
                  try
            {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_db","root","");
                String pass12 = tname.getText();
                      int e1 = Integer.parseInt(pass12);
                      {
            statement=con.createStatement();
            String query="SELECT passenger_id FROM user_info where passenger_id = '"+e1+"' ";
            result=statement.executeQuery(query);
            if(result.next())
            {
                logid = result.getInt("passenger_id");
                   JOptionPane.showMessageDialog(this, "Done Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                Project_Main u = new Project_Main();
                u.setVisible(true);
                this.setVisible(false);
               }
            else
                    JOptionPane.showMessageDialog(this, "Invalid Id !!!!!","Error",JOptionPane.ERROR_MESSAGE);
               
            }
      
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
                
            }
            else if (Admin.isSelected())
            {
               try
            {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_db","root","");
                String pass12 = tname.getText();
                      int e1 = Integer.parseInt(pass12);
                     
                           statement=con.createStatement();
                           String query="SELECT * FROM admin_info where admin_id = '"+e1+"' ";
                           result=statement.executeQuery(query);
                           char r[] = tpass.getPassword();
                           String er = new String(r);
                           if(result.next())
                           {
                                    logid = result.getInt("admin_id");
                                    logidi = result.getString("passwords");
                                   
                            }
                            else
                                JOptionPane.showMessageDialog(this, "Invalid Id !!!!!","Error",JOptionPane.ERROR_MESSAGE);
                           if(logid == e1 || (er == null ? logidi == null : er.equals(logidi)))
                           {
                                JOptionPane.showMessageDialog(this, "Done Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                                    Employee u = new Employee();
                                    u.setVisible(true);
                                    this.setVisible(false);
                           }
                           else
                                JOptionPane.showMessageDialog(this, "Invalid Password!!!!!","Error",JOptionPane.ERROR_MESSAGE);
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }  
            }
        }
        } 
      else if(e.getSource() == Reload)
        {
           // System.out.println("logged out");
            String h;
            Login f = new Login();
            h = f.Captcha();
            tCaptcha.setText(h);
            tCaptcha.setEditable(false);
            s = h;
        } 
      else if(e.getSource() == signup)
        {
                
            try {
                SignUp u = new SignUp();
                u.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }
        
    }
    public static void main(String args[]) 
            
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Update_Traininfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        LoginPage  f = new LoginPage();
    }
}
