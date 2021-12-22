package com.gmail.shirokuro_kazu.gui;

import com.gmail.shirokuro_kazu.Run;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SettingMenu extends JDialog implements KeyListener {
    private JPanel contentPane;
    private JButton OKButton;
    private JButton cancelButton;
    private JButton applyButton;
    private JTextField beforePathTextField;
    private JTextField afterPathTextField;

    public SettingMenu(JFrame frame) {
        super(frame, "設定", true);
        setContentPane(contentPane);
        getRootPane().setDefaultButton(OKButton);

        beforePathTextField.setText(Run.data.getOldPath());
        beforePathTextField.addKeyListener(this);

        afterPathTextField.setText(Run.data.getNewPath());
        afterPathTextField.addKeyListener(this);

        OKButton.addActionListener(e -> onOK());

        cancelButton.addActionListener(e -> onCancel());

        applyButton.setEnabled(false);
        applyButton.addActionListener(e -> onApply());

        // X をクリックしたとき、 onCancel() を呼ぶ
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // ESCAPE で onCancel() を呼ぶ
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        Run.data.setFilePath(beforePathTextField.getText(), afterPathTextField.getText());
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void onApply() {
        Run.data.setFilePath(beforePathTextField.getText(), afterPathTextField.getText());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object source = e.getSource();
        if (beforePathTextField.equals(source) || afterPathTextField.equals(source)) {
            applyButton.setEnabled(true);
        }
    }
}
