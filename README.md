# DAW-M3-UF6-Pt1_JDBC
Adaptació del projecte de Bases de Dades a la UF6 de Programació de Persistència a la Base de Dades

DAO: Aquest directori conté classes Java per al patró Data Access Object (DAO). La seva funció és gestionar la capa de dades de l'aplicació, interactuant amb la base de dades per a obtenir i emmagatzemar dades relacionades amb candidats (CandidatDAO.java), candidatures (CandidaturesDAO.java), municipis (MunicipisDAO.java), persones (PersonesDAO.java), províncies (ProvinciesDAO.java) i comunitats autònomes (comunitats_autonomesDAO.java).Encarregada de la arquitectura CRUD.

Importacions: Aquest directori conté les classes utilitzades per a gestionar la importació de dades en l'aplicació. Hi ha classes per a manejar la introducció de candidats, candidatures, comunitats autònomes, persones, províncies, municipis, i altres dades relacionades amb les eleccions com els vots.

Model: Aquest directori conté  les classes Java que defineixen els models de dades utilitzades en l'aplicació, com a Candidat (Candidats.java), Candidatures (Candidatures.java), Comunitats Autònomes (Comunitats_autonomes.java), Municipis (Municipis.java), Persones (Persones.java) i Províncies (Provincies.java)4.

Utils: Aquest directori conté actualment una única classe Java, Connector_MySQL.java, que  gestiona la connexió a una base de dades MySQL fent ús de JDBC.

datos:Fitxers de dades per a realitzar la importació

Main:Classe principal per arrancar el programa

Menu:Classe per a mostrar per pantalla els menus, gestionar la selecció de opcions en aquests i cridar els metodes que calguin en cada moment

