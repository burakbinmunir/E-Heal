package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;


@Tag("display-patientoptions")
@JsModule("./display-patientoptions.ts")
@Route("patientoptionsdiplay")
public class DisplayPatientoptions extends LitTemplate {

    @Id("bookAppointmentLayout")
    private VerticalLayout bookAppointmentLayout;
    @Id("viewAppointmentLayout")
    private VerticalLayout viewAppointmentLayout;
    @Id("healthRecordLayout")
    private VerticalLayout healthRecordLayout;
    @Id("home")
    private VerticalLayout home;
    @Id("iconLayout")
    private VerticalLayout iconLayout;
    private Admin admin;
    @Id("orderMedicinesOnline")
    private VerticalLayout orderMedicinesOnline;
    @Id("firstAid")
    private VerticalLayout firstAid;

    void initializeBookAppointment(){

        Image homeImage = new Image();
        homeImage.setWidth("35px");
        homeImage.setHeight("35px");
        Icon icon = new Icon(VaadinIcon.SIGN_OUT);
        iconLayout.add(icon);
        iconLayout.setAlignItems(FlexComponent.Alignment.END);
        iconLayout.addClickListener(
             event-> {
                 admin.logout();
                 admin.removeUnderObservation();
                 admin.removeTempDoc();
                 iconLayout.getUI().ifPresent(ui->ui.navigate(LoginPage.class));
             }
        );
        homeImage.setSrc("https://img.freepik.com/free-vector/online-doctor-concept_52683-37472.jpg?t=st=1653406934~exp=1653407534~hmac=d3f6865050b6cb98913ded094f621591f8d0f5f0f7c41b0ea5fcc73b4208aebc&w=740");
        home.add(homeImage);
        home.addClickListener(
                event->
                {
                   home.getUI().ifPresent(ui->ui.navigate(DisplayPatientoptions.class));
                }
        );
        Image bookAppointmentImage = new Image();
        bookAppointmentImage.setSrc("https://img.freepik.com/free-vector/businessman-planning-events-deadlines-agenda_74855-6274.jpg?w=1060&t=st=1653115032~exp=1653115632~hmac=8a67094d90cbfe45de50cc221b7df799921cd4b08c3b46579985c968dc9abb51");
        bookAppointmentImage.setWidth("400px");
        bookAppointmentImage.setHeight("300px");
        bookAppointmentLayout.add(bookAppointmentImage);

        Label bookAppointmentLabel = new Label("Book Appointment");
        bookAppointmentLabel.setEnabled(true);
        bookAppointmentLayout.add(bookAppointmentLabel);

        bookAppointmentLayout.addClickListener(
                event->{
                    bookAppointmentLayout.getUI().ifPresent(ui->ui.navigate(SearchdoctorPage1.class));
                }
        );
    }

    void initializeViewAppointment(){
        Image viewAppointmentImage = new Image();
        viewAppointmentImage.setSrc("https://img.freepik.com/free-vector/employee-marking-deadline-day-man-with-pencil-appointing-date-event-making-note-calendar-vector-illustration-schedule-agenda-time-management_74855-8347.jpg?t=st=1653093635~exp=1653094235~hmac=551e746045344d0a5f418e02af9732dc67adfe58dde70748f0c2c300e5c29bf9&w=1380");
        viewAppointmentImage.setHeight("300px");
        viewAppointmentImage.setWidth("400px");
        viewAppointmentLayout.add(viewAppointmentImage);

        Label viewAppointmentLabel = new Label("View Appointments");
        viewAppointmentLayout.add(viewAppointmentLabel);
        viewAppointmentLayout.addClickListener(
                event->{viewAppointmentLayout.getUI().ifPresent(ui->ui.navigate(SeeScheduledAppointments.class));}
        );


    }

    void initializeMaintainHealthRecord(){
        Image healthRecordImage = new Image();
        healthRecordImage.setSrc("https://img.freepik.com/free-vector/doctor-technicians-discussing-medical-record_1262-19767.jpg?t=st=1653403717~exp=1653404317~hmac=bf0f0a20bb310076793623f4478f36be27cd9a5aa8337e749a3ff1d1307c4d23&w=1060");
        healthRecordImage.setWidth("400px");
        healthRecordImage.setHeight("300px");

        Label heathRecordLabel = new Label("Maintain Health Record");
        healthRecordLayout.add(healthRecordImage);
        healthRecordLayout.add(heathRecordLabel);

        healthRecordLayout.addClickListener(
                event->{
                    healthRecordLayout.getUI().ifPresent(ui->ui.navigate(HealthrecordPage2.class));
                });
    }

    void initializeOrderMedicinesOnline(){
        Image img = new Image();
        img.setSrc("https://img.freepik.com/free-vector/flat-online-pharmacy-store-person-holding-tablet-buying-medication-internet-hands-ordering-pills-drops-balm_102902-6183.jpg?w=1380");
        img.setHeight("300px");
        img.setWidth("400px");
        orderMedicinesOnline.add(img);

        Label label = new Label("Order Medicines Online");
        orderMedicinesOnline.add(label);

        orderMedicinesOnline.addClickListener(
                event->{
                    orderMedicinesOnline.getUI().ifPresent(ui->ui.navigate(AllPrescriptions.class));
                }
        );
    }


    public DisplayPatientoptions() {
        admin = new Admin();
        initializeBookAppointment();
        initializeViewAppointment();
        initializeMaintainHealthRecord();
        initializeOrderMedicinesOnline();
        Image img = new Image();
        img.setSrc("https://img.freepik.com/free-vector/medical-service-set-icons_24877-51551.jpg?t=st=1653623013~exp=1653623613~hmac=c6e3ba08b22801bd7ef56c862e7c88f927ec85025f77f50a64f8d7bd0bae2e31&w=740");
        img.setWidth("300px");
        img.setHeight("300px");
        Label label = new Label("See First Aid Measures");
        firstAid.add(img);
        firstAid.add(label);
        firstAid.addClickListener(
                e-> {
                    firstAid.getUI().ifPresent(ui -> ui.navigate(GetFirstaid.class));
                }
        );
    }

}
