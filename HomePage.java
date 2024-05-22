import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame {
    private Color currentThemeColor = new Color(255, 240, 245); // Default theme color (Faint pink background)
 
    public HomePage() {
       
        setTitle("Home Page");
        
         setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(currentThemeColor); // Set initial theme color
           ImageIcon icon = new ImageIcon(getClass().getResource("/stud.jpeg"));
        Image backgroundImage = icon.getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        setContentPane(backgroundPanel);

        // Colors for buttons
        Color primaryColor = new Color(255, 99, 71); // Tomato red
        Color secondaryColor = new Color(255, 153, 153); // Coral
        Color settingsColor = new Color(102, 204, 255); // Sky blue
        Color aboutUsColor = new Color(255, 204, 102); // Peach

         // Buttons
        JButton settingsButton = createStyledButton("Settings", settingsColor);
        JButton contactUsButton = createStyledButton("Contact Us", primaryColor);
        JButton aboutUsButton = createStyledButton("About Us", aboutUsColor);
        JButton adminButton = createStyledButton("Admin", primaryColor);
        JButton staffButton = createStyledButton("Staff", primaryColor);
        JButton studentButton = createStyledButton("Student", primaryColor);
        JButton parentButton = createStyledButton("Parent", primaryColor);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBackground(currentThemeColor); // Faint pink background
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Adding buttons to the panel
        JPanel topButtonPanel = new JPanel(new FlowLayout());
        topButtonPanel.setBackground(currentThemeColor); // Faint pink background
        topButtonPanel.add(settingsButton);
        topButtonPanel.add(aboutUsButton);
        topButtonPanel.add(contactUsButton);
        buttonPanel.add(topButtonPanel);

        JPanel bottomButtonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        bottomButtonPanel.setBackground(currentThemeColor); // Faint pink background
        bottomButtonPanel.add(adminButton);
        bottomButtonPanel.add(staffButton);
        bottomButtonPanel.add(studentButton);
        bottomButtonPanel.add(parentButton);
        buttonPanel.add(bottomButtonPanel);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Add action listeners to the buttons
        parentButton.addActionListener(e -> {
            dispose(); // Close the window
            new Parent(); // Open homepage
        });
        adminButton.addActionListener(e -> {
            dispose(); // Close the window
            new AdminDesk(); // Open homepage
        });
        
        aboutUsButton.addActionListener(e -> openAboutUsPage());
        contactUsButton.addActionListener(e -> openContactUsPage());
       // adminButton.addActionListener(e -> openLoginPage("Admin"));
        staffButton.addActionListener(e -> openLoginPage("Staff"));
        studentButton.addActionListener(e -> openLoginPage("Student"));
      // parentButton.addActionListener(e -> openLoginPage("Parent"));
        settingsButton.addActionListener(e -> openSettingsWindow());

        setVisible(true);
       
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        return button;
    }

    private void openAboutUsPage() {
        SwingUtilities.invokeLater(() -> new AboutUsWindow());
    }

    private void openContactUsPage() {
        SwingUtilities.invokeLater(() -> new ContactUsWindow());
    }

    private void openLoginPage(String userType) {
        SwingUtilities.invokeLater(() -> new LoginPage(userType));
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage());
    }
}

class AboutUsWindow extends JFrame {
    public AboutUsWindow() {
         setTitle("About Us");
        setSize(800, 400);
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
    
    }
}

class ContactUsWindow extends JFrame {
    public ContactUsWindow() {
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
    }
}
class LoginPage extends JFrame {
    public LoginPage(String userType) {
        setTitle("Login Page - " + userType);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel label = new JLabel("Enter your credentials:");
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
         JButton loginButton = new JButton("Login");

        add(label);
        add(usernameField);
        add(passwordField);
        add(loginButton);

        setVisible(true);
    }

}