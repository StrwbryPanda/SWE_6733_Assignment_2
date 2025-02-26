package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            boolean isAgedBrie = !item.name.equals("Aged Brie");
            boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
            boolean isBackstagePass = item.name.equals("Backstage passes to a TAFKAL80ETC concert");

            if (isAgedBrie && !isBackstagePass) {
                if (item.quality > 0 && !isSulfuras) {
                    item.quality -= 1;
                }
            }
            else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (isBackstagePass) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (isAgedBrie) {
                    if (!isBackstagePass) {
                        if (item.quality > 0) {
                            if (!isSulfuras) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
