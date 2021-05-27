# TechWorkshop

Das Technik Workshop Projekt besteht aus drei Modulen welche seperat gebaut und gestartet werden
können.

Bauen der Module:
    mvn clean install 

Das Projekt basiert auf der neuesten Java 11 Version. Dies wird benötigt um die Verbindung zur 
Mognodb Cloud Atlas herzustellen. 

Download:
https://adoptopenjdk.net/

Außerdem muss die IP-Adresse in der Cloud hinterlegt werden.

### techworkshop-mongo

Dieses Modul dient für die Verbindung mit einer Mongo Datenbank. Da die Services von diesem Modul in
den anderen aufgerufen wird, muss dieses Modul nicht unbedingt gestartet werden.

Der Service läuft unter: localhost:8082

### techworkshop-schnittstelle

Dieses Modul liefert eine REST-Api für das Projekt.

Der Service läuft unter: localhost:8081

Swagger-Oberfläche: localhost:8081/swagger-ui.html

In der Swagger-Oberfläche werden die Rest-Endpunkte angezeigt und können getestet werden.

### techworkshop-webapp

Dieses Modul liefert ein User Interface, mit welchem der Nutzer arbeiten kann.

Der Service läuft unter: localhost:8080