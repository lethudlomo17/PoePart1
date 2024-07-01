package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MainTest {
    private Main manager;

    @BeforeEach
    void setUp() {
        manager = new Main();
        manager.populateTestData();
    }
    @Test
    void testDeveloperArrayCorrectlyPopulated() {
        String report = "Mike Smith ,Edward Harrison ,Samantha Paulson ,Glenda Oberholzer";
        System.out.println(manager.developerArrayCorrectlyPopulated());
        assertEquals(report, manager.developerArrayCorrectlyPopulated());
    }

    @Test
    void testDisplayLongestTaskDuration() {
        String longestTaskDetails = "Glenda Oberholzer,11";
        assertEquals(longestTaskDetails, manager.displayLongestTaskDuration());
    }

    @Test
    void testSearchTaskByName() {
        String searchResult = "Create Login";
        String expected = "Mike Smith" + "," +searchResult;
        assertEquals(expected, manager.searchTaskByName("Create Login").get(0));
        System.out.println(manager.searchTaskByName("Create Login").get(0));
    }

    @Test
    void testSearchTasksByDeveloper() {
        String expected = "Create Reports";
        assertEquals(expected, manager.searchTasksByDeveloper("Samantha Paulson").get(0));
        System.out.println(manager.searchTasksByDeveloper("Samantha Paulson").get(0));

    }

    @Test
    void testTotalTaskDuration() {
        assertEquals(26, manager.returnTotalHours());
    }

    @Test
    void testDeleteTaskByName() {
        String confirmationMessage = "Task 'Create Reports' deleted successfully.";
        assertEquals(true, manager.deleteTaskByName("Create Reports"));
    }

    @Test
    void testDisplayReport() {
        assertEquals("Mike Smith", manager.getDevelopers().get(0));
        assertEquals("Edward Harrison", manager.getDevelopers().get(1));
        assertEquals("Samantha Paulson", manager.getDevelopers().get(2));
        assertEquals("Glenda Oberholzer", manager.getDevelopers().get(3));
    }

}