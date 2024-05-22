import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StaffDesk extends JFrame {
    private static HashMap<String, String> studentAttendance = new HashMap<>();
 
    public StaffDesk() {
        setTitle("Staff Desk");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Load the background image
        ImageIcon icon = new ImageIcon(getClass().getResource("/staff.jpeg"));
        Image backgroundImage = icon.getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        setContentPane(backgroundPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JButton AboutUsButton = createButton("About US", new Color(70, 130, 180), 220, 60);
        gbc.gridx++;
        add(AboutUsButton, gbc);
        JButton ContactButton = createButton("Contact", new Color(255, 69, 0), 220, 60);
        gbc.gridx++;
        add(ContactButton, gbc);

        JButton lectureCornerButton = createButton("Lecture Corner", new Color(218, 112, 214), 220, 60);
        add(lectureCornerButton, gbc);

        JButton leaveApplicationButton = createButton("Leave Application", new Color(255, 69, 0), 220, 60);
        gbc.gridx++;
        add(leaveApplicationButton, gbc);

        JButton attendanceButton = createButton("Attendance", new Color(60, 179, 113), 220, 60);
        gbc.gridx = 0;
        gbc.gridy++;
        add(attendanceButton, gbc);

        JButton queryResponseButton = createButton("Query Response", new Color(70, 130, 180), 220, 60);
        gbc.gridx++;
        add(queryResponseButton, gbc);

        JButton exitButton = createButton("Exit", new Color(255, 0, 0), 120, 40);
        gbc.gridx = 1;
        gbc.gridy++;
        add(exitButton, gbc);

        exitButton.addActionListener(e -> {
            dispose(); // Close the window
            new HomePage(); // Open homepage
        });
        lectureCornerButton.addActionListener(e -> openLectureCornerWindow());
        leaveApplicationButton.addActionListener(e -> openLeaveApplicationWindow());
        attendanceButton.addActionListener(e -> openAttendanceWindow());
        queryResponseButton.addActionListener(e -> openQueryResponseWindow());
        AboutUsButton.addActionListener(e -> AboutUsWindow());
        ContactButton.addActionListener(e -> ContactUsWindow());
        setVisible(true);
    }

    private JButton createButton(String text, Color bgColor, int width, int height) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(width, height));
        return button;
    }

    private void openLectureCornerWindow() {
        JFrame lectureFrame = new JFrame("Lecture Corner");
        lectureFrame.setSize(400, 300);
        lectureFrame.setLocationRelativeTo(this);
        lectureFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lectureFrame.getContentPane().setBackground(new Color(176, 224, 230)); // Powder blue

        JTextArea lectureText = new JTextArea(
                "Monday:\n9:00 AM - Java Basics\n11:00 AM - OOP Concepts\n\nTuesday:\n10:00 AM - Algorithms");
        lectureText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(lectureText);
        lectureFrame.add(scrollPane, BorderLayout.CENTER);

        lectureFrame.setVisible(true);
    }

    private void openLeaveApplicationWindow() {
        JFrame leaveFrame = new JFrame("Leave Application");
        leaveFrame.setSize(350, 250);
        leaveFrame.setLocationRelativeTo(this);
        leaveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        leaveFrame.getContentPane().setBackground(new Color(255, 235, 205)); // Blanched almond

        JPanel leavePanel = new JPanel(new GridLayout(3, 2, 10, 10));
        leavePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        leavePanel.setBackground(new Color(255, 235, 205)); // Blanched almond

        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField();
        leavePanel.add(dateLabel);
        leavePanel.add(dateField);

        JLabel reasonLabel = new JLabel("Reason:");
        JTextArea reasonArea = new JTextArea();
        reasonArea.setLineWrap(true);
        leavePanel.add(reasonLabel);
        leavePanel.add(reasonArea);

        JButton submitButton = createButton("Submit", new Color(255, 140, 0), 100, 30);
        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(leaveFrame, "Leave submitted successfully!");
            leaveFrame.dispose();
        });
        leavePanel.add(submitButton);

        leaveFrame.add(leavePanel, BorderLayout.CENTER);
        leaveFrame.setVisible(true);
    }

    private void openAttendanceWindow() {
        JFrame attendanceFrame = new JFrame("Attendance Management");
        attendanceFrame.setSize(900, 600);
        attendanceFrame.setLocationRelativeTo(this);
        attendanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        attendanceFrame.getContentPane().setBackground(new Color(176, 196, 222)); // Light Steel Blue

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton dailyAttendanceButton = createButton("Daily Attendance", new Color(70, 130, 180), 150, 30);
        dailyAttendanceButton.addActionListener(e -> showDailyAttendance(attendanceFrame));
        panel.add(dailyAttendanceButton, gbc);
        gbc.gridy++;

        JButton exitButton = createButton("Exit", new Color(255, 69, 0), 150, 30);
        exitButton.addActionListener(e -> attendanceFrame.dispose());
        panel.add(exitButton, gbc);

        attendanceFrame.add(panel);
        attendanceFrame.setVisible(true);
    }

    private void openQueryResponseWindow() {
        JFrame responseFrame = new JFrame("Query Response");
        responseFrame.setSize(400, 300);
        responseFrame.setLocationRelativeTo(this);
        responseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        responseFrame.getContentPane().setBackground(new Color(240, 240, 240)); // Light Gray

        JTextArea responseArea = new JTextArea(10, 30);
        responseArea.setEditable(true); // Allow staff to type response
        JScrollPane scrollPane = new JScrollPane(responseArea);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String response = responseArea.getText();
            // You can process the response here (e.g., send it to a server, store in a database, etc.)
            JOptionPane.showMessageDialog(responseFrame, "Response submitted successfully:\n\n" + response);
            responseFrame.dispose();
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);

        responseFrame.add(panel);
        responseFrame.setVisible(true);
    }

    private void showDailyAttendance(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "Daily Attendance", true);
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(parentFrame);

        JPanel attendancePanel = new JPanel(new BorderLayout());

        JTextArea attendanceText = new JTextArea(10, 30);
        attendanceText.setEditable(false);
        updateAttendanceText(attendanceText); // Update text with current attendance data

        JScrollPane scrollPane = new JScrollPane(attendanceText);
        attendancePanel.add(scrollPane, BorderLayout.CENTER);

        JPanel detailsPanel = new JPanel(new GridLayout(1, 2, 10, 5));

        JTextField nameField = new JTextField();
        JTextField rollNoField = new JTextField();
        detailsPanel.add(new JLabel("Name:"));
        detailsPanel.add(nameField);
        detailsPanel.add(new JLabel("Roll No:"));
        detailsPanel.add(rollNoField);

        attendancePanel.add(detailsPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton presentButton = createButton("Present", new Color(34, 139, 34), 100, 30);
        JButton absentButton = createButton("Absent", new Color(220, 20, 60), 100, 30);
        JButton showAllButton = createButton("Show All", new Color(70, 130, 255), 100, 30);
        JButton updateButton = createButton("Update", new Color(255, 140, 0), 100, 30);
        JButton exitButton = createButton("Exit", new Color(255, 69, 0), 100, 30);
        buttonPanel.add(presentButton);
        buttonPanel.add(absentButton);
        buttonPanel.add(showAllButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(exitButton);

        attendancePanel.add(buttonPanel, BorderLayout.SOUTH);

        presentButton.addActionListener(e -> markAttendance(nameField.getText(), rollNoField.getText(), "Present", attendanceText));
        absentButton.addActionListener(e -> markAttendance(nameField.getText(), rollNoField.getText(), "Absent", attendanceText));
        showAllButton.addActionListener(e -> showAllAttendance(attendanceText));
        updateButton.addActionListener(e -> updateAttendanceText(attendanceText)); // Update attendance text
        exitButton.addActionListener(e -> dialog.dispose());

        dialog.add(attendancePanel);
        dialog.setVisible(true);
    }

    private void markAttendance(String name, String rollNo, String status, JTextArea attendanceText) {
        if (!name.isEmpty() && !rollNo.isEmpty()) {
            String key = name.trim() + " - " + rollNo.trim();
            // Get current date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateTimeString = now.format(formatter);
            // Append date and time along with status to the attendance map
            studentAttendance.put(key, dateTimeString + " - " + status);
            updateAttendanceText(attendanceText);
            JOptionPane.showMessageDialog(null, "Marked " + status + " for " + name + " (Roll No: " + rollNo + ")");
        } else {
            JOptionPane.showMessageDialog(null, "Name and Roll No cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateAttendanceText(JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name\tRoll No\tAttendance\n");
        sb.append("--------------------------------------\n");
        studentAttendance.forEach((key, value) -> sb.append(key.split(" - ")[0]).append("\t").append(key.split(" - ")[1]).append("\t").append(value).append("\n"));
        textArea.setText(sb.toString());
    }

    private void showAllAttendance(JTextArea attendanceText) {
        StringBuilder sb = new StringBuilder();
        sb.append("All Attendance Records\n");
        sb.append("Student Name\tRoll No\tAttendance\n");
        sb.append("--------------------------------------\n");
        studentAttendance.forEach((key, value) -> sb.append(key.split(" - ")[0]).append("\t").append(key.split(" - ")[1]).append("\t").append(value).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString(), "All Attendance Records", JOptionPane.INFORMATION_MESSAGE);
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
        SwingUtilities.invokeLater(StaffDesk::new);
    }
}
