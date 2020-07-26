package com.gmail.shirokuro_kazu;

import com.gmail.shirokuro_kazu.data.Data;
import com.gmail.shirokuro_kazu.gui.MainGUI;
import com.gmail.shirokuro_kazu.mainsystem.LoadFilePath;

public class Run {
    public static Data data = new Data();

    public static void main (String[] args) {
        new LoadFilePath();
        new MainGUI();
    }
}
