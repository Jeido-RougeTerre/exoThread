# Réutilisation de `CyclicBarrier` pour plusieurs étapes

Crée un programme où trois threads passent par plusieurs étapes synchronisées.
À chaque étape, affiche un message indiquant quelle étape a été complétée et quel thread l'a atteinte.


Résultat possible  :

```bash
Thread-3 atteint l'étape 1
Thread-2 atteint l'étape 1
Thread-1 atteint l'étape 1
Thread-1 atteint l'étape 2
Thread-3 atteint l'étape 2
Thread-2 atteint l'étape 2
Thread-2 atteint l'étape 3
Thread-1 atteint l'étape 3
Thread-3 atteint l'étape 3
```