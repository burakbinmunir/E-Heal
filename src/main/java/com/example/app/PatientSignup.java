package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import com.example.app.PersonSignup;



/**
 * A Designer generated component for the patient-signup template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("patient-signup")
@JsModule("./patient-signup.ts")
@Route("patientSignUp")
public class PatientSignup extends LitTemplate {


    @Id("personSignup")
    private PersonSignup personSignup;
    @Id("signupButton")
    private Button signupButton;
    @Id("backButton")
    private Button backButton;


    public PatientSignup() {
        backButton.addClickListener(
                event->{
                    backButton.getUI().ifPresent(ui -> ui.navigate(LoginPage.class));
                }

        );
        signupButton.addClickListener(
                event-> {
                    Admin admin = new Admin();
                    admin.enrollPatient(personSignup.getUsername(),personSignup.getPassword(),personSignup.getFirstName(),personSignup.getLastName(),personSignup.getPhoneNumber(),personSignup.getEmail(),personSignup.getGender(),personSignup.getDOB(), personSignup.getCNIC(),personSignup.getSecurityQuestion(),personSignup.getAnswerToSQ());
                    personSignup.getUI().ifPresent(ui -> ui.navigate(LoginPage.class));
                }
        );
    }

}
