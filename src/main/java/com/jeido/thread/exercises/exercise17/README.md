# Gestion d'un inventaire avec `ConcurrentHashMap`

Crée une application où plusieurs threads effectuent une simulation d'achats et de réapprovisionnements dans un magasin.
Chaque article du magasin est représenté par une clé unique dans un `ConcurrentHashMap`.
Les threads doivent réduire le stock d'un article lorsqu'un achat est simulé et augmenter le stock lors d'un réapprovisionnement.



Résultat possible  :

```bash
Acheteur-1 a acheté 1 unité de ProduitC
Acheteur-2 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitA
Acheteur-1 a acheté 1 unité de ProduitB
Acheteur-2 a acheté 1 unité de ProduitB
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-1 a acheté 1 unité de ProduitC
Acheteur-2 a acheté 1 unité de ProduitB
Réapprovisionneur a réapprovisionné 10 unités de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-2 a acheté 1 unité de ProduitB
Acheteur-1 a acheté 1 unité de ProduitB
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitC
Acheteur-2 a acheté 1 unité de ProduitB
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitC
Inventaire final : {ProduitC=14, ProduitA=72, ProduitB=44}
```

Résultat possible 2 :

```bash
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitC
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitB
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitB
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitC
Réapprovisionneur a réapprovisionné 10 unités de ProduitC
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitB
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-2 a acheté 1 unité de ProduitB
Acheteur-2 a acheté 1 unité de ProduitC
Inventaire final : {ProduitC=34, ProduitA=40, ProduitB=56}
```