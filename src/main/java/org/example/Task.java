package org.example;



public class Task {
    private String status;
    private String developerDetails;
    private int taskNumber;
    private String taskName;
    private String taskDescription;
    private String taskID;
    private int duration;

    public Task(String status, String developerDetails, int taskNumber, String taskName, String taskDescription, String taskID, int duration) {
        this.status = status;
        this.developerDetails = developerDetails;
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskID = taskID;
        this.duration = duration;
    }

    @Override
    public String toString(){
        return "Task ID:" + taskID.toUpperCase() + "\nStatus: " + status + "\nDeveloper Details: "
                + developerDetails.toUpperCase() + "\nTask Number:" +taskNumber + "\nTask Name: "
                + taskName.toUpperCase() + "\nTask Description: " + taskDescription + "\nDuration: "
                + duration + "hours";
    }


}


