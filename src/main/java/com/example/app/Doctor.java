package com.example.app;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Route("Doctor")
public class Doctor extends Person{
    private String registrationNumber;
    private String specialization;
    private List<MedicalCentre> medicalCentres;
    private Admin admin;
    private Button viewButton;

    public Button getViewButton(){return viewButton;}
    public String getGender(){return super.getGender();}

    public Doctor(){
        admin = new Admin();
        viewButton = new Button("View");
        viewButton.addClickListener(event->{
            Dialog doctorDialog = new Dialog();
            VerticalLayout doctorDialogLayout = new VerticalLayout();


        HorizontalLayout horLayout = new HorizontalLayout();
        TextField nameField = new TextField();
        nameField.setLabel("Name");
        nameField.setValue(getFirstName() + " " + getLastName());
        nameField.setEnabled(false);
        horLayout.add(nameField);

       TextField phoneField = new TextField();
       phoneField.setValue(getPhoneNumber());
       phoneField.setLabel("Phone Number");
       phoneField.setEnabled(false);
       horLayout.add(phoneField);

        TextField emailField = new TextField();
        emailField.setValue(getEmail());
        emailField.setLabel("Email");
        emailField.setEnabled(false);
        horLayout.add(emailField);
        doctorDialogLayout.add(horLayout);
        Grid<MedicalCentre> medicalCentres = new Grid<MedicalCentre>();
        medicalCentres.addColumn(MedicalCentre::getName).setHeader("Name");
        medicalCentres.addColumn(MedicalCentre::getAddress).setHeader("Address");
        medicalCentres.addColumn(MedicalCentre::getType).setHeader("Type");
        medicalCentres.addColumn(MedicalCentre::getStartTime).setHeader("From");
        medicalCentres.addColumn(MedicalCentre::getEndTime).setHeader("To");

        medicalCentres.setItems(getMedicalCentres());
        doctorDialogLayout.setVisible(true);
        doctorDialogLayout.add(medicalCentres);

        Button bookAppointmentButton = new Button("Book Appointment");
        medicalCentres.addComponentColumn(MedicalCentre::getBookAppointmentButton);
        doctorDialog.add(doctorDialogLayout);



        doctorDialog.setSizeFull();
        doctorDialog.open();
        admin.setTempDoc(registrationNumber);


        });

        medicalCentres = new ArrayList<MedicalCentre>();
        registrationNumber = ""; specialization= "";

    }

    public String getSpecialization(){return specialization;}

    public String getPhoneNumber(){return super.getPhoneNumber();}

    public String getEmail(){return super.getEmail();}


    public List<MedicalCentre> getMedicalCentres(){
            return admin.getMedicalCentres(registrationNumber);
    }

    void setRegistrationNumber(String rN){
        this.registrationNumber = rN;
    }

    void setSpecialization(String sp){
        this.specialization = sp;
    }


    void setID(int Id){
        super.setID(Id);
    }
    public void setFirstName(String firstName){
        super.setFirstName(firstName);
    }


    public void setLastName(String lastName){
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

    public String getName(){
        return getFirstName() +" " +getLastName();
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
