package com.gmail.shirokuro_kazu.Core;

import com.gmail.shirokuro_kazu.Run;

import javax.swing.*;
import java.io.File;

public class Rename {
    private final FileCount fileCount;
    private final JTextArea textArea1;
    private String FileExtension = null;        //取得した拡張子

    public Rename(FileCount fileCount, JTextArea textArea1) {
        this.fileCount = fileCount;
        this.textArea1 = textArea1;
    }

    public void rename(String fileName, String character, int count) {
        int FileExtensionPosition = fileName.lastIndexOf("."); //拡張子前の"."がどの位置にあるかを取得する
        if (FileExtensionPosition != -1) {
            FileExtension = fileName.substring(FileExtensionPosition);
        }

        //元ファイルのパス
        File OldFile = new File(Run.data.getOldPath() + "/" + fileName);
        //ファイル名変更後のパス
        File NewFile = new File(Run.data.getNewPath() + "/" + character + "/" + character + count + FileExtension);

        //重複の処理
        if (NewFile.exists()) {
            NewFile.delete();
            textArea1.append("重複ファイル：" + NewFile + "をデリート\n");
        }

        //ファイル名変更
        OldFile.renameTo(NewFile);
        textArea1.append(character + count + "：リネーム完了\n");

        switch (character) {
            case "Bee" -> fileCount.addBeeCount();
            case "Butterfly" -> fileCount.addButterflyCount();
            case "Dragonfly" -> fileCount.addDragonflyCount();
            case "Ladybug" -> fileCount.addLadybugCount();
            case "Locust" -> fileCount.addLocustCount();
            case "Praying_mantis" -> fileCount.addPrayingMantisCount();
            case "fish" -> fileCount.addFishCount();
        }
    }
}
