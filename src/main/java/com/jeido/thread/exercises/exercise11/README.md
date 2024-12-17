# Méthode synchronisée

Implémente une classe `BankAccount` avec deux méthodes synchronisées : `deposit()` et `withdraw()`.
Simule plusieurs threads effectuant des dépôts et des retraits.
Assure-toi que le solde du compte reste correct après toutes les opérations.




Résultat possible 1 :

```bash
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-3 a déposé 10, solde actuel : 10
Thread-3 a déposé 10, solde actuel : 20
Thread-3 a déposé 10, solde actuel : 30
Thread-3 a déposé 10, solde actuel : 40
Thread-3 a déposé 10, solde actuel : 50
Thread-1 a déposé 10, solde actuel : 60
Thread-1 a déposé 10, solde actuel : 70
Thread-1 a déposé 10, solde actuel : 80
Thread-1 a déposé 10, solde actuel : 90
Thread-1 a déposé 10, solde actuel : 100
Solde final : 100
```

Résultat possible 2 :

```bash
Thread-1 a déposé 10, solde actuel : 10
Thread-1 a déposé 10, solde actuel : 20
Thread-1 a déposé 10, solde actuel : 30
Thread-1 a déposé 10, solde actuel : 40
Thread-1 a déposé 10, solde actuel : 50
Thread-3 a déposé 10, solde actuel : 60
Thread-3 a déposé 10, solde actuel : 70
Thread-3 a déposé 10, solde actuel : 80
Thread-3 a déposé 10, solde actuel : 90
Thread-3 a déposé 10, solde actuel : 100
Thread-2 a retiré 10, solde actuel : 90
Thread-2 a retiré 10, solde actuel : 80
Thread-2 a retiré 10, solde actuel : 70
Thread-2 a retiré 10, solde actuel : 60
Thread-2 a retiré 10, solde actuel : 50
Solde final : 50
```