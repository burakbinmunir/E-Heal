package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;


import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.sql.Date;


/**
 * A Designer generated component for the person-signup template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("person-signup")
@JsModule("./person-signup.ts")
@Route(value = "personSignUp")
public class PersonSignup<Item> extends LitTemplate {


    @Id("firstName")
    public TextField firstName;
    @Id("lastName")
    private TextField lastName;
    @Id("dateOfBirth")
    private DatePicker dateOfBirth;
    @Id("email")
    private TextField email;
    @Id("phoneNumber")
    private TextField phoneNumber;
    @Id("securityQuestion")
    private TextField securityQuestion;
    @Id("answerToSecurityQuestion")
    private TextField answerToSecurityQuestion;
    @Id("userName")
    private TextField userName;
    @Id("password")
    private PasswordField password;

    @Id("personalDetails")
    private AccordionPanel personalDetails;
    @Id("personalDetailsLayout")
    private HorizontalLayout personalDetailsLayout;
    private CheckboxGroup<String> genderBox;
    @Id("cnic")
    private TextField cnic;

    /**
     * Creates a new PersonSignup.
     */
    public PersonSignup() {
        personalDetails.setOpened(true);
        genderBox = new CheckboxGroup<>();
        genderBox.setLabel("Gender");
        genderBox.setItems("Male", "Female", "Others");
        personalDetailsLayout.add(genderBox);
    }

    public String getFirstName(){ return firstName.getValue();}

    public String getGender(){return String.valueOf(genderBox.getSelectedItems());}

    public String getUsername(){ return userName.getValue();}

    public String getPassword(){ return password.getValue();}

    public String getPhoneNumber() {return phoneNumber.getValue();}

    public Date getDOB(){return Date.valueOf(dateOfBirth.getValue());}

    public String getEmail(){return email.getValue();}

    public String getCNIC(){ return cnic.getValue();}

    public String getSecurityQuestion(){return securityQuestion.getValue();}

    public String getAnswerToSQ(){return answerToSecurityQuestion.getValue();}


    public String getLastName(){
        return lastName.getValue();
    }


}
