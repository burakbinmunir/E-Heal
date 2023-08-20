package com.example.app;

import com.example.app.HealthServiceProvider.Pharmacy;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.themes.LumoDarkTheme;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import java.util.Objects;


@Tag("login-page")
@JsModule("./login-page.ts")
@Route("")
public class LoginPage extends LitTemplate  {


    @Id("signupLabel")
    private HorizontalLayout signupLabel;
    @Id("loginButton")
    private Button loginButton;
    @Id("forgetPasswordLabel")
    private HorizontalLayout forgetPasswordLabel;
    @Id("password")
    private PasswordField password;
    @Id("username")
    private TextField username;
    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
    private Dialog loginChoice;
    RadioButtonGroup<String> choices;
    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;
    @Id("hell")
    private VerticalLayout hell;
    private Admin admin;
    @Id("welcome")
    private HorizontalLayout welcome;
    @Id("Welcome To Eheal")
    private Label welcomeToEheal;

    public void showDialog(){
        Dialog dialog = new Dialog();

        VerticalLayout dialogLayout = new VerticalLayout();
        Label header = new Label("Make Choice");
        dialogLayout.add(header);

        choices = new RadioButtonGroup<String>();
        choices.setItems("Doctor", "Patient","Pharmacy","Laboratory","Admin" );
        choices.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        choices.setRequired(true);
        dialogLayout.add(choices);

        Button proceedButton = new Button("Proceed");
        dialogLayout.add(proceedButton);
        dialog.add(dialogLayout);
        dialog.open();
        proceedButton.addClickListener(
                event->{
                    if (Objects.equals(choices.getValue(), "Patient") || Objects.equals(choices.getValue(), "Doctor") || Objects.equals(choices.getValue(), "Pharmacy") || Objects.equals(choices.getValue(), "Laboratory") || Objects.equals(choices.getValue(), "Admin")) {
                        dialog.close();
                    }
                    else {
                        Notification.show("Please Make Choice");
                    }
                }

        );

    }

    public LoginPage() {
        welcomeToEheal.setSizeFull();


        admin = new Admin();
        Image img = new Image();
        img.setSrc("https://img.freepik.com/free-vector/online-doctor-concept_52683-37472.jpg?t=st=1653406934~exp=1653407534~hmac=d3f6865050b6cb98913ded094f621591f8d0f5f0f7c41b0ea5fcc73b4208aebc&w=740");
        hell.add(img);
        img.setWidthFull();
        showDialog();

        loginButton.addClickListener(event->{

            if (Objects.equals(choices.getValue(), "Patient")){
                String userName = username.getValue();
                String passwordEntered = password.getValue();
                Patient currentUser = admin.verifyPatient(userName,passwordEntered);
                if (currentUser != null) {
                    loginButton.getUI().ifPresent(ui -> ui.navigate(DisplayPatientoptions.class));
                }
                else {
                    Notification.show("Wrong Credentials");
                }
            }

            if (Objects.equals(choices.getValue(), "Doctor")) {
                String userName = username.getValue();
                String passwordEntered = password.getValue();
                Doctor currentUser = admin.verifyDoctor(username.getValue(),password.getValue());
                if (currentUser!=null) {
                    loginButton.getUI().ifPresent(ui -> ui.navigate(DoctorsOptions.class));
                }
                else{

                    Notification.show("Wrong credentials");
                }
            }

            if (Objects.equals(choices.getValue(), "Pharmacy")) {
                String userName = username.getValue();
                String passwordEntered = password.getValue();
                Pharmacy pharma = admin.pharmacyLogin(userName,passwordEntered);
                if (pharma!=null){
                        loginButton.getUI().ifPresent(ui->ui.navigate(PharmacyOptions.class));
                }
            }

            if (Objects.equals(choices.getValue(), "Admin")){
                if (Objects.equals(username.getValue(), "Admin") && Objects.equals(password.getValue(), "admin")){
                loginButton.getUI().ifPresent(ui->ui.navigate(AdminOptions.class));
                }

            }



        });
        signupLabel.addClickListener(

                event->{
                    if (Objects.equals(choices.getValue(), "Patient")) {
                        signupLabel.getUI().ifPresent(ui -> ui.navigate(PatientSignup.class));
                    }else {

                        if (Objects.equals(choices.getValue(), "Doctor")) {
                            signupLabel.getUI().ifPresent(ui -> ui.navigate(DoctorSignup.class));
                        } else {
                            if (Objects.equals(choices.getValue(), "Pharmacy")) {
                              signupLabel.getUI().ifPresent(ui -> ui.navigate(PharmacySignup.class));
                              } else {
                                if (Objects.equals(choices.getValue(), null)) {
                                    Notification.show("Please Make a choice");
                                    showDialog();
                                }
                                else{
                                   if (Objects.equals(choices.getValue(), "Laboratory")) {
                                        signupLabel.getUI().ifPresent(ui -> ui.navigate(LaboratorySignup.class));
                                    }
                                    else{
                                    if (Objects.equals(choices.getValue(), "Admin")) {
                                        Notification.show("You Cannot Sign up as Admin");
                                    }
                                }
                            }
                        }
                            }
                        }
                    }




        );
    }


}
