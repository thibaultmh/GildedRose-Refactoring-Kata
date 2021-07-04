package com.gildedrose;

class GildedRose {
    /*
     * TMH:
     * According to specs we can't change this.
     * I would change it to a private List<Item> and a getter that returns an unmodifiable list.
     * Arrays are very inflexible and are mutable.
     */
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        if (items == null) {
            return;
        }
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item == null) {
                continue;
            }
            item.update();
        }
    }
}