package com.gmail.shirokuro_kazu.mainsystem;

import com.gmail.shirokuro_kazu.Run;
import com.gmail.shirokuro_kazu.gui.MainGUI;

import java.io.File;

public class LoadFile extends Thread{
    boolean pause = false;
    boolean stop = false;

    String Bee = "Bee";
    static int Bee_Count = 0;
    String Butterfly = "Butterfly";
    static int Butterfly_Count = 0;
    String Dragonfly = "Dragonfly";
    static int Dragonfly_Count = 0;
    String Ladybug = "Ladybug";
    static int Ladybug_Count = 0;
    String Locust = "Locust";
    static int Locust_Count = 0;
    String Praying_mantis = "Praying_mantis";
    static int Praying_mantis_Count = 0;
    String sakana = "sakana";
    static int sakana_Count = 0;

    String Character;
    int Count;

    public void run() { //GUIからデータを取得 (型 変数名)

        MainGUI.textArea1.append("起動\n");

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

                if (FileName.contains(Bee)) {
                    Character = Bee;
                    Count = Bee_Count;
                    new Rename(FileName, Character, Count);
                } else if (FileName.contains(Butterfly)) {
                    Character = Butterfly;
                    Count = Butterfly_Count;
                    new Rename(FileName, Character, Count);
                } else if (FileName.contains(Dragonfly)) {
                    Character = Dragonfly;
                    Count = Dragonfly_Count;
                    new Rename(FileName, Character, Count);
                } else if (FileName.contains(Ladybug)) {
                    Character = Ladybug;
                    Count = Ladybug_Count;
                    new Rename(FileName, Character, Count);
                } else if (FileName.contains(Locust)) {
                    Character = Locust;
                    Count = Locust_Count;
                    new Rename(FileName, Character, Count);
                } else if (FileName.contains(Praying_mantis)) {
                    Character = Praying_mantis;
                    Count = Praying_mantis_Count;
                    new Rename(FileName, Character, Count);
                } else if (FileName.contains(sakana)) {
                    Character = sakana;
                    Count = sakana_Count;
                    new Rename(FileName, Character, Count);
                }
            }
            try {
                Thread.sleep(1000);
                synchronized(this){
                    if (pause) wait();
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
