package com.gildedrose.sellinstratigies;

import com.gildedrose.Item;

public class SellInDecrease implements SellInUpdater {

    @Override
    public void update(Item item) {
        item.sellIn--;
    }
}
