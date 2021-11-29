package fr.yannm.annuaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class test
 *
 * @author Yann
 * @version 1.0
 * @name : HomeController
 * @created 08/11/2021 - 18:17
 * @project Annuaire
 * @copyright Yann
 **/
@Controller
public class HomeController {

    @GetMapping("/greeting")
    public String greetings(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                            Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
