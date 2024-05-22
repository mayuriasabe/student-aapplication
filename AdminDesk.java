
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDesk extends JFrame {
  private Color currentThemeColor = new Color(255, 240, 245);
    public AdminDesk() {
        setTitle("Admin Desk");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 10, 10));

 
        // Background color
        getContentPane().setBackground(new Color(240, 248, 255)); // Light blue
  ImageIcon icon = new ImageIcon(getClass().getResource("/admin2.jpeg"));
        Image backgroundImage = icon.getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        setContentPane(backgroundPanel);
        JButton staffButton = new JButton("Staff");
        staffButton.setBackground(new Color(70, 130, 180)); // Steel blue
        staffButton.setForeground(Color.WHITE);
        staffButton.setFont(new Font("Arial", Font.BOLD, 16));
        staffButton.addActionListener(e -> {
            // Open staff input dialog
             openStudentInputDialog();
        });
        JButton settingButton = new JButton("Settings");
        settingButton.setBackground(new Color(70, 130, 180)); // Steel blue
        settingButton.setForeground(Color.WHITE);
        settingButton.setFont(new Font("Arial", Font.BOLD, 16));
        settingButton.addActionListener(e -> {
            // Open staff input dialog
             openSettingsWindow();
        });
        JButton AboutUsButton = new JButton("About Us");
        AboutUsButton.setBackground(new Color(70, 130, 180)); // Steel blue
        AboutUsButton.setForeground(Color.WHITE);
        AboutUsButton.setFont(new Font("Arial", Font.BOLD, 16));
        AboutUsButton.addActionListener(e -> {
            // Open staff input dialog
             AboutUsWindow();
        });
      
        
        // Buttons
        JButton contactButton = new JButton("Contact Us");
        contactButton.setBackground(new Color(70, 130, 180)); // Steel blue
        contactButton.setForeground(Color.WHITE);
        contactButton.setFont(new Font("Arial", Font.BOLD, 16));
        contactButton.addActionListener(e -> {
            // Open staff input dialog
             ContactUsWindow();
        });

        JButton studentButton = new JButton("Student");
        studentButton.setBackground(new Color(70, 130, 180)); // Steel blue
        studentButton.setForeground(Color.WHITE);
        studentButton.setFont(new Font("Arial", Font.BOLD, 16));
        studentButton.addActionListener(e -> {
            // Open student input dialog
            openStudentInputDialog();
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(70, 130, 180)); // Steel blue
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.addActionListener(e -> {
            // Close admin desk and display homepage
            dispose();
            new HomePage();
        });

        // Add buttons to the frame
        add(settingButton);
        add(AboutUsButton);
        add(contactButton);
        add(staffButton);
        add(studentButton);
        add(exitButton);

        setVisible(true);
    }

     private void openSettingsWindow() {
        JFrame settingsFrame = new JFrame("Settings");
        settingsFrame.setSize(600, 300);
        settingsFrame.setLocationRelativeTo(this);
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel settingsPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        settingsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Settings:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingsPanel.add(titleLabel);

        JButton changeThemeButton = new JButton("Change Theme");
        changeThemeButton.addActionListener(e -> {
            // Change the theme color here
            currentThemeColor = JColorChooser.showDialog(settingsFrame, "Choose Theme Color", currentThemeColor);
            if (currentThemeColor != null) {
                getContentPane().setBackground(currentThemeColor);
                // Update button panel background colors
                updateButtonPanelBackground(currentThemeColor);
            }
        });
        settingsPanel.add(changeThemeButton);

        JButton saveSettingsButton = new JButton("Save Settings");
        saveSettingsButton.addActionListener(e -> {
            // Add functionality to save settings here
            JOptionPane.showMessageDialog(settingsFrame, "Settings saved!");
        });
        settingsPanel.add(saveSettingsButton);

        settingsFrame.add(settingsPanel);
        settingsFrame.setVisible(true);
    }

    private void updateButtonPanelBackground(Color color) {
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JPanel) {
                ((JPanel) comp).setBackground(color);
            }
        }
    }
    public void AboutUsWindow() {
         setTitle("About Us");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(getClass().getResource("/about us.jpeg"));
        Image backgroundImage = icon.getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        setContentPane(backgroundPanel);
        getContentPane().setBackground(new Color(0, 255, 255)); // Light blue background

       JLabel contactLabel = new JLabel("<html><br>NUMETRIC TECHNOLOGIES PRIVATE LIMITED:</br><br>"
                + "Email: mayu@example.com<br>"
                + "Phone: 7249004044<br>"
                + "Address: 123 Main St, Solapur, India</html>");
        contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
 
        add(contactLabel, BorderLayout.CENTER);

        setVisible(true);
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(70, 130, 180)); // Steel blue
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.addActionListener(e -> {
            // Close admin desk and display homepage
            dispose();
            new AdminDesk();
        });
     add(exitButton);
     setVisible(true);
    }



    public void ContactUsWindow() {
        setTitle("Contact Us");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(getClass().getResource("/contact.jpeg"));
        Image backgroundImage = icon.getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        setContentPane(backgroundPanel);
        getContentPane().setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel contactLabel = new JLabel("<html><br>Contact Information:</br><br>"
                + "Email: mayu@example.com<br>"
                + "Phone: 7249004044<br>"
                + "Address: 123 Main St, Solapur, India</html>");
        contactLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(contactLabel, BorderLayout.CENTER);

        setVisible(true);
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(70, 130, 180)); // Steel blue
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.addActionListener(e -> {
            // Close admin desk and display homepage
            dispose();
            new AdminDesk();
        });
     add(exitButton);
     setVisible(true);
    }


    private void openStaffInputDialog() {
        JTextField nameField = new JTextField(20);
        JTextField branchField = new JTextField(20);
        JTextField mobileField = new JTextField(20);
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Branch:"));
        panel.add(branchField);
        panel.add(new JLabel("Mobile Number:"));
        panel.add(mobileField);
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Staff",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // Retrieve and process staff information here
            String name = nameField.getText();
            String branch = branchField.getText();
            String mobile = mobileField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Display success message
            JOptionPane.showMessageDialog(null, "Staff added successfully:\nName: " + name +
                    "\nBranch: " + branch + "\nMobile: " + mobile + "\nUsername: " + username +
                    "\nPassword: " + password);
        }
    }

    private void openStudentInputDialog() {
        JTextField nameField = new JTextField(20);
        JTextField branchField = new JTextField(20);
        JTextField mobileField = new JTextField(20);
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Branch:"));
        panel.add(branchField);
        panel.add(new JLabel("Mobile Number:"));
        panel.add(mobileField);
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Student",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // Retrieve and process student information here
            String name = nameField.getText();
            String branch = branchField.getText();
            String mobile = mobileField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Display success message
            JOptionPane.showMessageDialog(null, "Student added successfully:\nName: " + name +
                    "\nBranch: " + branch + "\nMobile: " + mobile + "\nUsername: " + username +
                    "\nPassword: " + password);
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminDesk());
    }
}
