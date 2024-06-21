package org.example;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @Lethu Dlomo
 */

public class Login {

    //-declaring variables
    String  savedname ="lethu";
    String savedpassword="" ;


    //validate entered username
    public  boolean checkUserName(String user){

        if(!user.contains("_") ||  user.length()>5){
            return false;
        }
        else return true;
    }
    //validate entered password
    public  boolean checkPasswordComplexity(String password){
        if (password.length()<=8){
            return false;
        }
        int numberofdigits=0;
        int specialcharacter=0;
        int capitalletter=0;
        for(int i=0; i<password.length();i++){
            if(Character.isDigit(password.charAt(i))){
                numberofdigits++;
            }
            else if (Character.isAlphabetic(password.charAt(i))) {
                if (Character.isUpperCase(password.charAt(i))) {
                    capitalletter++;
                }
            }
            else {
                specialcharacter++;
            }
        }
        if(specialcharacter==0 || numberofdigits ==0 || capitalletter==0){
            return false;
        }
        else return true;
    }
    //checks if the username and password are vaild
    //if vaild, user is registered. if not,returns necessary message
    public    String registerUser(String firtsname, String lastname ,String name, String password){
        boolean correctUserName= checkUserName(name);
        boolean correctPassword= checkPasswordComplexity(password) ;
        //check username and password
        if( !correctUserName|| !correctPassword ){
            if (!correctUserName==true){
                return "Username is not correctly formatted, Please ensure that your username contains an under score and is no more than 5 characters and The password does not meet the complexity requirment";
            }
            else  {
                return "The password does not meet the complexity requirement";
            }
        }
        else{
            this.savedname =name;
            System.out.println("User name successfully captured");
            this.savedpassword=password;
            System.out.println("Password successfully captured");
            System.out.println("You have been registered successfully");

            return "Welcome  " + firtsname + " " + lastname+
                    " it is great to see you";
        }
    }
    //allows user to login if username and password are vaild or correct
    public  Boolean loginUser(String user,String password){
        if(savedname==user && savedpassword==password)
        {
            return true;
        }
        else {
            return false;
        }
    }

    //checks login status and returns necessary message
    public String returnLoginStatus(String user, String password){
        if(savedname==user && savedpassword==password)
        {
            return " successful login";
        }
        else {
            return " failed to login";
        }
    }
}