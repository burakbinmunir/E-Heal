package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.Getter;

/**
 * A Designer generated component for the medical-record template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("medical-record")
@JsModule("./themes/eheal/medical-record.ts")
@Route("medicalrecord")
public class MedicalRecordPage extends LitTemplate {


    @Id("diseaseName")
    @Getter

    private TextField diseaseName;
    @Id("occurenceYear")
    @Getter
    private TextField occurenceYear;
    @Id("occurenceMonth")
    @Getter
    private TextField occurenceMonth;


    public MedicalRecordPage() {


    }

}
