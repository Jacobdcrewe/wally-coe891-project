package com.musenkishi.wally.models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;

public class ExceptionReporterTest {

    // Input Space Partitioning (ISP) with Boundary Value Analysis (BVA)
    @Test
    public void testExceptionReporterParameters() {
        ExceptionReporter reporter = new ExceptionReporter(this.getClass(), "Test Message", "Test Exception");
        assertEquals(this.getClass(), reporter.getFromClass());
        assertEquals("Test Message", reporter.getCustomMessage());
        assertEquals("Test Exception", reporter.getExceptionMessage());
    }

    // Logic-based Testing
    @Test
    public void testLogicalConditions() {
        ExceptionReporter reporter = new ExceptionReporter(
                ExceptionReporterTest.class, "Custom Message", "Exception Message");

        // Test logical conditions
        assertNotNull(reporter.getFromClass());
        assertNotNull(reporter.getCustomMessage());
        assertNotNull(reporter.getExceptionMessage());
    }

    // Mutation Testing
    @Test
    public void testMutation() throws NoSuchFieldException, IllegalAccessException {
        ExceptionReporter reporter = new ExceptionReporter(
                ExceptionReporterTest.class, "Custom Message", "Exception Message");

        // Use reflection to modify the private field customMessage
        Field field = ExceptionReporter.class.getDeclaredField("customMessage");
        field.setAccessible(true); // Allow access to private field
        field.set(reporter, "Mutated Message");

        // Check if the custom message has been mutated successfully
        assertEquals("Mutated Message", reporter.getCustomMessage());
    }
}
