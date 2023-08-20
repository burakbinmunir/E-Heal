package com.example.app;

import com.vaadin.flow.component.button.Button;

import java.sql.Time;
import java.util.List;

public class MedicalCentre {
    private String name;
    private String address;
    private List<String> offDays;
    private String type;
    private Time startTime;
    private Time endTime;
    private Button bookAppointmentButton;

    MedicalCentre(){
        name = ""; address = "";
        offDays = null; type = "";

        bookAppointmentButton = new Button("Book Appointment");
        bookAppointmentButton.addClickListener(event->{
            bookAppointmentButton.getUI().ifPresent(ui->ui.navigate(BookDocapp.class));

        });
    }

    public Time getStartTime(){return startTime;}
    public Time getEndTime(){return endTime;}

    public Button getBookAppointmentButton(){return bookAppointmentButton;}
    public void setAddress(String address){this.address = address;}
    public void setName(String name){this.name = name;}
    public void setOffDays(List<String> offDays){this.offDays = offDays;}
    public void setType(String type){this.type = type;}

    public String getAddress(){return address;}
    public String getName() {return name;}
    public String getType(){return type;}
    public List<String> getOffDays(){return offDays;}
    public void setStartTime(Time startTime){this.startTime = startTime;}
    public void setEndTime(Time endTime){this.endTime = endTime;}
}
