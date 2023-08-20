package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * A Designer generated component for the medical-historybypatient template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("medical-historybypatient")
@JsModule("./themes/eheal/medical-historybypatient.ts")
@Route("medicalhistorybypatiient")
public class MedicalHistorybypatient extends LitTemplate {

    @Id("statusRadioBoxLayout")
    private VerticalLayout statusRadioBoxLayout;
    @Id("medicalRecord")
    private MedicalRecordPage medicalRecordPage;
    @Getter
    private RadioButtonGroup<String> status;
    @Id("medicalHistoryImage")
    private HorizontalLayout medicalHistoryImage;
    @Id("vaadinButton")
    private Button vaadinButton;


    public MedicalHistorybypatient() {
        status = new RadioButtonGroup<String>();
        List<String> statusEnumeration = new ArrayList<String>();
        statusEnumeration.add("Cured");
        statusEnumeration.add("Satble and On-Medication");
        statusEnumeration.add("Not Cured and Not On-Medication");
        status.setItems(statusEnumeration);
        status.setVisible(true);
        statusRadioBoxLayout.add(status);
        statusRadioBoxLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        Image img = new Image();
        img.setSrc("https://img.freepik.com/free-vector/treatment-hospital-concept_485380-998.jpg?w=740");
        img.setWidth("300px");
        img.setHeight("300px");
        medicalHistoryImage.add(img);
        Admin admin = new Admin();

        vaadinButton.addClickListener(
                event->{
                    admin.addMedicalRecord(medicalRecordPage.getDiseaseName().getValue(),Integer.parseInt (medicalRecordPage.getOccurenceYear().getValue()),Integer.parseInt( medicalRecordPage.getOccurenceMonth().getValue()),status.getValue());
                    vaadinButton.getUI().ifPresent(ui->ui.navigate(HealthrecordPage2.class));
                }
        );
    }

}
