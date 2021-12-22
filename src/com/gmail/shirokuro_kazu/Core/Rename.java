package com.gmail.shirokuro_kazu.Core;

import com.gmail.shirokuro_kazu.Run;

import javax.swing.*;
import java.io.File;

public class Rename {
    private final FileCount fileCount;
    private final JTextArea textArea1;
    private String FileExtension = null;        //�擾�����g���q

    public Rename(FileCount fileCount, JTextArea textArea1) {
        this.fileCount = fileCount;
        this.textArea1 = textArea1;
    }

    public void rename(String fileName, String character, int count) {
        int FileExtensionPosition = fileName.lastIndexOf("."); //�g���q�O��"."���ǂ̈ʒu�ɂ��邩���擾����
        if (FileExtensionPosition != -1) {
            FileExtension = fileName.substring(FileExtensionPosition);
        }

        //���t�@�C���̃p�X
        File OldFile = new File(Run.data.getOldPath() + "/" + fileName);
        //�t�@�C�����ύX��̃p�X
        File NewFile = new File(Run.data.getNewPath() + "/" + character + "/" + character + count + FileExtension);

        //�d���̏���
        if (NewFile.exists()) {
            NewFile.delete();
            textArea1.append("�d���t�@�C���F" + NewFile + "���f���[�g\n");
        }

        //�t�@�C�����ύX
        OldFile.renameTo(NewFile);
        textArea1.append(character + count + "�F���l�[������\n");

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
