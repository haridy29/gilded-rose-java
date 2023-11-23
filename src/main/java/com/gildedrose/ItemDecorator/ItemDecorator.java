package com.gildedrose.ItemDecorator;

import com.gildedrose.Item;
import com.gildedrose.qualitystratigies.QualityUpdater;
import com.gildedrose.sellinstratigies.SellInUpdater;

public abstract class ItemDecorator {
    protected Item item;
    protected QualityUpdater qualityUpdater;
    protected SellInUpdater sellInUpdater;

    public ItemDecorator(Item item, QualityUpdater qualityUpdater, SellInUpdater sellInUpdater) {
        this.item = item;
        this.qualityUpdater = qualityUpdater;
        this.sellInUpdater = sellInUpdater;
    }

    public void updateSellIn() {
        if (sellInUpdater != null) {
            this.sellInUpdater.update(item);
        }

    }

    public void updateQuality() {
        if (qualityUpdater != null) {
            this.qualityUpdater.update(item, 1);

        }
    }
}
