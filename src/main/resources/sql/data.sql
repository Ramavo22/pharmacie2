INSERT INTO typeproduit (label) values
    ('Medicament'),
    ('Accessoire');

INSERT INTO usage (label) VALUES
      ('Injectable'),
      ('Oral'),
      ('Vaginal'),
      ('Oculaire'),
      ('Topique'),
      ('Auriculaire'),
      ('Rectal');

INSERT INTO typepersonne (nom) values
    ('enfant'),
    ('adulte'),
    ('troisème age');


INSERT INTO laboratoire (label) values
    ('Opham'),
    ('Pharmalagasy'),
    ('PHARMATECH');

INSERT INTO maladie (label) VALUES
                                ('Grippe'),
                                ('Fièvre'),
                                ('Douleur musculaire'),
                                ('Inflammation'),
                                ('Brûlures légères'),
                                ('Infections bactériennes'),
                                ('Sinusite'),
                                ('Allergies'),
                                ('Otite'),
                                ('Conjonctivite'),
                                ('Hépatite B'),
                                ('Fongiques'),
                                ('Déshydratation oculaire'),
                                ('Asthme'),
                                ('Rhinite allergique'),
                                ('Migraine'),
                                ('Dermatite'),
                                ('Douleurs abdominales'),
                                ('Anémie'),
                                ('Virus respiratoire');


INSERT INTO produit (laboratoire_id, prix, type_personne_id, type_produit_id, usage_id, label,enstock) VALUES
(1, 5000, 2, 1, 2, 'Paracétamol 500mg',0), -- Antalgique oral pour adulte
(2, 7500, 3, 1, 1, 'Vaccin Anti-Grippe',0), -- Injectable pour troisième âge
(3, 12000, 1, 1, 5, 'Crème Anti-brûlure',0), -- Topique pour enfant
(1, 4500, 2, 1, 2, 'Ibuprofène 400mg',0), -- Anti-inflammatoire oral
(2, 2000, 2, 1, 3, 'Ovule Médicinal',0), -- Vaginal pour adulte
(3, 3000, 1, 1, 6, 'Gouttes Auriculaires',0), -- Auriculaire pour enfant
(1, 8000, 3, 1, 4, 'Collyre Antiseptique',0), -- Oculaire pour troisième âge
(2, 5000, 2, 1, 7, 'Suppositoire Anti-douleur',0), -- Rectal pour adulte
(3, 10000, 3, 1, 1, 'Vaccin Anti-Hépatite B',0), -- Injectable pour troisième âge
(1, 3500, 1, 1, 5, 'Pommade Hydratante',0), -- Topique pour enfant
(2, 9000, 2, 1, 2, 'Antibiotique 500mg',0), -- Oral pour adulte
(3, 15000, 3, 1, 7, 'Suppositoire Fébrile',0), -- Rectal pour troisième âge
(1, 2500, 1, 1, 6, 'Gouttes Nasales Enfant',0), -- Auriculaire pour enfant
(2, 6000, 2, 1, 4, 'Collyre Hydratant',0), -- Oculaire pour adulte
(3, 12000, 3, 1, 2, 'Antihistaminique Oral',0), -- Oral pour troisième âge
(1, 1000, 1, 1, 3, 'Ovule Anti-fongique',0), -- Vaginal pour enfant
(2, 7000, 2, 1, 5, 'Crème Anti-Démangeaison',0), -- Topique pour adulte
(3, 11000, 3, 1, 7, 'Suppositoire pour la Fièvre',0), -- Rectal pour troisième âge
(1, 4000, 2, 1, 6, 'Spray Nasal Hydratant',0), -- Auriculaire pour adulte
(2, 8000, 3, 1, 2, 'Antiviral Oral 250mg',0); -- Oral pour troisième âge


INSERT INTO medicamentmaladie (maladie_id, medicament_id) VALUES
                                                              (1, 1), -- Paracétamol pour la Grippe
                                                              (2, 1), -- Paracétamol pour la Fièvre
                                                              (3, 4), -- Ibuprofène pour les Douleurs musculaires
                                                              (4, 4), -- Ibuprofène pour l'Inflammation
                                                              (5, 3), -- Crème Anti-brûlure pour les Brûlures légères
                                                              (6, 11), -- Antibiotique pour les Infections bactériennes
                                                              (7, 13), -- Gouttes Nasales pour la Sinusite
                                                              (8, 15), -- Antihistaminique pour les Allergies
                                                              (9, 6), -- Gouttes Auriculaires pour l'Otite
                                                              (10, 7), -- Collyre Antiseptique pour la Conjonctivite
                                                              (11, 9), -- Vaccin Anti-Hépatite B pour Hépatite B
                                                              (12, 16), -- Ovule Anti-fongique pour les Fongiques
                                                              (13, 14), -- Collyre Hydratant pour Déshydratation oculaire
                                                              (14, 20), -- Antiviral Oral pour Asthme
                                                              (15, 19), -- Spray Nasal pour Rhinite allergique
                                                              (16, 4), -- Ibuprofène pour Migraine
                                                              (17, 17), -- Crème Anti-Démangeaison pour Dermatite
                                                              (18, 18), -- Suppositoire pour la Fièvre pour Douleurs abdominales
                                                              (19, 10), -- Pommade Hydratante pour Anémie (symptômes liés à la peau)
                                                              (20, 2); -- Vaccin Anti-Grippe pour Virus respiratoire


INSERT INTO vente (produit_id, prixunitaire, quantite, datevente) VALUES
(1, 5000, 10, '2025-01-01 09:00:00'), -- Vente de Paracétamol
(2, 7500, 5, '2025-01-02 10:30:00'), -- Vaccin Anti-Grippe
(3, 12000, 3, '2025-01-03 14:00:00'), -- Crème Anti-brûlure
(4, 4500, 15, '2025-01-04 16:00:00'), -- Ibuprofène
(5, 2000, 20, '2025-01-05 08:30:00'), -- Ovule Médicinal
(6, 3000, 8, '2025-01-06 11:45:00'), -- Gouttes Auriculaires
(7, 8000, 6, '2025-01-07 12:00:00'), -- Collyre Antiseptique
(8, 5000, 12, '2025-01-08 13:15:00'), -- Suppositoire Anti-douleur
(9, 10000, 4, '2025-01-09 10:00:00'), -- Vaccin Anti-Hépatite B
(10, 3500, 7, '2025-01-10 15:30:00'), -- Pommade Hydratante
(11, 9000, 3, '2025-01-11 17:45:00'), -- Antibiotique
(12, 15000, 2, '2025-01-12 09:15:00'), -- Suppositoire Fébrile
(13, 2500, 25, '2025-01-13 11:00:00'), -- Gouttes Nasales Enfant
(14, 6000, 9, '2025-01-14 16:45:00'), -- Collyre Hydratant
(15, 12000, 5, '2025-01-15 14:30:00'), -- Antihistaminique
(16, 1000, 30, '2025-01-16 10:00:00'), -- Ovule Anti-fongique
(17, 7000, 6, '2025-01-17 13:00:00'), -- Crème Anti-Démangeaison
(18, 11000, 3, '2025-01-18 09:45:00'), -- Suppositoire pour la Fièvre
(19, 4000, 18, '2025-01-19 10:30:00'), -- Spray Nasal
(20, 8000, 10, '2025-01-20 15:00:00'); -- Antiviral Oral



