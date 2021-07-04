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
        // TODO
    }

}
