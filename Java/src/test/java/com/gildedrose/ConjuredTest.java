package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ConjuredTest {

    @Test
    public void testUpdate() {
        Item item = new Conjured("name", 3, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(2));
        assertThat(item.getQuality(), is(4));
    }

    @Test
    public void testUpdate_Expired() {
        Item item = new Conjured("name", 0, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(-1));
        assertThat(item.getQuality(), is(2));
    }

    @Test
    public void testUpdate_NegativeQuality() {
        Item item1 = new Conjured("name", 2, 0);
        Item item2 = new Conjured("name", 2, 1);
        Item item3 = new Conjured("name", -1, 0);
        Item item4 = new Conjured("name", -1, 3);

        item1.update();
        item2.update();
        item3.update();
        item4.update();

        assertThat(item1.getQuality(), is(0));
        assertThat(item2.getQuality(), is(0));
        assertThat(item3.getQuality(), is(0));
        assertThat(item4.getQuality(), is(0));
    }

}
