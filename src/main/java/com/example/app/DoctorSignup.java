package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import javax.management.Notification;
import java.util.Vector;


@Tag("doctor-signup")
@JsModule("./doctor-signup.ts")
@Route("doctorsignup")
public class DoctorSignup extends LitTemplate {

    @Id("doctrateDetailLayout")
    private HorizontalLayout doctrateDetailLayout;
    private ComboBox<String> specialization;



    @Id("personSignup")
    private PersonSignup personSignup;
    @Id("resgistrationNumber")
    private TextField resgistrationNumber;
    @Id("backButton")
    private Button backButton;
    @Id("nextButton")
    private Button nextButton;

    /**
     * Creates a new DoctorSignup.
     */
    public DoctorSignup() {
        specialization = new ComboBox<>("Specialization");
        Admin admin = new Admin();
        Vector<String> spec = new Vector<String>();
        spec = admin.getSpecializations();
        specialization.setItems(spec);
        doctrateDetailLayout.add(specialization);


        backButton.addClickListener(
                event->{
                    backButton.getUI().ifPresent(ui -> ui.navigate(LoginPage.class));
                }
        );


        nextButton.addClickListener(
                event->{
                    admin.enrollPatient(personSignup.getUsername(),personSignup.getPassword(),personSignup.getFirstName(),personSignup.getLastName(),personSignup.getPhoneNumber(),personSignup.getEmail(),personSignup.getGender(),personSignup.getDOB(), personSignup.getCNIC(),personSignup.getSecurityQuestion(),personSignup.getAnswerToSQ());
                    admin.enrollDoctor(resgistrationNumber.getValue(),specialization.getValue(),personSignup.getUsername());
                    admin.addTempReg(resgistrationNumber.getValue());
                    nextButton.getUI().ifPresent(ui->ui.navigate(DoctorSignup2.class));
                }
        );


    }



}
