package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the hsp-signup template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("hsp-signup")
@JsModule("./hsp-signup.ts")
@Route("hspsignup")
public class HspSignup extends LitTemplate {

    @Id("hspName")
    private TextField hspName;
    @Id("hspAddress")
    private TextField hspAddress;
    @Id("hspPhoneNumber")
    private TextField hspPhoneNumber;
    @Id("hspEmail")
    private TextField hspEmail;
    @Id("hspRegistrationNumber")
    private TextField hspRegistrationNumber;
    @Id("hspPassword")
    private PasswordField hspPassword;

    public HspSignup() {
        System.out. print(1);
    }

    public String getHspName() {
        return hspName.getValue();
    }

    public String getHspAddress() {
        return hspAddress.getValue();
    }

    public String getHspPhoneNumber() {
        return hspPhoneNumber.getValue();
    }
    public String getHspEmail() {
        return hspEmail.getValue();
    }
    public String getHspRegistrationNumber() {
        return hspRegistrationNumber.getValue();
    }
    public String getHspPassword() {
        return hspPassword.getValue();
    }
}




