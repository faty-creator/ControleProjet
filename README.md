##Gestion des Étudiants et Inscriptions

##Contexte :

-Dans le cadre de la gestion académique, il est essentiel d'assurer un suivi efficace des étudiants et de leurs inscriptions aux cours. Les méthodes traditionnelles de gestion manuelle ou basées sur des fichiers statiques peuvent conduire à des erreurs, une perte de temps et une mauvaise organisation. Un système informatisé permettrait une gestion plus fluide et efficace des inscriptions aux cours, tout en offrant une meilleure expérience aux étudiants et aux administrateurs.
---
##Problématique:

-Les universités et institutions académiques rencontrent souvent des difficultés dans la gestion des inscriptions aux cours. Les systèmes obsolètes ou la gestion manuelle peuvent engendrer :

Des erreurs d'inscription,

Un manque de suivi des étudiants par cours,

Des difficultés dans la recherche et la gestion des informations académiques,

Une expérience utilisateur peu optimisée pour les administrateurs et les étudiants.
---
##Objectif:

-L'objectif de ce projet est de développer une application qui facilite la gestion des étudiants et de leurs inscriptions aux cours. 
---
##L'application doit :

Permettre un suivi précis des inscriptions aux cours,

Optimiser la gestion des étudiants et des cours,

Offrir des outils de recherche et de filtrage avancés pour une meilleure expérience utilisateur,

Fournir une visualisation claire des inscriptions aux cours.
---
##Tables de Données:

Etudiant (id, nom, prénom, date_naissance, email)

Cours (id, intitule, professeur, salle)

Inscription (id, etudiant_id, cours_id, date_inscription)
---
##Fonctionnalités Principales:

Gestion des étudiants : Ajout, modification et suppression d'étudiants.

Inscription des étudiants aux cours : Gestion des inscriptions et des retraits d'étudiants.

Filtrage des inscriptions : Possibilité de filtrer les étudiants par cours.

Recherche d'étudiants : Recherche rapide d'un étudiant par son nom.

Visualisation des données : Graphique en barres pour représenter le nombre d'étudiants inscrits par cours.