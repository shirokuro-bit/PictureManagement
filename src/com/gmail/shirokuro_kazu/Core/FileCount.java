package com.gmail.shirokuro_kazu.Core;

public class FileCount {
    private final int limit = 3;
    private int beeCount = 0;
    private int butterflyCount = 0;
    private int dragonflyCount = 0;
    private int ladybugCount = 0;
    private int locustCount = 0;
    private int prayingMantisCount = 0;
    private int fishCount = 0;

    public FileCount() {

    }

    public int getBeeCount() {
        return beeCount;
    }

    public void addBeeCount() {
        if (beeCount > limit) {
            beeCount = 0;
        } else {
            beeCount++;
        }
    }

    public int getButterflyCount() {
        return butterflyCount;
    }

    public void addButterflyCount() {
        if (butterflyCount > limit) {
            butterflyCount = 0;
        } else {
            butterflyCount++;
        }
    }

    public int getDragonflyCount() {
        return dragonflyCount;
    }

    public void addDragonflyCount() {
        if (beeCount > limit) {
            dragonflyCount = 0;
        } else {
            dragonflyCount++;
        }
    }

    public int getLadybugCount() {
        return ladybugCount;
    }

    public void addLadybugCount() {
        if (ladybugCount > limit) {
            ladybugCount = 0;
        } else {
            ladybugCount++;
        }
    }

    public int getLocustCount() {
        return locustCount;
    }

    public void addLocustCount() {
        if (locustCount > limit) {
            locustCount = 0;
        } else {
            locustCount++;
        }
    }

    public int getPrayingMantisCount() {
        return prayingMantisCount;
    }

    public void addPrayingMantisCount() {
        if (prayingMantisCount > limit) {
            prayingMantisCount = 0;
        } else {
            prayingMantisCount++;
        }
    }

    public int getFishCount() {
        return fishCount;
    }

    public void addFishCount() {
        if (fishCount > limit) {
            fishCount = 0;
        } else {
            fishCount++;
        }
    }
}
