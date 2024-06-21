package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        String firstname= JOptionPane.showInputDialog("Enter your name");
        String lastname= JOptionPane.showInputDialog("Enter your lastname");
        String user= JOptionPane.showInputDialog("Enter your user name");
        String password= JOptionPane.showInputDialog("Enter your password");


        Login login= new Login();
        System.out.println(login.registerUser(firstname,lastname,user,password));

    }
}