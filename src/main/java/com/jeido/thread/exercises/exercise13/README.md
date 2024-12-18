# Gestion des tâches concurrentes avec `ReentrantLock`

**Objectif** :
Créer un système où plusieurs tâches tentent d'utiliser une ressource partagée (par exemple, une imprimante). Utiliser un `ReentrantLock` pour garantir qu'une seule tâche accède à la ressource à la fois. Implémentez également une gestion du délai d'attente en utilisant `tryLock(timeout, TimeUnit)` pour gérer les cas où le verrou n'est pas disponible immédiatement.

**Instructions** :
1. Implémentez une classe représentant la ressource partagée (par exemple, une imprimante).
2. Utilisez un `ReentrantLock` pour synchroniser l'accès à cette ressource.
3. Créez plusieurs threads qui tenteront d'accéder à la ressource en appelant une méthode simulant une tâche.
4. Assurez-vous que :
    - Si un thread ne peut pas acquérir le verrou dans un délai raisonnable, il affiche un message d'échec.
    - Une fois la tâche terminée, le verrou est libéré correctement.

**Rappel** :
- `lock()` → Attend toujours jusqu'à ce que le verrou soit disponible.
- `tryLock()` → N'attend pas, retourne immédiatement si le verrou n'est pas disponible.
- `tryLock(timeout, TimeUnit)` → Attend jusqu'à ce que le verrou soit disponible ou que le délai soit écoulé.

Résultat possible  :

```bash
Tâche-1 tente d'utiliser l'imprimante...
Tâche-3 tente d'utiliser l'imprimante...
Tâche-2 tente d'utiliser l'imprimante...
Tâche-1 a acquis le verrou et utilise l'imprimante.
Tâche-1 a terminé d'utiliser l'imprimante et libère le verrou.
Tâche-3 a acquis le verrou et utilise l'imprimante.
Tâche-2 n'a pas pu accéder à l'imprimante (temps d'attente dépassé).
Tâche-3 a terminé d'utiliser l'imprimante et libère le verrou.
Toutes les tâches sont terminées.
```


Résultat possible 2 :

```bash
Tâche-3 tente d'utiliser l'imprimante...
Tâche-1 tente d'utiliser l'imprimante...
Tâche-3 a acquis le verrou et utilise l'imprimante.
Tâche-2 tente d'utiliser l'imprimante...
Tâche-3 a terminé d'utiliser l'imprimante et libère le verrou.
Tâche-1 a acquis le verrou et utilise l'imprimante.
Tâche-1 a terminé d'utiliser l'imprimante et libère le verrou.
Tâche-2 a acquis le verrou et utilise l'imprimante.
Tâche-2 a terminé d'utiliser l'imprimante et libère le verrou.
Toutes les tâches sont terminées.
```