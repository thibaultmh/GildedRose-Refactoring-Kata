package com.gildedrose;

/**
 * Conjured is an {@link Item} that decreases in Quality twice as fast as normal items.
 *
 * @author thibaultmh
 *
 */
public class Conjured extends Item {

    /**
     * Creates a conjured item.
     *
     * @param name item name
     * @param sellIn days to sell the item
     * @param quality quality of the item (0-50)
     */
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        // TODO
    }
}
