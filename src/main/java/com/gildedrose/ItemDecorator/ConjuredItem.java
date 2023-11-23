package com.gildedrose.ItemDecorator;

import com.gildedrose.Item;
import com.gildedrose.qualitystratigies.QualityDecrease;
import com.gildedrose.qualitystratigies.QualityIncrease;
import com.gildedrose.qualitystratigies.QualityUpdater;
import com.gildedrose.sellinstratigies.SellInDecrease;
import com.gildedrose.sellinstratigies.SellInUpdater;

public class ConjuredItem extends ItemDecorator {
    public ConjuredItem(Item item) {
        super(item, new QualityDecrease(), new SellInDecrease());
    }

    @Override
    public void updateQuality() {
        if (this.item.sellIn > 0) {
            this.qualityUpdater.update(this.item, 2);
        } else {
            this.qualityUpdater.update(this.item, 4);
        }
    }
}
