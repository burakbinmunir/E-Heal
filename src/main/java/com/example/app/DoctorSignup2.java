package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;

import java.sql.Time;

@Tag("doctor-signup2")
@JsModule("./doctor-signup2.ts")
@Route("doctorsignup2")
public class DoctorSignup2 extends LitTemplate {

    @Id("medicalCentreName")
    private TextField medicalCentreName;
    @Id("medicalCentreAdress")
    private TextField medicalCentreAdress;
    @Id("vaadinCheckboxGroup")
    private CheckboxGroup vaadinCheckboxGroup;
    @Id("addMoreButton")
    private Button addMoreButton;
    @Id("degreeName")
    private TextField degreeName;
    @Id("completionYear")
    private TextField completionYear;
    @Id("institute")
    private TextField institute;
    @Id("addMoreDegrees")
    private Button addMoreDegrees;
    @Id("signupButton")
    private Button signupButton;
    @Id("medicalCenterLayout")
    private HorizontalLayout medicalCenterLayout;
    private RadioButtonGroup<String> medicalCenterType;
    private CheckboxGroup<String> offDays;
    private     Admin admin;
    @Id("resgistrationNumber")
    private TextField resgistrationNumber;
    @Id("startTime")
    private TimePicker startTime;
    @Id("endTime")
    private TimePicker endTime;

    /**
     * Creates a new DoctorSignup2.
     */
    public DoctorSignup2() {
        admin = new Admin();
        resgistrationNumber.setVisible(false);
        medicalCenterType = new RadioButtonGroup<>();
        medicalCenterType.setLabel("Type");
        medicalCenterType.setRequired(true);
        medicalCenterType.setItems("Hospital", "Clinic");
        medicalCenterLayout.add(medicalCenterType);

        offDays = new CheckboxGroup<>();
        offDays.setLabel("Off Days");
        offDays.setItems("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday" );
        offDays.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        medicalCenterLayout.add(offDays);


        addMoreButton.addClickListener(
                event->{
                    admin.addMedicalCentre(medicalCentreName.getValue(),medicalCentreAdress.getValue(),medicalCenterType.getValue(), Time.valueOf(startTime.getValue()),Time.valueOf( endTime.getValue()));
                    medicalCentreName.clear();
                    medicalCentreAdress.clear();
                    medicalCenterType.clear();
                    endTime.clear();
                    startTime.clear();
                    offDays.clear();
                }
        );

        addMoreDegrees.addClickListener(event->{
            admin.addDegree(resgistrationNumber.getValue(), degreeName.getValue(), Integer.parseInt(completionYear.getValue()),institute.getValue());
            degreeName.clear();
            completionYear.clear();
            institute.clear();
        });
        signupButton.addClickListener(e->{
           signupButton.getUI().ifPresent(ui->ui.navigate(LoginPage.class));
        });
    }

}
