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
}
