package project.milktea_pos_inv;

import java.awt.Dialog;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JDialog;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class POSFrame extends javax.swing.JFrame {

    DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy  hh:mm:ss a");
    LocalDateTime timeNow;

    POSManager manager;
    private int selectedRow = -1;

    public POSFrame() {
        manager = new POSManager();

        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setupDateAndTime();
        setupOrdersTable();

        ordersTable.getModel().addTableModelListener(e -> {
            TotalLabel.setText("Php ");
        });
    }

    /**
     * Clock updater
     */
    private void setupDateAndTime() {
        updateClock();
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();
    }

    private void updateClock() {
        timeNow = LocalDateTime.now();
        TimeLabel.setText(timeNow.format(datetimeFormat));
    }

    private void setupOrdersTable() {
        DefaultTableModel model = manager.getTableModel();
        ordersTable.setModel(model);

        // Update total whenever orders change
        model.addTableModelListener((TableModelEvent e) -> {
            TotalLabel.setText(String.format("Php %.2f", manager.getSubtotal()));
        });

        ordersTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                selectedRow = ordersTable.getSelectedRow();
            }
        });
    }

    private void loadMilkteaProducts() {
        milkteaPanel.removeAll();

        milkteaPanel.add(new ProductView(manager, new Products("MT01", "Pearl Milk Tea", 89.0, "Milktea", 20)));
        milkteaPanel.add(new ProductView(manager, new Products("MT02", "Matcha Latte", 95.0, "Milktea", 15)));
        milkteaPanel.add(new ProductView(manager, new Products("MT03", "Wintermelon Milk Tea", 85.0, "Milktea", 10)));

        milkteaPanel.revalidate();
        milkteaPanel.repaint();
    }

    private void loadFrappeProducts() {
        milkteaPanel.removeAll();

        milkteaPanel.add(new ProductView(manager, new Products("FR01", "Java Chip Frappe", 120.0, "Frappe", 8)));
        milkteaPanel.add(new ProductView(manager, new Products("FR02", "Mocha Frappe", 115.0, "Frappe", 10)));

        milkteaPanel.revalidate();
        milkteaPanel.repaint();
    }

    private void loadPastryProducts() {
        milkteaPanel.removeAll();

        milkteaPanel.add(new ProductView(manager, new Products("PS01", "Blueberry Cheesecake", 140.0, "Pastry", 5)));
        milkteaPanel.add(new ProductView(manager, new Products("PS02", "Chocolate Muffin", 75.0, "Pastry", 12)));

        milkteaPanel.revalidate();
        milkteaPanel.repaint();
    }

    private void loadMiscProducts() {
        milkteaPanel.removeAll();

        milkteaPanel.add(new ProductView(manager, new Products("MS01", "Bottled Water", 25.0, "Misc", 30)));
        milkteaPanel.add(new ProductView(manager, new Products("MS02", "Reusable Straw", 30.0, "Misc", 20)));

        milkteaPanel.revalidate();
        milkteaPanel.repaint();
    }

    private void logout() {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topNavigation = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        bottomNavigation = new javax.swing.JPanel();
        datePanel = new javax.swing.JPanel();
        TimeLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        orderReorder = new javax.swing.JButton();
        orderVoidAll = new javax.swing.JButton();
        orderSettings = new javax.swing.JButton();
        orderPayment = new javax.swing.JButton();
        menuPanel = new javax.swing.JPanel();
        productCategoriesPanel = new javax.swing.JPanel();
        milkteaCategory = new javax.swing.JButton();
        frappeCategory = new javax.swing.JButton();
        PastryCategory = new javax.swing.JButton();
        miscCategory = new javax.swing.JButton();
        ordersDescriptionPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tableNavigationPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        totalPaymentsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsPanel = new javax.swing.JPanel();
        milkteaPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MilkteaTimePOS");
        setUndecorated(true);

        topNavigation.setBackground(new java.awt.Color(204, 255, 255));
        topNavigation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        topNavigation.setFocusTraversalPolicyProvider(true);
        topNavigation.setPreferredSize(new java.awt.Dimension(960, 75));

        logoutButton.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setBorderPainted(false);
        logoutButton.setFocusPainted(false);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout topNavigationLayout = new javax.swing.GroupLayout(topNavigation);
        topNavigation.setLayout(topNavigationLayout);
        topNavigationLayout.setHorizontalGroup(
            topNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topNavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(16, 16, 16))
        );
        topNavigationLayout.setVerticalGroup(
            topNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topNavigationLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(topNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton))
                .addGap(17, 17, 17))
        );

        bottomNavigation.setBackground(new java.awt.Color(255, 255, 204));
        bottomNavigation.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bottomNavigation.setPreferredSize(new java.awt.Dimension(960, 100));
        bottomNavigation.setLayout(new java.awt.BorderLayout());

        datePanel.setBackground(new java.awt.Color(204, 255, 204));
        datePanel.setMinimumSize(new java.awt.Dimension(300, 100));
        datePanel.setPreferredSize(new java.awt.Dimension(300, 0));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 38);
        flowLayout1.setAlignOnBaseline(true);
        datePanel.setLayout(flowLayout1);

        TimeLabel.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        TimeLabel.setText("\"\"");
        datePanel.add(TimeLabel);

        bottomNavigation.add(datePanel, java.awt.BorderLayout.EAST);

        buttonPanel.setBackground(new java.awt.Color(255, 255, 204));
        buttonPanel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        orderReorder.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        orderReorder.setText("Reorder");
        orderReorder.setBorderPainted(false);
        orderReorder.setFocusPainted(false);
        orderReorder.setFocusable(false);
        orderReorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderReorderActionPerformed(evt);
            }
        });
        buttonPanel.add(orderReorder);

        orderVoidAll.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        orderVoidAll.setText("Void All");
        orderVoidAll.setBorderPainted(false);
        orderVoidAll.setFocusPainted(false);
        orderVoidAll.setFocusable(false);
        orderVoidAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderVoidAllActionPerformed(evt);
            }
        });
        buttonPanel.add(orderVoidAll);

        orderSettings.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        orderSettings.setText("Settings");
        orderSettings.setBorderPainted(false);
        orderSettings.setFocusPainted(false);
        orderSettings.setFocusable(false);
        orderSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderSettingsActionPerformed(evt);
            }
        });
        buttonPanel.add(orderSettings);

        orderPayment.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        orderPayment.setText("Payment");
        orderPayment.setBorderPainted(false);
        orderPayment.setFocusPainted(false);
        orderPayment.setFocusable(false);
        orderPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderPaymentActionPerformed(evt);
            }
        });
        buttonPanel.add(orderPayment);

        bottomNavigation.add(buttonPanel, java.awt.BorderLayout.CENTER);

        menuPanel.setBackground(new java.awt.Color(204, 255, 204));
        menuPanel.setLayout(new java.awt.BorderLayout());

        productCategoriesPanel.setBackground(new java.awt.Color(204, 204, 255));
        productCategoriesPanel.setPreferredSize(new java.awt.Dimension(100, 390));
        productCategoriesPanel.setLayout(new java.awt.GridLayout(4, 0, 10, 10));

        milkteaCategory.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        milkteaCategory.setText("Milktea");
        milkteaCategory.setBorderPainted(false);
        milkteaCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        milkteaCategory.setFocusPainted(false);
        milkteaCategory.setFocusable(false);
        milkteaCategory.setMargin(new java.awt.Insets(10, 10, 10, 10));
        milkteaCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milkteaCategoryActionPerformed(evt);
            }
        });
        productCategoriesPanel.add(milkteaCategory);

        frappeCategory.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        frappeCategory.setText("Frappe");
        frappeCategory.setBorderPainted(false);
        frappeCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        frappeCategory.setFocusPainted(false);
        frappeCategory.setFocusable(false);
        frappeCategory.setMargin(new java.awt.Insets(10, 10, 10, 10));
        frappeCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frappeCategoryActionPerformed(evt);
            }
        });
        productCategoriesPanel.add(frappeCategory);

        PastryCategory.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        PastryCategory.setText("Pastry");
        PastryCategory.setBorderPainted(false);
        PastryCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PastryCategory.setFocusPainted(false);
        PastryCategory.setFocusable(false);
        PastryCategory.setMargin(new java.awt.Insets(10, 10, 10, 10));
        PastryCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PastryCategoryActionPerformed(evt);
            }
        });
        productCategoriesPanel.add(PastryCategory);

        miscCategory.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        miscCategory.setText("Misc.");
        miscCategory.setBorderPainted(false);
        miscCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miscCategory.setFocusPainted(false);
        miscCategory.setFocusable(false);
        miscCategory.setMargin(new java.awt.Insets(10, 10, 10, 10));
        miscCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miscCategoryActionPerformed(evt);
            }
        });
        productCategoriesPanel.add(miscCategory);

        menuPanel.add(productCategoriesPanel, java.awt.BorderLayout.WEST);

        ordersDescriptionPanel.setMaximumSize(new java.awt.Dimension(500, 32767));
        ordersDescriptionPanel.setPreferredSize(new java.awt.Dimension(500, 390));
        ordersDescriptionPanel.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel2.setText("ORDERS");
        jPanel1.add(jLabel2);

        ordersDescriptionPanel.add(jPanel1, java.awt.BorderLayout.NORTH);

        tableNavigationPanel.setMinimumSize(new java.awt.Dimension(0, 50));
        tableNavigationPanel.setPreferredSize(new java.awt.Dimension(75, 50));
        tableNavigationPanel.setLayout(new java.awt.GridLayout(5, 1));

        jButton1.setText("UP");
        tableNavigationPanel.add(jButton1);

        jButton2.setText("SEL");
        tableNavigationPanel.add(jButton2);

        jButton3.setText("DOWN");
        tableNavigationPanel.add(jButton3);

        jButton4.setText("VOID");
        tableNavigationPanel.add(jButton4);

        jButton5.setText("EDIT");
        tableNavigationPanel.add(jButton5);

        ordersDescriptionPanel.add(tableNavigationPanel, java.awt.BorderLayout.WEST);

        ordersTable.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        ordersTable.setCellSelectionEnabled(true);
        ordersTable.setDragEnabled(true);
        ordersTable.setEnabled(false);
        ordersTable.setShowHorizontalLines(true);
        ordersTable.setShowVerticalLines(true);
        ordersTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ordersTablePropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(ordersTable);

        ordersDescriptionPanel.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        totalPaymentsPanel.setBackground(new java.awt.Color(255, 255, 255));
        totalPaymentsPanel.setLayout(new java.awt.GridLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel1.setText("Total: ");
        totalPaymentsPanel.add(jLabel1);

        TotalLabel.setFont(new java.awt.Font("Microsoft YaHei", 0, 24)); // NOI18N
        TotalLabel.setText("Php");
        totalPaymentsPanel.add(TotalLabel);

        ordersDescriptionPanel.add(totalPaymentsPanel, java.awt.BorderLayout.SOUTH);

        menuPanel.add(ordersDescriptionPanel, java.awt.BorderLayout.EAST);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        itemsPanel.setLayout(new java.awt.GridLayout(1, 0));

        milkteaPanel.setLayout(new java.awt.GridLayout(10, 10, 10, 10));
        itemsPanel.add(milkteaPanel);

        jScrollPane1.setViewportView(itemsPanel);

        menuPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topNavigation, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(bottomNavigation, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(bottomNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        logout();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void orderReorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderReorderActionPerformed
        JOptionPane.showMessageDialog(this, "Reorder feature coming soon!");
    }//GEN-LAST:event_orderReorderActionPerformed

    private void orderSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderSettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderSettingsActionPerformed

    private void ordersTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ordersTablePropertyChange

    }//GEN-LAST:event_ordersTablePropertyChange

    private void orderVoidAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderVoidAllActionPerformed
        manager.clearOrders();        // TODO add your handling code here:
    }//GEN-LAST:event_orderVoidAllActionPerformed

    private void milkteaCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milkteaCategoryActionPerformed
        loadMilkteaProducts();
    }//GEN-LAST:event_milkteaCategoryActionPerformed

    private void frappeCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frappeCategoryActionPerformed
        loadFrappeProducts();
    }//GEN-LAST:event_frappeCategoryActionPerformed

    private void PastryCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PastryCategoryActionPerformed
        loadPastryProducts();
    }//GEN-LAST:event_PastryCategoryActionPerformed

    private void miscCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miscCategoryActionPerformed
        loadMiscProducts();
    }//GEN-LAST:event_miscCategoryActionPerformed

    private void orderPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderPaymentActionPerformed
        if (manager.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No orders to pay for!");
            return;
        }

        PaymentPanel paymentPanel = new PaymentPanel(manager);

        JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(this), "Process Payment", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(paymentPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        // After dialog closes, update total display
        TotalLabel.setText("Php " + manager.getSubtotal());
        ordersTable.revalidate();
        ordersTable.repaint();
    }//GEN-LAST:event_orderPaymentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PastryCategory;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JPanel bottomNavigation;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel datePanel;
    private javax.swing.JButton frappeCategory;
    private javax.swing.JPanel itemsPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton milkteaCategory;
    private javax.swing.JPanel milkteaPanel;
    private javax.swing.JButton miscCategory;
    private javax.swing.JButton orderPayment;
    private javax.swing.JButton orderReorder;
    private javax.swing.JButton orderSettings;
    private javax.swing.JButton orderVoidAll;
    private javax.swing.JPanel ordersDescriptionPanel;
    private javax.swing.JTable ordersTable;
    private javax.swing.JPanel productCategoriesPanel;
    private javax.swing.JPanel tableNavigationPanel;
    private javax.swing.JPanel topNavigation;
    private javax.swing.JPanel totalPaymentsPanel;
    // End of variables declaration//GEN-END:variables
}
