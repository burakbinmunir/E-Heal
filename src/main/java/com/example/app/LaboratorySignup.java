package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;




@Tag("laboratory-signup")
@JsModule("./laboratory-signup.ts")
@Route("laboratorysignup")
public class LaboratorySignup extends LitTemplate {

    @Id("backButton")
    private Button backButton;
    @Id("hspSignup")
    private HspSignup hspSignup;
    private ConfirmDialog dialog;
    private Admin admin;
    @Id("signupButton")
    private Button signupButton;


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


    public LaboratorySignup() {
       admin = new Admin();
        backButton.addClickListener(event->{
            backButton.getUI().ifPresent(ui->ui.navigate(LoginPage.class));
        });


    }
    

}
