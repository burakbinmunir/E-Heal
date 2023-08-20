package com.example.app;


import com.example.app.System.FirstAid;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;


import java.util.List;

/**
 * A Designer generated component for the get-firstaid template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("get-firstaid")
@JsModule("./get-firstaid.ts")
@Route("get-firstaid")
public class GetFirstaid extends LitTemplate {

    @Id("gridLayout")
    private HorizontalLayout gridLayout;

    /**
     * Creates a new GetFirstaid.
     */
    private Admin admin ;
    public GetFirstaid() {
        admin = new Admin();
        String url ;
        Grid<FirstAid> firstaid = new Grid<FirstAid>();
        firstaid.addColumn(FirstAid::getIncidentName).setHeader("Incident");
        List<FirstAid> list = admin.viewFirstAid();
        firstaid.setItems(list);
        gridLayout.add(firstaid);

        firstaid.addComponentColumn(event -> {
            Button button = new Button("View Measure" );
            button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

            button.addClickListener(e->{
                for (FirstAid f : list) {
                    Anchor link = new Anchor(f.measureLink);
                    link.setTarget("_blank"); //this is to open in a new tab
                    link.add(button);
                    UI.getCurrent().getPage().open(f.measureLink);
                }

            });
            return button;
        });
    }
}
