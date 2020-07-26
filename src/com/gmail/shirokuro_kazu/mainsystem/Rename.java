package com.gmail.shirokuro_kazu.mainsystem;

import com.gmail.shirokuro_kazu.Run;
import com.gmail.shirokuro_kazu.gui.MainGUI;

import java.io.File;

public class Rename {
    String FileExtension = null;		//取得した拡張子

    public Rename(String FileName, String Character, int Count) {
        int FileExtensionPostion = FileName.lastIndexOf("."); //拡張子前の"."がどの位置にあるかを取得する
        if (FileExtensionPostion != -1) {
            FileExtension = FileName.substring(FileExtensionPostion);
        }

        //元ファイルのパス
        File OldFile = new File( Run.data.getOldPath()+ "/" + FileName);
        //ファイル名変更後のパス
        File NewFile = new File(Run.data.getNewPath() + "/" + Character + "/" + Character + Count + FileExtension);

        //重複の処理
        if (NewFile.exists()) {
            NewFile.delete();
            MainGUI.textArea1.append("重複ファイル：" + NewFile + "をデリート\n");
        }

        //ファイル名変更
        OldFile.renameTo(NewFile);
        MainGUI.textArea1.append(Character + Count + "：リネーム完了\n");

        switch (Character) {
            case "Bee":
                LoadFile.Bee_Count++;
                if (LoadFile.Bee_Count > 2) {
                    LoadFile.Bee_Count = 0;
                }
            case "Butterfly":
                LoadFile.Bee_Count++;
                if (LoadFile.Bee_Count > 2) {
                    LoadFile.Bee_Count = 0;
                }
            case "Dragonfly":
                LoadFile.Bee_Count++;
                if (LoadFile.Bee_Count > 2) {
                    LoadFile.Bee_Count = 0;
                }
            case "Ladybug":
                LoadFile.Bee_Count++;
                if (LoadFile.Bee_Count > 2) {
                    LoadFile.Bee_Count = 0;
                }
            case "Locust":
                LoadFile.Bee_Count++;
                if (LoadFile.Bee_Count > 2) {
                    LoadFile.Bee_Count = 0;
                }
            case "Praying_mantis":
                LoadFile.Bee_Count++;
                if (LoadFile.Bee_Count > 2) {
                    LoadFile.Bee_Count = 0;
                }
            case "sakana":
                LoadFile.Bee_Count++;
                if (LoadFile.Bee_Count > 2) {
                    LoadFile.Bee_Count = 0;
                }
        }
    }
}
