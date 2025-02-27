package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality(){
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem (Item item) {

        switch (item.name) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePass(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                if (item.quality != 80) {
                    item.quality = 80;
                }
                return;
            default:
                if (item.name.startsWith("Conjured")){updateConjuredItem(item);}
                else{updateStandardItem(item);}
        }
        decreaseSellIn(item);
        if(item.sellIn < 0) { expireItem(item);}

    }
    //methods to update items
    private void updateStandardItem(Item item) {
        decreaseQuality(item);
    }
    private void updateAgedBrie(Item item) {
        increaseQuality(item);
    }
    private void updateBackstagePass(Item item) {
        increaseQuality(item);
        //sellin value increases a second time if <10 days
        if (item.sellIn < 10) { increaseQuality(item);}
        //sellin value increases a third time in <5 days
        if (item.sellIn < 5) { increaseQuality(item);}
    }
    private void updateConjuredItem(Item item) {
        decreaseQuality(item);
        decreaseQuality(item);
    }
    //methods to change quality
    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
    private void expireItem(Item item){
        //aged brie increases in quality the older it gets
        if (item.name.equals("Aged Brie")) {increaseQuality(item);}
        //backstage page quality is 0 after the sellin date passes
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {item.quality = 0;}
        //calls decrease quality again, bc it degrades twice as fast
        else {decreaseQuality(item);}
    }

    //method to decrease the SellIn variable
    private void decreaseSellIn(Item item){
        item.sellIn--;
    }
}
