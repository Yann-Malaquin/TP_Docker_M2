package fr.yannm.annuaire.controller;

import fr.yannm.annuaire.model.company.CreateCompany;
import fr.yannm.annuaire.model.company.UpdateCompany;
import fr.yannm.annuaire.model.person.CreatePerson;
import fr.yannm.annuaire.model.person.UpdatePerson;
import fr.yannm.annuaire.service.AnnuaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Billy Mortreux Yann Malaquin
 * @version 1.0
 * @name : PersonRestController
 * @created 03/12/2021 - 18:05
 * @project Annuaire
 * @copyright Billy Mortreux Yann Malaquin
 **/
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api
public class PersonRestController {

    @Autowired
    AnnuaireService annuaireService;

    @GetMapping("annuaireRest")
    @ApiOperation("Retourne toutes les personnes.")
    public ResponseEntity<?> getPersons() {
        return annuaireService.getPersonsRest();
    }

    @PostMapping("createPersonRest")
    @ApiOperation("Crée une personne en fonctione des données récupérées.")
    public ResponseEntity<?> createPerson(@Validated @RequestBody CreatePerson createPerson) {
        return annuaireService.createPersonRest(createPerson);
    }

    @DeleteMapping("deletePersonRest/{id}")
    @ApiOperation("Supprime une personne en fonction de son id.")
    public ResponseEntity<?> deletePerson(@PathVariable("id") int id) {
        return annuaireService.deletePersonRest(id);
    }

    @GetMapping("annuaire/person/{id}")
    @ApiOperation("Retourne une personne en fonction de son id.")
    public ResponseEntity<?> getPerson(@PathVariable("id") int id) {
        return annuaireService.findByIdRest(id);
    }

    @PutMapping("annuaire/updatePerson/{id}")
    @ApiOperation("Récupère une personne en fonction de son id et MAJ les données en fonction des données récupérées.")
    public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @Validated @RequestBody UpdatePerson updatePerson) {
        return annuaireService.updatePersonRest(id, updatePerson);
    }

    @GetMapping("annuaire/search/{name}")
    @ApiOperation("Recherche une ou plusieurs personnes en fonction du nom.")
    public ResponseEntity<?> getPersons(@PathVariable("name") String name) {
        return annuaireService.findPersonRest(name);
    }

    @PostMapping("createCompany")
    @ApiOperation("Création d'une entreprise en fonction des données récupérées.")
    public ResponseEntity<?> createCompany(@Validated @RequestBody CreateCompany createCompany) {
        return annuaireService.createCompany(createCompany);
    }

    @GetMapping("annuaireCompany")
    @ApiOperation("Retourne toutes les entreprises.")
    public ResponseEntity<?> getCompanies() {
        return annuaireService.getCompany();
    }

    @DeleteMapping("deleteCompany/{id}")
    @ApiOperation("Supprime une entreprise en fonction de son id.")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") int id) {
        return annuaireService.deleteCompany(id);
    }

    @GetMapping("annuaire/company/{id}")
    @ApiOperation("Retourne une entreprise en fonction de son entreprise.")
    public ResponseEntity<?> getCompany(@PathVariable("id") int id) {
        return annuaireService.findCompanyById(id);
    }

    @PutMapping("annuaire/updateCompany/{id}")
    @ApiOperation("Récupère une entreprise en fonction de son id et MAJ les données en fonction des données récupérées.")
    public ResponseEntity<?> updateCompany(@PathVariable("id") int id, @Validated @RequestBody UpdateCompany updateCompany) {
        return annuaireService.updateCompany(id, updateCompany);
    }
}
