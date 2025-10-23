package project.milktea_pos_inv;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PaymentPanel extends JPanel {

    private final POSManager manager;
    private final JLabel totalLabel;
    private final JTextField cashField;
    private final JLabel changeLabel;

    private final DecimalFormat df = new DecimalFormat("#,##0.00");

    public PaymentPanel(POSManager manager) {
        this.manager = manager;

        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250));
        setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        double total = manager.getSubtotal();

        // 🧭 Header
        JLabel header = new JLabel("💵 Payment Summary", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        header.setForeground(new Color(40, 40, 40));
        header.setBorder(new EmptyBorder(0, 0, 10, 0));

        // 🧾 Main Card Container
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // 🔹 Total Amount
        JLabel totalText = new JLabel("Total Amount:");
        totalText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        totalLabel = new JLabel("₱ " + df.format(total));
        totalLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        totalLabel.setForeground(new Color(0, 120, 60));

        card.add(totalText, gbc);
        gbc.gridx = 1;
        card.add(totalLabel, gbc);

        // 🔹 Cash Tendered
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel cashText = new JLabel("Cash Tendered:");
        cashText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        card.add(cashText, gbc);

        gbc.gridx = 1;
        cashField = new JTextField();
        cashField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cashField.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1, true),
                new EmptyBorder(5, 8, 5, 8)
        ));
        card.add(cashField, gbc);

        // 🔹 Change
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel changeText = new JLabel("Change:");
        changeText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        card.add(changeText, gbc);

        gbc.gridx = 1;
        changeLabel = new JLabel("₱ 0.00");
        changeLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        changeLabel.setForeground(new Color(0, 80, 180));
        card.add(changeLabel, gbc);

        add(header, BorderLayout.NORTH);
        add(card, BorderLayout.CENTER);

        // 🔘 Buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
        buttons.setBackground(new Color(245, 247, 250));

        JButton calcButton = styledButton("Calculate", new Color(220, 220, 220), new Color(50, 50, 50));
        JButton confirmButton = styledButton("Confirm", new Color(0, 120, 60), Color.WHITE);
        JButton cancelButton = styledButton("Cancel", new Color(180, 30, 30), Color.WHITE);

        buttons.add(calcButton);
        buttons.add(confirmButton);
        buttons.add(cancelButton);

        add(buttons, BorderLayout.SOUTH);

        // 🧮 Events
        calcButton.addActionListener(e -> calculateChange());
        confirmButton.addActionListener(e -> confirmPayment());
        cancelButton.addActionListener(e -> SwingUtilities.getWindowAncestor(this).dispose());

        // 💡 Real-time change computation
        cashField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculateChange();
            }
        });
    }

    // 🔹 Reusable styled buttons
    private JButton styledButton(String text, Color bg, Color fg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(8, 15, 8, 15));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(bg.darker());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(bg);
            }
        });
        return btn;
    }

    // 🔸 Calculate change
    private void calculateChange() {
        try {
            double total = manager.getSubtotal();
            double cash = Double.parseDouble(cashField.getText());
            double change = cash - total;
            if (change < 0) {
                changeLabel.setText("₱ 0.00");
            } else {
                changeLabel.setText("₱ " + df.format(change));
            }
        } catch (NumberFormatException ex) {
            changeLabel.setText("₱ 0.00");
        }
    }

    // 🔸 Confirm payment
    private void confirmPayment() {
        try {
            double total = manager.getSubtotal();
            double cash = Double.parseDouble(cashField.getText());

            if (cash < total) {
                JOptionPane.showMessageDialog(this, "⚠️ Cash is not enough!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double change = cash - total;
            JOptionPane.showMessageDialog(this,
                    String.format("""
                            ✅ Payment Successful!
                            
                            Total: ₱%.2f
                            Cash: ₱%.2f
                            Change: ₱%.2f
                            """, total, cash, change),
                    "Transaction Complete",
                    JOptionPane.INFORMATION_MESSAGE);

            manager.clearOrders();
            SwingUtilities.getWindowAncestor(this).dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input for cash.");
        }
    }
}
