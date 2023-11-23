package com.gildedrose.ItemDecorator;

import com.gildedrose.Item;
import com.gildedrose.qualitystratigies.QualityIncrease;
import com.gildedrose.qualitystratigies.QualityUpdater;
import com.gildedrose.sellinstratigies.SellInDecrease;

public class BackstageItem extends ItemDecorator {
    public BackstageItem(Item item) {
        super(item, new QualityIncrease(), new SellInDecrease());
    }

    @Override
    public void updateQuality() {
        if (this.item.sellIn > 10) {
            super.updateQuality();
        } else if (this.item.sellIn > 5) {
            this.qualityUpdater.update(item, 2);
        } else if (this.item.sellIn > 0) {
            this.qualityUpdater.update(item, 3);
        } else {
            this.item.quality = 0;
        }
    }
}
