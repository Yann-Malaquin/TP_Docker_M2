package fr.yannm.annuaire.service;

import fr.yannm.annuaire.model.Person;
import fr.yannm.annuaire.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Yann
 * @version 1.0
 * @name : Annuaire
 * @created 22/11/2021 - 16:01
 * @project Annuaire
 * @copyright Yann
 **/
@Service(value = "annuaire")
public class Annuaire implements AnnuaireItf {

    @Autowired
    PersonRepository personRepository;

    @Override
    public ResponseEntity<?> createPersons() {
        Person person = new Person("Michel", "Jean", "0606060606", "Lille");
        personRepository.save(person);
        person = new Person("Claude", "Jean", "0606060606", "Valenciennes");
        personRepository.save(person);
        person = new Person("Jeannette", "Micheline", "0606060606", "Paris");
        personRepository.save(person);


        return ResponseEntity.ok("Personnes ajoutées");
    }

    @Override
    public Map<String, Person> getPersons() {
        // Initialisation de la map
        Map<String, Person> personMap = new HashMap<>();

        // Initialisation de la liste et récupération des personnes
        List<Person> personList = new ArrayList<>();
        personList.addAll(personRepository.findAll());

        // Insertion des personnes dans la map
        for (Person p : personList) {
            personMap.put(String.valueOf(p.getId()), p);
        }

        return personMap;
    }

    @Override
    public Person findById(int id) {

        // Initialisation de la map
        Map<String, Person> personMap = new HashMap<>();

        //  Récupération de la personne
        Optional<Person> p = personRepository.findById(id);

        // Si une personne de cet id est présente
        if (p.isPresent()) {
            return p.get();
        }

        return null;
    }

    @Override
    public Map<String, Person> findByName(String name) {
        // Initialisation de la map
        Map<String, Person> personMap = new HashMap<>();


        // Initialisation de la liste et récupération des personnes
        List<Person> personList = new ArrayList<>();
        personList.addAll(personRepository.findAllByName(name));

        // Insertion des personnes dans la map
        for (Person p : personList) {
            personMap.put(String.valueOf(p.getId()), p);
        }

        return personMap;
    }


    @Override
    public Person addPerson(String name, String surname, String phone, String city) {

        Person person = new Person(name, surname, phone, city);
        personRepository.save(person);

        return person;
    }

    @Override
    public void deletePerson(int id) {

        Optional<Person> p = personRepository.findById(id);

        if (p.isPresent()) {
            personRepository.delete(p.get());
        }
    }

    @Override
    public Person updatePerson(String id,String name, String surname, String phone, String city) {
        System.out.println("name = " + name);
        System.out.println("id = " + id);
        Optional<Person> p = personRepository.findById(Integer.parseInt(id));
        Person toUpdate = null;
        if (p.isPresent()) {
            System.out.println(toUpdate);
            toUpdate = p.get();
            toUpdate.setId(Integer.parseInt(id));
            toUpdate.setName(name);
            toUpdate.setSurname(surname);
            toUpdate.setPhone(phone);
            toUpdate.setCity(city);
            personRepository.save(toUpdate);
        }


        return toUpdate;
    }
}
