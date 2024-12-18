# Synchronisation de tâches avec `CyclicBarrier`

Crée un programme où trois threads simulent le chargement de données depuis des fichiers différents.
Chaque thread attend les autres à une barrière avant de fusionner les données pour poursuivre.



Résultat possible  :

```bash
Thread-3 commence à charger les données.
Thread-1 commence à charger les données.
Thread-2 commence à charger les données.
Thread-2 a terminé le chargement des données.
Thread-1 a terminé le chargement des données.
Thread-3 a terminé le chargement des données.
Fusion des données terminée. Tous les threads peuvent continuer.
```

Résultat possible 2 :

```bash
Thread-2 commence à charger les données.
Thread-3 commence à charger les données.
Thread-1 commence à charger les données.
Thread-3 a terminé le chargement des données.
Thread-2 a terminé le chargement des données.
Thread-1 a terminé le chargement des données.
Fusion des données terminée. Tous les threads peuvent continuer.
```