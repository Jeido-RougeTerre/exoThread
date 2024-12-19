# Liste partagée avec `CopyOnWriteArrayList`

Implémente une application où plusieurs threads ajoutent des éléments à une liste partagée (par exemple, des noms de produits)
en utilisant `CopyOnWriteArrayList`. Vérifie que la liste finale contient tous les éléments sans duplications.



Résultat possible  :

```bash
Liste finale des produits : [Thread-1-Produit-0, Thread-2-Produit-0, Thread-1-Produit-1, Thread-1-Produit-2, Thread-2-Produit-1, Thread-1-Produit-3, Thread-2-Produit-2, Thread-1-Produit-4, Thread-2-Produit-3, Thread-1-Produit-5, Thread-2-Produit-4, Thread-2-Produit-5, Thread-2-Produit-6, Thread-1-Produit-6, Thread-2-Produit-7, Thread-2-Produit-8, Thread-1-Produit-7, Thread-2-Produit-9, Thread-1-Produit-8, Thread-1-Produit-9]
```