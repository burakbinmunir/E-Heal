package com.example.app.Appointments;

import com.example.app.Admin;
import com.example.app.CancelAppointmentByPatient;
import com.example.app.Doctor;
import com.example.app.LoginPage;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;

import java.sql.Date;
import java.sql.Time;

public class DoctorAppointment extends Appointment{
    private String currentCondition;
    private Doctor doctor;
    private String doctorName;
    private  Button button;
    private Admin admin;
    public DoctorAppointment(){
        admin = new Admin();
        button  = new Button("View Appointment" ,  VaadinIcon.CALENDAR_CLOCK.create());
        button.addClickListener(
                event-> {
                    admin.keepUnderObservation(doctor.getName(), doctor.getSpecialization(),doctor.getPhoneNumber(),doctor.getEmail(),doctor.getGender(),"Nishat",getDate(),getStartTime(),getEndTime(),returnStatus(),getAppointmentNumber());
                    button.getUI().ifPresent(ui -> ui.navigate(CancelAppointmentByPatient.class));
                }
            );
        currentCondition = "";
    }

    public int returnStatus(){return super.returnStatus();}
    public Date getDate() {return super.getDate();}
    public Time getStartTime() {return super.getStartTime();}
    public Time getEndTime(){return super.getEndTime();}
    public int getAppointmentNumber(){return super.getAppointmentNumber();}
    public String getStatus() {return super.getStatus();}
    public String getDoctorName(){return doctor.getName();}

    public void setCurrentCondition(String currentCondition){
        this.currentCondition = currentCondition;
    }

    public void setDoctorFirstName(String firstName){
        doctor.setFirstName(firstName);
    }

    public void setDoctor(Doctor doc){
        this.doctor = doc;
    }

    public void setDoctorLastName(String lastName){
        doctor.setLastName(lastName);
    }

    public void setDate(Date date){super.setDate(date);}
    public void setStartTime(Time time){super.setStartTime(time);}
    public void setEndTime(Time time){super.setEndTime(time);}
    public void setAppointmentNumber(int appointmentNumber){super.setAppointmentNumber(appointmentNumber);}
    public void setStatus(int status){super.setStatus(status);}


    public Button getButton(){return button;}



}
