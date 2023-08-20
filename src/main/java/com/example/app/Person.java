package com.example.app;

import com.vaadin.flow.component.html.Image;

import java.sql.Date;

public class Person {
    private String firstName;
    private String lastName;
    private String CNIC;
    private String phoneNumber;
    private String email;
    private Image recentPicture;
    private Date dateOfBirth;
    private String gender;
    private String securityQuestion;
    private String answerToSecurityQuestion;
    private String username;
    private String password;
    private int personID;
    
    public String getLastName() {return lastName;}
    public String getName(){
        return (firstName + " " + lastName);
    }


    Person(){
        firstName = ""; lastName = ""; CNIC = "";
        phoneNumber = ""; email = "";  dateOfBirth = null;
        gender = ""; securityQuestion = "";  answerToSecurityQuestion = "";
        username = ""; password = ""; personID = 0;
    }

    public String getUserName(){return username;}
    public String getPhoneNumber(){return phoneNumber;}

    public String getEmail(){return email;}

        void setFirstName(String firstName){
            this.firstName = firstName;
        }

        String getFirstName(){
            return firstName;
        }

        void setLastName(String lastName){
            this.lastName = lastName;
        }

        void setEmail(String email){
            this.email = email;
        }

        void setPhoneNumber (String phoneNumber){
            this.phoneNumber = phoneNumber;
        }

        void setDateOfBirth(Date dateOfBirth){
            this.dateOfBirth = dateOfBirth;
        }

        void setID(int id){
            this.personID = id;
        }

        void setGender (String gender){
            this.gender = gender;
        }

        void setSecurityQuestion(String securityQuestion){
            this.securityQuestion = securityQuestion;
        }

        void setAnswerToSecurityQuestion(String answerToSecurityAnswer){
            this.answerToSecurityQuestion = answerToSecurityAnswer;
        }

        void setCNIC(String CNIC){
            this.CNIC = CNIC;
        }

        void setUsername(String username){
            this.username = username;
        }

        void setPassword(String password){
            this.password = password;
        }

    public String getGender() {
        return gender;
    }
}
