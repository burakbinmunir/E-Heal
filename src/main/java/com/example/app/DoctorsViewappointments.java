package com.example.app;

import com.example.app.Appointments.PatientAppointment;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * A Designer generated component for the doctors-viewappointments template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("doctors-viewappointments")
@JsModule("./themes/eheal/doctors-viewappointments.ts")
@Route("viewappointmentsbysdoctor")
public class DoctorsViewappointments extends LitTemplate {

    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;
    private List<PatientAppointment> appointmentList;
    private Admin admin;
    public DoctorsViewappointments() {
        admin = new Admin();
        appointmentList = new ArrayList<PatientAppointment>();

        Grid<PatientAppointment> appointmentGrid = new Grid<PatientAppointment>();
        appointmentGrid.addColumn(PatientAppointment::getAppointmentNumber).setHeader("Appointment Number");
        appointmentGrid.addColumn(PatientAppointment::getPatientName).setHeader("Patient Name");
        appointmentGrid.addColumn(PatientAppointment::getDate).setHeader("Date");
        appointmentGrid.addColumn(PatientAppointment::getStartTime).setHeader("Start Time");
        appointmentGrid.addColumn(PatientAppointment::getEndTime).setHeader("End Time");
        appointmentGrid.addColumn(PatientAppointment::getStatus).setHeader("Current Status");
        appointmentGrid.addComponentColumn(PatientAppointment::getViewButton);

        appointmentGrid.setItems(admin.getCurretnDoctorAppointments());
        vaadinVerticalLayout.add(appointmentGrid);
    }

}
