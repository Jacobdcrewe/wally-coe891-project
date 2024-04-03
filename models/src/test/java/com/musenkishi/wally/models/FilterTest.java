package com.musenkishi.wally.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilterTest {

    @Test
    public void testEquals() {
        System.out.println("TESTING: Filter.equals");

        // Initialize same filters
        Filter<String, Integer> filter1 = new Filter<>("key1", 10, true);
        Filter<String, Integer> filter2 = new Filter<>("key1", 10, true);

        // Create different filters
        // isCustom differs
        Filter<String, Integer> filter3 = new Filter<>("key1", 10, false);
        // key differs
        Filter<String, Integer> filter4 = new Filter<>("key2", 10, true);
        // value differs
        Filter<String, Integer> filter5 = new Filter<>("key1", 11, true);
        // object is different class
        int differentObjectType = 1;

        // filters with all null attributes (boolean cant be null)
        Filter<String, Integer> filter6 = new Filter<>(null, null);
        Filter<String, Integer> filter7 = new Filter<>(null, null);

        // both instances are null
        Filter<String, Integer> filter8 = null;
        Filter<String, Integer> filter9 = null;

        // null keys
        Filter<String, Integer> filter10 = new Filter<>(null, 10, true);
        // null values
        Filter<String, Integer> filter11 = new Filter<>("key1", null, true);


        // same object
        assertTrue(filter1.equals(filter1));

        // different object, correct type, same attributes
        assertTrue(filter1.equals(filter2));

        // wrong type
        assertFalse(filter1.equals(differentObjectType));

        // null object
        assertFalse(filter1.equals(null));

        // different attributes
        assertFalse(filter1.equals(filter3));
        assertFalse(filter1.equals(filter4));
        assertFalse(filter1.equals(filter5));
        assertFalse(filter1.equals(filter6));

        // both instances have all null attributes
        assertTrue(filter6.equals(filter7));

        // both instances are null
        // should throw error
        // written like this to have the completed testing output
        boolean errorThrown = false;
        try {
            filter8.equals(filter9);
        } catch(NullPointerException e) {
            errorThrown = true;
        }
        assertTrue("NullPointerException not Thrown", errorThrown);

        // test null key with non null key (and value)
        assertFalse(filter10.equals(filter1));
        assertFalse(filter11.equals(filter1));

        System.out.println("COMPLETED TESTING: Filter.equals");
    }

    @Test
    public void testHashCode() {
        System.out.println("TESTING: Filter.hashCode()");

        Filter<String, Integer> filter1 = new Filter<>("key", 1, true);
        Filter<String, Integer> filter2 = new Filter<>(null, 1, true);
        Filter<String, Integer> filter3 = new Filter<>("key", null, true);
        Filter<String, Integer> filter4 = new Filter<>("key", 1, false);

        // testing expected outputs for mutation testing
        int expectedHashCode1 = 101941951;
        int expectedHashCode2 = 32;
        int expectedHashCode3 = 101941920;
        int expectedHashCode4 = 101941950;

        // check for not null when key and value not null and isCustom true
        assertEquals(expectedHashCode1, filter1.hashCode());

        // check for not null when key null
        assertEquals(expectedHashCode2, filter2.hashCode());

        // check for not null on null value
        assertEquals(expectedHashCode3, filter3.hashCode());

        // check for not null when isCustom false
        assertEquals(expectedHashCode4, filter4.hashCode());

        // Additional checks to ensure the hashCodes are different for different objects
        assertNotEquals(filter1.hashCode(), filter2.hashCode());
        assertNotEquals(filter1.hashCode(), filter3.hashCode());
        assertNotEquals(filter1.hashCode(), filter4.hashCode());
        assertNotEquals(filter2.hashCode(), filter3.hashCode());
        assertNotEquals(filter2.hashCode(), filter4.hashCode());
        assertNotEquals(filter3.hashCode(), filter4.hashCode());

        System.out.println("COMPLETED TESTING: Filter.hashCode()");
    }



}