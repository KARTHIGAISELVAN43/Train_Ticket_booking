/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

/**
 *
 * @author myash
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;

public class DisplayImageFromDatabase extends JFrame {
Image image;
    public DisplayImageFromDatabase() {
        setTitle("Display Image from Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(400,400,200,200);
        add(imageLabel);

        // Replace these values with your MySQL database connection details
        String url = "jdbc:mysql://localhost:3306/train_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT image FROM admin_info WHERE admin_id = 18542;";
            // Change this ID according to your database record

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                Blob blob = resultSet.getBlob("image");
                byte[] imageData = blob.getBytes(1, (int) blob.length());

                // Convert byte array to Image
                ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                image = ImageIO.read(bis);

                // Set the image to the JLabel
                var imageIcon = new ImageIcon(image);
                Icon i2=new ImageIcon(imageIcon.getImage().getScaledInstance(200,200, WIDTH));
                imageLabel.setIcon(i2);
               //imageLabel.setBounds(400,400,200,250);
            } else {
                JOptionPane.showMessageDialog(this, "No image found for the given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       // pack();
        //setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DisplayImageFromDatabase::new);
    }
}
