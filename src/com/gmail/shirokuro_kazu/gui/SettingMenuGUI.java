package com.gmail.shirokuro_kazu.gui;

import com.gmail.shirokuro_kazu.Run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SettingMenuGUI implements ActionListener, KeyListener {

    JFrame frame;
    JPanel panel;
    JLabel label1, label2;
    JTextArea textArea1, textArea2;
    JButton button1, button2, button3;

    public SettingMenuGUI() {
        frame = new JFrame("Setting");
        frame.setBounds(120, 100, 420, 580);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);

        label1 = new JLabel("変更前");
        label1.setBounds(40,40,50,20);
        label1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));

        label2 = new JLabel("変更後");
        label2.setBounds(40,85,50,20);
        label2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));

        textArea1 = new JTextArea();
        textArea1.append(Run.data.getOldPath());
        textArea1.setBounds(100,40,250,20);
        textArea1.addKeyListener(this);

        textArea2 = new JTextArea();
        textArea2.append(Run.data.getNewPath());
        textArea2.setBounds(100,85,250,20);
        textArea2.addKeyListener(this);

        button1 = new JButton("OK");
        button1.setBounds(135,510,85,25);
        button1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
        button1.addActionListener(this);

        button2 = new JButton("キャンセル");
        button2.setBounds(225,510,85,25);
        button2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
        button2.addActionListener(this);

        button3 = new JButton("適用");
        button3.setEnabled(false);
        button3.setBounds(315,510,85,25);
        button3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
        button3.addActionListener(this);

        panel.add(label1);
        panel.add(label2);
        panel.add(textArea1);
        panel.add(textArea2);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        frame.add(panel);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1) {          //ok
            Run.data.setFilePath(textArea1.getText(),textArea2.getText());
            frame.setVisible(false);
        }else if (e.getSource() == button2) {   //cancel
            frame.setVisible(false);
        }else if (e.getSource() == button3) {   //apply
            Run.data.setFilePath(textArea1.getText(),textArea2.getText());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == textArea1){
            button3.setEnabled(true);
        }else if (e.getSource() == textArea2) {
            button3.setEnabled(true);
        }
    }
}
