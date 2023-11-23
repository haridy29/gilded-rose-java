package com.gildedrose;


import com.gildedrose.ItemDecorator.ItemDecorator;
import com.gildedrose.ItemDecoratorFactory.ItemDecoratorFactoryMethod;

import static java.lang.Math.*;

class GildedRose {
    Item[] items;
    ItemDecorator[] decoratedItems;


    public GildedRose(Item[] items) {
        this.items = items;
        this.decoratedItems = ItemDecoratorFactoryMethod.getItems(items);
    }


    public void updateQuality() {
        for (ItemDecorator decoratedItem : decoratedItems) {
            decoratedItem.updateQuality();
            decoratedItem.updateSellIn();
        }
    }
}