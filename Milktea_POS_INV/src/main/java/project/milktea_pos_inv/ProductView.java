package project.milktea_pos_inv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductView extends JPanel {

    private final POSManager manager;
    private final Products product;
    private final JButton productButton;
    private final Color baseColor = new Color(255, 255, 255);
    private final Color hoverColor = new Color(240, 248, 255);

    public ProductView(POSManager manager, Products product) {
        this.manager = manager;
        this.product = product;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 230));
        setBackground(baseColor);
        setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true));

        // ✅ Product button (for image + click)
        productButton = new JButton();
        productButton.setContentAreaFilled(false);
        productButton.setBorderPainted(false);
        productButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        productButton.addActionListener(e -> showProductDialog());

        // 🖼️ Product image (top section)
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(180, 150));
        if (product.getImagePath() != null) {
            ImageIcon icon = new ImageIcon(product.getImagePath());
            Image scaled = icon.getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
        } else {
            imageLabel.setText("No Image");
            imageLabel.setForeground(Color.GRAY);
        }

        // 🏷️ Info panel (bottom section)
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        JLabel nameLabel = new JLabel(product.getName(), SwingConstants.CENTER);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel priceLabel = new JLabel("₱" + String.format("%.2f", product.getPrice()), SwingConstants.CENTER);
        priceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        priceLabel.setForeground(new Color(50, 120, 70));

        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);

        // 🧩 Layer everything nicely
        add(imageLabel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);
        add(productButton, BorderLayout.CENTER); // overlay button

        // 🎨 Hover effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(baseColor);
                repaint();
            }
        });

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }

    private void showProductDialog() {
        ProductDialogPanel dialogPanel = new ProductDialogPanel(product);

        int result = JOptionPane.showConfirmDialog(
                this,
                dialogPanel,
                "Customize " + product.getName(),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            int qty = dialogPanel.getQuantity();
            double total = dialogPanel.computeTotal();
            var addons = dialogPanel.getSelectedAddons();

            manager.addOrder(
                    product.getItemID(),
                    product.getName() + (addons.isEmpty() ? "" : " + " + String.join(", ", addons)),
                    qty,
                    total
            );
        }
    }
}
