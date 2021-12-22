package com.gmail.shirokuro_kazu.gui;

import com.gmail.shirokuro_kazu.Core.LoadFile;
import com.gmail.shirokuro_kazu.Run;

import javax.swing.*;

public class Main {
    private final JFrame frame;
    LoadFile loadFile = null;
    private JTextArea textArea1;
    private JButton stopButton;
    private JPanel panel;

    public Main() {
        frame = new JFrame("直義");
        createContent();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setJMenuBar(createMenuBar());
        frame.setVisible(true);
    }

    private void createContent() {
        stopButton.addActionListener(e -> {
            loadFile.setPause();
            if (stopButton.getText().equals("停止")) {
                stopButton.setText("再開");
                textArea1.append("再開\n");
            } else if (stopButton.getText().equals("再開")) {
                stopButton.setText("停止");
                textArea1.append("停止\n");
            }
        });

        new LoadFile(textArea1).start(); //Renameをスレッドとして起動
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("System");

        JMenuItem menuItem1 = new JMenuItem("Edit Path");
        menuItem1.addActionListener(e -> {
            SettingMenu settingMenu = new SettingMenu(frame);
            settingMenu.pack();
            settingMenu.setVisible(true);
        });

        JMenuItem menuItem2 = new JMenuItem("Current Path");
        String message = Run.data.getOldPath() + "\n" + Run.data.getNewPath();
        menuItem2.addActionListener(e -> JOptionPane.showMessageDialog(frame, message, "Current Path", JOptionPane.INFORMATION_MESSAGE));

        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);

        return menuBar;
    }
}
