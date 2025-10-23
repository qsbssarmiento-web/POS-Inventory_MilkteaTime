package project.milktea_pos_inv;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginFrame.class.getName());

    private AccountManager accountManager = new AccountManager();

    public LoginFrame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        System.out.println(getClass().getResource("/Images/SystemLogo.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginToggleGroup = new javax.swing.ButtonGroup();
        rightDisplayPanel = new javax.swing.JPanel();
        exitbutton = new javax.swing.JButton();
        leftControlPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        invToggleButton = new javax.swing.JToggleButton();
        posToggleButton = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MilkteaPOSINV");
        setAlwaysOnTop(true);
        setName("loginFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(960, 540));

        rightDisplayPanel.setBackground(new java.awt.Color(204, 255, 204));
        rightDisplayPanel.setPreferredSize(new java.awt.Dimension(480, 540));

        exitbutton.setText("Exit");
        exitbutton.setToolTipText("Exit");
        exitbutton.setBorderPainted(false);
        exitbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitbutton.setFocusPainted(false);
        exitbutton.setFocusable(false);
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightDisplayPanelLayout = new javax.swing.GroupLayout(rightDisplayPanel);
        rightDisplayPanel.setLayout(rightDisplayPanelLayout);
        rightDisplayPanelLayout.setHorizontalGroup(
            rightDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightDisplayPanelLayout.createSequentialGroup()
                .addContainerGap(339, Short.MAX_VALUE)
                .addComponent(exitbutton)
                .addContainerGap())
        );
        rightDisplayPanelLayout.setVerticalGroup(
            rightDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightDisplayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitbutton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        leftControlPanel.setBackground(new java.awt.Color(204, 255, 255));
        leftControlPanel.setAlignmentX(0.0F);
        leftControlPanel.setAlignmentY(0.0F);
        leftControlPanel.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        leftControlPanel.setPreferredSize(new java.awt.Dimension(480, 540));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel1.setText("Username");

        usernameTextField.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        usernameTextField.setMinimumSize(new java.awt.Dimension(68, 40));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel2.setText("Password");

        passwordTextField.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        passwordTextField.setMinimumSize(new java.awt.Dimension(68, 40));

        loginButton.setBackground(new java.awt.Color(153, 255, 204));
        loginButton.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new java.awt.Dimension(76, 40));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        invToggleButton.setBackground(new java.awt.Color(204, 255, 204));
        loginToggleGroup.add(invToggleButton);
        invToggleButton.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        invToggleButton.setText("Inventory");
        invToggleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invToggleButton.setMinimumSize(new java.awt.Dimension(71, 30));
        jPanel1.add(invToggleButton);

        posToggleButton.setBackground(new java.awt.Color(204, 255, 204));
        loginToggleGroup.add(posToggleButton);
        posToggleButton.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        posToggleButton.setText("POS");
        posToggleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        posToggleButton.setMinimumSize(new java.awt.Dimension(35, 30));
        posToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posToggleButtonActionPerformed(evt);
            }
        });
        jPanel1.add(posToggleButton);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel3.setText("Systems");

        jPanel2.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        jLabel4.setText("Welcome!");
        jPanel2.add(jLabel4);

        jPanel3.setOpaque(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SystemLogo.png"))); // NOI18N
        jPanel3.add(jLabel5);

        javax.swing.GroupLayout leftControlPanelLayout = new javax.swing.GroupLayout(leftControlPanel);
        leftControlPanel.setLayout(leftControlPanelLayout);
        leftControlPanelLayout.setHorizontalGroup(
            leftControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftControlPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(leftControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftControlPanelLayout.createSequentialGroup()
                        .addGroup(leftControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leftControlPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(100, 100, 100))))
            .addGroup(leftControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftControlPanelLayout.setVerticalGroup(
            leftControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftControlPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rightDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
            .addComponent(rightDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("MilkteaTimeLogin");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        String username = usernameTextField.getText().trim();
        String password = new String(passwordTextField.getPassword());
        String userType;

        if (posToggleButton.isSelected()) {
            userType = "cashier";
        } else if (invToggleButton.isSelected()) {
            userType = "administrator";
        } else {
            JOptionPane.showMessageDialog(this, "Please select a target system!", "Unknown Target", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty!", "Missing Information", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty!", "Missing Information", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check if account exists
        if (accountManager.accountExists("administrator", username) || accountManager.accountExists("cashier", username)) {

            // Verify credentials
            if (accountManager.accountVerified(userType, username, password)
                    || accountManager.accountVerified("administrator", username, password)) {

                dispose();

                // POS can be used by both admin and cashier
                if (posToggleButton.isSelected()) {
                    java.awt.EventQueue.invokeLater(() -> new POSFrame().setVisible(true));
                } // Inventory only for admins
                else if (invToggleButton.isSelected()) {
                    boolean isAdmin = accountManager.accountVerified("administrator", username, password);
                    if (isAdmin) {
                        java.awt.EventQueue.invokeLater(() -> new InventoryFrame().setVisible(true));
                    } else {
                        JOptionPane.showMessageDialog(this, "Access Denied. Admininstrators Only.", "Unauthorized", JOptionPane.WARNING_MESSAGE);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Password!", "Login Error", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Account Not Found.", "Unknown Account", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void posToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posToggleButtonActionPerformed

    }//GEN-LAST:event_posToggleButtonActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0); // Exit the program
        }
    }//GEN-LAST:event_exitbuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbutton;
    private javax.swing.JToggleButton invToggleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel leftControlPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.ButtonGroup loginToggleGroup;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JToggleButton posToggleButton;
    private javax.swing.JPanel rightDisplayPanel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
