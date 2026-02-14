# DomainFlow — Moteur léger de modélisation de domaine (version Java)

DomainFlow est un moteur Java minimaliste conçu pour modéliser un domaine métier à partir de fichiers JSON, le valider, le compiler en structures internes, puis le rendre sous forme de représentations hiérarchiques (JSON, SVG, etc.).  
Le projet met l’accent sur la clarté, la modularité et l’extensibilité, tout en restant suffisamment simple pour servir de base à des travaux d’architecture logicielle ou de backend.

---

## 📚 Table des matières
- [Pourquoi ce projet existe](#pourquoi-ce-projet-existe)
- [Objectifs](#objectifs)
- [Valeur ajoutée](#valeur-ajoutée)
- [Ce que ce projet démontre](#ce-que-ce-projet-démontre)
- [Fonctionnalités clés](#fonctionnalités-clés)
- [Architecture](#architecture)
- [API REST](#api-rest)
- [CRUD intégré](#crud-intégré)
- [Technos utilisées](#technos-utilisées)
- [Statut](#statut)
- [Évolutions possibles](#évolutions-possibles)

---

## Pourquoi ce projet existe

DomainFlow est né d’un besoin : explorer comment représenter un domaine métier de manière générique, le valider, le compiler et le transformer en structures hiérarchiques exploitables.  
L’objectif n’est pas de créer une application métier, mais un **moteur réutilisable**, propre, et extensible — un socle technique qui illustre une réflexion d’architecture.

---

## Objectifs

- Décrire un domaine via des fichiers JSON simples.
- Charger et valider ces définitions.
- Compiler les entités et relations en un graphe interne.
- Produire des représentations hiérarchiques (JSON, SVG…).
- Fournir une API REST consommable par un front.
- Rester modulaire, extensible et évolutif.

---

## Valeur ajoutée

- Description de domaine claire et lisible.
- Pipeline simple : *load → validate → compile → render*.
- Architecture découpée mais légère.
- Moteur indépendant du framework (Spring n’est utilisé que pour l’API).
- Possibilité d’ajouter facilement de nouveaux renderers.
- Base solide pour un projet d’architecture logicielle ou backend.

---

## Ce que ce projet démontre

- Capacité à concevoir un moteur générique plutôt qu’une simple application CRUD.
- Compréhension de la modélisation de domaine.
- Mise en place d’une architecture modulaire et propre.
- Séparation nette entre logique métier, infrastructure et API.
- Vision évolutive (microservices possibles, mais non nécessaires).
- Maîtrise du backend Java moderne.

---

## Fonctionnalités clés

- Chargement de définitions JSON (entités + relations).
- Validation de cohérence.
- Compilation en graphe interne.
- Renderers interchangeables (JSON, SVG).
- API REST front‑ready.
- CRUD simple pour stocker des définitions de domaine.

---

## Architecture

DomainFlow adopte une structure simple, claire et modulaire :

```
domainflow/
  ├── domain/                 # Modèle + logique métier
  │   ├── Entity.java
  │   ├── Relation.java
  │   ├── DomainGraph.java
  │   ├── DomainValidator.java
  │   └── DomainCompiler.java
  │
  ├── infrastructure/         # I/O, stockage, impl techniques
  │   ├── DomainSource.java
  │   ├── FileDomainSource.java
  │   ├── DomainRepository.java
  │   └── InMemoryDomainRepository.java
  │
  ├── render/                 # Renderers (plug-ins)
  │   ├── Renderer.java
  │   ├── JsonRenderer.java
  │   └── SvgRenderer.java
  │
  ├── api/                    # REST controllers
  │   ├── DomainController.java
  │   └── RenderController.java
  │
  └── DomainFlowApplication.java
```

### Principes d’architecture

- **domain/** : cœur métier pur Java, sans dépendance framework.
- **infrastructure/** : sources de données, stockage, impl techniques.
- **render/** : modules de rendu interchangeables.
- **api/** : exposition REST (Spring Boot).
- **DomainFlowApplication** : point d’entrée.

Cette structure reste simple mais suffisamment découpée pour évoluer vers une architecture hexagonale ou microservices.

---

## API REST

L’API expose deux familles d’opérations :

### 1. Gestion des définitions de domaine (CRUD)

```
POST   /domains
GET    /domains
GET    /domains/{id}
PUT    /domains/{id}
DELETE /domains/{id}
```

Les définitions sont stockées en mémoire via un repository simple.

### 2. Compilation et rendu

```
POST /render/json
POST /render/svg
```

Chaque endpoint prend une définition de domaine et renvoie une représentation compilée.

---

## CRUD intégré

Bien que DomainFlow ne soit pas une application CRUD, un CRUD minimal a été ajouté pour :

- stocker des définitions de domaine,
- permettre des tests rapides,
- cocher les cases d’une application backend complète.

Ce CRUD reste simple et ne pollue pas le moteur.

---

## Technos utilisées

- **Java 17+**
- **Spring Boot** (API REST)
- **Jackson** (JSON)
- **SVG** (rendu hiérarchique)
- **Collections Java** (stockage en mémoire)

---

## Statut

Le projet est en développement actif.  
Les fonctionnalités essentielles sont présentes, et l’architecture est prête pour accueillir :

- de nouveaux renderers,
- des sources de données alternatives,
- une API plus riche,
- une séparation en modules ou microservices.

---

## Évolutions possibles

- Renderer Graphviz, radial, layered.
- Stockage persistant (PostgreSQL, MongoDB…).
- Module CLI dédié.
- Découpage en modules Maven.
- Déploiement en microservices (compiler-service, render-service…).
- Interface web de visualisation.

---

## Licence

License MIT.
