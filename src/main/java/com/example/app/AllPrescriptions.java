package com.example.app;

import com.example.app.PatientPackage.Prescription;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the all-prescriptions template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("all-prescriptions")
@JsModule("./all-prescriptions.ts")
@Route("allprescription")
public class AllPrescriptions extends LitTemplate {

    @Id("prescriptionsLayout")
    private HorizontalLayout prescriptionsLayout;

    private Admin admin;

    public AllPrescriptions() {
        admin = new Admin();
        Grid<Prescription> prescriptionGrid = new Grid<Prescription>();
        prescriptionGrid.addColumn(Prescription::getAppointmentNumber).setHeader("Appointment Number");
        prescriptionGrid.addColumn(Prescription::getPrescribedDate).setHeader("Prescribed Date");
        prescriptionGrid.addComponentColumn(Prescription::getViewPrescriptionButton);
        prescriptionGrid.addComponentColumn(Prescription::getOrderButton);
        prescriptionGrid.setItems(admin.getPrescriptions());
        prescriptionsLayout.add(prescriptionGrid);
        prescriptionsLayout.setVisible(true);
    }

}
