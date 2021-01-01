package de.techworkshop.webapp.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import de.techworkshop.mongo.document.MitarbeiterDocument;
import de.techworkshop.mongo.service.MitarbeiterService;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class MitarbeiterView extends VerticalLayout {

  private static final long serialVersionUID = 354341734010294903L;

  private final TextField firstName = new TextField("Vorname");
  private final TextField lastName = new TextField("Nachname");
  private final Button saveButton = new Button("Speichern");

  @Autowired
  private MitarbeiterService mitarbeiterService;

  public MitarbeiterView() {

    saveButton.addClickListener(event -> {
      MitarbeiterDocument mitarbeiter = new MitarbeiterDocument();
      mitarbeiter.setFirstName(firstName.getValue());
      mitarbeiter.setLastName(lastName.getValue());

      mitarbeiterService.save(mitarbeiter);
    });

    add(firstName, lastName, saveButton);
  }
}
