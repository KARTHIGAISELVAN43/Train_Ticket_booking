/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train; 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseToPDFConverter {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/train_db";
        String username = "root";
        String password = "";

        try {
            // Establishing a database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();

            // Execute a query to fetch data from the database
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reserved");

            // Creating a PDF document using iText
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("fileexe.pdf"));
            document.open();

            // Adding database data to the PDF document
            while (resultSet.next()) {
                int column1Data = resultSet.getInt("reserveid");
                String column2Data = resultSet.getString("train_number");
                  String column3Data = resultSet.getString("passenger_name");
                String column4Data = resultSet.getString("mobile_number");
                  String column5Data = resultSet.getString("address");
                String column6Data = resultSet.getString("age");
                  String column7Data = resultSet.getString("From");
                String column8Data = resultSet.getString("To");
                  String column9Data = resultSet.getString("Fare");
                String column10Data = resultSet.getString("Time");
                  String column11Data = resultSet.getString("Coach_number");
                String column12Data = resultSet.getString("Coach_type");
                  String column13Data = resultSet.getString("Seat_type");
                String column14Data = resultSet.getString("Seat_number");
                  String column15Data = resultSet.getString("Food_pantry");
                String column16Data = resultSet.getString("fooditems");
                // Adding data to the PDF document
                
                
                document.add(new Paragraph("Column 1: " + column1Data));
                document.add(new Paragraph("Column 2: " + column2Data));
                document.add(new Paragraph("Column 3: " + column3Data));
                document.add(new Paragraph("Column 4: " + column4Data));
                document.add(new Paragraph("Column 5: " + column5Data));
                document.add(new Paragraph("Column 6: " + column6Data));
                document.add(new Paragraph("Column 7: " + column7Data));
                document.add(new Paragraph("Column 8: " + column8Data));
                document.add(new Paragraph("Column 9: " + column9Data));
                document.add(new Paragraph("Column 10: " + column10Data));
                document.add(new Paragraph("Column 11: " + column11Data));
                document.add(new Paragraph("Column 12: " + column12Data));
                document.add(new Paragraph("Column 13: " + column13Data));
                document.add(new Paragraph("Column 14: " + column14Data));
                document.add(new Paragraph("Column 15: " + column15Data));
                document.add(new Paragraph("Column 16: " + column16Data));
                
                document.add(new Paragraph("-------------------------------------------"));
            }

            // Closing resources
            document.close();
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("PDF created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

