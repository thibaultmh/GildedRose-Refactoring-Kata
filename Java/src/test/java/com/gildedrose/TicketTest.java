/* Copyright 2021 MIPS NV. All rights reserved. */

package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TicketTest {

    @Test
    public void testUpdate() {
        Item item = new Ticket("name", 20, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(19));
        assertThat(item.getQuality(), is(7));
    }

    @Test
    public void testUpdate_Lessthan10() {
        Item item = new Ticket("name", 10, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(9));
        assertThat(item.getQuality(), is(8));
    }

    @Test
    public void testUpdate_Lessthan5() {
        Item item = new Ticket("name", 5, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(4));
        assertThat(item.getQuality(), is(9));
    }

    @Test
    public void testUpdate_Expired() {
        Item item = new Ticket("name", 0, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(-1));
        assertThat(item.getQuality(), is(0));
    }

    @Test
    public void testUpdate_QualityOver50() {
        Item item1 = new Ticket("name", 20, 49);
        Item item2 = new Ticket("name", 10, 49);
        Item item3 = new Ticket("name", 5, 49);

        item1.update();
        item2.update();
        item3.update();

        assertThat(item1.getQuality(), is(50));
        assertThat(item2.getQuality(), is(50));
        assertThat(item3.getQuality(), is(50));
    }

}
