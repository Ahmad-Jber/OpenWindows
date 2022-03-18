package com.Open;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class Run {
    JFrame frame = new JFrame("Open Folder or File");
    JTextField path = new JTextField();
    JButton run = new JButton("Run");
    JLabel res = new JLabel();
    Component [] arr = {new JLabel(""),new JLabel(""),path,run,res};
    public void addComponent(){
        for (Component c:arr) {
            frame.add(c);
        }
    }
    public void view(){
        frame.setVisible(true);
        frame.setLayout(new GridLayout(10,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponent();
        frame.pack();
        frame.setLocation(400,400);
        run.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(path.getText());
            }
        });
    }
    public void action(String path){
        File file = new File(path);
        Desktop desk = Desktop.getDesktop();
        try {
            desk.open(file);
            res.setText("Success");
        } catch (Exception e) {
            res.setText("Invalid Path");
        }
    }
}
