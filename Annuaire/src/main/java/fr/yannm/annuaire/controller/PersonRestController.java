package fr.yannm.annuaire.controller;

import fr.yannm.annuaire.service.Annuaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yann
 * @version 1.0
 * @name : PersonRestController
 * @created 03/12/2021 - 18:05
 * @project Annuaire
 * @copyright Yann
 **/
@CrossOrigin
@RestController
public class PersonRestController {

    @Autowired
    Annuaire annuaire;

    @GetMapping("annuaireRest")
    public ResponseEntity<?> getPersons(){
        return annuaire.getPersonsRest();
    }


}
