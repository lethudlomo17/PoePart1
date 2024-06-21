package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int totalDuration = 0;
    private static int taskNumberCounter = 0;
    public void inputTaskDetails() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        int taskNumber = taskNumberCounter++;
        //JOptionPane.showMessageDialog(null, "Auto-generated Task Number: " + taskNumber, "Task Number", JOptionPane.INFORMATION_MESSAGE);
        boolean validDescription = false;
        String taskDescription;
        do {
            taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
            validDescription = checkTaskDescription(taskDescription);
        } while (!validDescription);
        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details:");
        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
        String taskID = createTaskID(taskName, taskNumber,developerDetails);
        //JOptionPane.showMessageDialog(null, "Auto-generated Task ID: " + taskID, "Task ID", JOptionPane.INFORMATION_MESSAGE);
        String [] statusOptions = {"To do","Done", "Doing"};
        int statusChoice = JOptionPane.showOptionDialog(null, "Select Task Status:", "Task Status",
                            JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, statusOptions,statusOptions[0]);
        String status = statusOptions[statusChoice];
        Task task = new Task(status, developerDetails, taskNumber, taskName, taskDescription, taskID, duration);
        tasks.add(task);
        totalDuration += duration;

        JOptionPane.showMessageDialog(null, task.toString(), "Task Details", JOptionPane.INFORMATION_MESSAGE);
    }
    public String createTaskID(String taskName, int taskNumber, String developerDetails){
        String taskNamePart;
        if(taskName.length() >= 2){
            taskNamePart = taskName.substring(0,2).toUpperCase();
        }
        else{
            taskNamePart = taskName.toUpperCase();
        }
        String developerPart;
        if(developerDetails.length()>=3){
            developerPart = developerDetails.substring(developerDetails.length()-3).toUpperCase();
        }
        else {
            developerPart = developerDetails.toUpperCase();
        }
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }
    public boolean checkTaskDescription(String taskDescription){
        if(taskDescription.length()> 50){
            JOptionPane.showMessageDialog(null, "Please enter a task description of less" +
                    " 50 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            JOptionPane.showMessageDialog(null, "Task successsfully captured", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        return true;
    }
    public int returnTotalHours() {
        JOptionPane.showMessageDialog(null, "Total Duration: " + totalDuration + " hours", "Total Duration", JOptionPane.INFORMATION_MESSAGE);
        return totalDuration;
    }
    public void displayTasks() {
        // Implement functionality to display tasks (coming soon)
        JOptionPane.showMessageDialog(null, "Coming soon.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        Main manager = new Main();
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        boolean quit = false;
        do{
            String[] options = {"Add Task", "Show report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Menu:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    manager.inputTaskDetails();
                    break;
                case 1:
                    manager.displayTasks();
                    break;
                case 2:
                    quit = true;
                    break;
                default:
                    // Handle unexpected choices
                    JOptionPane.showMessageDialog(null, "Invalid choice.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
            if(!quit && choice !=1){
                manager.returnTotalHours();

            }
        } while(!quit);
    }
}
