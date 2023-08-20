package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;



@Tag("prescribe-medicine")
@JsModule("./prescribe-medicine.ts")
@Route("prescribe-medicine")
public class PrescribeMedicine extends LitTemplate {


    @Id("vaadinHorizontalLayout")
    private HorizontalLayout ImageHeader;
    @Id("medicines ")
    private HorizontalLayout medicines;
    @Id("medicineName")
    private TextField medicineName;
    @Id("ButtonPanel")
    private HorizontalLayout buttonPanel;

    @Id("SavePrecriptionButton")
    private HorizontalLayout savePrecriptionButton;
    private Admin admin;
    @Id("labTestBox")
    private VerticalLayout labTestBox;
    @Id("Dosage")
    private HorizontalLayout dosage;
    @Id("doctorComments")
    private TextArea doctorComments;


    public PrescribeMedicine() {


        admin = new Admin();

        TextField labTestName = new TextField("Test Name");
        Button addMoreTest = new Button("Add Lab Test");
        labTestBox.add(labTestName);
        labTestBox.add(addMoreTest);
        addMoreTest.addClickListener(
                ev->{
                    admin.addLabTest(labTestName.getValue());
                    labTestName.clear();
                }
        );


        Image image = new Image();
        image.setSrc("https://previews.123rf.com/images/cowpland/cowpland1706/cowpland170600153/80267165-m%C3%A9dicale-ic%C3%B4ne-de-la-prescription.jpg");
        image.setWidth("100px");
        image.setHeight("100px");
        ImageHeader.add(image);


        IntegerField morningDose = new IntegerField();
        morningDose.setLabel("Morning");
        morningDose .setValue(2);
        morningDose .setHasControls(true);
        morningDose .setMin(0);
        morningDose .setMax(9);
        medicines.add(morningDose);

        IntegerField noonDose = new IntegerField();
        noonDose.setLabel("Noon");
        noonDose .setValue(2);
        noonDose .setHasControls(true);
        noonDose .setMin(0);
        noonDose .setMax(9);
        medicines.add(noonDose);

        IntegerField nightDose = new IntegerField();
        nightDose.setLabel("Night");
        nightDose .setValue(2);
        nightDose .setHasControls(true);
        nightDose .setMin(0);
        nightDose .setMax(9);
        medicines.add(nightDose);


        IntegerField Duration = new IntegerField();
        Duration.setLabel("How many days the prescription have to be followed?(Days)");
        Duration .setValue(2);
        Duration .setHasControls(true);
        Duration .setMin(0);
        Duration .setMax(30);
        dosage.add(Duration);

        TextField diseaseName = new TextField("Disease Name");
        dosage.add(diseaseName);

        Button button = new Button("Add Medicines", VaadinIcon.PLUS.create());
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.setAutofocus(true);
        button.addClickListener(
            e->{
                    admin.addMedicine(medicineName.getValue(), morningDose.getValue(), noonDose.getValue(), nightDose.getValue());
                    medicineName.clear();
                    morningDose.clear();
                    noonDose.clear();
                    nightDose.clear();
            }
        );
        medicines.add(button);

        Button savebtn = new Button("Save",VaadinIcon.CHECK_SQUARE.create());
        savebtn.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        savebtn.setAutofocus(true);
        savePrecriptionButton.add(savebtn);
        savebtn.addClickListener(
                eve1->{
                    admin.addPrescription(diseaseName.getValue(), doctorComments.getValue(),Duration.getValue());
                    Notification.show("Patient Diagnosed").addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                    savePrecriptionButton.getUI().ifPresent(ui->ui.navigate(DoctorsViewappointments.class));
                }
        );



        Button cancelbtn = new Button("Cancel" , VaadinIcon.CLOSE_CIRCLE.create());
        cancelbtn.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancelbtn.setAutofocus(true);
        savePrecriptionButton.add(cancelbtn);
        cancelbtn.addClickListener(
                eve->{
                    cancelbtn.getUI().ifPresent(ui->ui.navigate(DoctorsOptions.class));
                }

        );

    }

}
