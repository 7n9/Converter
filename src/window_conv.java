import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class window_conv extends JFrame{
    private JPanel panel1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    String[] sys = {"DEC", "BIN", "HEX"};

    public window_conv(){

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException e) {
            //throw new RuntimeException(e);
        }

        this.setSize(300, 200);
        this.setTitle("Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        for(String s : sys){
            comboBox1.addItem(s);
            comboBox2.addItem(s);

        }

        button1.setBackground(Color.GRAY);
        button1.setForeground(Color.WHITE);
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        comboBox1.setBackground(Color.GRAY);
        comboBox1.setForeground(Color.WHITE);
        comboBox1.setFocusable(false);
        comboBox2.setBackground(Color.GRAY);
        comboBox2.setForeground(Color.WHITE);
        comboBox2.setFocusable(false);
        textField1.setBackground(Color.GRAY);
        textField2.setBackground(Color.GRAY);
        textField1.setForeground(Color.WHITE);
        textField2.setForeground(Color.WHITE);
        panel1.setBackground(Color.DARK_GRAY);
        this.add(panel1);

        panel1.setVisible(true);
        this.setVisible(true);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Objects.equals(comboBox1.getSelectedItem(), comboBox2.getSelectedItem())){
                    try {
                        if (comboBox1.getSelectedItem().toString().equals("DEC")) {
                            if (comboBox2.getSelectedItem().toString().equals("BIN")) {
                                textField2.setText(decToBin(Integer.parseInt(textField1.getText())));
                            } else {
                                textField2.setText(decToHex(Integer.parseInt(textField1.getText())));
                            }
                        } else if (comboBox1.getSelectedItem().toString().equals("BIN")) {
                            if (comboBox2.getSelectedItem().toString().equals("DEC")) {
                                textField2.setText(binToDec(textField1.getText()));
                            } else {
                                textField2.setText(binToHex(textField1.getText()));
                            }
                        } else {
                            if (comboBox2.getSelectedItem().toString().equals("DEC")) {
                                textField2.setText(hexToDec(textField1.getText()));
                            } else {
                                textField2.setText(hexToBin(textField1.getText()));
                            }
                        }
                    }catch (Exception ex){
                        UIManager.put("OptionPane.background", Color.DARK_GRAY);
                        UIManager.put("Panel.background", Color.DARK_GRAY);
                        UIManager.put("OptionPane.messageForeground", Color.WHITE);
                        JOptionPane.showMessageDialog(null, "Wrong input!", "Err", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }


    public String decToBin(int dec) {
        return Integer.toBinaryString(dec);
    }

    public String decToHex(int dec) {
        return Integer.toHexString(dec);
    }

    public String binToDec(String bin) {
        return String.valueOf(Integer.parseInt(bin, 2));
    }

    public String binToHex(String bin) {
        return Integer.toHexString(Integer.parseInt(bin, 2));
    }

    public String hexToDec(String hex) {
        return String.valueOf(Integer.parseInt(hex, 16));
    }

    public String hexToBin(String hex) {
        return Integer.toBinaryString(Integer.parseInt(hex, 16));
    }

}
