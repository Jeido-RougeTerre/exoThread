# Création de threads en étendant la classe `Thread`

Crée une classe `MonPremierThread` qui étend `Thread` et redéfinit la méthode `run()` pour afficher un message
contenant le nom du thread et un compteur (par exemple, de 1 à 10).
Dans la méthode `main`, crée et démarre 3 threads de cette classe.


Résultat possible :

```bash
Thread-1 - Compteur : 1
Thread-0 - Compteur : 1
Thread-2 - Compteur : 1
Thread-1 - Compteur : 2
Thread-2 - Compteur : 2
Thread-0 - Compteur : 2
Thread-2 - Compteur : 3
Thread-0 - Compteur : 3
Thread-1 - Compteur : 3
Thread-1 - Compteur : 4
Thread-0 - Compteur : 4
Thread-2 - Compteur : 4
Thread-0 - Compteur : 5
Thread-2 - Compteur : 5
Thread-1 - Compteur : 5
Thread-2 - Compteur : 6
Thread-0 - Compteur : 6
Thread-1 - Compteur : 6
Thread-0 - Compteur : 7
Thread-1 - Compteur : 7
Thread-2 - Compteur : 7
Thread-2 - Compteur : 8
Thread-0 - Compteur : 8
Thread-1 - Compteur : 8
Thread-1 - Compteur : 9
Thread-2 - Compteur : 9
Thread-0 - Compteur : 9
Thread-1 - Compteur : 10
Thread-2 - Compteur : 10
Thread-0 - Compteur : 10
```