package com.gildedrose.qualitystratigies;

import com.gildedrose.Item;

import static java.lang.Math.max;

public class QualityDecrease implements QualityUpdater {
    private final static int MIN_QUALITY = 0;

    @Override
    public void update(Item item, int updateRate) {

        item.quality -= updateRate;
        item.quality = max(item.quality, MIN_QUALITY);
    }
}
