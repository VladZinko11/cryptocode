package com.javarush.zinko.Ui;

import javax.swing.*;
import java.awt.*;

public class Dialogue {
    JPanel mainPanel;
    JFrame frame;
    JButton buttonAddFile;
    JButton buttonEncode;
    JButton buttonDecode;
    JButton buttonBrutForce;
    JButton buttonSaveFile;

    public void start() {
        frame = new JFrame("Caesar cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainPanel = new JPanel();
        buttonDecode = new JButton("Decode");
        buttonEncode = new JButton("Encode");
        buttonBrutForce = new JButton("Brut Force");
        buttonSaveFile = new JButton("Save File");
        buttonAddFile = new JButton("Add File");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));



        mainPanel.add(buttonDecode);
        mainPanel.add(buttonEncode);
        mainPanel.add(buttonBrutForce);
        mainPanel.add(buttonSaveFile);
        mainPanel.add(buttonAddFile);
        frame.getContentPane().add(BorderLayout.EAST, mainPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}
