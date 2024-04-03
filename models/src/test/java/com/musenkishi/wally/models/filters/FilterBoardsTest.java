package com.musenkishi.wally.models.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FilterBoardsTest {

    @Test
    public void testGetFormattedValue() {
        // BVA
        // boolean inputs BCC (Base Choice Coverage)
        FilterBoards filterBoard1 = new FilterBoards(true, true, true);
        FilterBoards filterBoard2 = new FilterBoards(false, false, false);
        FilterBoards filterBoard3 = new FilterBoards(true, false, false);
        FilterBoards filterBoard4 = new FilterBoards(false, true, false);
        FilterBoards filterBoard5 = new FilterBoards(false, false, true);

        String expected1 = "111";
        String expected2 = "000";
        String expected3 = "100";
        String expected4 = "010";
        String expected5 = "001";

        // make sure the expected inputs are equal to the outputs
        assertEquals(expected1, filterBoard1.getFormattedValue());
        assertEquals(expected2, filterBoard2.getFormattedValue());
        assertEquals(expected3, filterBoard3.getFormattedValue());
        assertEquals(expected4, filterBoard4.getFormattedValue());
        assertEquals(expected5, filterBoard5.getFormattedValue());

        // paramValue inputs
        // should throw error
        // written like this to have the completed testing output
        boolean errorThrown = false;
        try {
            FilterBoards filterBoard6 = new FilterBoards(null);
        } catch(NullPointerException e) {
            errorThrown = true;
        }
        assertTrue("NullPointerException not Thrown", errorThrown);

        // should throw error
        errorThrown = false;
        try {
            FilterBoards filterBoard7 = new FilterBoards("00");
        } catch(StringIndexOutOfBoundsException e) {
            errorThrown = true;
        }
        assertTrue("StringIndexOutOfBoundsException not Thrown", errorThrown);

        FilterBoards filterBoard8 = new FilterBoards("101");
        FilterBoards filterBoard9 = new FilterBoards("1011");
        FilterBoards filterBoard10 = new FilterBoards("201");

        String expected8 = "101";
        String expected9 = "101";
        String expected10 = "001";

        assertEquals(expected8, filterBoard8.getFormattedValue());

        // should say too long string
        assertEquals(expected9, filterBoard9.getFormattedValue());

        // any input that isnt 1 is turned to a 0.
        assertEquals(expected10, filterBoard10.getFormattedValue());
    }
}