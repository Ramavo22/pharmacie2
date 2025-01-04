CREATE TABLE laboratoire(
   id SERIAL,
   label VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE maladie(
   id INTEGER,
   label VARCHAR(50) ,
   PRIMARY KEY(id)
);

CREATE TABLE vente(
   id SERIAL,
   date_vente TIMESTAMP NOT NULL,
   name VARCHAR(50) ,
   PRIMARY KEY(id)
);

CREATE TABLE type_produit(
   id SERIAL,
   label VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE produit(
   id SERIAL,
   label VARCHAR(50) ,
   en_stock INTEGER,
   type_produit_id INTEGER NOT NULL,
   labo_id INTEGER,
   PRIMARY KEY(id),
   FOREIGN KEY(type_produit_id) REFERENCES type_produit(id),
   FOREIGN KEY(labo_id) REFERENCES laboratoire(id)
);

CREATE TABLE medicament_maladie(
   id VARCHAR(50) ,
   maladie_id INTEGER NOT NULL,
   medicament_id INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(maladie_id) REFERENCES maladie(id),
   FOREIGN KEY(medicament_id) REFERENCES produit(id)
);

CREATE TABLE stock(
   id VARCHAR(50) ,
   date_mouvement TIMESTAMP NOT NULL,
   entree INTEGER,
   sortie INTEGER NOT NULL,
   medicament_id INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(medicament_id) REFERENCES produit(id)
);

CREATE TABLE vente_detaitls(
   id INTEGER,
   qte INTEGER,
   produit_id INTEGER NOT NULL,
   vente_id INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(produit_id) REFERENCES produit(id),
   FOREIGN KEY(vente_id) REFERENCES vente(id)
);

CREATE TABLE medicament_maladie_non_compatible(
   id INTEGER,
   medicamen_id INTEGER NOT NULL,
   maladie_id INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(medicamen_id) REFERENCES produit(id),
   FOREIGN KEY(maladie_id) REFERENCES maladie(id)
);
