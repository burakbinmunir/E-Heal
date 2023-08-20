package com.example.app;

import com.example.app.Appointments.PatientAppointment;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * A Designer generated component for the view-approved-doctorappointments template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("view-approved-doctorappointments")
@JsModule("./view-approved-doctorappointments.ts")
@Route("viewapprovedappoontments")
public class ViewApprovedDoctorappointments extends LitTemplate {

    @Id("gridLayout")
    private HorizontalLayout gridLayout;
    private Admin admin;
     ViewApprovedDoctorappointments() {
         admin = new Admin();
         Grid<PatientAppointment> approvedAppointments = new Grid<PatientAppointment>();
         approvedAppointments.addColumn(PatientAppointment::getAppointmentNumber).setHeader("Appointment Number");
         approvedAppointments.addColumn(PatientAppointment::getPatientName).setHeader("Patient Name");
         approvedAppointments.addComponentColumn(PatientAppointment::getDiagnosePatientButton).setHeader("");

         List<PatientAppointment> foundAppointments = new ArrayList<PatientAppointment>();
         foundAppointments = admin.getApprovedAppointments();
         approvedAppointments.setItems(foundAppointments);

         gridLayout.add( approvedAppointments);
    }

}
