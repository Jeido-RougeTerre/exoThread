# Gestion des résultats avec `Callable` et `ExecutorService`


Crée une classe `CalculateurCallable` qui implémente l’interface `Callable`. Cette classe doit retourner le cube d’un nombre entier donné.  
Dans la méthode `main`, utilise un `ExecutorService` simple (créé avec `Executors.newSingleThreadExecutor()`) pour soumettre des tâches avec des nombres de 1 à 5, récupère les résultats à l’aide de `Future` et affiche-les.

Résultat possible :

```bash
Le cube de 1 est 1
Le cube de 2 est 8
Le cube de 3 est 27
Le cube de 4 est 64
Le cube de 5 est 125
```