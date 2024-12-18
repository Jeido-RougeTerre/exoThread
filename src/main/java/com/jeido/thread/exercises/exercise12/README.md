# Synchronisation de blocs

Crée une classe `SharedResource` avec une liste partagée (`List<Integer>`).
Utilise des blocs synchronisés pour garantir qu'un seul thread à la fois puisse ajouter ou supprimer des éléments.
Simule plusieurs threads effectuant ces opérations.


Résultat possible 1 :

```bash
Thread-1 a ajouté 0
Thread-1 a ajouté 1
Thread-1 a ajouté 2
Thread-1 a ajouté 3
Thread-1 a ajouté 4
Thread-2 a supprimé 0
Thread-2 a supprimé 1
Thread-2 a supprimé 2
Thread-2 a supprimé 3
Thread-2 a supprimé 4
État final de la liste : []
```


Résultat possible 2 :

```bash
Thread-2 n'a rien à supprimer.
Thread-2 n'a rien à supprimer.
Thread-2 n'a rien à supprimer.
Thread-2 n'a rien à supprimer.
Thread-2 n'a rien à supprimer.
Thread-1 a ajouté 0
Thread-1 a ajouté 1
Thread-1 a ajouté 2
Thread-1 a ajouté 3
Thread-1 a ajouté 4
État final de la liste : [0, 1, 2, 3, 4]
```