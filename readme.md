# TP Programmation Serveur - Composants

Développement d'une application de gestion d'annuaire en s'appuyant sur SpringBoot, Kafka
et Docker.

## Environnement de développement

### Pré-requis

* JDK 1.8
* Composer
* Docker
* Docker-compose

### Technologies

* Spring-boot
* Angular
* Thymeleaf
* HSQLDB
* nodejs 16 et npm

### Lancer l'environnement de développement

Toutes les commandes sont réalisées sous Windows.

### Récupération du dépôt github
```bash
git clone https://github.com/Yann-Malaquin/Annuaire.git
```

### Lancement du container Docker
```bash
docker-compose up --build
```

### Kafka

Ne fonctionne pas avec le docker, problème lié avec le localhost que je n'ai pas su résoudre ...

Pour l'utiliser, angular et hsqldb peuvent être lancés via docker mais springboot en local avec la commande

```bash
mvn spring-boot:run
```

### Utilisation kafka

Nom du topic : annuaire
Format Json :
```bash 
{"name": "Hood","surname": "Shannon","phone": "+33 (816) 462-3396","city": "Johnsonburg"}
```
Un fichier est églament fourni pour permettre un ajout plus important:
Nom du fichier : producer.json

```bash
.\kafka-console-producer --broker-list localhost:9092 --topic annuaire \\< C:\Users\Yann\Desktop\kafka_2.10-0.10.2.1\producer.json
```









