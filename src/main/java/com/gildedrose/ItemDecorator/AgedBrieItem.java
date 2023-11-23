package com.gildedrose.ItemDecorator;

import com.gildedrose.Item;
import com.gildedrose.qualitystratigies.QualityIncrease;
import com.gildedrose.sellinstratigies.SellInDecrease;

public class AgedBrieItem extends ItemDecorator {
    public AgedBrieItem(Item item) {
        super(item, new QualityIncrease(), new SellInDecrease());
    }


}
