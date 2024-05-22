import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Parent extends JFrame {
    private Color currentThemeColor = new Color(255, 240, 245); // Default theme color (Faint pink background)

    public Parent() {
        setTitle("Home Page");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(currentThemeColor); // Set initial theme color
 ImageIcon icon = new ImageIcon(getClass().getResource("/pp.jpeg"));
        Image backgroundImage = icon.getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        setContentPane(backgroundPanel);

        // Colors for buttons
        Color primaryColor = new Color(255, 99, 71); // Tomato red
        Color secondaryColor = new Color(255, 153, 153); // Coral
        Color settingsColor = new Color(102, 204, 255); // Sky blue
        Color aboutUsColor = new Color(255, 204, 102); // Peach
        Color facultyColor = new Color(102, 255, 178); // Light Green
        Color noticeColor = new Color(255, 153, 153); // Yellow
        Color careerColor = new Color(70, 130, 180); // Light Purple
        Color queryColor = new Color(255, 99, 71); // Pink
        Color collegesColor = new Color(255, 182, 193); // Light Pink
        Color schoolsColor = new Color(240, 230, 140); // Khaki
        Color universityColor = new Color(255, 228, 181); // Moccasin
        Color awardsColor = new Color(238, 130, 238); // Violet
        Color reviewsColor = new Color(250, 128, 114); // Salmon
        Color careerSupportColor = new Color(123, 104, 238); // Medium Slate Blue
       Color exitColor = new Color(255, 228, 181);
        // Buttons
        JButton settingsButton = createStyledButton("Settings", settingsColor);
        JButton contactUsButton = createStyledButton("Contact Us", primaryColor);
        JButton aboutUsButton = createStyledButton("About Us", aboutUsColor);
        JButton facultyButton = createStyledButton("Faculty Details", facultyColor);
        JButton noticeButton = createStyledButton("Notice", noticeColor);
        JButton careerButton = createStyledButton("Career", careerColor);
        JButton queryButton = createStyledButton("Query", queryColor);
        JButton collegesButton = createStyledButton("Colleges", collegesColor);
        JButton schoolsButton = createStyledButton("Schools", schoolsColor);
        JButton universityButton = createStyledButton("University", universityColor);
        JButton awardsButton = createStyledButton("Awards & Certifications", awardsColor);
        JButton reviewsButton = createStyledButton("Review & Ratings", reviewsColor);
        JButton careerSupportButton = createStyledButton(" Support", careerSupportColor);
         JButton exitButton=createStyledButton("Exit",exitColor); 
        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(currentThemeColor); // Faint pink background
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Adding buttons to the panel
        JPanel topButtonPanel = new JPanel(new FlowLayout());
        topButtonPanel.setBackground(currentThemeColor); // Faint pink background
        topButtonPanel.add(settingsButton);
        topButtonPanel.add(aboutUsButton);
        topButtonPanel.add(contactUsButton);
        topButtonPanel.add(facultyButton);

        JPanel middleButtonPanel = new JPanel(new FlowLayout());
        middleButtonPanel.setBackground(currentThemeColor); // Faint pink background
        middleButtonPanel.add(noticeButton);
        middleButtonPanel.add(careerButton);
        middleButtonPanel.add(queryButton);
        middleButtonPanel.add(collegesButton);

        JPanel lowerMiddleButtonPanel = new JPanel(new FlowLayout());
        lowerMiddleButtonPanel.setBackground(currentThemeColor); // Faint pink background
        lowerMiddleButtonPanel.add(schoolsButton);
        lowerMiddleButtonPanel.add(universityButton);
        lowerMiddleButtonPanel.add(awardsButton);
        lowerMiddleButtonPanel.add(reviewsButton);

        JPanel bottomButtonPanel = new JPanel(new FlowLayout());
        bottomButtonPanel.setBackground(currentThemeColor); // Faint pink background
        bottomButtonPanel.add(careerSupportButton);
bottomButtonPanel.add(exitButton);
        buttonPanel.add(topButtonPanel);
        buttonPanel.add(middleButtonPanel);
        buttonPanel.add(lowerMiddleButtonPanel);
        buttonPanel.add(bottomButtonPanel);
        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Add action listeners to the buttons
        exitButton.addActionListener(e -> {
            dispose(); // Close the window
            new HomePage(); // Open homepage
        });
        aboutUsButton.addActionListener(e -> openAboutUsPage());
        contactUsButton.addActionListener(e -> openContactUsPage());
        settingsButton.addActionListener(e -> openSettingsWindow());
        facultyButton.addActionListener(e -> openFacultyDetailsPage());
        noticeButton.addActionListener(e -> openNoticePage());
        careerButton.addActionListener(e -> openCareerPage());
        queryButton.addActionListener(e -> openQueryPage());
        collegesButton.addActionListener(e -> openCollegesPage());
        schoolsButton.addActionListener(e -> openSchoolsPage());
        universityButton.addActionListener(e -> openUniversityPage());
        awardsButton.addActionListener(e -> openAwardsPage());
        reviewsButton.addActionListener(e -> openReviewsPage());
        careerSupportButton.addActionListener(e -> openCareerSupportPage());

        setVisible(true);
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 50)); // Increase button size
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        button.setOpaque(true);
        return button;
    }

    private void openAboutUsPage() {
        SwingUtilities.invokeLater(() -> new AboutUsWindow());
    }

    private void openContactUsPage() {
        SwingUtilities.invokeLater(() -> new ContactUsWindow());
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
            currentThemeColor = JColorChooser.showDialog(settingsFrame, "Choose Theme Color", currentThemeColor);
            if (currentThemeColor != null) {
                getContentPane().setBackground(currentThemeColor);
                updateButtonPanelBackground(currentThemeColor);
            }
        });
        settingsPanel.add(changeThemeButton);

        JButton saveSettingsButton = new JButton("Save Settings");
        saveSettingsButton.addActionListener(e -> JOptionPane.showMessageDialog(settingsFrame, "Settings saved!"));
        settingsPanel.add(saveSettingsButton);

        settingsFrame.add(settingsPanel);
        settingsFrame.setVisible(true);
    }

    private void updateButtonPanelBackground(Color color) {
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JPanel) {
                ((JPanel) comp).setBackground(color);
                for (Component innerComp : ((JPanel) comp).getComponents()) {
                    if (innerComp instanceof JPanel) {
                        ((JPanel) innerComp).setBackground(color);
                    }
                }
            }
        }
    }

    private void openFacultyDetailsPage() {
        SwingUtilities.invokeLater(() -> new FacultyDetailsWindow());
    }

    private void openNoticePage() {
        SwingUtilities.invokeLater(() -> new NoticeWindow());
    }

    private void openCareerPage() {
        SwingUtilities.invokeLater(() -> new CareerWindow());
    }

    private void openQueryPage() {
        SwingUtilities.invokeLater(() -> new QueryWindow());
    }

    private void openCollegesPage() {
        SwingUtilities.invokeLater(() -> new CollegesWindow());
    }

    private void openSchoolsPage() {
        SwingUtilities.invokeLater(() -> new SchoolsWindow());
    }

    private void openUniversityPage() {
        SwingUtilities.invokeLater(() -> new UniversityWindow());
    }

    private void openAwardsPage() {
        SwingUtilities.invokeLater(() -> new AwardsWindow());
    }

    private void openReviewsPage() {
        SwingUtilities.invokeLater(() -> new ReviewRatingsWindow());
    }

    private void openCareerSupportPage() {
        SwingUtilities.invokeLater(() -> new CareerSupportWindow());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Parent());
    }
}

