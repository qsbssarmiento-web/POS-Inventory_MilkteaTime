package project.milktea_pos_inv;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDialogPanel extends JPanel {

    private final Products product;
    private final JSpinner qtySpinner;
    private final JCheckBox pearl;
    private final JCheckBox creamCheese;
    private final JCheckBox nata;

    public ProductDialogPanel(Products product) {
        this.product = product;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Image Section ---
        if (product.getImagePath() != null) {
            ImageIcon icon = new ImageIcon(product.getImagePath());
            Image scaled = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaled));
            add(imageLabel, BorderLayout.WEST);
        }

        // --- Details + Inputs Section ---
        JPanel detailsPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        detailsPanel.add(new JLabel("<html><h3>" + product.getName() + "</h3>₱" + product.getPrice() + "</html>"));

        // Quantity Input
        JPanel qtyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtyPanel.add(new JLabel("Quantity:"));
        qtySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
        qtyPanel.add(qtySpinner);
        detailsPanel.add(qtyPanel);

        // Add-ons
        JPanel addonsPanel = new JPanel(new GridLayout(0, 1));
        addonsPanel.setBorder(BorderFactory.createTitledBorder("Add-ons"));
        pearl = new JCheckBox("Pearl (+₱10)");
        creamCheese = new JCheckBox("Cream Cheese (+₱15)");
        nata = new JCheckBox("Nata de Coco (+₱10)");
        addonsPanel.add(pearl);
        addonsPanel.add(creamCheese);
        addonsPanel.add(nata);

        detailsPanel.add(addonsPanel);
        add(detailsPanel, BorderLayout.CENTER);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }

    /**
     * Returns the selected quantity
     */
    public int getQuantity() {
        return (int) qtySpinner.getValue();
    }

    /**
     * Returns the selected add-ons and computes total additional cost
     */
    public List<String> getSelectedAddons() {
        List<String> addons = new ArrayList<>();
        if (pearl.isSelected()) {
            addons.add("Pearl");
        }
        if (creamCheese.isSelected()) {
            addons.add("Cream Cheese");
        }
        if (nata.isSelected()) {
            addons.add("Nata de Coco");
        }
        return addons;
    }

    /**
     * Calculates the final price based on product base price, quantity, and
     * addons
     */
    public double computeTotal() {
        double addonPrice = 0;
        if (pearl.isSelected()) {
            addonPrice += 10;
        }
        if (creamCheese.isSelected()) {
            addonPrice += 15;
        }
        if (nata.isSelected()) {
            addonPrice += 10;
        }

        double base = product.getPrice() + addonPrice;
        return base * getQuantity();
    }
}
