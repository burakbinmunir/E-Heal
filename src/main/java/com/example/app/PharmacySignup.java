package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the pharmacy-signup template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("pharmacy-signup")
@JsModule("./pharmacy-signup.ts")
@Route("pharmacysignup")
public class PharmacySignup extends LitTemplate {

    @Id("backButton")
    private Button backButton;
    private ConfirmDialog dialog;
    private Admin admin;
    @Id("hspSignup")
    private HspSignup hspSignup;
    @Id("pharmacySignUp")
    private Button pharmacySignUp;

    void showConfirmDialog(){
        dialog = new ConfirmDialog();
        dialog.setHeader("Important Message");
        dialog.setText("Dear user thank you for signup.\n Please remember your registration number is your username :)");
        Button confirmButton = new Button("Acknowlegded");
        dialog.add(confirmButton);
        dialog.open();
        confirmButton.addClickListener(event->{
            dialog.close();
        });
    }

    public PharmacySignup() {
            admin  = new Admin();
        backButton.addClickListener(event->{
            backButton.getUI().ifPresent(ui->ui.navigate(LoginPage.class));
        });

        pharmacySignUp.addClickListener(event->{
            admin.enrollLaboratory(hspSignup.getHspName(), hspSignup.getHspRegistrationNumber(), hspSignup.getHspAddress(), hspSignup.getHspPassword(), hspSignup.getHspPhoneNumber(), hspSignup.getHspEmail());
            pharmacySignUp.getUI().ifPresent(ui->ui.navigate(LoginPage.class));

            showConfirmDialog();

            Notification.show("Login With your credentials");
        });
    }

}
