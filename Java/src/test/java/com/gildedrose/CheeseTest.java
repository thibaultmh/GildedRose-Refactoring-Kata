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
        Item item1 = new Cheese("name", 2, 50);
        Item item2 = new Cheese("name", -1, 50);
        Item item3 = new Cheese("name", -1, 49);

        item1.update();
        item2.update();
        item3.update();

        assertThat(item1.getQuality(), is(50));
        assertThat(item2.getQuality(), is(50));
        assertThat(item3.getQuality(), is(50));
    }

}
