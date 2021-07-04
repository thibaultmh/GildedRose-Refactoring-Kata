package com.gildedrose;

/**
 * Ticket is an {@link Item} that increases in Quality as its SellIn value approaches.
 *
 * @author thibaultmh
 *
 */
public class Ticket extends Item {

    /**
     * Creates a ticket item.
     *
     * @param name item name
     * @param sellIn days to sell the item
     * @param quality quality of the item (0-50)
     */
    public Ticket(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        sellIn--;
        if (sellIn > 10) {
            quality++;
        } else if (sellIn > 5) {
            quality += 2;
        } else if (sellIn > 0) {
            quality += 3;
        } else {
            quality = 0;
        }
        if (quality >= 50) {
            quality = 50;
        }
    }

}
