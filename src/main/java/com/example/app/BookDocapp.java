package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;

import java.sql.Date;
import java.sql.Time;

@Tag("book-docapp")
@JsModule("./book-docapp.ts")
@Route("bookdocappointment")
public class BookDocapp extends LitTemplate {

    @Id("date")
    private DatePicker date;
    @Id("startTime")
    private TimePicker startTime;
    @Id("endTime")
    private TimePicker endTime;
    @Id("currentCondition")
    private TextArea currentCondition;
    @Id("bookAppointmentButton")
    private Button bookAppointmentButton;
    private Admin admin;

    public BookDocapp() {
        admin = new Admin();
        bookAppointmentButton.addClickListener(
                event-> {
                    admin.bookAppointment(Time.valueOf(startTime.getValue()), Time.valueOf(endTime.getValue()), Date.valueOf(date.getValue()), currentCondition.getValue());
                    admin.removeTempDoc();
                    bookAppointmentButton.getUI().ifPresent(ui->ui.navigate(DisplayPatientoptions.class));
                }
        );
    }

}
