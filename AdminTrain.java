/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;
import com.mycompany.edittraininfo.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class AdminTrain extends javax.swing.JFrame {

Statement stmt;
Connection con;
ResultSet result,result1;
    
    public AdminTrain() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        traincount = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("STATUS");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(600, 10, 260, 60);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Train Number", "Train Name", "source", "destination", "Arrival", "Departure", "Fare"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 180, 1110, 402);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton1.setText("Click");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(700, 100, 210, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Click To View Available Trains in the Railway ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 80, 610, 60);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Train Count");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(910, 40, 110, 30);

        traincount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        getContentPane().add(traincount);
        traincount.setBounds(1090, 36, 90, 30);

        Back.setBackground(new java.awt.Color(255, 0, 0));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back);
        Back.setBounds(60, 40, 160, 40);

        setBounds(0, 0, 1302, 632);
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            // TODO add your handling code here:
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_db","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
         jTable1.setBackground(new java.awt.Color(102, 255, 255));
         jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
         jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "train_number", "train_name", "source", "destination" ,"arrival","departure","price"
            }
        ));
         jTable1.setGridColor(new java.awt.Color(153, 255, 255));
         jTable1.setIntercellSpacing(new java.awt.Dimension(2, 2));
         jTable1.setRowHeight(100);
         jTable1.setShowHorizontalLines(true);
        int c= 0;
            DefaultTableModel tbl=(DefaultTableModel)  jTable1.getModel();
            tbl.setRowCount(0);
            String query = "SELECT * from train_information";
            try {
                stmt = con.createStatement();
                result = stmt.executeQuery(query);
                    String tname,souce,des,arr,dept;
                    Integer tno,fare;
                    while(result.next()){
                          tno = result.getInt("train_number");
                          tname = result.getString("train_name");
                          souce = result.getString("source");
                          des = result.getString("destination");
                          arr = result.getString("arrival");
                          dept = result.getString("departure");
                          ++c;
                          fare = result.getInt("price");
                          
                        String [] rowData={tno.toString(),tname,souce,des,arr,dept,fare.toString()};
                        tbl.addRow(rowData);
                    }
                     }
            catch(Exception ex){
                ex.printStackTrace();
            }
            String h = String.valueOf(c);
            traincount.setText(h);
        
        
    }                                        

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
       AdminStatus i = new AdminStatus();
       i.setVisible(true);
       this.setVisible(false);
    }                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminTrain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel traincount;
    // End of variables declaration                   
}

