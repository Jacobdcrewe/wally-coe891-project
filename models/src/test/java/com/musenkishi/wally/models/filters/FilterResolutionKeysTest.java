package com.musenkishi.wally.models.filters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.musenkishi.wally.models.Filter;

import org.junit.Test;

public class FilterResolutionKeysTest {
    // returns true if the value is within the list of filters. returns false if the input is not within.
    @Test
    public void testIsCustom() {
        System.out.println("TESTING: FilterResolutionKeys.isCustom()");
        // BVA test for string within list. string outside of list. one string in list one not. null values.
        // in list
        Filter<String, String> filter1 = new Filter<>("1024x768", "1024x768");
        assertTrue(FilterResolutionKeys.isCustom(filter1));

        // outside of list
        Filter<String, String> filter2 = new Filter<>("hello", "world");
        assertFalse(FilterResolutionKeys.isCustom(filter2));

        // first in second out
        Filter<String, String> filter3 = new Filter<>("1024x768", "world");
        // should be false bc key is first value value is second value and the value is what the check is based off
        assertFalse(FilterResolutionKeys.isCustom(filter3));

        // first out second in
        Filter<String,String> filter4 = new Filter<>("hello", "1024x768");
        // should be true bc key is first value value is second value and the value is what the check is based off
        assertTrue(FilterResolutionKeys.isCustom(filter4));

        // null values
        Filter<String, String> filter5 = null;
        // should throw error
        // written like this to have the completed testing output
        boolean errorThrown = false;
        try {
            FilterResolutionKeys.isCustom(filter5);
        } catch(NullPointerException e) {
            errorThrown = true;
        }
        assertTrue("NullPointerException not Thrown", errorThrown);

        Filter<String, String> filter6 = new Filter<>(null, null);
        errorThrown = false;
        try {
            FilterResolutionKeys.isCustom(filter6);
        } catch(NullPointerException e) {
            errorThrown = true;
        }
        assertTrue("NullPointerException not Thrown", errorThrown);



        System.out.println("COMPLETED TESTING: FilterResolutionKeys.isCustom()");
    }
}
