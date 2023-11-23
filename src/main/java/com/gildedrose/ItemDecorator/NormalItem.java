package com.gildedrose.ItemDecorator;

import com.gildedrose.Item;
import com.gildedrose.qualitystratigies.QualityDecrease;
import com.gildedrose.sellinstratigies.SellInDecrease;

public class NormalItem extends ItemDecorator {
    public NormalItem(Item item) {
        super(item, new QualityDecrease(), new SellInDecrease());
    }

    @Override
    public void updateQuality() {
        if (this.item.sellIn > 0) {
            super.updateQuality();
        } else {
            this.qualityUpdater.update(this.item, 2);
        }
    }
}
