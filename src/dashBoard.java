/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Rai
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class dashBoard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(dashBoard.class.getName());

    /**
     * Creates new form dashBoard
     */
    public dashBoard() {
        initComponents();
        initCustomLayout(); 
    }
    private void initCustomLayout() {
        // 1. Frame Settings
        setTitle("EduMonitor Pro - Dashboard");
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(1260, 720);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
        getContentPane().setLayout(new java.awt.BorderLayout());

        // 2. Sidebar Panel
        javax.swing.JPanel pnlSidebar = new javax.swing.JPanel();
        pnlSidebar.setPreferredSize(new java.awt.Dimension(220, 720));
        pnlSidebar.setBackground(new java.awt.Color(30, 41, 59)); // Dark Navy
        pnlSidebar.setLayout(new javax.swing.BoxLayout(pnlSidebar, javax.swing.BoxLayout.Y_AXIS));
        pnlSidebar.setBorder(new javax.swing.border.EmptyBorder(25, 20, 25, 20));

        // Logo Header
        javax.swing.JLabel lblLogo = new javax.swing.JLabel("EduMonitor Pro");
        lblLogo.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));
        lblLogo.setForeground(java.awt.Color.WHITE);
        lblLogo.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        // Navigation Links
        javax.swing.JLabel lblNavDashboard  = createNavItem("Dashboard", true);
        javax.swing.JLabel lblNavStudents   = createNavItem("Students", false);
        javax.swing.JLabel lblNavAttendance = createNavItem("Attendance", false);
        javax.swing.JLabel lblNavPerformance= createNavItem("Performance", false);
        javax.swing.JLabel lblNavReports    = createNavItem("Reports", false);
        javax.swing.JLabel lblNavSettings   = createNavItem("Settings", false);
        javax.swing.JLabel lblNavLogOut     = createNavItem("Log Out", false);

        // Logout Action
        lblNavLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInPage login = new logInPage();
                login.pack();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                dispose();
            }
        });

        // Assemble Sidebar
        pnlSidebar.add(lblLogo);
        pnlSidebar.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 35)));
        pnlSidebar.add(lblNavDashboard);
        pnlSidebar.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 15)));
        pnlSidebar.add(lblNavStudents);
        pnlSidebar.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 15)));
        pnlSidebar.add(lblNavAttendance);
        pnlSidebar.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 15)));
        pnlSidebar.add(lblNavPerformance);
        pnlSidebar.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 15)));
        pnlSidebar.add(lblNavReports);
        pnlSidebar.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 15)));
        pnlSidebar.add(lblNavSettings);
        pnlSidebar.add(javax.swing.Box.createGlue()); // Pushes Logout to bottom
        pnlSidebar.add(lblNavLogOut);

        // 3. Main Content Container
        javax.swing.JPanel pnlMainContent = new javax.swing.JPanel(new java.awt.BorderLayout());
        pnlMainContent.setBackground(new java.awt.Color(248, 250, 252));

        // Top Header Bar
        javax.swing.JPanel pnlHeader = new javax.swing.JPanel(new java.awt.BorderLayout());
        pnlHeader.setPreferredSize(new java.awt.Dimension(1040, 65));
        pnlHeader.setBackground(java.awt.Color.WHITE);
        pnlHeader.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(226, 232, 240)),
            new javax.swing.border.EmptyBorder(12, 25, 12, 25)
        ));

        // Page Title
        javax.swing.JLabel lblPageTitle = new javax.swing.JLabel("Dashboard");
        lblPageTitle.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));
        lblPageTitle.setForeground(new java.awt.Color(15, 23, 42));

        // Search Bar
        javax.swing.JPanel pnlSearch = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        pnlSearch.setOpaque(false);
        javax.swing.JTextField txtSearch = new javax.swing.JTextField(20);
        txtSearch.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        txtSearch.setToolTipText("Search students, classes, or reports...");
        txtSearch.setPreferredSize(new java.awt.Dimension(240, 32));
        pnlSearch.add(txtSearch);

        // Profile Section
        javax.swing.JPanel pnlProfile = new javax.swing.JPanel();
        pnlProfile.setLayout(new javax.swing.BoxLayout(pnlProfile, javax.swing.BoxLayout.Y_AXIS));
        pnlProfile.setOpaque(false);

        javax.swing.JLabel lblUserName = new javax.swing.JLabel("Admin");
        lblUserName.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        lblUserName.setForeground(new java.awt.Color(15, 23, 42));

        javax.swing.JLabel lblUserRole = new javax.swing.JLabel("System Administrator");
        lblUserRole.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 10));
        lblUserRole.setForeground(new java.awt.Color(100, 116, 139));

        pnlProfile.add(lblUserName);
        pnlProfile.add(lblUserRole);

        // Assemble Header Bar
        pnlHeader.add(lblPageTitle, java.awt.BorderLayout.WEST);
        pnlHeader.add(pnlSearch, java.awt.BorderLayout.CENTER);
        pnlHeader.add(pnlProfile, java.awt.BorderLayout.EAST);

        // 4. Body Area
        javax.swing.JPanel pnlBody = new javax.swing.JPanel();
        pnlBody.setBackground(new java.awt.Color(248, 250, 252));

        // Attach to Frame
        pnlMainContent.add(pnlHeader, java.awt.BorderLayout.NORTH);
        pnlMainContent.add(pnlBody, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlSidebar, java.awt.BorderLayout.WEST);
        getContentPane().add(pnlMainContent, java.awt.BorderLayout.CENTER);
    }

    private javax.swing.JLabel createNavItem(String text, boolean isActive) {
        javax.swing.JLabel label = new javax.swing.JLabel(text);
        label.setFont(new java.awt.Font("SansSerif", isActive ? java.awt.Font.BOLD : java.awt.Font.PLAIN, 13));
        label.setForeground(isActive ? java.awt.Color.WHITE : new java.awt.Color(148, 163, 184));
        label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        return label;
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
