package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void SulfurasNonZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void SulfurasZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void RandomItem() {
        Item[] items = new Item[]{new Item("Broadsword", 10, 15)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    void RandomItemZeroDays() {
        Item[] items = new Item[]{new Item("Broadsword", 0, 15)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void AgedBrieExpiredDays() {
        Item[] items = new Item[]{new Item("Aged Brie", -3, 15)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(17, app.items[0].quality);
    }

    @Test
    void Backstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
    }

    @Test
    void BackstageThreeDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(33, app.items[0].quality);
    }

    @Test
    void BackstageZeroDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void BackstageMoreThanTenDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 12, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }

    @Test
    void AgedBrieQualityIncrease() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void AgedBrieQualityNotAbove50() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void Conjured() {
        Item[] items = new Item[]{new Item("Conjured", 3, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
    }

    @Test
    void sellInExpired() {
        Item[] items = new Item[]{new Item("Expired Item", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Expired Item", app.items[0].name);
    }

    @Test
    void ItemToString() {
        Item[] items = new Item[]{new Item("Item", 1, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Item, 0, 1", app.items[0].toString());
    }

    @Test
    void QualityLess50(){
        Item[] items = new Item[]{new Item("Item", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49,items[0].quality);
    }

    @Test
    void ConjuredItem(){
        Item[] items = new Item[]{new Item("Conjured Item", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9,items[0].sellIn);
        assertEquals(18,items[0].quality);
    }
}



