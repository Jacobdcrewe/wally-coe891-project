package com.musenkishi.wally.models.filters;

import static org.junit.Assert.*;
import org.junit.Test;

public class FilterResOptTest {

    @Test
    public void ConstructorWithBooleansTest() {
        FilterResOpt filter = new FilterResOpt(true, false);
        assertTrue(filter.isExactly());
        assertFalse(filter.isAtLeast());
    }

    @Test
    public void ConstructorWithStringTest() {
        FilterResOpt filter = new FilterResOpt("eqeq");
        assertTrue(filter.isExactly());
        assertFalse(filter.isAtLeast());

        filter = new FilterResOpt("gteq");
        assertFalse(filter.isExactly());
        assertTrue(filter.isAtLeast());

        filter = new FilterResOpt("eqeqgteq");
        assertTrue(filter.isExactly());
        assertTrue(filter.isAtLeast());
    }

    @Test
    public void GetFormattedValueTest() {
        FilterResOpt filter = new FilterResOpt(true, false);
        assertEquals("eqeq", filter.getFormattedValue());

        filter = new FilterResOpt(false, true);
        assertEquals("gteq", filter.getFormattedValue());
    }

    @Test
    public void SettersTest() {
        FilterResOpt filter = new FilterResOpt(true, false);
        filter.setExactly(false);
        filter.setAtLeast(true);

        assertFalse(filter.isExactly());
        assertTrue(filter.isAtLeast());
    }

    @Test
    public void EqualsTest() {
        FilterResOpt filter1 = new FilterResOpt(true, false);
        FilterResOpt filter2 = new FilterResOpt(true, false);
        FilterResOpt filter3 = new FilterResOpt(false, true);

        assertEquals(filter1, filter2);
        assertNotEquals(filter1, filter3);
    }

    @Test
    public void HashCodeTest() {
        FilterResOpt filter1 = new FilterResOpt(true, false);
        FilterResOpt filter2 = new FilterResOpt(true, false);
        FilterResOpt filter3 = new FilterResOpt(false, true);

        assertEquals(filter1.hashCode(), filter2.hashCode());
        assertNotEquals(filter1.hashCode(), filter3.hashCode());
    }
}