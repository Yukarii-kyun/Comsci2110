/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Rai
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class dashBoard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(dashBoard.class.getName());
    private CardLayout pageLayout;
    private JPanel pageHost;
    private JLabel pageTitle;

    /**
     * Creates new form dashBoard
     */
    public dashBoard() {
        initComponents();
        initCustomLayout();
    }
    private void initCustomLayout() {
        Color navy = new Color(24, 47, 78);
        Color ink = new Color(31, 49, 73);
        Color muted = new Color(112, 132, 153);
        Color page = new Color(244, 248, 253);
        Color line = new Color(222, 231, 241);

        setTitle("EduMonitor Pro - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1260, 720);
        setMinimumSize(new Dimension(1040, 650));
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JPanel pnlSidebar = new JPanel();
        pnlSidebar.setPreferredSize(new Dimension(194, 720));
        pnlSidebar.setBackground(navy);
        pnlSidebar.setLayout(new BoxLayout(pnlSidebar, BoxLayout.Y_AXIS));
        pnlSidebar.setBorder(new EmptyBorder(22, 18, 22, 18));

        JLabel lblLogo = new JLabel("EduMonitor Pro");
        lblLogo.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblNavDashboard = createNavItem("Dashboard", true);
        JLabel lblNavStudents = createNavItem("Students", false);
        JLabel lblNavAttendance = createNavItem("Attendance", false);
        JLabel lblNavPerformance = createNavItem("Performance", false);
        JLabel lblNavReports = createNavItem("Reports", false);
        JLabel lblNavSettings = createNavItem("Settings", false);
        JLabel lblNavLogOut = createNavItem("Log Out", false);

        lblNavDashboard.addMouseListener(navigateTo("Dashboard", "dashboard"));
        lblNavStudents.addMouseListener(navigateTo("Students", "students"));
        lblNavAttendance.addMouseListener(navigateTo("Attendance", "attendance"));
        lblNavPerformance.addMouseListener(navigateTo("Performance", "performance"));
        lblNavReports.addMouseListener(navigateTo("Reports", "reports"));
        lblNavSettings.addMouseListener(navigateTo("Settings", "settings"));

        lblNavLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInPage login = new logInPage();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                dispose();
            }
        });

        pnlSidebar.add(lblLogo);
        pnlSidebar.add(Box.createRigidArea(new Dimension(0, 34)));
        pnlSidebar.add(lblNavDashboard);
        pnlSidebar.add(Box.createRigidArea(new Dimension(0, 13)));
        pnlSidebar.add(lblNavStudents);
        pnlSidebar.add(Box.createRigidArea(new Dimension(0, 13)));
        pnlSidebar.add(lblNavAttendance);
        pnlSidebar.add(Box.createRigidArea(new Dimension(0, 13)));
        pnlSidebar.add(lblNavPerformance);
        pnlSidebar.add(Box.createRigidArea(new Dimension(0, 13)));
        pnlSidebar.add(lblNavReports);
        pnlSidebar.add(Box.createRigidArea(new Dimension(0, 13)));
        pnlSidebar.add(lblNavSettings);
        pnlSidebar.add(Box.createVerticalGlue());
        JLabel lblHelp = createNavItem("Help & Support", false);
        pnlSidebar.add(lblHelp);
        pnlSidebar.add(Box.createRigidArea(new Dimension(0, 18)));
        pnlSidebar.add(lblNavLogOut);

        JPanel pnlMainContent = new JPanel(new BorderLayout());
        pnlMainContent.setBackground(page);

        JPanel pnlHeader = new JPanel(new BorderLayout(16, 0));
        pnlHeader.setPreferredSize(new Dimension(1040, 62));
        pnlHeader.setBackground(Color.WHITE);
        pnlHeader.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, line),
            new EmptyBorder(11, 24, 11, 24)
        ));

        pageTitle = new JLabel("Dashboard");
        pageTitle.setFont(new Font("SansSerif", Font.BOLD, 17));
        pageTitle.setForeground(ink);

        JPanel pnlSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlSearch.setOpaque(false);
        JTextField txtSearch = new JTextField(20);
        txtSearch.setFont(new Font("SansSerif", Font.PLAIN, 12));
        txtSearch.setToolTipText("Search students, classes, or reports");
        txtSearch.setPreferredSize(new Dimension(242, 31));
        txtSearch.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(line), new EmptyBorder(0, 10, 0, 10)));
        pnlSearch.add(txtSearch);

        JPanel pnlProfile = new JPanel();
        pnlProfile.setLayout(new BoxLayout(pnlProfile, BoxLayout.Y_AXIS));
        pnlProfile.setOpaque(false);

        JLabel lblUserName = new JLabel("Professor Sarah");
        lblUserName.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblUserName.setForeground(ink);

        JLabel lblUserRole = new JLabel("Educator");
        lblUserRole.setFont(new Font("SansSerif", Font.PLAIN, 10));
        lblUserRole.setForeground(muted);

        pnlProfile.add(lblUserName);
        pnlProfile.add(lblUserRole);

        pnlHeader.add(pageTitle, BorderLayout.WEST);
        pnlHeader.add(pnlSearch, BorderLayout.CENTER);
        pnlHeader.add(pnlProfile, BorderLayout.EAST);

        pageLayout = new CardLayout();
        pageHost = new JPanel(pageLayout);
        pageHost.setBackground(page);
        pageHost.setBorder(new EmptyBorder(20, 24, 18, 24));

        JPanel content = new JPanel(new GridBagLayout());
        content.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 0, 14, 0);

        JPanel welcome = new JPanel(new BorderLayout(18, 0));
        welcome.setBackground(Color.WHITE);
        welcome.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(line), new EmptyBorder(17, 18, 17, 18)));
        JPanel welcomeText = new JPanel();
        welcomeText.setOpaque(false);
        welcomeText.setLayout(new BoxLayout(welcomeText, BoxLayout.Y_AXIS));
        JLabel welcomeTitle = new JLabel("Welcome back, Professor Sarah");
        welcomeTitle.setFont(new Font("SansSerif", Font.BOLD, 17));
        welcomeTitle.setForeground(ink);
        JLabel welcomeCopy = new JLabel("Monitor student activities, performance, and attendance in one view.");
        welcomeCopy.setFont(new Font("SansSerif", Font.PLAIN, 11));
        welcomeCopy.setForeground(muted);
        welcomeText.add(welcomeTitle);
        welcomeText.add(Box.createRigidArea(new Dimension(0, 7)));
        welcomeText.add(welcomeCopy);
        welcomeText.add(Box.createRigidArea(new Dimension(0, 17)));
        JPanel dateRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        dateRow.setOpaque(false);
        JLabel date = new JLabel("May 20, 2024     09:42 AM     2 Active Sections");
        date.setFont(new Font("SansSerif", Font.BOLD, 10));
        date.setForeground(new Color(67, 102, 143));
        dateRow.add(date);
        welcomeText.add(dateRow);
        welcome.add(welcomeText, BorderLayout.CENTER);
        welcome.add(new WelcomeIllustrationPanel(), BorderLayout.EAST);
        gbc.gridy = 0;
        content.add(welcome, gbc);

        JPanel stats = new JPanel(new GridLayout(1, 4, 12, 0));
        stats.setOpaque(false);
        stats.add(createStatCard("Total Students", "1248", "+8.4%", "this month", new Color(36, 106, 181)));
        stats.add(createStatCard("Present Today", "94.2%", "+2.1%", "vs last week", new Color(44, 154, 118)));
        stats.add(createStatCard("At Risk", "14", "-5.7%", "vs last month", new Color(224, 147, 58)));
        stats.add(createStatCard("Pending Reviews", "32", "6 new", "this week", new Color(117, 91, 181)));
        gbc.gridy = 1;
        content.add(stats, gbc);

        JPanel roster = new JPanel(new BorderLayout(0, 10));
        roster.setOpaque(false);
        JPanel rosterHeader = new JPanel(new BorderLayout());
        rosterHeader.setOpaque(false);
        JLabel rosterTitle = new JLabel("Student Roster");
        rosterTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        rosterTitle.setForeground(ink);
        JLabel rosterSub = new JLabel("Manage and track individual student metrics");
        rosterSub.setFont(new Font("SansSerif", Font.PLAIN, 10));
        rosterSub.setForeground(muted);
        JPanel titleBlock = new JPanel();
        titleBlock.setOpaque(false);
        titleBlock.setLayout(new BoxLayout(titleBlock, BoxLayout.Y_AXIS));
        titleBlock.add(rosterTitle);
        titleBlock.add(rosterSub);
        JButton export = new JButton("Export Data");
        JButton addStudent = new JButton("Add New Student");
        styleButton(export, false);
        styleButton(addStudent, true);
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        actions.setOpaque(false);
        actions.add(export);
        actions.add(addStudent);
        rosterHeader.add(titleBlock, BorderLayout.WEST);
        rosterHeader.add(actions, BorderLayout.EAST);
        roster.add(rosterHeader, BorderLayout.NORTH);

        String[] columns = {"STUDENT NAME", "STUDENT ID", "GRADE/YEAR", "SECTION", "TODAY'S STATUS", "PERFORMANCE", "LAST ACTIVITY"};
        Object[][] rows = {
            {"Alex Thompson", "STU-2024-01", "Grade 11", "A-Delta", "Present", "Excellent", "2024-05-20"},
            {"Sarah Jenkins", "STU-2024-02", "Grade 12", "A-Delta", "Late", "Average", "2024-05-20"},
            {"Marcus Chen", "STU-2024-03", "Grade 10", "C-Gamma", "Present", "Good", "2024-05-20"},
            {"Olivia Rodriguez", "STU-2024-04", "Grade 11", "B-Alpha", "Absent", "At Risk", "2024-05-18"},
            {"James Wilson", "STU-2024-05", "Grade 12", "A-Delta", "Present", "Good", "2024-05-20"}
        };
        JTable table = new JTable(new DefaultTableModel(rows, columns) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        });
        table.setFont(new Font("SansSerif", Font.PLAIN, 10));
        table.setForeground(ink);
        table.setRowHeight(31);
        table.setGridColor(new Color(232, 238, 245));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 9));
        table.getTableHeader().setForeground(muted);
        table.getTableHeader().setBackground(new Color(249, 251, 254));
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        int[] widths = {150, 105, 82, 80, 105, 88, 100};
        for (int i = 0; i < widths.length; i++) table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
        roster.add(new JScrollPane(table), BorderLayout.CENTER);
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        content.add(roster, gbc);

        JScrollPane bodyScroll = new JScrollPane(content);
        bodyScroll.setBorder(null);
        bodyScroll.getVerticalScrollBar().setUnitIncrement(14);
        bodyScroll.setOpaque(false);
        bodyScroll.getViewport().setOpaque(false);
        pageHost.add(bodyScroll, "dashboard");
        pageHost.add(createStudentsPage(ink, muted, line), "students");
        pageHost.add(createAttendancePage(ink, muted, line), "attendance");
        pageHost.add(createPerformancePage(ink, muted, line), "performance");
        pageHost.add(createReportsPage(ink, muted, line), "reports");
        pageHost.add(createSettingsPage(ink, muted, line), "settings");

        pnlMainContent.add(pnlHeader, BorderLayout.NORTH);
        pnlMainContent.add(pageHost, BorderLayout.CENTER);

        getContentPane().add(pnlSidebar, BorderLayout.WEST);
        getContentPane().add(pnlMainContent, BorderLayout.CENTER);
    }

    private javax.swing.JLabel createNavItem(String text, boolean isActive) {
        javax.swing.JLabel label = new javax.swing.JLabel(text);
        label.setFont(new Font("SansSerif", isActive ? Font.BOLD : Font.PLAIN, 12));
        label.setForeground(isActive ? Color.WHITE : new Color(168, 186, 207));
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(new EmptyBorder(7, 8, 7, 8));
        return label;
    }

    private java.awt.event.MouseAdapter navigateTo(String title, String page) {
        return new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(java.awt.event.MouseEvent event) {
                pageTitle.setText(title);
                pageLayout.show(pageHost, page);
            }
        };
    }

    private JPanel createStudentsPage(Color ink, Color muted, Color line) {
        JPanel page = createPageShell();
        page.add(createPageHeading("Students", "Manage your students and keep their profiles up to date.", "Add New Student", ink, muted), BorderLayout.NORTH);
        String[] columns = {"STUDENT NAME", "STUDENT ID", "GRADE", "SECTION", "EMAIL", "STATUS"};
        Object[][] rows = {
            {"Alex Thompson", "STU-2024-01", "Grade 11", "A-Delta", "alex.t@example.com", "Active"},
            {"Sarah Jenkins", "STU-2024-02", "Grade 12", "A-Delta", "sarah.j@example.com", "Active"},
            {"Marcus Chen", "STU-2024-03", "Grade 10", "C-Gamma", "marcus.c@example.com", "Active"},
            {"Olivia Rodriguez", "STU-2024-04", "Grade 11", "B-Alpha", "olivia.r@example.com", "Needs review"},
            {"James Wilson", "STU-2024-05", "Grade 12", "A-Delta", "james.w@example.com", "Active"}
        };
        page.add(createTablePanel(columns, rows, ink, muted, line), BorderLayout.CENTER);
        return page;
    }

    private JPanel createAttendancePage(Color ink, Color muted, Color line) {
        JPanel page = createPageShell();
        page.add(createPageHeading("Attendance", "Review daily attendance and follow up on absences.", "Mark Attendance", ink, muted), BorderLayout.NORTH);
        JPanel content = new JPanel(new BorderLayout(0, 14));
        content.setOpaque(false);
        JPanel cards = new JPanel(new GridLayout(1, 3, 12, 0));
        cards.setOpaque(false);
        cards.add(createStatCard("Present Today", "1,176", "+2.1%", "vs last week", new Color(44, 154, 118)));
        cards.add(createStatCard("Late Arrivals", "38", "3.0%", "of students", new Color(224, 147, 58)));
        cards.add(createStatCard("Absent", "34", "2.7%", "of students", new Color(198, 82, 85)));
        content.add(cards, BorderLayout.NORTH);
        content.add(createTablePanel(new String[]{"STUDENT NAME", "SECTION", "DATE", "ARRIVAL", "STATUS", "NOTES"}, new Object[][] {
            {"Sarah Jenkins", "A-Delta", "2024-05-20", "08:24 AM", "Late", "Traffic delay"},
            {"Olivia Rodriguez", "B-Alpha", "2024-05-20", "--", "Absent", "Parent notified"},
            {"Marcus Chen", "C-Gamma", "2024-05-20", "08:01 AM", "Present", "--"},
            {"James Wilson", "A-Delta", "2024-05-20", "07:58 AM", "Present", "--"}
        }, ink, muted, line), BorderLayout.CENTER);
        page.add(content, BorderLayout.CENTER);
        return page;
    }

    private JPanel createPerformancePage(Color ink, Color muted, Color line) {
        JPanel page = createPageShell();
        page.add(createPageHeading("Performance", "Track progress across assessments and identify students who need support.", "New Assessment", ink, muted), BorderLayout.NORTH);
        JPanel content = new JPanel(new BorderLayout(0, 14));
        content.setOpaque(false);
        JPanel cards = new JPanel(new GridLayout(1, 3, 12, 0));
        cards.setOpaque(false);
        cards.add(createStatCard("Class Average", "82.6%", "+4.2%", "this term", new Color(36, 106, 181)));
        cards.add(createStatCard("Top Performers", "186", "+12", "this month", new Color(44, 154, 118)));
        cards.add(createStatCard("Needs Support", "27", "-8.3%", "this term", new Color(224, 147, 58)));
        content.add(cards, BorderLayout.NORTH);
        content.add(createTablePanel(new String[]{"STUDENT NAME", "SECTION", "LAST ASSESSMENT", "SCORE", "TREND", "TEACHER NOTE"}, new Object[][] {
            {"Alex Thompson", "A-Delta", "Algebra II", "96%", "Up", "Ready for extension work"},
            {"Sarah Jenkins", "A-Delta", "Algebra II", "74%", "Stable", "Review quadratic equations"},
            {"Marcus Chen", "C-Gamma", "World History", "88%", "Up", "Strong written response"},
            {"Olivia Rodriguez", "B-Alpha", "Biology", "61%", "Down", "Schedule a support session"}
        }, ink, muted, line), BorderLayout.CENTER);
        page.add(content, BorderLayout.CENTER);
        return page;
    }

    private JPanel createReportsPage(Color ink, Color muted, Color line) {
        JPanel page = createPageShell();
        page.add(createPageHeading("Reports", "Create and download clear summaries for classes, attendance, and progress.", "Generate Report", ink, muted), BorderLayout.NORTH);
        JPanel reports = new JPanel(new GridLayout(2, 2, 12, 12));
        reports.setOpaque(false);
        reports.add(createReportCard("Attendance Summary", "Weekly attendance by section", "Updated today", ink, muted, line));
        reports.add(createReportCard("Performance Overview", "Assessment results and trends", "Updated yesterday", ink, muted, line));
        reports.add(createReportCard("At-Risk Students", "Students needing intervention", "Updated today", ink, muted, line));
        reports.add(createReportCard("Parent Update", "Shareable student progress summary", "Updated May 18", ink, muted, line));
        page.add(reports, BorderLayout.CENTER);
        return page;
    }

    private JPanel createSettingsPage(Color ink, Color muted, Color line) {
        JPanel page = createPageShell();
        page.add(createPageHeading("Settings", "Configure your profile, classroom preferences, and notifications.", "Save Changes", ink, muted), BorderLayout.NORTH);
        JPanel settings = new JPanel();
        settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
        settings.setBackground(Color.WHITE);
        settings.setBorder(new EmptyBorder(20, 22, 20, 22));
        settings.add(createSettingRow("Profile information", "Professor Sarah", "Update your name and contact details", ink, muted, line));
        settings.add(createSettingRow("Default academic year", "2024 - 2025", "Used when creating new classes and reports", ink, muted, line));
        settings.add(createSettingRow("Email notifications", "Enabled", "Receive updates about attendance and reviews", ink, muted, line));
        settings.add(createSettingRow("Weekly summary", "Every Monday", "Choose when your weekly digest arrives", ink, muted, line));
        page.add(settings, BorderLayout.CENTER);
        return page;
    }

    private JPanel createPageShell() {
        JPanel page = new JPanel(new BorderLayout(0, 14));
        page.setOpaque(false);
        return page;
    }

    private JPanel createPageHeading(String title, String subtitle, String actionText, Color ink, Color muted) {
        JPanel heading = new JPanel(new BorderLayout());
        heading.setOpaque(false);
        JPanel copy = new JPanel();
        copy.setOpaque(false);
        copy.setLayout(new BoxLayout(copy, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
        titleLabel.setForeground(ink);
        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        subtitleLabel.setForeground(muted);
        copy.add(titleLabel);
        copy.add(Box.createRigidArea(new Dimension(0, 5)));
        copy.add(subtitleLabel);
        JButton action = new JButton(actionText);
        styleButton(action, true);
        heading.add(copy, BorderLayout.WEST);
        heading.add(action, BorderLayout.EAST);
        return heading;
    }

    private JScrollPane createTablePanel(String[] columns, Object[][] rows, Color ink, Color muted, Color line) {
        JTable table = new JTable(new DefaultTableModel(rows, columns) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        });
        table.setFont(new Font("SansSerif", Font.PLAIN, 10));
        table.setForeground(ink);
        table.setRowHeight(34);
        table.setGridColor(new Color(232, 238, 245));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 9));
        table.getTableHeader().setForeground(muted);
        table.getTableHeader().setBackground(new Color(249, 251, 254));
        table.getTableHeader().setPreferredSize(new Dimension(0, 32));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createLineBorder(line));
        scroll.getViewport().setBackground(Color.WHITE);
        return scroll;
    }

    private JPanel createReportCard(String title, String description, String updated, Color ink, Color muted, Color line) {
        JPanel card = new JPanel(new BorderLayout(0, 8));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(line), new EmptyBorder(17, 18, 17, 18)));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        titleLabel.setForeground(ink);
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        descriptionLabel.setForeground(muted);
        JLabel updatedLabel = new JLabel(updated);
        updatedLabel.setFont(new Font("SansSerif", Font.PLAIN, 9));
        updatedLabel.setForeground(new Color(67, 102, 143));
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(descriptionLabel, BorderLayout.CENTER);
        card.add(updatedLabel, BorderLayout.SOUTH);
        return card;
    }

    private JPanel createSettingRow(String title, String value, String description, Color ink, Color muted, Color line) {
        JPanel row = new JPanel(new BorderLayout(14, 0));
        row.setBackground(Color.WHITE);
        row.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, line), new EmptyBorder(14, 0, 14, 0)));
        JPanel copy = new JPanel();
        copy.setOpaque(false);
        copy.setLayout(new BoxLayout(copy, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        titleLabel.setForeground(ink);
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        descriptionLabel.setForeground(muted);
        copy.add(titleLabel);
        copy.add(Box.createRigidArea(new Dimension(0, 4)));
        copy.add(descriptionLabel);
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        valueLabel.setForeground(new Color(36, 106, 181));
        row.add(copy, BorderLayout.CENTER);
        row.add(valueLabel, BorderLayout.EAST);
        return row;
    }

    private JPanel createStatCard(String title, String value, String change, String period, Color accent) {
        JPanel card = new JPanel(new BorderLayout(8, 0));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(222, 231, 241)), new EmptyBorder(13, 14, 13, 14)));
        JPanel copy = new JPanel();
        copy.setOpaque(false);
        copy.setLayout(new BoxLayout(copy, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        titleLabel.setForeground(new Color(117, 137, 158));
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        valueLabel.setForeground(new Color(36, 54, 78));
        JLabel changeLabel = new JLabel(change + "  " + period);
        changeLabel.setFont(new Font("SansSerif", Font.PLAIN, 9));
        changeLabel.setForeground(accent);
        copy.add(titleLabel);
        copy.add(Box.createRigidArea(new Dimension(0, 5)));
        copy.add(valueLabel);
        copy.add(Box.createRigidArea(new Dimension(0, 4)));
        copy.add(changeLabel);
        JLabel icon = new JLabel("o");
        icon.setFont(new Font("SansSerif", Font.BOLD, 18));
        icon.setForeground(accent);
        card.add(copy, BorderLayout.CENTER);
        card.add(icon, BorderLayout.EAST);
        return card;
    }

    private void styleButton(JButton button, boolean primary) {
        button.setFont(new Font("SansSerif", Font.BOLD, 10));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new EmptyBorder(7, 10, 7, 10));
        button.setBackground(primary ? new Color(36, 106, 181) : Color.WHITE);
        button.setForeground(primary ? Color.WHITE : new Color(67, 88, 113));
    }

    private static class WelcomeIllustrationPanel extends JPanel {
        WelcomeIllustrationPanel() { setPreferredSize(new Dimension(190, 104)); setBackground(new Color(229, 239, 248)); }

        @Override protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g = (Graphics2D) graphics.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(new Color(198, 218, 232));
            g.fillOval(76, 12, 78, 78);
            g.setColor(new Color(255, 255, 255, 210));
            g.fillRect(18, 28, 105, 58);
            g.setColor(new Color(36, 106, 181));
            g.fillRect(27, 39, 48, 5);
            g.setColor(new Color(75, 160, 154));
            g.fillRect(27, 51, 73, 5);
            g.setColor(new Color(237, 165, 73));
            g.fillRect(27, 63, 57, 5);
            g.setColor(new Color(31, 49, 73));
            g.drawLine(133, 24, 169, 88);
            g.drawLine(133, 24, 102, 90);
            g.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new dashBoard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
