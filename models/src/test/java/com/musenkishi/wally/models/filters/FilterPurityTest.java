package com.musenkishi.wally.models.filters;

import static org.junit.Assert.*;


import org.junit.Test;

public class FilterPurityTest {


    @Test
    public void getFormattedValueA() {
        FilterPurity obj;
        boolean sfw_check = true;
        boolean sketchy_check = true;

        obj = new FilterPurity(sfw_check, sketchy_check);
        assertEquals("110", obj.getFormattedValue());
    }

    @Test
    public void getFormattedValueB() {
        FilterPurity obj;
        boolean sfw_check = true;
        boolean sketchy_check = false;

        obj = new FilterPurity(sfw_check, sketchy_check);
        assertEquals("100", obj.getFormattedValue());
    }

    @Test
    public void getFormattedValueC() {
        FilterPurity obj;
        boolean sfw_check = false;
        boolean sketchy_check = true;

        obj = new FilterPurity(sfw_check, sketchy_check);
        assertEquals("010", obj.getFormattedValue());
    }

    @Test
    public void getFormattedValueD() {
        FilterPurity obj;
        boolean sfw_check = false;
        boolean sketchy_check = false;

        obj = new FilterPurity(sfw_check, sketchy_check);
        assertEquals("000", obj.getFormattedValue());
    }

    @Test()
    public void getFormattedValueA_complete() {
        FilterPurity obj;
        boolean sfw_check = true;
        boolean sketchy_check = true;
        obj = new FilterPurity(sfw_check, sketchy_check);

        assertNotEquals("000", obj.getFormattedValue());
        assertNotEquals("010", obj.getFormattedValue());
        assertNotEquals("100", obj.getFormattedValue());
    }

    @Test
    public void getFormattedValueB_complete() {
        FilterPurity obj;
        boolean sfw_check = true;
        boolean sketchy_check = false;
        obj = new FilterPurity(sfw_check, sketchy_check);

        assertNotEquals("000", obj.getFormattedValue());
        assertNotEquals("110", obj.getFormattedValue());
        assertNotEquals("010", obj.getFormattedValue());
    }

    @Test
    public void getFormattedValueC_complete() {
        FilterPurity obj;
        boolean sfw_check = false;
        boolean sketchy_check = true;
        obj = new FilterPurity(sfw_check, sketchy_check);

        assertNotEquals("000", obj.getFormattedValue());
        assertNotEquals("110", obj.getFormattedValue());
        assertNotEquals("100", obj.getFormattedValue());
    }

    @Test()
    public void getFormattedValueD_complete() {
        FilterPurity obj;
        boolean sfw_check = false;
        boolean sketchy_check = false;
        obj = new FilterPurity(sfw_check, sketchy_check);

        assertNotEquals("110", obj.getFormattedValue());
        assertNotEquals("010", obj.getFormattedValue());
        assertNotEquals("100", obj.getFormattedValue());
    }

    @Test
    public void equalsTest1() {
        FilterPurity obj = new FilterPurity("00");
        Object o = new Object();

        assertNotEquals(obj, o);

    }

    @Test
    public void equalsTest2() {
        FilterPurity obj = new FilterPurity("00");
        FilterPurity o = new FilterPurity("00");

        assertEquals(obj, o);
    }

    @Test
    public void equalsTest3() {
        FilterPurity obj = new FilterPurity(true, true);
        FilterPurity o = new FilterPurity(true, false);

        assertNotEquals(obj, o);
    }


}