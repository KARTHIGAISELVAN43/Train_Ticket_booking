/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

/**
 *
 * @author myash
 */
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ImageInputFrame extends javax.swing.JFrame {

    public ImageInputFrame() {
        initComponents();
    }

    private void initComponents() {
        

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            Image image = imageIcon.getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT);
            // Do something with the image, such as displaying it in a JLabel or processing it
            // For example:
            JFrame imageDisplayFrame = new JFrame();
            imageDisplayFrame.getContentPane().add(new javax.swing.JLabel(new ImageIcon(image)));
            imageDisplayFrame.pack();
            imageDisplayFrame.setVisible(true);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ImageInputFrame().setVisible(true);
        });
    }

    private javax.swing.JButton jButtonSelectImage;
}

