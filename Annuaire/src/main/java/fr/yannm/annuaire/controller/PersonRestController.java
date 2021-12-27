package fr.yannm.annuaire.controller;

import fr.yannm.annuaire.model.company.CreateCompany;
import fr.yannm.annuaire.model.company.UpdateCompany;
import fr.yannm.annuaire.model.person.CreatePerson;
import fr.yannm.annuaire.model.person.UpdatePerson;
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

    @GetMapping("annuaire/search/{name}")
    public ResponseEntity<?> getPersons(@PathVariable("name") String name) {
        return annuaire.findPersonRest(name);
    }

    @PostMapping("createCompany")
    public ResponseEntity<?> createCompany(@Validated @RequestBody CreateCompany createCompany) {
        return annuaire.createCompany(createCompany);
    }

    @GetMapping("annuaireCompany")
    public ResponseEntity<?> getCompanies() {
        return annuaire.getCompany();
    }

    @DeleteMapping("deleteCompany/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") int id) {
        return annuaire.deleteCompany(id);
    }

    @GetMapping("annuaire/company/{id}")
    public ResponseEntity<?> getCompany(@PathVariable("id") int id) {
        return annuaire.findCompanyById(id);
    }

    @PutMapping("annuaire/updateCompany/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable("id") int id, @Validated @RequestBody UpdateCompany updateCompany) {
        return annuaire.updateCompany(id, updateCompany);
    }
}
