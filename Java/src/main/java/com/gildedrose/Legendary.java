package com.gildedrose;

/**
 * Legendary is an {@link Item} that never has to be sold or decreases in Quality. It has a fixed
 * Quality of {@link #LEGENDARY_QUALITY}.
 *
 * @author thibaultmh
 *
 */
public class Legendary extends Item {
    public static final int LEGENDARY_QUALITY = 80;

    /**
     * Creates a legendary item.
     *
     * @param name item name
     * @param sellIn days to sell the item
     */
    public Legendary(String name, int sellIn) {
        super(name, sellIn, LEGENDARY_QUALITY);
    }

    @Override
    public void update() {
        // empty
    }

}
