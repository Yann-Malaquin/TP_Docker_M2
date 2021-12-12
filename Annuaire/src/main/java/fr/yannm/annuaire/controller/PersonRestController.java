package fr.yannm.annuaire.controller;

import fr.yannm.annuaire.model.CreatePerson;
import fr.yannm.annuaire.model.UpdatePerson;
import fr.yannm.annuaire.service.Annuaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yann
 * @version 1.0
 * @name : PersonRestController
 * @created 03/12/2021 - 18:05
 * @project Annuaire
 * @copyright Yann
 **/
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PersonRestController {

    @Autowired
    Annuaire annuaire;

    @GetMapping("annuaireRest")
    public ResponseEntity<?> getPersons() {
        return annuaire.getPersonsRest();
    }

    @PostMapping("createPersonRest")
    public ResponseEntity<?> createPerson(@Validated @RequestBody CreatePerson createPerson) {
        return annuaire.createPersonRest(createPerson);
    }

    @DeleteMapping("deletePersonRest/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") int id) {
        return annuaire.deletePersonRest(id);
    }

    @GetMapping("annuaire/person/{id}")
    public ResponseEntity<?> getPerson(@PathVariable("id") int id) {
        return annuaire.findByIdRest(id);
    }

    @PutMapping("annuaire/updatePerson/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @Validated @RequestBody UpdatePerson updatePerson) {
        return annuaire.updatePersonRest(id, updatePerson);
    }

    @GetMapping("annuaire/{name}")
    public ResponseEntity<?> getPersons(@PathVariable("name") String name) {
        return annuaire.findPersonRest(name);
    }
}
