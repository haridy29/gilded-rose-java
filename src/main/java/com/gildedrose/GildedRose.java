package com.gildedrose;


import static java.lang.Math.*;

class GildedRose {
    Item[] items;
    private String AGED_BRIE_NAME, SULFURAS_NAME, BACKSTAGE_NAME, NORMAL_NAME;

    public GildedRose(Item[] items) {
        this.items = items;

        this.AGED_BRIE_NAME = "Aged Brie";
        this.SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
        this.BACKSTAGE_NAME = "Backstage passes to a TAFKAL80ETC concert";
        this.NORMAL_NAME = "Normal";
    }

    public void updateAgedBrieItem(Item item) {
        int maxQuality = 50;
        item.quality = min(item.quality + 1, maxQuality);
        item.sellIn--;
    }

    public void updateBackstagePassesItem(Item item) {

        if (item.sellIn > 10) {
            item.quality++;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 0) {
            item.quality += 3;

        } else {
            item.quality = 0;
        }
        int maxQuality = 50;
        item.quality = min(item.quality, maxQuality);
        item.sellIn--;
    }

    public void updateNormalItem(Item item) {

        if (item.sellIn > 0) {
            item.quality--;
        } else {
            item.quality -= 2;
        }
        int minQuality = 0;
        item.quality = max(minQuality, item.quality);
        item.sellIn--;
    }


    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(AGED_BRIE_NAME)) {
                updateAgedBrieItem(item);
            } else if (item.name.equals(BACKSTAGE_NAME)) {
                updateBackstagePassesItem(item);
            } else if (item.name.equals(SULFURAS_NAME)) {
                    //Do Nothing
            } else {
                updateNormalItem(item);
            }
        }
    }
}