package fr.yannm.annuaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Map;

@SpringBootApplication
@EnableKafka
public class AnnuaireApplication {

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        String kafka = env.get("BOOTSTRAP_SERVERS");
        System.out.println("--------------------------------"+ kafka + "-------------------------------------------------------");

        SpringApplication.run(AnnuaireApplication.class, args);
    }

}
