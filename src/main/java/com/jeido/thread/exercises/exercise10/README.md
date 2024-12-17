# Opérations complexes avec `AtomicLong`

Crée une application où chaque thread multiplie une valeur partagée (initialisée à 1) par un nombre donné, en utilisant un `AtomicLong`.
Par exemple, le premier thread multiplie par 2, le second par 3, etc. Affiche la valeur finale après que tous les threads aient terminé.




Résultat possible :

```bash
Thread-1 multiplacateur : 3 = 6
Thread-2 multiplacateur : 4 = 24
Thread-4 multiplacateur : 6 = 144
Thread-3 multiplacateur : 5 = 720
Thread-0 multiplacateur : 2 = 2
Valeur finale : 720
```