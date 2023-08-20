package com.example.app;

import com.example.app.Appointments.DoctorAppointment;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

import  java.util.ArrayList;
import  java.util.List;
@Tag("see-scheduled-appointments")
@JsModule("./see-scheduled-appointments.ts")
@Route("see-scheduled-appointments")
public class SeeScheduledAppointments extends LitTemplate {


    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
    @Id("iconPosition")
    private HorizontalLayout iconPosition;
    private Admin admin;
    /**
     * Creates a new SeeScheduledAppointments.
     */
    public SeeScheduledAppointments() {
        admin = new Admin();

        Image image = new Image();
        image.setSrc("https://www.pngkey.com/maxpic/u2w7t4r5e6q8i1a9/https://www.pngkey.com/png/full/246-2461646_medical-appointment-icon.png");
        image.setWidth("100px");
        image.setHeight("100px");

        Grid<DoctorAppointment> myGrid = new Grid<DoctorAppointment>();
        myGrid.addColumn(DoctorAppointment::getAppointmentNumber).setHeader("Appointment Number");
        myGrid.addColumn(DoctorAppointment::getDate).setHeader("Appointment Date");
        myGrid.addColumn(DoctorAppointment::getStartTime).setHeader("Starting Time");
        myGrid.addColumn(DoctorAppointment::getEndTime).setHeader("Ending Time");
        myGrid.addColumn(DoctorAppointment::getStatus).setHeader("Status");
        myGrid.addColumn(DoctorAppointment::getDoctorName).setHeader("Doctor Name");

        List<DoctorAppointment> doctorAppointments = admin.getDoctorAppointments();
        myGrid.setItems(doctorAppointments);
        vaadinVerticalLayout.add(myGrid);
        vaadinVerticalLayout.add(myGrid);


        myGrid.addComponentColumn(DoctorAppointment::getButton);
        Image headingIcon = new Image();
        headingIcon.setSrc("https://img.icons8.com/external-flaticons-lineal-color-flat-icons/344/external-appointment-banking-flaticons-lineal-color-flat-icons.png");
        headingIcon.setWidth("50px");
        headingIcon.setHeight("50px");
        iconPosition.add(headingIcon);

      }

}