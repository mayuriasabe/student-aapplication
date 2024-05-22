import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {

    public LoginPage(String userType) {
        setTitle(userType + " Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background color
        getContentPane().setBackground(new Color(240, 248, 255)); // Light blue

        // Panel for login components
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(240, 248, 255)); // Light blue

        // Constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Labels and fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(nameLabel, gbc);

        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(emailLabel, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JTextField nameField = new JTextField(15);
        loginPanel.add(nameField, gbc);

        gbc.gridy++;
        JTextField emailField = new JTextField(15);
        loginPanel.add(emailField, gbc);

        gbc.gridy++;
        JPasswordField passwordField = new JPasswordField(15);
        loginPanel.add(passwordField, gbc);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(70, 130, 180)); // Steel blue
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        // Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(192, 192, 192)); // Light gray
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 0, 0);
        loginPanel.add(registerButton, gbc);

        // Forgot password link
        JLabel forgotPasswordLink = new JLabel("Forgot Password?");
        forgotPasswordLink.setForeground(Color.BLUE.darker());
        forgotPasswordLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.gridy++;
        loginPanel.add(forgotPasswordLink, gbc);

        // Add ActionListener to login button
        loginButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            char[] password = passwordField.getPassword();
            if (!name.isEmpty() && !email.isEmpty() && password.length > 0) {
                displaySuccessMessage(userType, name);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add ActionListener to registration button
        registerButton.addActionListener(e -> new RegistrationPage());

        // Add MouseListener to forgot password link
        forgotPasswordLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayForgotPasswordDialog();
            }
        });

        // Add login panel to the frame
        add(loginPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void displaySuccessMessage(String userType, String name) {
        JOptionPane.showMessageDialog(this, "Welcome, " + name + "!\nYou have successfully logged in as a " + userType + ".", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
        switch (userType) {
       // case "Admin":
         //   new AdminDesk();
           // break;
        case "Staff":
            new StaffDesk();
            break;
        case "Student":
            new StudentDesk(name);
            break;
        default:
            System.out.println("Unknown user type: " + userType);
            break;
    }
    this.dispose(); // Close the login window
 // Close the login window
    } // Close the login window
    

    private void displayForgotPasswordDialog() {
        String email = JOptionPane.showInputDialog(this, "Enter your email for password reset:");
        if (email != null && !email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password reset link sent to " + email, "Reset Email Sent", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Email cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
       // SwingUtilities.invokeLater(() -> new LoginPage("Admin"));
        SwingUtilities.invokeLater(() -> new LoginPage("Staff"));
        SwingUtilities.invokeLater(() -> new LoginPage("Student"));
    }
}
