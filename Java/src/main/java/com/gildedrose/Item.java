package com.gildedrose;

/*
 * TMH:
 * We can't change anything here according to the specs, but there are several improvements to be made:
 * - private attributes + getters
 * - rename 'sellIn' to 'daysToExpire'
 * - generate a toString that is more informative
 * - javadoc + unit tests
 */

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    /**
     * Updates Item SellIn and Quality.
     */
    public void update() {
        // TMH: we couldn't alter item but I figured adding extra functionality would be OK since it can't break old code. This function is the cleanest solution I think ...
        // TMH: I would make this an interface or abstract method but for backwards compatibility assume this is a normal item
        sellIn--;
        if (quality <= 0) {
            quality = 0;
            return; // quality can't degrade below 0
        }
        if (sellIn < 0) {
            quality -= 2;
        } else {
            quality--;
        }
    }

    /**
     * Gets the item name.
     *
     * @return the name
     */
    public String getName() {
        // TMH: we couldn't alter item but I figured adding extra functionality would be OK since it can't break old code.
        return name;
    }

    /**
     * Gets the the number of days we have to sell the item.
     *
     * @return the sellIn
     */
    public int getSellIn() {
        // TMH: we couldn't alter item but I figured adding extra functionality would be OK since it can't break old code.
        return sellIn;
    }

    /**
     * Gets the item quality.
     *
     * @return the quality
     */
    public int getQuality() {
        // TMH: we couldn't alter item but I figured adding extra functionality would be OK since it can't break old code.
        return quality;
    }

}
