package com.gildedrose.qualitystratigies;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class QualityIncrease implements QualityUpdater {
    private final static int MAX_QUALITY = 50;

    @Override
    public void update(Item item, int updateRate) {
        item.quality += updateRate;
        item.quality = min(item.quality, MAX_QUALITY);
    }
}
