package fr.yannm.annuaire.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import fr.yannm.annuaire.model.person.Person;
import fr.yannm.annuaire.repository.PersonRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author Yann
 * @version 1.0
 * @name : KafkaConsumer
 * @created 28/12/2021 - 14:58
 * @project Annuaire
 * @copyright Yann
 **/
@Service
public class KafkaConsumer {

    @Autowired
    PersonRepository personRepository;

    @KafkaListener(topics = "annuaire", groupId = "groupe-ms")
    public void onMessage(ConsumerRecord<String, String> cr) throws Exception{

        // Récupération depuis le producer
        Person person = personEvent(cr.value());

        // Si la personne n'existe pas on l'ajouter à la BDD
        if (!personRepository.findByPhone(person.getPhone()).isPresent()){
            personRepository.save(person);
        }
    }

    // Permet de convertir un String en JSON
    private Person personEvent(String jsonPersonEvent) throws Exception{
        JsonMapper jsonMapper=new JsonMapper();
        Person personEvent = jsonMapper.readValue(jsonPersonEvent, Person.class);

        return personEvent;
    }


}
