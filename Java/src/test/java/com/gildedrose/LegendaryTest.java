
package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class LegendaryTest {

    @Test
    public void testUpdate() {
        Item item = new Legendary("name", 3);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(3));
        assertThat(item.getQuality(), is(80));
    }

    @Test
    public void testUpdate_Expired() {
        Item item = new Legendary("name", 0);

        item.update();

        assertThat(item.getName(), is("name"));
        assertThat(item.getSellIn(), is(0));
        assertThat(item.getQuality(), is(80));
    }

}
