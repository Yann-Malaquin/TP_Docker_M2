package fr.yannm.annuaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@EnableKafka
public class AnnuaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnuaireApplication.class, args);
    }
}
