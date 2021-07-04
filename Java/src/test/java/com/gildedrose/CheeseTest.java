package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CheeseTest {

    @Test
    public void testUpdate() {
        Item item = new Cheese("name", 3, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(2));
        assertThat(item.getQuality(), is(7));
    }

    @Test
    public void testUpdate_Expired() {
        Item item = new Cheese("name", 0, 6);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(-1));
        assertThat(item.getQuality(), is(8));
    }

    @Test
    public void testUpdate_QualityOver50() {
        Item item = new Cheese("name", 2, 50);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(1));
        assertThat(item.getQuality(), is(50));
    }

}
