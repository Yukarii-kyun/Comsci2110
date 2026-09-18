/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Rai
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class logInPage extends javax.swing.JFrame {
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JCheckBox cbRemember;
    private JButton btnSignIn;
    private JButton btnGoogle;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(logInPage.class.getName());

    /**
     * Creates new form logInPage
     */
  public logInPage() {
        initCustomLoginLayout();
    }

    private void initCustomLoginLayout() {
        // Clear all default/generated components from content pane
        getContentPane().removeAll();

        // Frame Setup
        setTitle("Group6767 System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Main Outer Panel
        JPanel pnlBackground = new JPanel(new GridBagLayout());
        pnlBackground.setBackground(new Color(241, 245, 249)); // Slate #F1F5F9
        pnlBackground.setBorder(new EmptyBorder(30, 30, 30, 30));

        // Main Login Card Panel
        JPanel pnlCard = new JPanel();
        pnlCard.setBackground(Color.WHITE);
        pnlCard.setLayout(new BoxLayout(pnlCard, BoxLayout.Y_AXIS));
        pnlCard.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            new EmptyBorder(32, 36, 32, 36)
        ));

        // Header Section
        JLabel lblBrand = new JLabel("Group6767 System");
        lblBrand.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblBrand.setForeground(new Color(15, 23, 42));
        lblBrand.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblTitle = new JLabel("Welcome back");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitle.setForeground(new Color(15, 23, 42));
        lblTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblSub = new JLabel("<html><body style='width: 280px;'>Please enter your credentials to access the educator dashboard.</body></html>");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblSub.setForeground(new Color(100, 116, 139));
        lblSub.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Input Fields Section
        JLabel lblEmail = new JLabel("Email or Username");
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblEmail.setForeground(new Color(51, 65, 85));
        lblEmail.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtEmail = new JTextField(22);
        txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtEmail.setPreferredSize(new Dimension(320, 36));
        txtEmail.setMaximumSize(new Dimension(320, 36));
        txtEmail.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Password & Forgot Password Header Row
        JPanel pnlPassHeader = new JPanel(new BorderLayout());
        pnlPassHeader.setOpaque(false);
        pnlPassHeader.setMaximumSize(new Dimension(320, 20));
        pnlPassHeader.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblPassword.setForeground(new Color(51, 65, 85));

        JLabel lblForgot = new JLabel("Forgot password?");
        lblForgot.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblForgot.setForeground(new Color(37, 99, 235));
        lblForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pnlPassHeader.add(lblPassword, BorderLayout.WEST);
        pnlPassHeader.add(lblForgot, BorderLayout.EAST);

        txtPassword = new JPasswordField(22);
        txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtPassword.setPreferredSize(new Dimension(320, 36));
        txtPassword.setMaximumSize(new Dimension(320, 36));
        txtPassword.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Checkbox Section
        cbRemember = new JCheckBox("Remember this device for 30 days");
        cbRemember.setFont(new Font("SansSerif", Font.PLAIN, 11));
        cbRemember.setForeground(new Color(100, 116, 139));
        cbRemember.setOpaque(false);
        cbRemember.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Action Buttons
        btnSignIn = new JButton("Sign in to Dashboard →");
        btnSignIn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnSignIn.setBackground(new Color(15, 23, 42));
        btnSignIn.setForeground(Color.WHITE);
        btnSignIn.setFocusPainted(false);
        btnSignIn.setPreferredSize(new Dimension(320, 40));
        btnSignIn.setMaximumSize(new Dimension(320, 40));
        btnSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSignIn.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblDivider = new JLabel("───────  OR CONTINUE WITH  ───────");
        lblDivider.setFont(new Font("SansSerif", Font.PLAIN, 10));
        lblDivider.setForeground(new Color(148, 163, 184));
        lblDivider.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnGoogle = new JButton("Institutional Google Account");
        btnGoogle.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnGoogle.setBackground(Color.WHITE);
        btnGoogle.setForeground(new Color(51, 65, 85));
        btnGoogle.setFocusPainted(false);
        btnGoogle.setPreferredSize(new Dimension(320, 38));
        btnGoogle.setMaximumSize(new Dimension(320, 38));
        btnGoogle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnGoogle.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Footer Section
        JLabel lblFooter = new JLabel("Privacy Policy  •  Terms of Service  •  Help Center");
        lblFooter.setFont(new Font("SansSerif", Font.PLAIN, 10));
        lblFooter.setForeground(new Color(148, 163, 184));
        lblFooter.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Event Listeners
        btnSignIn.addActionListener(e -> performLogin());
        txtPassword.addActionListener(e -> performLogin());

        // Component Assembly
        pnlCard.add(lblBrand);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 16)));
        pnlCard.add(lblTitle);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 6)));
        pnlCard.add(lblSub);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 20)));
        pnlCard.add(lblEmail);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 6)));
        pnlCard.add(txtEmail);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 12)));
        pnlCard.add(pnlPassHeader);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 6)));
        pnlCard.add(txtPassword);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 10)));
        pnlCard.add(cbRemember);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 20)));
        pnlCard.add(btnSignIn);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 16)));
        pnlCard.add(lblDivider);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 16)));
        pnlCard.add(btnGoogle);
        pnlCard.add(Box.createRigidArea(new Dimension(0, 24)));
        pnlCard.add(lblFooter);

        pnlBackground.add(pnlCard);
        setContentPane(pnlBackground);
        pack(); // Automatically sizes window to fit components cleanly
        setLocationRelativeTo(null);
    }

    private void performLogin() {
        String username = txtEmail.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please enter both email and password.",
                "Login Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        dashBoard dashboard = new dashBoard();
        dashboard.setVisible(true);
        this.dispose();
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
        SwingUtilities.invokeLater(() -> new logInPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
