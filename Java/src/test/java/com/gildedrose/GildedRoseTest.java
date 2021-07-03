package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class GildedRoseTest {

    @Test
    public void testUpdateQuality() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Elixir of the Mongoose", 5, 7)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items, is(not(nullValue())));
        assertThat(app.items, arrayWithSize(2));

        Item item1 = app.items[0];
        assertThat(item1.name, is("+5 Dexterity Vest"));
        assertThat(item1.sellIn, is(9));
        assertThat(item1.quality, is(19));

        Item item2 = app.items[1];
        assertThat(item2.name, is("Elixir of the Mongoose"));
        assertThat(item2.sellIn, is(4));
        assertThat(item2.quality, is(6));
    }

    @Test
    public void testUpdateQuality_Cheese() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].name, is("Aged Brie"));
        assertThat(app.items[0].sellIn, is(1));
        assertThat(app.items[0].quality, is(1));
    }

    @Test
    public void testUpdateQuality_Legendary() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items, is(not(nullValue())));
        assertThat(app.items, arrayWithSize(2));

        Item item1 = app.items[0];
        assertThat(item1.name, is("Sulfuras, Hand of Ragnaros"));
        assertThat(item1.sellIn, is(0));
        assertThat(item1.quality, is(80));

        Item item2 = app.items[1];
        assertThat(item2.name, is("Sulfuras, Hand of Ragnaros"));
        assertThat(item2.sellIn, is(-1));
        assertThat(item2.quality, is(80));
    }

    @Test
    public void testUpdateQuality_Ticket() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items, is(not(nullValue())));
        assertThat(app.items, arrayWithSize(3));

        Item item1 = app.items[0];
        assertThat(item1.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item1.sellIn, is(14));
        assertThat(item1.quality, is(21));

        Item item2 = app.items[1];
        assertThat(item2.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item2.sellIn, is(9));
        assertThat(item2.quality, is(50));

        Item item3 = app.items[2];
        assertThat(item3.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item3.sellIn, is(4));
        assertThat(item3.quality, is(50));
    }

    @Test
    public void testUpdateQuality_Conjured() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        throw new RuntimeException("TODO");
    }

}
