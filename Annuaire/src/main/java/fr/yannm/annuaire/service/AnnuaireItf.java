package fr.yannm.annuaire.service;

import fr.yannm.annuaire.model.Person;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.Map;

/**
 * @author Yann
 * @version 1.0
 * @name : AnnuaireItf
 * @created 22/11/2021 - 15:56
 * @project Annuaire
 * @copyright Yann
 **/
public interface AnnuaireItf {

    public ResponseEntity<?> createPersons();

    public Map<String, Person> getPersons();

    public Person findById(int id);

    public Map<String, Person> findByName(String name);

    public Person addPerson(String name, String surname, String phone, String city);

    public void deletePerson(int id);

    public Person updatePerson(String id, String name, String surname, String phone, String city);

    public ResponseEntity<?> getPersonsRest();
}
