package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Все классы в одном файле, не бейте

public class MainForm extends JFrame {
    private final JComboBox<Product> comboBox;
    private JLabel productDetailsLabel;
    private JLabel productNameLabel;

    public MainForm() throws HeadlessException {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        comboBox = new JComboBox<>();

        add(comboBox, gbc);

        JButton updateButton = new JButton("Обновить");
        updateButton.addActionListener(a -> {
            comboBox.removeAllItems();
            for (var product: Product.products) {
                comboBox.addItem(product);
            }
        });
        add(updateButton, gbc);

        JButton adminButton = new JButton("Админка");
        adminButton.addActionListener(a -> {
            var adminForm = new AdminForm();
            adminForm.setVisible(true);
        });
        add(adminButton, gbc);

    }
}

class AdminForm extends JFrame{
    public AdminForm() throws HeadlessException {
        setSize(500, 500);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField name = new JTextField("Title", 20);

        JTextArea details = new JTextArea("Details");

        JTextField price = new JTextField("Price", 20);

        add(name, gbc);
        add(details, gbc);
        add(price, gbc);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(a ->{
            // Не бейте
            Product.products.add(new Product(name.getText(), details.getText(), Integer.parseInt(price.getText())));
        });

        add(addButton);
    }
}



class Product{
    // Не бейте
    public static ArrayList<Product> products = new ArrayList<>();

    private String name;
    private String details;
    private int price;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(String name, String details, int price) {
        this.name = name;
        this.details = details;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
