
# 💼 FinanciaPro

Projet pédagogique réalisé dans le cadre de ma formation Bachelor à l’EPSI.  
L’objectif est de concevoir une API REST modulaire avec Spring Boot, permettant de gérer des utilisateurs, leurs opérations budgétaires, ainsi que des demandes et remboursements de prêts.

---

## 🎯 Objectifs pédagogiques

- ✅ Concevoir une **API REST modulaire** avec des entités liées
- ✅ Implémenter une **authentification par API Key** 
- ✅ Réaliser des **opérations de calcul métier** (revenus, dépenses, intérêts)
- ✅ Respecter l’architecture **MVC** (Model, Repository, Service, Controller)
- ✅ Tester les endpoints avec **Postman**
- ✅ Structurer un projet avec **Spring Boot 3, Java 17 ou +, JPA, Lombok**
- ✅ Générer une documentation future avec **Swagger** (optionnel)

---

## 🧱 Technologies utilisées

| Outil              | Version  |
|--------------------|----------|
| Java               | 17 ou +  |
| Spring Boot        | 3.5.0    |
| Spring Data JPA    | 3.5.0    |
| MySQL              | 8.0      |
| Lombok             | 1.18.38  |
| Maven              | 3.x      |
| Postman            | Dernière |
| IntelliJ IDEA      | 2024.1   |

---

## 🗃️ Structure du projet

```
financiapro/
├── controller/         # Contrôleurs REST
├── model/              # Entités JPA
├── repository/         # Interfaces JPA
├── service/            # Logique métier
├── resources/
│   └── application.properties
└── FinanciaProApplication.java
```

---

## 📊 Modèle de données

- **User**
    - id
    - prénom
    - nom
    - email
    - apiKey

- **BudgetItem**
    - id
    - type (INCOME / EXPENSE)
    - montant
    - description
    - date
    - user

- **LoanRequest**
    - id
    - borrower (User)
    - lender (User)
    - montant
    - intérêt
    - durée (mois)
    - statut (PENDING / ACCEPTED / REFUSED)

- **Repayment**
    - id
    - loanRequest
    - montant
    - date
    - commentaire

---

## 🔁 Relations clés

- Un `User` peut avoir plusieurs `BudgetItem`
- Un `User` peut **créer** ou **accepter** un `LoanRequest`
- Un `LoanRequest` accepté est suivi par des `Repayment`

---

## 🚀 Démarrage rapide

1. **Cloner le projet**
   ```bash
   git clone https://github.com/jordanDev34/financiapro.git
   cd financiapro
   ```

2. **Configurer la base de données**

Dans `src/main/resources/application.properties` :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/financiapro
   spring.datasource.username=root
   spring.datasource.password=indique_ton_mot_de_passe
   spring.jpa.hibernate.ddl-auto=update
   ```
Indiquer le mot de passe utilisé dans MySQL Workbench

3. **Lancer le projet via git bash ou bien clic droit sur le fichier 'FinanciaProApplication.java' puis => Run 'FinanciaProApplication.main()'**
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 📬 Endpoints (exemples)

### ✅ POST /users – Ajouter un utilisateur
```json
{
  "prenom": "Loic",
  "nom": "Formateur_en_herbe",
  "email": "loic@example.com",
  "apiKey": "api-key-formateur"
}
```
![Capture POSTMAN](docs/PostUserPostman.jpg)

---

### ✅ GET /users – Liste des utilisateurs
![Capture POSTMAN](docs/GetAllUsersPostman.jpg)

---

### 🔒 À venir
- Authentification par API Key
- Tests avec Postman Collections
- Swagger UI

---

## ✍️ Auteur

**Jordan LOBRY et Rayan LEBEC**  
Étudiant Bachelor EPSI | Promo 2025

---

## 📝 Licence

Projet à but pédagogique – non destiné à un usage en production.
