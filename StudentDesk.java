import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentDesk extends JFrame {

    public StudentDesk(String studentName) {
        setTitle("Student Desk");
        setSize(1000, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
ImageIcon icon = new ImageIcon(getClass().getResource("/student.jpeg"));
        Image backgroundImage = icon.getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        setContentPane(backgroundPanel);

        // Background color
        getContentPane().setBackground(new Color(176, 224, 230)); // Powder blue

        // Constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(13, 10, 10, 10);

        // Student name label
        JLabel nameLabel = new JLabel("Student Name: " + studentName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(nameLabel, gbc);

        // Note label and textfield
        gbc.gridy++;
        JLabel noteLabel = new JLabel("Note:");
        noteLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(noteLabel, gbc);

        gbc.gridx++;
        JTextField noteField = new JTextField(20);
        add(noteField, gbc);

        // Mark Attendance checkbox
        JCheckBox markAttendanceCheckBox = new JCheckBox("");
        markAttendanceCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        add(markAttendanceCheckBox, gbc);

        // Submit button
        JButton submitButton = createButton("Submit", new Color(0, 128, 0), 120, 40);
        gbc.gridx++;
        add(submitButton, gbc);

        JButton AboutButton = createButton("About Us", new Color(255, 165, 0), 120, 40);
        gbc.gridx++;
        add(AboutButton, gbc);
        JButton ContactButton = createButton("Contact Us", new Color(0, 0, 125), 120, 40);
        gbc.gridx++;
        add(ContactButton, gbc);
        // Fees Structure button
        JButton feesButton = createButton("Fees Structure", new Color(255, 165, 0), 160, 40);
        gbc.gridx = 0;
        gbc.gridy++;
        add(feesButton, gbc);

        // Lecture Corner button
        JButton lectureButton = createButton("Lecture Corner", new Color(0, 0, 255), 160, 40);
        gbc.gridx++;
        add(lectureButton, gbc);

        // Raise Query button
        JButton raiseQueryButton = createButton("Raise Query", new Color(255, 69, 0), 160, 40);
        gbc.gridx = 0;
        gbc.gridy++;
        add(raiseQueryButton, gbc);

        // Lecture Staff button
        JButton lectureStaffButton = createButton("Lecture Staff", new Color(255, 192, 203), 160, 40);
        gbc.gridx++;
        add(lectureStaffButton, gbc);

        // Exit button
        JButton exitButton = createButton("exit", new Color(255, 192, 203), 160, 40);
        gbc.gridx++;
        add(exitButton, gbc);


        // Add ActionListener to the Fees Structure button
        feesButton.addActionListener(e -> {
            showFeesStructureDialog();
        });

        // Add ActionListener to the Lecture Corner button
        lectureButton.addActionListener(e -> {
            showLectureCornerDialog();
        });
         lectureStaffButton.addActionListener(e -> {
            showLectureStaffDialog();
        });

        // Add ActionListener to the Raise Query button
        raiseQueryButton.addActionListener(e -> {
            showRaiseQueryDialog();
        });

        // Add ActionListener to the Lecture Staff button
        AboutButton.addActionListener(e -> {
            AboutUsWindow();
        });
        ContactButton.addActionListener(e -> {
            ContactUsWindow();
        });
        feesButton.addActionListener(e -> {
            showFeesStructureDialog();
        });

        // Add ActionListener to the Exit button
       
        exitButton.setBackground(new Color(70, 130, 180)); // Steel blue
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.addActionListener(e -> {
            // Close admin desk and display homepage
            dispose();
            new HomePage();
        });

        // Add ActionListener to the Submit button
        submitButton.addActionListener(e -> {
            if (markAttendanceCheckBox.isSelected()) {
                markAttendance(studentName);
                JOptionPane.showMessageDialog(StudentDesk.this, "Attendance marked successfully!");
            } else {
                JOptionPane.showMessageDialog(StudentDesk.this, "Please mark the attendance checkbox to submit attendance.");
            }
        });

        setVisible(true);
    }

    // Method to create a styled button
    private JButton createButton(String text, Color bgColor, int width, int height) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Larger font size
        button.setPreferredSize(new Dimension(width, height)); // Custom size
        return button;
    }

    // Dummy method for marking attendance (replace with actual logic)
    private void markAttendance(String studentName) {
        System.out.println("Attendance marked for " + studentName);
    }

    // Method to show the fees structure dialog
    private void showFeesStructureDialog() {
        JOptionPane.showMessageDialog(this, "Fees Structure Details:\n\nTuition Fee: $1000\nBooks Fee: $200\nTotal: $1200", "Fees Structure", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to show the lecture corner dialog
    private void showLectureCornerDialog() {
        StringBuilder message = new StringBuilder("Lecture Corner:\n");
        message.append("1. Introduction to Java Programming - 10:00 AM\n");
        message.append("2. Advanced Data Structures - 1:00 PM\n");
        message.append("3. Algorithms and Complexity - 3:00 PM\n");
        JOptionPane.showMessageDialog(this, message.toString(), "Lecture Corner", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to show the raise query dialog
    private void showRaiseQueryDialog() {
        JTextArea queryTextArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(queryTextArea);
        int option = JOptionPane.showConfirmDialog(this, scrollPane, "Raise Query", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            String query = queryTextArea.getText();
            // You can process the submitted query here (e.g., send it to a server, store in a database, etc.)
            JOptionPane.showMessageDialog(this, "Query submitted successfully:\n\n" + query, "Query Submitted", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method to show the lecture staff dialog
    private void showLectureStaffDialog() {
        StringBuilder staffInfo = new StringBuilder("Lecture Staff:\n");
        staffInfo.append("1. Dr. John Doe -Mathematics Professor\n");
        staffInfo.append("2. Jane Smith - Java Lecture Professor\n");
        staffInfo.append("3. Michael Johnson - DSA Professor\n");
        staffInfo.append("1. Dr.Jagtap -Physics Professor\n");
        staffInfo.append("2.  Smith - Python Professor\n");
        staffInfo.append("3. Michael John - AI Professor\n");
        JOptionPane.showMessageDialog(this, staffInfo.toString(), "Lecture Staff", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
     public void AboutUsWindow() {
        StringBuilder message = new StringBuilder("About US:\n");
        message.append(" NUMETRIC TECHNOLOGIES PRIVATE LIMITED\n");
        message.append("numerty@gmail.com\n");
        message.append("www.numetry.com\n");
        JOptionPane.showMessageDialog(this, message.toString(), "Lecture Corner", JOptionPane.INFORMATION_MESSAGE);
    
   
    }
public void ContactUsWindow() {
       StringBuilder message = new StringBuilder("Contact Us:\n");
        message.append("1.Email: mayu@example.com \n");
        message.append("2.Mono -7249023654\n");
        message.append("3.solapur ,maharashtra,India\n");
        JOptionPane.showMessageDialog(this, message.toString(), "Contact US", JOptionPane.INFORMATION_MESSAGE);
    }   
        
       
    



    public static void main(String[] args) {
        // Ask the user to enter their name
        String studentName = JOptionPane.showInputDialog(null, "Enter your name:");
        if (studentName != null && !studentName.isEmpty()) {
            SwingUtilities.invokeLater(() -> new StudentDesk(studentName));
        } else {
            JOptionPane.showMessageDialog(null, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
