package com.example.app;

import com.example.app.PatientPackage.Prescription;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.map.Assets;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the healthrecord-page2 template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("healthrecord-page2")
@JsModule("./themes/eheal/healthrecord-page2.ts")
@Route("healthrecordpage2")
public class HealthrecordPage2 extends LitTemplate {

    @Id("addNewRecord1")
    private VerticalLayout addNewRecord;
    @Id("viewMedicalHistory")
    private VerticalLayout viewMedicalHistory;
    private Admin admin;
    @Id("viewEhealHIstory")
    private VerticalLayout viewEhealHIstory;

    public void setViewEhealHIstory(){
        admin = new Admin();
        Image img = new Image();
        img.setSrc("https://img.freepik.com/free-vector/healthcare-smart-card-abstract-concept-illustration_335657-3843.jpg?t=st=1653619105~exp=1653619705~hmac=648d0e3ebfbc19fc831421495c10986f94a3d213c3f0eef56db7d26954f1acef&w=740");
        img.setWidth("400px");
        img.setHeight("300px");
        viewEhealHIstory.add(img);
        Label label = new Label("View Eheal Record");
        viewEhealHIstory.add(label);

        viewMedicalHistory.addClickListener(
                e->{
                    Dialog newDialog = new Dialog();
                    HorizontalLayout dlayout = new HorizontalLayout();
                    Grid<Prescription> grid = new Grid<Prescription>();
                    grid.addColumn(Prescription::getAppointmentNumber).setHeader("Appointment Number");
                    grid.addColumn(Prescription::getPrescribedDate).setHeader("Prescribed On");
                    grid.addColumn(Prescription::getDiseaseName).setHeader("Disease Name");
                    grid.addComponentColumn(Prescription::getViewPrescriptionButton);
                    grid.setItems(admin.getPrescriptions());
                    dlayout.add(grid);
                    Button backButton = new Button("Back");
                    backButton.addClickListener(ev->{
                        newDialog.close();
                    });
                    newDialog.add(dlayout);
                    newDialog.add(backButton);
                    newDialog.setSizeFull();
                    newDialog.isOpened();

                }
        );
    }

    public void initializeaddNewRecord(){
        Image addNewRecordImage = new Image();
        addNewRecordImage.setSrc("https://img.freepik.com/free-vector/healthcare-smart-card-abstract-concept-illustration-manage-patient-identity-practitioners-pharmacists-secure-access-medical-records-improved-communication_335657-884.jpg?t=st=1653619096~exp=1653619696~hmac=395ce53ab342dfa98791049a9033745bf7e6c40d7a3d8121c97b5a64ac20934e&w=740");
        addNewRecordImage.setWidth("400px");
        addNewRecordImage.setHeight("300px");
        addNewRecord.add(addNewRecordImage);
        Label newLabel = new Label("Add New Record");
        addNewRecord.add(newLabel);

        addNewRecord.addClickListener(
                event->{
                    addNewRecord.getUI().ifPresent(ui->ui.navigate(MedicalHistorybypatient.class));
                }
        );
    }

    void viewMedicalHistory(){
        Image viewMedicalHistoryImage = new Image();

         viewMedicalHistoryImage.setSrc("https://img.freepik.com/free-vector/treat-patient-medical-history_485380-1457.jpg?w=740");
         viewMedicalHistoryImage.setWidth("400px");
         viewMedicalHistoryImage.setHeight("300px");

        viewMedicalHistory.add(viewMedicalHistoryImage);

        Label label = new Label("View Medical History");
        viewMedicalHistory.add(label);

        viewMedicalHistory.addClickListener(
                event->{
                    viewMedicalHistory.getUI().ifPresent(ui->ui.navigate(MedicalhistoryView.class));
                }
        );
    }
    public HealthrecordPage2() {
            viewMedicalHistory();
            initializeaddNewRecord();
            setViewEhealHIstory();
    }

}
