/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author myash
 */
public class Calendar {
       JLabel res;
       String DOB;
       
       JFrame frame;
     JPanel calendarPanel;
     JLabel monthLabel;
     JButton sel;
     JComboBox year;
     YearMonth currentYearMonth;
    Calendar(JTextField dt) {
        frame = new JFrame("Calender");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setResizable(false);
        currentYearMonth = YearMonth.now();

        monthLabel = new JLabel();
        monthLabel.setBounds(120, 0, 190, 40);
        monthLabel.setFont(new Font("Arial", Font.BOLD, 20));
        //year = new JComboBox();
       
      //  year.setBounds(10,100,30,15);
        JButton previousButton = new JButton("<<");
        previousButton.addActionListener(e -> {
            currentYearMonth = currentYearMonth.minusMonths(1);
            updateCalendar(dt);
        });

        JButton nextButton = new JButton(">>");
        nextButton.addActionListener(e -> {
            currentYearMonth = currentYearMonth.plusMonths(1);
            updateCalendar(dt);
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(null);
        
        controlPanel.add(previousButton);
        previousButton.setBounds(0, 0, 50,30);
        controlPanel.add(monthLabel);
      
       // controlPanel.add(year, BorderLayout.);
       controlPanel.setBounds(0, 0, 400, 30);
       nextButton.setBounds(350, 0, 50,30);
        controlPanel.add(nextButton);
        
        
        
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(0, 7,1,1));
        calendarPanel.setBounds(0,32, 390,255);
        frame.add(controlPanel);
        frame.add(calendarPanel);
        //calendarPanel.setBounds(0,32, 400,265);

        updateCalendar(dt);
        
        frame.setVisible(true);
    }

 
 public String updateCalendar(JTextField dt) {
        monthLabel.setText(currentYearMonth.getMonth().toString() + " " + currentYearMonth.getYear() );

        calendarPanel.removeAll();

        LocalDate date = currentYearMonth.atDay(1);
        int daysInMonth = currentYearMonth.lengthOfMonth();
        int offset = date.getDayOfWeek().getValue() % 7;

        for (int i = 1; i <= daysInMonth + offset; i++) {
            JButton dayButton = new JButton();
         
            if (i > offset) {
                int day = i - offset;
                dayButton.setText(String.valueOf(day));
                LocalDate currentDate = LocalDate.of(currentYearMonth.getYear(), currentYearMonth.getMonth(), day);
                //DOB = currentDate.toString();
                dayButton.addActionListener(new ActionListener(){
    @Override
                     public void actionPerformed(ActionEvent e){
                         DOB = currentDate.toString();
                         dt.setText(DOB);
                         
                }
               // DOB = currentDate.toString();
            });
              
            }
            calendarPanel.add(dayButton);
        }
        calendarPanel.setVisible(true);
        calendarPanel.revalidate();
        calendarPanel.repaint();
        
      return DOB;
    }
    public String ReturnCal()
    {
        return DOB;
    }
 
    
    public static void main(String []args){
     Calendar g =  new Calendar(new JTextField());
     String f  = g.ReturnCal();
     System.out.print(f);
     
 }
 
 
    
}
