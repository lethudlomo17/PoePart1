package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String user="leth_";
        String password="ABCDEFGHI,9";
        String myAnswer;

        Login login =new Login();
        myAnswer = login.registerUser(user, password);
        System.out.println(myAnswer);
    }
}