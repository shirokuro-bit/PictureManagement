package com.gmail.shirokuro_kazu.gui;

import com.gmail.shirokuro_kazu.Run;
import com.gmail.shirokuro_kazu.mainsystem.LoadFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI implements ActionListener {

    JFrame frame;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem1, menuItem2;

    JPanel panel1;

    JLabel label1;
    JButton button;
    public static JTextArea textArea1;

    JScrollPane scrollPane1;

    LoadFile loadFile = null;

    public MainGUI() {
        frame = new JFrame("直義");
        frame.setBounds(120, 100, 480, 270);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        menuBar = new JMenuBar();

        menu = new JMenu("System");

        menuItem1 = new JMenuItem("Edit Path");
        menuItem1.addActionListener(this);

        menuItem2 = new JMenuItem("Current Path");
        menuItem2.addActionListener(this);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(3,1));

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));

        label1 = new JLabel("ファイル名管理");
        label1.setHorizontalAlignment(JLabel.CENTER);

        button = new JButton("停止");
        button.addActionListener(this);

        textArea1 = new JTextArea();			// 1行25文字で10行分の領域を確保
        textArea1.setLineWrap(true);
        textArea1.setEditable(false);

        // スクロールペインを定義、テキストエリアを組み込む
        scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel1.add(button);

        contentPane.add(label1);
        contentPane.add(scrollPane1);
        contentPane.add(panel1);

        menuBar.add(menu);
        menu.add(menuItem1);
        menu.add(menuItem2);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

        loadFile = new LoadFile();
        loadFile.start();   //Renameをスレッドとして起動
    }

    public void actionPerformed( ActionEvent e ) {
        if(e.getSource() == button) {  //再開/停止
            loadFile.setPause();
            if (button.getText().equals("停止")){
                button.setText("再開");
                textArea1.append("再開\n");
            }else if (button.getText().equals("再開")) {
                button.setText("停止");
                textArea1.append("停止\n");
            }
        }else if (e.getSource() == menuItem1) {
            SettingMenuGUI st = new SettingMenuGUI();
        }else if (e.getSource() == menuItem2) {
            JOptionPane.showMessageDialog(frame, Run.data.getOldPath()+"\n"+Run.data.getNewPath(),"Current Path",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
