package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            boolean isAgedBrie = item.name.equals("Aged Brie");
            boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
            boolean isBackstagePass = item.name.equals("Backstage passes to a TAFKAL80ETC concert");

            if (!isAgedBrie && !isBackstagePass) {
                if (item.quality > 0 && !isSulfuras) {
                    item.quality -= 1;
                }
            }
            else {
                if (item.quality < 50) {
                    item.quality += 1;

                    if (isBackstagePass) {
                        if (item.sellIn < 11) {item.quality += 1;}
                        if (item.sellIn < 6) {item.quality += 1;}
                    }
                }
            }

            if (!isSulfuras) {
                item.sellIn -= 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackstagePass && item.quality > 0 && !isSulfuras) {
                                item.quality -= 1;
                    } else {
                        item.quality = 0;
                    }
                }
                else {
                    if (item.quality < 50) {
                        item.quality += 1;
                    }
                }
            }
        }
    }

    public void updateQualityNew(){
        for (Item item : items) {
            updateItem(item);
        }
    }

    //Kylie
    private void updateItem (Item item) {

        switch (item.name) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;

            case "Sulfuras, Hand of Ragnaros":
                // No qualities are changed.
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePass(item);
                break;

            default:
                updateStandardItem(item);
        }

    }

    //methods to update items
    private void updateStandardItem(Item item)
    {
        decreaseQuality(item);
    }
    private void updateAgedBrie(Item item) {
        increaseQuality(item);
    }

    private void updateBackstagePass(Item item) {
        increaseQuality(item);
        if (item.sellIn < 10) { increaseQuality(item);}
        if (item.sellIn < 5) { increaseQuality(item);}
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
        if (item.name.equals("Aged Brie")) {increaseQuality(item);}
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {item.quality = 0;}
        //calls decrease quality again, bc it degrades twice as 
        else {decreaseQuality(item);}
    }

//method to decrease the SellIn variable
    private void sellIn(Item item){
        item.sellIn--;
    }

    //Deo
    private void updateQuality2(){
        for(Item item:items){
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")){ // Sulfuras quality does not change
            updateItemQuality2(item);
            item.sellIn--;
            }
            if (item.sellIn<0) expiredItem(item);

        }
    }

    private void updateItemQuality2(Item item){
        if(item.name.equals("Aged Brie")||item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            increaseQuality(item);

        }
    }

    private void expiredItem (Item item){

    }
}

