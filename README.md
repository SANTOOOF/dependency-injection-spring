# Projet d'Injection de Dépendances avec Spring

### Ce projet est une démonstration des différentes méthodes d'injection de dépendances en Java, en utilisant le framework Spring. Il illustre les concepts fondamentaux de l'inversion de contrôle (IoC) et de l'injection de dépendances à travers plusieurs approches : instanciation statique, instanciation dynamique, configuration XML et annotations Spring.

## Structure du Projet

```
dependency-injection-spring/
├── .idea/                      # Configuration IntelliJ IDEA
├── src/main/
│   ├── java/net/rahli/
│   │   ├── dao/                # Couche d'accès aux données
│   │   │   ├── IDao.java       # Interface DAO
│   │   │   └── DaoImpl.java    # Implémentation DAO (version base de données)
│   │   ├── ext/
│   │   │   └── DaoImplV2.java  # Implémentation alternative DAO (version capteurs)
│   │   ├── metier/             # Couche métier
│   │   │   ├── IMetier.java    # Interface métier
│   │   │   └── MetierImpl.java # Implémentation métier
│   │   └── pres/               # Couche présentation
│   │       ├── Pres1.java      # Instanciation statique
│   │       ├── Pres2.java      # Instanciation dynamique
│   │       ├── PresSpringXML.java        # Configuration Spring XML
│   │       └── PresSpringAnnotation.java # Configuration Spring par annotations
│   └── resources/
│       └── config.xml          # Fichier de configuration Spring XML
├── config.txt                  # Fichier de configuration pour l'instanciation dynamique
├── pom.xml                     # Configuration Maven
└── .gitignore                  # Fichier d'exclusion Git
```

## Description des Composants

### Couche DAO (Data Access Object)

- **IDao** : Interface définissant la méthode `getData()` pour récupérer des données.
- **DaoImpl** : Implémentation de l'interface IDao qui simule une récupération de données depuis une base de données (retourne 34).
- **DaoImplV2** : Implémentation alternative de l'interface IDao qui simule une récupération de données depuis des capteurs (retourne 12).

![Screenshot 2025-05-17 230844](https://github.com/user-attachments/assets/20d42c19-0b20-45c6-a124-acfde061853d)
![Screenshot 2025-05-17 231102](https://github.com/user-attachments/assets/9376d474-b3e6-4abd-bf8d-e9d9c91389cb)
![Screenshot 2025-05-17 231156](https://github.com/user-attachments/assets/4f61bef3-5c3f-414d-b240-8ebce35a0201)

### Couche Métier

- **IMetier** : Interface définissant la méthode `calcul()` pour effectuer un traitement métier.
- **MetierImpl** : Implémentation de l'interface IMetier qui utilise un objet IDao pour récupérer des données et effectuer un calcul.

![Screenshot 2025-05-17 231607](https://github.com/user-attachments/assets/980a8951-6c0c-4fc2-aa5b-4fd12f46e803)
![Screenshot 2025-05-17 231511](https://github.com/user-attachments/assets/8bd908ec-ad1d-4ead-b9dd-33e91f42c691)

### Couche Présentation

- **Pres1** : Démonstration de l'instanciation statique des objets et de l'injection de dépendances par constructeur.
- **Pres2** : Démonstration de l'instanciation dynamique des objets à partir d'un fichier de configuration (config.txt).
- **PresSpringXML** : Démonstration de l'injection de dépendances avec Spring en utilisant un fichier de configuration XML.
- **PresSpringAnnotation** : Démonstration de l'injection de dépendances avec Spring en utilisant des annotations.

![Screenshot 2025-05-17 232014](https://github.com/user-attachments/assets/6e6f5bb6-e79a-4845-ba20-87e8311bf028)
![Screenshot 2025-05-17 232159](https://github.com/user-attachments/assets/c3a8e39d-997b-4c34-8057-422f9289f269)

## Fichiers de Configuration

- **config.txt** : Contient les noms complets des classes à instancier dynamiquement.
- **config.xml** : Configuration Spring XML définissant les beans et leurs dépendances.

![Screenshot 2025-05-17 232531](https://github.com/user-attachments/assets/09adbe1a-214a-44b0-8196-0adf2c92ca69)
![Screenshot 2025-05-17 232602](https://github.com/user-attachments/assets/6845dcec-4963-4fc4-a015-31696a2f0fd2)

## Dépendances

Le projet utilise les dépendances Spring suivantes :
- spring-core (6.2.3)
- spring-context (6.2.3)
- spring-beans (6.2.3)

## Prérequis

- Java 21
- Maven

## Installation et Exécution

1. Cloner le dépôt :
   ```
   git clone https://github.com/SANTOOOF/dependency-injection-spring.git
   ```

2. Accéder au répertoire du projet :
   ```
   cd dependency-injection-spring
   ```

3. Compiler le projet avec Maven :
   ```
   mvn clean compile
   ```

4. Exécuter l'une des classes de présentation :
   ```
   # Pour l'instanciation statique
   mvn exec:java -Dexec.mainClass="net.rahli.pres.Pres1"
   
   # Pour l'instanciation dynamique
   mvn exec:java -Dexec.mainClass="net.rahli.pres.Pres2"
   
   # Pour Spring avec configuration XML
   mvn exec:java -Dexec.mainClass="net.rahli.pres.PresSpringXML"
   
   # Pour Spring avec annotations
   mvn exec:java -Dexec.mainClass="net.rahli.pres.PresSpringAnnotation"
   ```

## Concepts Illustrés

1. **Couplage faible** : Utilisation d'interfaces pour réduire le couplage entre les couches.
2. **Inversion de Contrôle (IoC)** : Délégation de la création et gestion des objets à un conteneur (Spring).
3. **Injection de Dépendances** : Plusieurs méthodes d'injection sont démontrées :
   - Par constructeur
   - Par setter
   - Par configuration XML
   - Par annotations

## Annotations Spring Utilisées

- `@Repository` : Pour marquer les classes DAO
- `@Service` : Pour marquer les classes de service (métier)
- `@Autowired` : Pour l'injection automatique de dépendances
- `@Qualifier` : Pour spécifier quelle implémentation injecter lorsqu'il y en a plusieurs

