package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

public class MainWindow extends JFrame{
    private JPanel mainPanel;
    private JComboBox comboBox3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton createMatrix;

    private HashMap<Integer, Double> firstMatrix;
    private HashMap<Integer, Double> secondMatrix;
    private int rowCount;
    private int columnCount;

    public void MainForm() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initMainWindow();

        focusListeners();

        buttonListeners();

    }

    private void buttonListeners() {
        createMatrix.addActionListener(e -> {
            JPanel generateMatrix = new JPanel();
            generateMatrix.setLayout(new GridLayout(rowCount, columnCount + 1, 5, 5));
            generateMatrix.setPreferredSize(new Dimension(rowCount * 50, columnCount * 50));
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    JTextField jTextField = new JTextField();
                    jTextField.setMargin(new Insets(30, 10, 0, 10));
                    jTextField.setBounds(100 + i * 30, 100 + j * 30, 20, 20);
                    jTextField.setBackground(new Color(0x7A7C7E));
                    jTextField.setVisible(true);
                    generateMatrix.add(jTextField);
                }
            }


            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    JTextField jTextField = new JTextField();
                    jTextField.setMargin(new Insets(30, 10, 0, 10));
                    jTextField.setBounds(100 + i * 30, 100 + j * 30, 20, 20);
                    jTextField.setBackground(new Color(0x7E0004));
                    if (j == 0) {
                        jTextField.setMargin(new Insets(50, 50, 0, 0));
                    }
                    jTextField.setVisible(true);
                    generateMatrix.add(jTextField);
                }
            }
            JOptionPane.showConfirmDialog(new JFrame(), generateMatrix,
                    "Заполните матрицы", JOptionPane.YES_NO_OPTION);
        });
    }

    private void focusListeners() {
        textField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println(textField1.getText());
                rowCount = Integer.parseInt(textField1.getText());
            }
        });

        textField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println(textField2.getText());
                columnCount = Integer.parseInt(textField2.getText());
            }
        });
    }

    private void initMainWindow() {
        setSize(1150, 500);
        add(mainPanel);
        setVisible(true);
    }
}
