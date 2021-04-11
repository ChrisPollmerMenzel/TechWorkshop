package de.techworkshop.schnittstelle.controller;

import de.techworkshop.mongo.document.MitarbeiterDocument;
import de.techworkshop.mongo.service.MitarbeiterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller für Mitarbeiter values.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/mitarbeiter", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Mitarbeiter", value = " ")
public class MitarbeiterController {

  /**
   * {@link MitarbeiterService}.
   */
  @Autowired
  private final MitarbeiterService mitarbeiterService;

  /**
   * Holen aller Mitarbeiter.
   *
   * @return {@link MitarbeiterDocument}
   */
  @ApiOperation("Gibt die Daten aller Mitarbeiter zurück.")
  @GetMapping(value = "/all")
  public List<MitarbeiterDocument> findAllMitarbeiter() {

    return mitarbeiterService.findAll();
  }
}
