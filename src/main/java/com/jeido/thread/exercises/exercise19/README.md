# File d'attente concurrente avec `ConcurrentLinkedQueue`

Crée un programme où plusieurs threads ajoutent et suppriment des éléments d'une file d'attente concurrente (`ConcurrentLinkedQueue`).
Affiche les éléments ajoutés et retirés, en vérifiant que la file reste cohérente.


Résultat possible  :

```bash
Producer a ajouté : Producer-Element-0
Producer a ajouté : Producer-Element-1
Producer a ajouté : Producer-Element-2
Producer a ajouté : Producer-Element-3
Producer a ajouté : Producer-Element-4
Producer a ajouté : Producer-Element-5
Producer a ajouté : Producer-Element-6
Producer a ajouté : Producer-Element-7
Producer a ajouté : Producer-Element-8
Producer a ajouté : Producer-Element-9
Consumer a retiré : Producer-Element-0
Consumer a retiré : Producer-Element-1
Consumer a retiré : Producer-Element-2
Consumer a retiré : Producer-Element-3
Consumer a retiré : Producer-Element-4
Consumer a retiré : Producer-Element-5
Consumer a retiré : Producer-Element-6
Consumer a retiré : Producer-Element-7
Consumer a retiré : Producer-Element-8
Consumer a retiré : Producer-Element-9
État final de la file : []
```


Résultat possible 2 :

```bash
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Producer a ajouté : Producer-Element-0
Producer a ajouté : Producer-Element-1
Producer a ajouté : Producer-Element-2
Producer a ajouté : Producer-Element-3
Producer a ajouté : Producer-Element-4
Producer a ajouté : Producer-Element-5
Producer a ajouté : Producer-Element-6
Producer a ajouté : Producer-Element-7
Producer a ajouté : Producer-Element-8
Producer a ajouté : Producer-Element-9
État final de la file : [Producer-Element-0, Producer-Element-1, Producer-Element-2, Producer-Element-3, Producer-Element-4, Producer-Element-5, Producer-Element-6, Producer-Element-7, Producer-Element-8, Producer-Element-9]

```