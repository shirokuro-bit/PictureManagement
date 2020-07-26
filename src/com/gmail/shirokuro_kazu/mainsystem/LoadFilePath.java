package com.gmail.shirokuro_kazu.mainsystem;

import com.gmail.shirokuro_kazu.Run;

import java.util.ResourceBundle;

public class LoadFilePath {
    public LoadFilePath(){
        ResourceBundle bundle = ResourceBundle.getBundle("FilePath");

        Run.data.setOldPath(bundle.getString("OldPath"));
        Run.data.setNewPath(bundle.getString("NewPath"));
    }
}
