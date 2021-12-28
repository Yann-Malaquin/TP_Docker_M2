package fr.yannm.annuaire.model;

import fr.yannm.annuaire.controller.PersonRestController;
import fr.yannm.annuaire.model.company.Company;
import fr.yannm.annuaire.model.person.Person;
import fr.yannm.annuaire.repository.CompanyRepository;
import fr.yannm.annuaire.repository.PersonRepository;
import fr.yannm.annuaire.service.AnnuaireService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Yann
 * @version 1.0
 * @name : PersonTest
 * @created 27/12/2021 - 17:41
 * @project Annuaire
 * @copyright Yann
 **/
@SpringBootTest
@AutoConfigureMockMvc
public class PersonTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    public void setup() {
        Person person = new Person();
        person.setId(1);
        person.setName("Nom");
        person.setSurname("Prenom");
        person.setPhone("0606060606");
        person.setCity("Ville");

        personRepository.save(person);
    }

    @Test
    public void getPersonCity() throws Exception {
        int id = 1;

        Optional<Person> personOptional = personRepository.findById(id);
        Person person = null;

        if (personOptional.isPresent()) {
            person = personOptional.get();
        }

        assertEquals(person.getCity(), "Ville");
    }
}
