package com.gildedrose;

/**
 * Cheese is an {@link Item} that increases in Quality the older it gets.
 *
 * @author thibaultmh
 *
 */
public class Cheese extends Item {

    /**
     * Creates a cheese item.
     *
     * @param name item name
     * @param sellIn days to sell the item
     * @param quality quality of the item (0-50)
     */
    public Cheese(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        // TODO
    }

}
