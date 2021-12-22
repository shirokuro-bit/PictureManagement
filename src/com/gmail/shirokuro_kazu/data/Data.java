package com.gmail.shirokuro_kazu.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Data {
    private String OldPath;
    private String NewPath;

    public String getOldPath() {
        return OldPath;
    }

    public String getNewPath() {
        return NewPath;
    }

    public void setOldPath(String OldPath) {
        this.OldPath = OldPath;
    }

    public void setNewPath(String NewPath) {
        this.NewPath = NewPath;
    }

    public void setFilePath(String OldPath, String NewPath) {
        Properties properties = new Properties();

        setOldPath(OldPath);
        setNewPath(NewPath);

        // プロパティファイルのパスを指定する
        String Path = "src/FilePath.properties";

        try {
            properties.setProperty("OldPath", OldPath);
            properties.setProperty("NewPath", NewPath);
            properties.store(new FileOutputStream(Path), "Comments");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
