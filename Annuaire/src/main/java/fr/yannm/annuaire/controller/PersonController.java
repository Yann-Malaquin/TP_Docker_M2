package fr.yannm.annuaire.controller;

import fr.yannm.annuaire.repository.PersonRepository;
import fr.yannm.annuaire.service.Annuaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller pour les personnes
 *
 * @author Yann
 * @version 1.0
 * @name : PersonController
 * @created 08/11/2021 - 18:53
 * @project Annuaire
 * @copyright Yann
 **/
@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    Annuaire annuaire;

    /**
     * Création de 3 personnes dans la BDD
     *
     * @return une responseEntity
     */
    @GetMapping("createPersons")
    public ResponseEntity<?> createPerson() {

        return annuaire.createPersons();
    }

    /**
     * Récupère toutes les personnes contenues dans la BDD
     *
     * @param id
     * @param surname
     * @param name
     * @param phone
     * @param city
     * @param model
     * @return un String
     */
    @GetMapping("annuaire")
    public String getPersons(@RequestParam(name = "id", required = false, defaultValue = "*") String id,
                             @RequestParam(name = "name", required = false, defaultValue = "*") String name,
                             @RequestParam(name = "surname", required = false, defaultValue = "*") String surname,
                             @RequestParam(name = "phone", required = false, defaultValue = "*") String phone,
                             @RequestParam(name = "city", required = false, defaultValue = "*") String city,
                             Model model) {

        // Ajout de la map comme attribut pour la vue
        model.addAttribute("personMap", annuaire.getPersons());

        return "personList";
    }

    @GetMapping("annuaire/person")
    public String getPersonByName(@RequestParam(name = "id", required = false, defaultValue = "*") String id,
                                  @RequestParam(name = "name", required = false, defaultValue = "*") String name,
                                  @RequestParam(name = "surname", required = false, defaultValue = "*") String surname,
                                  @RequestParam(name = "phone", required = false, defaultValue = "*") String phone,
                                  @RequestParam(name = "city", required = false, defaultValue = "*") String city,
                                  Model model) {

        if (!name.equals("*")) {
            model.addAttribute("personMap", annuaire.findByName(name));
        }
        return "personList";
    }

    @GetMapping("annuaire/addPerson")
    public String formPerson() {

        return "addPerson";
    }

    @PostMapping("annuaire/remove")
    public String deletePerson(@RequestParam(name = "id", required = false, defaultValue = "*") int id) {

        annuaire.deletePerson(id);

        return "redirect:";
    }

    @PostMapping("/addPerson")
    public String createPerson(@RequestParam(name = "name", required = false, defaultValue = "*") String name,
                               @RequestParam(name = "surname", required = false, defaultValue = "*") String surname,
                               @RequestParam(name = "phone", required = false, defaultValue = "*") String phone,
                               @RequestParam(name = "city", required = false, defaultValue = "*") String city) {

        annuaire.addPerson(name, surname, phone, city);

        return "redirect:annuaire";
    }

    @GetMapping("/updatePerson")
    public String getPersonToUpdateById(@RequestParam(name = "id", required = false, defaultValue = "*") String id,
                                        @RequestParam(name = "name", required = false, defaultValue = "*") String name,
                                        @RequestParam(name = "surname", required = false, defaultValue = "*") String surname,
                                        @RequestParam(name = "phone", required = false, defaultValue = "*") String phone,
                                        @RequestParam(name = "city", required = false, defaultValue = "*") String city,
                                        Model model) {

        model.addAttribute("person", annuaire.findById(Integer.parseInt(id)));

        return "updatePerson";
    }

    @PostMapping("/updatePerson")
    public String updatePerson(@RequestParam(name = "id", required = false, defaultValue = "*") String id,
                               @RequestParam(name = "name", required = false, defaultValue = "*") String name,
                               @RequestParam(name = "surname", required = false, defaultValue = "*") String surname,
                               @RequestParam(name = "phone", required = false, defaultValue = "*") String phone,
                               @RequestParam(name = "city", required = false, defaultValue = "*") String city,
                               Model model
    ) {

        model.addAttribute("person", annuaire.updatePerson(id, name, surname, phone, city));

        return "redirect:annuaire";
    }

}
