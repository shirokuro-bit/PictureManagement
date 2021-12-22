package com.gmail.shirokuro_kazu.Core;

import com.gmail.shirokuro_kazu.Run;

import javax.swing.*;
import java.io.File;

public class LoadFile extends Thread {
    private final String bee = "Bee";
    private final String butterfly = "Butterfly";
    private final String dragonfly = "Dragonfly";
    private final String ladybug = "Ladybug";
    private final String locust = "Locust";
    private final String prayingMantis = "Praying_mantis";
    private final String fish = "fish";
    private final JTextArea textArea1;
    private final FileCount fileCount = new FileCount();
    boolean pause = false;
    boolean stop = false;

    public LoadFile(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public void run() { //GUIからデータを取得 (型 変数名)
        Rename rename = new Rename(fileCount, textArea1);

        textArea1.append("起動\n");

        while (true) {
            //Fileクラスのオブジェクトを生成する
            File dir = new File(Run.data.getOldPath());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //listFilesメソッドを使用して一覧を取得する
            File[] list = dir.listFiles();

            //ファイル名の一覧を取得する
            File[] files = dir.listFiles();

            //ファイル数の確認
            if (list.length != 0) {  //ファイル数が0じゃない場合

                //ファイル名の取得
                String FileName = files[0].getName();

                if (FileName.contains(bee)) {
                    rename.rename(FileName, bee, fileCount.getBeeCount());
                } else if (FileName.contains(butterfly)) {
                    rename.rename(FileName, butterfly, fileCount.getButterflyCount());
                } else if (FileName.contains(dragonfly)) {
                    rename.rename(FileName, dragonfly, fileCount.getDragonflyCount());
                } else if (FileName.contains(ladybug)) {
                    rename.rename(FileName, ladybug, fileCount.getLadybugCount());
                } else if (FileName.contains(locust)) {
                    rename.rename(FileName, locust, fileCount.getLocustCount());
                } else if (FileName.contains(prayingMantis)) {
                    rename.rename(FileName, prayingMantis, fileCount.getPrayingMantisCount());
                } else if (FileName.contains(fish)) {
                    rename.rename(FileName, fish, fileCount.getFishCount());
                }
            }
            try {
                Thread.sleep(1000);
                synchronized (this) {
                    if (pause) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void setPause() {
        pause = !pause;
        if (!pause) {
            notify();
        }
    }
}
