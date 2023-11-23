package com.gildedrose.ItemDecoratorFactory;

import com.gildedrose.Item;
import com.gildedrose.ItemDecorator.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ItemDecoratorFactoryMethod {
    private static final HashMap<String, Class<?>> itemsFactory = new HashMap<>();
    private static String AGED_BRIE_NAME, SULFURAS_NAME, BACKSTAGE_NAME, CONJURED_NAME;

    static {
        AGED_BRIE_NAME = "Aged Brie";
        SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
        BACKSTAGE_NAME = "Backstage passes to a TAFKAL80ETC concert";
        CONJURED_NAME = "Conjured";

        itemsFactory.put(AGED_BRIE_NAME, AgedBrieItem.class);
        itemsFactory.put(SULFURAS_NAME, SulfurasItem.class);
        itemsFactory.put(BACKSTAGE_NAME, BackstageItem.class);
        itemsFactory.put(CONJURED_NAME, ConjuredItem.class);
    }


    private static ItemDecorator getItem(Item item) throws NoSuchMethodException {

        Class<?> myClass = itemsFactory.getOrDefault(item.name, NormalItem.class);
        Constructor<?> constructor = myClass.getConstructor(Item.class);
        try {
            return (ItemDecorator) constructor.newInstance(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static ItemDecorator[] getItems(Item[] items) {
        ItemDecorator[] decoratedItems = new ItemDecorator[items.length];
        for (int i = 0; i < items.length; i++) {
            try {
                decoratedItems[i] = getItem(items[i]);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return decoratedItems;
    }
}