class AboutUsWindow extends JFrame {
    public AboutUsWindow() {
        setTitle("About Us");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 250, 240)); // Light blue background

        JTextArea aboutUsText = new JTextArea();
        aboutUsText.setEditable(false);
        aboutUsText.setLineWrap(true);
        aboutUsText.setWrapStyleWord(true);
        aboutUsText.setText("NUMETRIC TECHNOLOGIES PRIVATE LIMITED\n"
                + "Numetric Technologies Private Limited is a Non-govt company, incorporated on 23 Nov, 2013. It's a private unlisted company and is classified as 'company limited by shares'.\n"
                + "\n"
                + "Company's authorized capital stands at Rs 1.0 lakhs and has 100.0% paid-up capital which is Rs 1.0 lakhs. Numetric Technologies Private Limited last annual general meet (AGM) happened on 30 Sep, 2017. The company last updated its financials on 31 Mar, 2017 as per Ministry of Corporate Affairs (MCA).\n"
                + "\n"
                + "Numetric Technologies Private Limited is majorly in Business Services business from last 11 years and currently, company operations are active. Current board members & directors are SHASHANK JAIN and DIVYA JAIN .\n"
                + "\n"
                + "Company is registered in Delhi (Delhi) Registrar Office. Numetric Technologies Private Limited registered address is H.No.-301, T/F CGHS, P NO.-3B GURURAM DASS, SECTOR-22, DWARKA NEW DELHI West Delhi DL 110075 IN..");

        JScrollPane scrollPane = new JScrollPane(aboutUsText);
        add(scrollPane, BorderLayout.CENTER);

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

        JLabel contactLabel = new JLabel("<html><b>Contact Information:</b><br>"
                + "Email: mayu@example.com<br>"
                + "Phone: 7249004044<br>"
                + "Address: 123 Main St, Solapur, India</html>");
        contactLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(contactLabel, BorderLayout.CENTER);

        setVisible(true);
    }
}

