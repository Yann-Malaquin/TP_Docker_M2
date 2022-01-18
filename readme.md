
# TP Programmation Serveur - Composants

Développement d'une application de gestion d'annuaire en s'appuyant sur SpringBoot, Kafka
et Docker. </br>

Réalisé par :

**Billy Mortreux et Yann Malaquin**

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
* PostgreSQL
* Adminer
* nodejs 16
* npm 8.1.2

### Lancer l'environnement de développement

Toutes les commandes sont réalisées sous Windows.

### Récupération du dépôt github
```
git clone https://github.com/Yann-Malaquin/Annuaire.git
```

### Lancement du docker-compose.yml
```bash
docker-compose up --build
```

### Pour supprimer les container
```bash
docker-compose down
```

## Kafka

### Utilisation Kafka

Nom du topic : annuaire<br/>
Format Json :

```json 
{"name": "Hood","surname": "Shannon","phone": "+33 (816) 462-3396","city": "Johnsonburg"}
```

Pour accéder à Kafka, ouvrir un terminal, saisir la commande suivante

```bash
docker exec -ti annuaire-kafka /bin/sh
```

```shell
sh-4.4$ kafka-console-producer --broker-list kafka:9092 --topic annuaire
> {"name": "Hood","surname": "Shannon","phone": "+33 (816) 462-3396","city": "Johnsonburg"}
```

Appuyez sur entrée. <br/> 
Rafraîchir la page web et si le modèle correspond, la personne sera ajoutée.


Un fichier est également fourni pour avoir plusieurs personnes. <br/>
Nom du fichier : producer.json

Pour ajouter un fichier json il faut le placer dans le même dossier du Dockerfile de kafka.
Il faut entrer la ligne de commande suivante dans le Dockerfile

```
COPY producer.json .
```

Par la suite dans un terminal il faut entrer les lignes de commandes suivantes :

```bash
docker exec -ti annuaire-kafka sh
```

```shell
sh-4.4$ kafka-console-producer --broker-list kafka:9092 --topic annuaire < producer.json
```

Appuyez sur entrée. <br/> 
Rafraîchir la page web et si les modèles correspondent, toutes les personnes du fichier seront ajoutées.

### URL

#### Thymeleaf

- Affichage de toutes les personnes : [localhost:8082/annuaire](localhost:8082/annuaire)
- Ajout d'une personne [http://localhost:8082/annuaire/addPerson](http://localhost:8082/annuaire/addPerson)

#### Angular

- Page d'accueil : [http://localhost:4200/](http://localhost:4200/)

Ensuite utilisation de la navbar pour naviguer au travers de l'application.
