# Pipelines de traitement parallèles avec threads virtuels

**Objectif :**
Créez un pipeline de traitement où chaque étape est gérée par un thread virtuel. Par exemple :
1. Lecture de données (thread virtuel).
2. Traitement des données (thread virtuel).
3. Stockage des résultats (thread virtuel).

**Astuce : Utilisation de `CompletableFuture` pour gérer un pipeline :**

- `CompletableFuture.runAsync()` : Permet d'exécuter une tâche de manière asynchrone dans un executor spécifique.
- `thenRunAsync()` : Chaine une tâche à exécuter après la fin de la précédente, de manière asynchrone.
- `join()` : Bloque le thread principal jusqu'à ce que la tâche (ou chaîne de tâches) soit terminée.

**Exemple de syntaxe avec deux étapes :**

```java
CompletableFuture<Void> step1 = CompletableFuture.runAsync(() -> {
    System.out.println("Étape 1 : Lecture des données");
}, executor);

CompletableFuture<Void> step2 = step1.thenRunAsync(() -> {
    System.out.println("Étape 2 : Traitement des données");
}, executor);

step2.join(); // Attend la fin des deux étapes
```

**Résultat attendu :**

- Les étapes sont exécutées séquentiellement mais de manière asynchrone, chaque étape utilisant un thread virtuel.