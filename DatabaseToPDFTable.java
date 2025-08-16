/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

/**
 *
 * @author myash
 */
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseToPDFTable {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            // Establish connection to your database
       //     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // SQL Query to retrieve prescription data
         /*   String sql = "SELECT * FROM prescriptions WHERE patient_id = ?"; // Modify the query accordingly
            
            // Create a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 123); // Example patient_id
            
            // Execute the query
            ResultSet resultSet = statement.executeQuery();
*/
            // Create a PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("prescription_table.pdf"));
            document.open();

            // Create a table with column headers
            PdfPTable table = new PdfPTable(3); // Adjust the number of columns as per your requirement

            // Add column headers
            table.addCell("Column 1");
            table.addCell("Column 2");
            table.addCell("Column 3");
            // Add more cells for additional columns as needed

            // Add data from the database to the table
            /*while (resultSet.next()) {
                // Retrieve data from the result set
                String data1 = resultSet.getString("column_name_1"); // Change column_name_1 accordingly
                String data2 = resultSet.getString("column_name_2"); // Change column_name_2 accordingly
                String data3 = resultSet.getString("column_name_3"); // Change column_name_3 accordingly
                // Retrieve more columns as needed*/

                // Add data to the table
                table.addCell("yash");
                table.addCell("kade");
                table.addCell("polard");
                // Add more cells for additional columns as needed
            //}
            table.addCell("Rohan");
            table.addCell("Rohan");
            table.addCell("Rohan");
            // Add the table to the document
            document.add(table);

            // Close document and database connections
            document.close();
            //resultSet.close();
            //statement.close();
          //  connection.close();

            System.out.println("PDF with table generated successfully!");

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
