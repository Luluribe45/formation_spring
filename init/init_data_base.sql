/* Base de données: base_personnes */
DROP DATABASE IF EXISTS base_personnes;
/*DROP USER IF EXISTS 'application'@'localhost';*/
CREATE DATABASE base_personnes DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER IF NOT EXISTS'application'@'localhost' IDENTIFIED BY 'passw0rd';
/* For MYSQL 8 */
GRANT ALL PRIVILEGES ON base_personnes.* TO'application'@'localhost';
/* For MYSQL 5 */
/*GRANT ALL ON base_personnes.* TO 'application'@'localhost' IDENTIFIED BY 'passw0rd';*/
USE base_personnes;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS Personne;

 CREATE TABLE Personne (
	idPersonne INTEGER PRIMARY KEY AUTO_INCREMENT,
	prenom VARCHAR(100),
	nom VARCHAR(100),
	poids double,
	taille double,
	rue VARCHAR(100),
	codePostal VARCHAR(100),
	ville VARCHAR(100),
	pays VARCHAR(100),
	version int(15)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Julien', 'Marshall',55,160,'rue de Nantes','Laval','53000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Julien', 'Claire',85,175,'rue du Paradis','Paris','75000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Jacques', 'Dupont',62,145,'rue des Passeurs','Paris','75000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Dupont', 'Dupont',62,155,'rue des Passeurs','Paris','75000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Dupond', 'Dupond',62,169,'rue des Passeurs','Paris','75000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Charles', 'Hallyday',100,189,'rue des Feugrais','Rouen','76000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Serge', 'Lama',87,200,'rue des Heureux','Nantes','44000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Vincent', 'Thomas',64,178,'rue de Paris','Rennes','35000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Eric', 'Dummat',78,195,'rue de Versaille','Paris','75000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Nicolas', 'Samuel',112,199,'rue de Saint Louis','Laval','53000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Rémy', 'Guerry',96,186,'rue des Sages','Lyon','69000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Nicolas', 'Drapeau',87,165,'rue Mitterrand','Limoges','87000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Gaelle', 'Letourneau',75,179,'rue Jean François','Rouen','76000','France',0);
 INSERT INTO Personne(prenom,nom,poids,taille,rue,ville,codePostal,pays,version) VALUES ('Anne', 'Claire',85,194,'rue du Paradis','Paris','75000','France',0);
 
