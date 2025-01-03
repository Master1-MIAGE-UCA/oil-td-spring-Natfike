[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QGf4F8_h)
# Projet "Dice" - Gestion de lancés de dés avec Spring Boot - Rendu

## Description
Le projet "Dice" est une application construite avec Spring Boot permettant de simuler des lancés de dés et de gérer un historique des résultats en base de données. Ce projet met en œuvre les concepts fondamentaux de Spring Boot, notamment l'injection de dépendances, les services RESTful, les entités JPA et les repositories.

Ceci est le livrable demandé dans le sujet. Celui-ci sera composé de trois parties : 
- Les liens pour accéder à l'API
- Les fonctionnalités présentes dans l'application 
- Les étapes de réalisation qui ont été réalisés / implémentées.

## Accés à l'API

L'API est accessible via cinq différents chemin, partant tous de la base 'http://localhost:8081'

- http://localhost:8081/swagger-ui/index.html : Pour accéder à la documentation swagger
- http://localhost:8081/v3/api-docs : Pour accéder à la documentation au format JSON
- http://localhost:8081/rollDice : Permet d'avoir le résultat d'un lancer de dés
- http://localhost:8081/rollDices/{x} : Permet d'avoir le résultat de x dés (remplacer x par un nombre)
- http://localhost:8081/diceLogs : Permet d'accéder aux logs des lancer de dès pour la session en cours.

---

##  Fonctionnalités

On pourra retrouver à travers ce projet diverses fonctionnalités, comprenant :

- API permettant le lancer de dés unique ou multiple avec nombre au choix
- Présence d'une documentation swagger automatiquement générée
- Utilisation de Lombok pour simplifier les getters, setters et constructeurs
- Système de base de données

---

## Étapes de réalisation

### 1. Création du projet Spring Boot
- Utilisez [Spring Initializr](https://start.spring.io/) pour créer le projet.
- Choisissez la dernière version de Spring Boot disponible (LTS).
- Optez pour **Maven** ou **Gradle** comme outil de gestion de dépendances.
- Ajoutez les dépendances nécessaires : **Spring Web**, **Spring Data JPA**, **H2 Database** .

### 2. Configuration du projet
- Configurez l'application pour qu'elle utilise le port **8081**.
- Donnez un nom (**dice**) au projet dans le fichier de configuration :
    - Utilisez **`application.properties`** ou **`application.yml`** selon votre préférence.

### 3. Création de la classe `Dice`
- Implémentez une classe représentant un dé avec les méthodes nécessaires pour effectuer un lancé.
- Marquez cette classe avec l'annotation `@Component` pour pouvoir l'injecter au besoin.

### 4. Création de l'entité `DiceRollLog`
- Modélisez une entité JPA `DiceRollLog` comprenant les champs suivants :
    - **`id`** : Identifiant unique.
    - **`diceCount`** : Nombre de dés lancés.
    - **`results`** : Liste ou chaîne des valeurs obtenues. Il existe de nombreuses façons de stocker des valeurs simples (simple String), certaines sont plus élégantes (@ElementCollection) que d'autres, vous pouvez choisir la solution qui vous conviendra.
    - **`timestamp`** : Horodatage du lancé.
- Utilisez des annotations JPA comme `@Entity`, `@Id`, `@GeneratedValue`, etc.

### 5. Création du `Repository`
- Implémentez une interface héritant de `JpaRepository<DiceRollLog, Long>` pour gérer les interactions avec la base de données.

### 6. Création du contrôleur REST pour lancer les dés
- Implémentez un contrôleur REST annoté avec `@RestController`.
- Ajoutez les endpoints suivants :
    - **`GET /rollDice`** : Lancer un seul dé.
    - **`GET /rollDices/{X}`** : Lancer X dés (X étant un paramètre dynamique).

### 7. Création du `Service`
- Créez un service marqué avec `@Service` contenant une méthode :
    - Prend en paramètre le nombre de dés à lancer.
    - Retourne les résultats des lancés au contrôleur.
    - Enregistre l’historique des lancés dans la base via le `Repository`.

### 8. Contrôleur pour afficher les historiques
- Ajoutez un autre contrôleur REST permettant d'afficher l'historique des lancés :
    - **`GET /diceLogs`** : Retourne tous les enregistrements de `DiceRollLog` au format JSON.

### 9. Tests et validation
- Démarrez l'application et testez les endpoints.
- Vérifiez les résultats dans la base de données et les réponses JSON.

### 10. (Bonus) Ajout de fonctionnalités avancées
- **Swagger** :
    - Ajoutez la dépendance Swagger/OpenAPI.
    - Configurez Swagger pour documenter vos endpoints.
    - Accédez à la documentation sur **`http://localhost:8081/swagger-ui.html`**.
- **Lombok** :
    - Utilisez Lombok pour simplifier les getters, setters et constructeurs de vos entités.

---

## Technologies
- **Framework principal** : Spring Boot
- **Base de données** : H2
- **Documentation API** : Swagger (bonus)
- **Simplification de code** : Lombok (bonus)
