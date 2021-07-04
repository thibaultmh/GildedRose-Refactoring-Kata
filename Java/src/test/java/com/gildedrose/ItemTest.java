/* Copyright 2021 MIPS NV. All rights reserved. */

package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ItemTest {

    @Test
    public void testUpdate() {
        Item item = new Item("name", 3, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(2));
        assertThat(item.getQuality(), is(5));
    }

    @Test
    public void testUpdate_Expired() {
        Item item = new Item("name", 0, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(-1));
        assertThat(item.getQuality(), is(4));
    }

    @Test
    public void testUpdate_NegativeQuality() {
        Item item1 = new Item("name", 2, 0);
        Item item2 = new Item("name", -1, 0);
        Item item3 = new Item("name", -1, 1);

        item1.update();
        item2.update();
        item3.update();

        assertThat(item1.getQuality(), is(0));
        assertThat(item2.getQuality(), is(0));
        assertThat(item3.getQuality(), is(0));
    }

}
