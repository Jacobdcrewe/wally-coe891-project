package com.musenkishi.wally.models;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.ArrayList;
import com.musenkishi.wally.models.*;
import com.musenkishi.wally.models.filters.*;

public class ListFilterGroupTest {

    private ListFilterGroup listFilterGroup;
    private static final String FILTER_ONE = "filterOne";
    private static final String FILTER_TWO = "filterTwo";

    @Before
    public void setUp() {
        listFilterGroup = new ListFilterGroup("testTag",
                new ArrayList<>(Arrays.asList(new Filter<>(FILTER_ONE, FILTER_ONE),
                        new Filter<>(FILTER_TWO, FILTER_TWO))));
    }

    // Input Space Partitioning / Boundary Value Analysis
    @Test
    public void testGetFilterAtBoundary() {
        assertNotNull(listFilterGroup.getFilter(0));
        assertNotNull(listFilterGroup.getFilter(1));
        try {
            listFilterGroup.getFilter(-1);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e.getMessage());
        }
        try {
            listFilterGroup.getFilter(2);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e.getMessage());
        }
    }

    // Graph-based testing & Logic-based Testing
    @Test
    public void testLogicOfGettingAndSettingSelectedOption() {
        Filter<String, String> expectedFilter = new Filter<>(FILTER_ONE, FILTER_ONE);
        listFilterGroup.setSelectedOption(expectedFilter);
        Filter<String, String> filter = listFilterGroup.getSelectedFilter();
        assertEquals(expectedFilter, filter);
    }

    // Mutation Testing
    @Test
    public void testMutationOfFiltersList() {
        int originalSize = listFilterGroup.getFilters().size();
        listFilterGroup.getFilters().add(new Filter<>("filterThree", "filterThree"));
        assertEquals(originalSize + 1, listFilterGroup.getFilters().size());
    }
}
