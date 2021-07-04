package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class GildedRoseTest {

    @Test
    public void testUpdateQuality() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Expired Item", 0, 7),
            new Item("Expired Item", -1, 7),
            new Item("Junk Item", 5, 0),
            new Item("Junk Item", -1, 1),
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items, is(not(nullValue())));
        assertThat(app.items, arrayWithSize(6));

        Item item1 = app.items[0];
        assertThat(item1.name, is("+5 Dexterity Vest"));
        assertThat(item1.sellIn, is(9));
        assertThat(item1.quality, is(19));

        Item item2 = app.items[1];
        assertThat(item2.name, is("Elixir of the Mongoose"));
        assertThat(item2.sellIn, is(4));
        assertThat(item2.quality, is(6));

        Item item3 = app.items[2];
        assertThat(item3.name, is("Expired Item"));
        assertThat(item3.sellIn, is(-1));
        assertThat(item3.quality, is(5));

        Item item4 = app.items[3];
        assertThat(item4.name, is("Expired Item"));
        assertThat(item4.sellIn, is(-2));
        assertThat(item4.quality, is(5));

        Item item5 = app.items[4];
        assertThat(item5.name, is("Junk Item"));
        assertThat(item5.sellIn, is(4));
        assertThat(item5.quality, is(0));

        Item item6 = app.items[5];
        assertThat(item6.name, is("Junk Item"));
        assertThat(item6.sellIn, is(-2));
        assertThat(item6.quality, is(0));
    }

    @Test
    public void testUpdateQuality_Cheese() {
        Item[] items = new Item[] {
            new Cheese("Aged Brie", 2, 0),
            new Cheese("Aged Brie", -1, 1), // expired
            new Cheese("Aged Brie", 2, 50), // high quality
            new Cheese("Aged Brie", 2, 51), // strange quality
            new Cheese("Aged Brie", -1, 50), // high quality + expired
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items, is(not(nullValue())));
        assertThat(app.items, arrayWithSize(5));

        Item item1 = app.items[0];
        assertThat(item1.name, is("Aged Brie"));
        assertThat(item1.sellIn, is(1));
        assertThat(item1.quality, is(1));

        Item item2 = app.items[1];
        assertThat(item2.name, is("Aged Brie"));
        assertThat(item2.sellIn, is(-2));
        assertThat(item2.quality, is(3));

        Item item3 = app.items[2];
        assertThat(item3.name, is("Aged Brie"));
        assertThat(item3.sellIn, is(1));
        assertThat(item3.quality, is(50));

        Item item4 = app.items[3];
        assertThat(item4.name, is("Aged Brie"));
        assertThat(item4.sellIn, is(1));
        assertThat(item4.quality, is(50)); // TMH: this has to be bug right? An item can't exceed a quality of 50 except a legendary.

        Item item5 = app.items[4];
        assertThat(item5.name, is("Aged Brie"));
        assertThat(item5.sellIn, is(-2));
        assertThat(item5.quality, is(50));
    }

    @Test
    public void testUpdateQuality_Legendary() {
        Item[] items = new Item[] {
            new Legendary("Sulfuras, Hand of Ragnaros", 0),
            new Legendary("Sulfuras, Hand of Ragnaros", -1),
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
            new Ticket("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Ticket("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            new Ticket("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            new Ticket("Backstage passes to a TAFKAL80ETC concert", 0, 20),
            new Ticket("Backstage passes to a TAFKAL80ETC concert", -1, 20),
            new Ticket("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Ticket("Backstage passes to a TAFKAL80ETC concert", 5, 50),
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items, is(not(nullValue())));
        assertThat(app.items, arrayWithSize(7));

        Item item1 = app.items[0];
        assertThat(item1.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item1.sellIn, is(14));
        assertThat(item1.quality, is(21));

        Item item2 = app.items[1];
        assertThat(item2.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item2.sellIn, is(9));
        assertThat(item2.quality, is(22));

        Item item3 = app.items[2];
        assertThat(item3.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item3.sellIn, is(2));
        assertThat(item3.quality, is(23));

        Item item4 = app.items[3];
        assertThat(item4.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item4.sellIn, is(-1));
        assertThat(item4.quality, is(0));

        Item item5 = app.items[4];
        assertThat(item5.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item5.sellIn, is(-2));
        assertThat(item5.quality, is(0));

        Item item6 = app.items[5];
        assertThat(item6.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item6.sellIn, is(9));
        assertThat(item6.quality, is(50));

        Item item7 = app.items[6];
        assertThat(item7.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item7.sellIn, is(4));
        assertThat(item7.quality, is(50));
    }

    @Test
    public void testUpdateQuality_Conjured() {
        Item[] items = new Item[] {
            new Conjured("Conjured Mana Cake", 3, 6),
            new Conjured("Conjured Mana Cake", 0, 6)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items, is(not(nullValue())));
        assertThat(app.items, arrayWithSize(2));

        Item item1 = app.items[0];
        assertThat(item1.name, is("Conjured Mana Cake"));
        assertThat(item1.sellIn, is(2));
        assertThat(item1.quality, is(4));

        Item item2 = app.items[1];
        assertThat(item2.name, is("Conjured Mana Cake"));
        assertThat(item2.sellIn, is(-1));
        assertThat(item2.quality, is(2));
    }

    @Test
    public void testUpdateQuality_StrangeItems() {
        Item[] items = new Item[] {
            new Item("Item", 3, -1), // items do not have negative quality normally
            new Cheese("Aged Brie", 2, -1), // items do not have negative quality normally
            new Ticket("Backstage passes to a TAFKAL80ETC concert", 5, -1), // items do not have negative quality normally
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 60), // items do not have quality >50
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items, is(not(nullValue())));
        assertThat(app.items, arrayWithSize(4));

        // I don't know what should happen, but it shouldn't crash at least
    }

    @Test
    public void testUpdateQuality_NullItems() {
        GildedRose app = new GildedRose(null);

        app.updateQuality();

        // assert no exception
    }

    @Test
    public void testUpdateQuality_NullItem() {
        Item[] items = new Item[] {
                new Item("Item", 3, 2),
                null,
                new Item("Item", 1, 1),
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        // assert no exception
    }

}
