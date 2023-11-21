package com.gildedrose;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private final String AGED_BRIE_NAME, SULFURAS_NAME, BACKSTAGE_NAME, NORMAL_NAME, CONJURED_NAME;

    GildedRoseTest() {
        this.AGED_BRIE_NAME = "Aged Brie";
        this.SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
        this.BACKSTAGE_NAME = "Backstage passes to a TAFKAL80ETC concert";
        this.NORMAL_NAME = "Normal";
        this.CONJURED_NAME = "Conjured";
    }

    @Test
    void testNormalItemQualityAndSellInDecreaseEachDay() {
        int sellIn = 2, quality = 20;
        Item[] Items = new Item[]{new Item(NORMAL_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality - 1);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    void testNormalItemQualityDecreasesByTwoWithZeroSellIN() {
        int sellIn = 0, quality = 20;
        Item[] Items = new Item[]{new Item(NORMAL_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality - 2);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    void testNormalItemQualityIsNeverNegative() {
        int sellIn = 2, quality = 0;
        Item[] Items = new Item[]{new Item(NORMAL_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    public void testAgedBrieQualityNeverExceed50() {
        int sellIn = 2, quality = 50;
        Item[] Items = new Item[]{new Item(AGED_BRIE_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    public void testAgedBrieSellInDecreaseEachDay() {
        int sellIn = 2, quality = 20;
        Item[] Items = new Item[]{new Item(AGED_BRIE_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality + 1);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    public void testAgedBrieQualityIncreaseEachDay() {
        int sellIn = 2, quality = 20;
        Item[] Items = new Item[]{new Item(AGED_BRIE_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality + 1);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    public void testSulfurasQualityAndSellInUnChangedEachDay() {
        int sellIn = 1, quality = 20;
        Item[] Items = new Item[]{new Item(SULFURAS_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality);
        assertEquals(Items[0].sellIn, sellIn);
    }
    @Test
    public void testSulfurasQualityNeverExceed80() {
        int sellIn = 1, quality = 80;
        Item[] Items = new Item[]{new Item(SULFURAS_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality);
        assertEquals(Items[0].sellIn, sellIn);
    }
    @Test
    public void testBackstagePassesQualityIncreasesEachDayWithSellInMoreThan10DaysLeft() {
        int sellIn = 11, quality = 20;
        Item[] Items = new Item[]{new Item(BACKSTAGE_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality + 1);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }


    @Test
    public void testBackstagePassesQualityIncreasesBy2EachDayWithSellIn10DaysOrLessLeft() {
        int sellIn = 10, quality = 20;
        Item[] Items = new Item[]{new Item(BACKSTAGE_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality + 2);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    public void testBackstagePassesQualityIncreasesBy3EachDayWithSellIn5DaysOrLessLeft() {
        int sellIn = 5, quality = 20;
        Item[] Items = new Item[]{new Item(BACKSTAGE_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality + 3);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    public void testBackstagePassesQualityDropsTo0AfterConcert() {
        int sellIn = 0, quality = 20;
        Item[] Items = new Item[]{new Item(BACKSTAGE_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, 0);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    public void testBackstagePassesQualityDoesNotExceed50() {
        int sellIn = 2, quality = 50;
        Item[] Items = new Item[]{new Item(BACKSTAGE_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }


    @Test
    void testConjuredItemWithAvailableSellInDays(){
        int sellIn = 2, quality = 20;
        Item[] Items = new Item[]{new Item(CONJURED_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality-2);
        assertEquals(Items[0].sellIn, sellIn - 1);

    }
    @Test
    void testConjuredItemQualityIsNeverNegative() {
        int sellIn = 2, quality = 0;
        Item[] Items = new Item[]{new Item(CONJURED_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

    @Test
    void testConjuredItemWithZeroSellInDaysLeft() {
        int sellIn = 0, quality = 5;
        Item[] Items = new Item[]{new Item(CONJURED_NAME, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(Items);
        gildedRose.updateQuality();
        assertEquals(Items[0].quality, quality-4);
        assertEquals(Items[0].sellIn, sellIn - 1);
    }

}
