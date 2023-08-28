package com.javarush.zinko.Ui;

import com.javarush.zinko.cryptography.Crypto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Dialogue {

    String result;

    JButton buttonAddFile;

    JButton buttonSaveFile;
    String text;
    JPanel mainPanel;
    JFrame frame;
    JButton buttonEncode;
    JButton buttonDecode;
    JButton buttonBrutForce;
    JTextField textField;

    public void start() {
        frame = new JFrame("Caesar cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainPanel = new JPanel();

        buttonAddFile = new JButton("Add File");
        buttonAddFile.addActionListener(new AddFileListener());

        buttonSaveFile = new JButton("Save File");
        buttonSaveFile.addActionListener(new SaveFileListener());

        buttonDecode = new JButton("Decode");
        buttonDecode.addActionListener(new DecodeListener());

        buttonEncode = new JButton("Encode");
        buttonEncode.addActionListener(new EncodeListener());

        buttonBrutForce = new JButton("Brut Force");
        buttonBrutForce.addActionListener(new BrutForceListener());

        textField = new JTextField();


        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(buttonDecode);
        mainPanel.add(buttonEncode);
        mainPanel.add(buttonBrutForce);
        mainPanel.add(buttonAddFile);
        mainPanel.add(buttonSaveFile);


        frame.getContentPane().add(BorderLayout.EAST, mainPanel);
        frame.getContentPane().add(BorderLayout.CENTER, textField);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public class DecodeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int key;
            key = Integer.parseInt(JOptionPane.showInputDialog("Введите ключ"));
            result = Crypto.decode(text, key);
            textField.setText(result);
        }
    }

    public class EncodeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int key;
            key = Integer.parseInt(JOptionPane.showInputDialog("Введите ключ"));
            result = Crypto.encode(text, key);
            textField.setText(result);
        }
    }

    public class BrutForceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            result = Crypto.bruteForce(text);
            textField.setText(result);
        }
    }

    public class AddFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String FileName;
            FileName = JOptionPane.showInputDialog("Имя файла");
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("C://IdeaProjects/" + FileName));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            String a;
            text="";
            while (true) {
                try {
                    if (!((a = reader.readLine()) != null)) break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                text = text + a;
            }
            textField.setText(text);
            try {
                reader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class SaveFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String FileName;
            FileName = JOptionPane.showInputDialog("Имя файла");
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(new File("C://IdeaProjects/" + FileName)));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                writer.write(result);
                writer.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}