class FacultyDetailsWindow extends JFrame {
    public FacultyDetailsWindow() {
        setTitle("Faculty Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        getContentPane().setBackground(new Color(245, 245, 245)); // Light grey background

        JTextArea facultyDetailsText = new JTextArea();
        facultyDetailsText.setEditable(false);
        facultyDetailsText.setLineWrap(true);
        facultyDetailsText.setWrapStyleWord(true);
        facultyDetailsText.setText("Faculty Details:\n"
                + "1. Dr. John Smith - Mathematics\n"
                + "2. Dr. Jane Doe - Physics\n"
                + "3. Dr. Emily Johnson - Chemistry\n"
                + "4. Dr. Michael Brown - Biology\n"
                + "5. Dr. Sarah Davis - Computer Science");

        JScrollPane scrollPane = new JScrollPane(facultyDetailsText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class NoticeWindow extends JFrame {
    public NoticeWindow() {
        setTitle("Notice");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 255, 224)); // Light yellow background

        JTextArea noticeText = new JTextArea();
        noticeText.setEditable(false);
        noticeText.setLineWrap(true);
        noticeText.setWrapStyleWord(true);
        noticeText.setText("Notices:\n"
                + "1. Function: Annual Day Celebration on 25th May\n"
                + "2. Function: Science Exhibition on 1st June\n"
                + "3. Fee Notice: Last date for fee submission is 30th June\n"
                + "4. Fee Notice: Late fee will be charged after 30th June");

        JScrollPane scrollPane = new JScrollPane(noticeText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class CareerWindow extends JFrame {
    public CareerWindow() {
        setTitle("Career");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(230, 230, 250)); // Lavender background

        JTextArea careerText = new JTextArea();
        careerText.setEditable(false);
        careerText.setLineWrap(true);
        careerText.setWrapStyleWord(true);
        careerText.setText("Career opportunities will be listed here...");

        JScrollPane scrollPane = new JScrollPane(careerText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class QueryWindow extends JFrame {
    public QueryWindow() {
        setTitle("Query");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 228, 225)); // Misty rose background

        JPanel queryPanel = new JPanel();
        queryPanel.setLayout(new GridLayout(4, 2, 10, 10));
        queryPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField();
        JLabel reasonLabel = new JLabel("Query:");
        JTextArea reasonArea = new JTextArea();
        reasonArea.setLineWrap(true);
        reasonArea.setWrapStyleWord(true);
        JScrollPane reasonScrollPane = new JScrollPane(reasonArea);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Query submitted successfully!"));

        queryPanel.add(dateLabel);
        queryPanel.add(dateField);
        queryPanel.add(reasonLabel);
        queryPanel.add(reasonScrollPane);
        queryPanel.add(new JLabel()); // Empty label for spacing
        queryPanel.add(submitButton);

        add(queryPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}

class CollegesWindow extends JFrame {
    public CollegesWindow() {
        setTitle("Colleges");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 240, 245)); // Light pink background

        JTextArea collegesText = new JTextArea();
        collegesText.setEditable(false);
        collegesText.setLineWrap(true);
        collegesText.setWrapStyleWord(true);
        collegesText.setText("Colleges:\n"
                + "1. Harvard University\n"
                + "2. Stanford University\n"
                + "3. Massachusetts Institute of Technology (MIT)\n"
                + "4. University of California, Berkeley\n"
                + "5. California Institute of Technology (Caltech)");

        JScrollPane scrollPane = new JScrollPane(collegesText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class SchoolsWindow extends JFrame {
    public SchoolsWindow() {
        setTitle("Schools");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 230, 140)); // Khaki background

        JTextArea schoolsText = new JTextArea();
        schoolsText.setEditable(false);
        schoolsText.setLineWrap(true);
        schoolsText.setWrapStyleWord(true);
        schoolsText.setText("Schools:\n"
                + "1. Phillips Exeter Academy\n"
                + "2. St. Paul's School\n"
                + "3. Lawrenceville School\n"
                + "4. Deerfield Academy\n"
                + "5. Groton School");

        JScrollPane scrollPane = new JScrollPane(schoolsText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class UniversityWindow extends JFrame {
    public UniversityWindow() {
        setTitle("University");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 228, 181)); // Moccasin background

        JTextArea universityText = new JTextArea();
        universityText.setEditable(false);
        universityText.setLineWrap(true);
        universityText.setWrapStyleWord(true);
        universityText.setText("University:\n"
                + "1. University of Oxford\n"
                + "2. University of Cambridge\n"
                + "3. University College London (UCL)\n"
                + "4. London School of Economics and Political Science (LSE)\n"
                + "5. Imperial College London");

        JScrollPane scrollPane = new JScrollPane(universityText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class AwardsWindow extends JFrame {
    public AwardsWindow() {
        setTitle("Awards & Certifications");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(238, 130, 238)); // Violet background

        JTextArea awardsText = new JTextArea();
        awardsText.setEditable(false);
        awardsText.setLineWrap(true);
        awardsText.setWrapStyleWord(true);
        awardsText.setText("Awards & Certifications:\n"
                + "1. Best Startup of the Year - 2023\n"
                + "2. Excellence in Technology - 2022\n"
                + "3. Innovation Award - 2021\n"
                + "4. Top 100 Companies to Work For - 2020\n"
                + "5. Best Customer Service - 2019");

        JScrollPane scrollPane = new JScrollPane(awardsText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class ReviewRatingsWindow extends JFrame {
    public ReviewRatingsWindow() {
        setTitle("Review & Ratings");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(250, 128, 114)); // Salmon background

        JTextArea reviewsText = new JTextArea();
        reviewsText.setEditable(false);
        reviewsText.setLineWrap(true);
        reviewsText.setWrapStyleWord(true);
        reviewsText.setText("Review & Ratings:\n"
                + "1. John - 4.5/5\n"
                + "2. Priya - 4.0/5\n"
                + "3. Smith - 4.8/5\n"
                + "4. Shreya - 3.9/5\n"
                + "5. Mayuri - 5.0/5");

        JScrollPane scrollPane = new JScrollPane(reviewsText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class CareerSupportWindow extends JFrame {
    public CareerSupportWindow() {
        setTitle("Career Support");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(123, 104, 238)); // Medium slate blue background

        JTextArea careerSupportText = new JTextArea();
        careerSupportText.setEditable(false);
        careerSupportText.setLineWrap(true);
        careerSupportText.setWrapStyleWord(true);
        careerSupportText.setText("Career Support:\n"
                + "1. Resume Building\n"
                + "2. Interview Preparation\n"
                + "3. Career Counseling\n"
                + "4. Skill Development Workshops\n"
                + "5. Job Placement Assistance");

        JScrollPane scrollPane = new JScrollPane(careerSupportText);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
