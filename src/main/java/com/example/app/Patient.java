package com.example.app;

import java.sql.Date;

public class Patient extends Person {

    Patient(){
        super();
    }

    void setID(int Id){
        super.setID(Id);
    }
    void setFirstName(String firstName){
        super.setFirstName(firstName);
    }


    void setLastName(String lastName){
        super.setLastName(lastName);
    }

    void setEmail(String email){
        super.setEmail(email);
    }

    void setPhoneNumber (String phoneNumber){
        super.setPhoneNumber(phoneNumber);
    }

    void setDateOfBirth(Date dateOfBirth){
        super.setDateOfBirth(dateOfBirth);
    }

    void setGender (String gender){
        super.setGender(gender);
    }

    void setSecurityQuestion(String securityQuestion){
        super.setSecurityQuestion(securityQuestion);
    }

    void setAnswerToSecurityQuestion(String answerToSecurityAnswer){
        super.setAnswerToSecurityQuestion(answerToSecurityAnswer);
    }

    void setCNIC(String CNIC){
        super.setCNIC(CNIC);
    }

    void setUsername(String username){
        super.setUsername(username);
    }

    void setPassword(String password){
        super.setPassword(password);
    }

}




