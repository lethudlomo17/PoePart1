package org.example;

import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Main {
    private ArrayList<String> developers = new ArrayList<>();
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<Integer> taskDurations = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();
    private int totalDuration = 0;
    private static int taskNumberCounter = 0;
    ArrayList<String> getDevelopers() {
        return developers;
    }

    public void populateTestData() {
        // Task 1
        developers.add("Mike Smith");
        taskNames.add("Create Login");
        taskDurations.add(5);
        taskStatuses.add("To Do");
        taskIDs.add(createTaskID("Create Login", taskNumberCounter++, "Mike Smith"));

        // Task 2
        developers.add("Edward Harrison");
        taskNames.add("Create Add Features");
        taskDurations.add(8);
        taskStatuses.add("Doing");
        taskIDs.add(createTaskID("Create Add Features", taskNumberCounter++, "Edward Harrison"));

        // Task 3
        developers.add("Samantha Paulson");
        taskNames.add("Create Reports");
        taskDurations.add(2);
        taskStatuses.add("Done");
        taskIDs.add(createTaskID("Create Reports", taskNumberCounter++, "Samantha Paulson"));

        // Task 4
        developers.add("Glenda Oberholzer");
        taskNames.add("Add Arrays");
        taskDurations.add(11);
        taskStatuses.add("To Do");
        taskIDs.add(createTaskID("Add Arrays", taskNumberCounter++, "Glenda Oberholzer"));

        totalDuration = 5 + 8 + 2 + 11;
    }
    public void inputTaskDetails() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        taskNames.add(taskName);
        int taskNumber = taskNumberCounter++;
        boolean validDescription = false;
        String taskDescription;
        do {
            taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
            validDescription = checkTaskDescription(taskDescription);
        } while (!validDescription);
        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details:");
        developers.add(developerDetails);
        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
        taskDurations.add(duration);
        String taskID = createTaskID(taskName, taskNumber, developerDetails);
        taskIDs.add(taskID);
        String[] statusOptions = {"To do", "Done", "Doing"};
        int statusChoice = JOptionPane.showOptionDialog(null, "Select Task Status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, statusOptions, statusOptions[0]);
        String status = statusOptions[statusChoice];
        taskStatuses.add(status);

        totalDuration += duration;

        JOptionPane.showMessageDialog(null, "Task successfully captured", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private String createTaskID(String taskName, int taskNumber, String developerDetails) {
        String taskNamePart;
        if (taskName.length() >= 2) {
            taskNamePart = taskName.substring(0, 2).toUpperCase();
        } else {
            taskNamePart = taskName.toUpperCase();
        }
        String developerPart;
        if (developerDetails.length() >= 3) {
            developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        } else {
            developerPart = developerDetails.toUpperCase();
        }
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }

    private boolean checkTaskDescription(String taskDescription) {
        if (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public int returnTotalHours() {
        JOptionPane.showMessageDialog(null, "Total Duration: " + totalDuration + " hours", "Total Duration", JOptionPane.INFORMATION_MESSAGE);
        return totalDuration;
    }

    public void displayDoneTasks() {
        System.out.println("Tasks with status 'Done':");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase("Done")) {
                System.out.println("Developer: " + developers.get(i));
                System.out.println("Task Name: " + taskNames.get(i));
                System.out.println("Task Duration: " + taskDurations.get(i) + " hours");
                System.out.println("Status: " + taskStatuses.get(i));
                System.out.println("------------------------");
            }
        }
    }
    String displayLongestTaskDuration() {
        int maxDuration = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < taskNames.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                index = i;
            }
        }

        if (index != -1) {
            System.out.println(""+developers.get(index) + "," + taskDurations.get(index));
            return ""+developers.get(index) + "," + taskDurations.get(index);
        } else {
            System.out.println("No tasks found.");
            return "No tasks found.";
        }
    }
    ArrayList<String> searchTaskByName(String taskName) {
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                results.add(developers.get(i) + "," + taskName);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' Found.", "Success", JOptionPane.INFORMATION_MESSAGE);

                break; // assuming task names are unique, can remove break if not
            }
        }
        if (results.isEmpty()) {
            results.add("Task with name '" + taskName + "' not found.");
            JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.", "Failure", JOptionPane.INFORMATION_MESSAGE);

        }
        return results;
    }
    ArrayList<String> searchTasksByDeveloper(String developerDetails) {
        ArrayList<String> results = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developerDetails)) {
                results.add(taskNames.get(i));
                JOptionPane.showMessageDialog(null, "Developer '" + developerDetails + "' Found.", "Success", JOptionPane.INFORMATION_MESSAGE);

                found = true;
                // Can continue to find all tasks assigned to the developer
            }
        }
        if (!found) {
            results.add("No tasks assigned to developer '" + developerDetails + "'.");
            JOptionPane.showMessageDialog(null, "Developer '" + developerDetails + "' not found.", "Success", JOptionPane.INFORMATION_MESSAGE);

        }
        return results;
    }
    boolean deleteTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                taskNames.remove(i);
                developers.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                taskIDs.remove(i);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }
    String developerArrayCorrectlyPopulated() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            if(i == taskNames.size() -1 ){
                report.append(developers.get(i));
                System.out.println(developers.get(i));
            }
            else{
                report.append(developers.get(i)).append(" ,");
                System.out.println(developers.get(i));
            }
        }
        return report.toString();
    }

    public static void main(String[] args) {
        Main manager = new Main();
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        boolean quit = false;
        do {
            String[] options = {"Add Task", "Show report", "Delete Task", "Show all tasks", "Search Task by Name", "Search Tasks by Developer", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Menu:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    manager.inputTaskDetails();
                    break;
                case 1:
                    manager.displayDoneTasks();
                    manager.displayLongestTaskDuration();
                    manager.returnTotalHours();
                    break;
                case 2:
                    String taskNameToDelete = JOptionPane.showInputDialog("Enter Task Name to delete:");
                    manager.deleteTaskByName(taskNameToDelete);
                    break;
                case 3:
                    manager.developerArrayCorrectlyPopulated();
                    break;
                case 4:
                    String taskNameToSearch = JOptionPane.showInputDialog("Enter Task Name to search:");
                    manager.searchTaskByName(taskNameToSearch);
                    break;
                case 5:
                    String developerToSearch = JOptionPane.showInputDialog("Enter Developer Name to search:");
                    manager.searchTasksByDeveloper(developerToSearch);
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (!quit);
    }
}