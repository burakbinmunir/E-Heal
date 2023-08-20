package com.example.app.Appointments;

import com.example.app.Admin;
import com.example.app.Patient;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
    private Time startTime;
    private Time endTime;
    private int appointmentNumber;
    private int status;
    private Date date;
    private Patient patient;
    private Admin admin;

    Appointment (){
        startTime = null; endTime = null;
        appointmentNumber= 0; status = 0;
        date= null; patient = null;
        admin = new Admin();
    }

    public Date getDate() {return date;}
    public Time getStartTime() {return startTime;}
    public Time getEndTime(){return endTime;}
    public int getAppointmentNumber(){return appointmentNumber;}
    public int returnStatus(){return status;}
    public String getStatus() {
        if (status == 0) {
            return "Pending";
        }
        if (status == 1) {
            return "Approved";
        }

        if (status == 2) {
            return "Cancelled";
        }

        if (status == 3) {
            return "Reschedule";
        }
        return "";
    }

    public void setStartTime(Time startTime){this.startTime = startTime;}
    public void setEndTime(Time endTime ){this.endTime = endTime;}
    public void setAppointmentNumber(int appointmentNumber){this.appointmentNumber = appointmentNumber;}
    public void setStatus(int status){this.status = status;}
    public void setDate(Date date){this.date = date;}


}
