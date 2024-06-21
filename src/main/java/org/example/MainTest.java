package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    private Main manager;

    @BeforeEach
    void setUp() {
        manager = new Main();
    }

    @Test
    void testCheckTaskDescriptionSuccessful() {
        // Success case: Description <= 50 characters
        boolean isValid = manager.checkTaskDescription("This is a valid description.");
        assertTrue(isValid);

    }
    @Test
    void testCheckTaskDescriptionFailed() {

        // Failure case: Description > 50 characters
        boolean isValid = manager.checkTaskDescription("This description is way too long to be valid, as it exceeds the fifty character limit imposed by the system.");
        assertFalse(isValid);

    }

    @Test
    void testCreateTaskID() {
        // Task ID for Test Case 1
        String taskID1 = manager.createTaskID("Login Feature", 1, "Robyn Harrison");
        assertEquals("LO:1:SON", taskID1);

        // Testing multiple Task IDs in a loop
        String[][] testData = {
                {"Create Report", "0", "Mike", "CR:0:IKE"},
                {"Create Report", "1", "Richard", "CR:1:ARD"},
                {"Create Report", "2", "Martha", "CR:2:THA"},
                {"Create Report", "3", "nd", "CR:3:ND"}
        };

        for (String[] data : testData) {
            String generatedTaskID = manager.createTaskID(data[0], Integer.parseInt(data[1]), data[2]);
            assertEquals(data[3], generatedTaskID);
        }
    }
}