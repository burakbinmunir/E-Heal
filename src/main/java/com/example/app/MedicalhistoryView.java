package com.example.app;

import com.example.app.PatientPackage.MedicalRecord;
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
 * A Designer generated component for the medicalhistory-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("medicalhistory-view")
@JsModule("./themes/eheal/medicalhistory-view.ts")
@Route("medicalhistory")
public class MedicalhistoryView extends LitTemplate {

    @Id("layout")
    private VerticalLayout layout;
    private Admin admin;

    public MedicalhistoryView() {
        admin = new Admin();
        Grid<MedicalRecord> medicalRecordGird = new Grid<MedicalRecord>();
        medicalRecordGird.addColumn(MedicalRecord::getDiseaseName).setHeader("Disease Name");
        medicalRecordGird.addColumn(MedicalRecord::getOccurenceMonth).setHeader("Occurence Month");
        medicalRecordGird.addColumn(MedicalRecord::getOccurenceYear).setHeader("Occurence Year");
        medicalRecordGird.addColumn(MedicalRecord::getCurrentCondition).setHeader("Current Status");
        List<MedicalRecord> records = new ArrayList<MedicalRecord>();
        records = admin.getMedicalRecord();
        medicalRecordGird.setItems(records);
        layout.add(medicalRecordGird);
    }

}
