package sdk;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Peter on 23/10/15.
 */
public class ServerConnection {

    // sætter adresse og port til vores server
    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    //Deklarerer variabler for klassen
    private String hostAddress;
    private int port;

    // Getters til HostAddress og port, til når der skal snakkes med serveren
    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }


    // Metode til at hente data fra databasen gennem serveren, ved brug af HTTP get
    public String get(String path){

        Client client = Client.create(); // opretter af instans af Client

        // Opretter et objekt af WebResource med URI der passer til serverens adresse
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);

        //Bruger get() metoden fra webResource klassen til at lave en HTTP GET forespørgesel  til vores web resource
        /**Forklaring - går ikke igen til lignende metoder
        dvs. hvis vores URI til WebResource svarer til serverens adresse
        så sendes der en HTTP GET forespørgelse til den resource der har adresse svarene til URI'en (altså serveren)*/
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        //Exception i tilfælde af der ikke returneres 200 eller 201 fra serveren
        if (response.getStatus() != 200 && response.getStatus() !=201) {
            throw new RuntimeException("Failed! Error: " + response.getStatus());
        }
        //ClientResponse objektet (response) repræsenterer et HTTP response i klienten, som her returneres
        return response.getEntity(String.class);
    }

    // Metode til at sende ny data til serveren,
    public String post(String json, String path){

        Client client = Client.create(); // opretter en instans af Client

        // opretter et objekt af WebResource med URI der matcher til serverens adresse
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        //bruger post() metoden fra webResource klassen til at lave en HTTP post forespørgesel til vores server
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        //Exception i tilfælde af der ikke returneres 200 eller 201 fra serveren
        if (response.getStatus() != 200 && response.getStatus() !=201) {
            throw new RuntimeException("Failed! Error: " + response.getStatus());
        }
        // returnerer response fra serveren
        return response.getEntity(String.class);

    }

    //metode til at opdatere data fra serveren (ændre ting i databasen)
    public String put(String json, String path) {

        Client client = Client.create(); // opretter en instans af Client

        // opretter et objekt af WebResource med URI der matcher serverens adresse
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        // bruger put() metoden fra webResource klassen til at lave en HTTP put forespørgesel til vores server
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        //Exception i tilfælde af der ikke returneres 200 eller 201 fra serveren
        if (response.getStatus() != 200 && response.getStatus() !=201) {
            throw new RuntimeException("Failed! Error: " + response.getStatus());
        }

        // returnerer response fra serveren
        return response.getEntity(String.class);
        }

    // metode til at slette data fra serveren
    public String delete(String path) {

        Client client = Client.create(); // opretter en instans af Client

        // opretter et objekt af WebResource med UTI der matcher serverens adresse
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        //bruger delete() metoden fra webResource klassen til at lave en HTTP delete forespørgelse til vores sever
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        //Exception i tilfælde af der ikke returneres 200 eller 201 fra serveren
        if (response.getStatus() != 200 && response.getStatus() !=201) {
            throw new RuntimeException("Failed! Error: " + response.getStatus());
        }
        // returnerer response fra serveren
        return response.getEntity(String.class);

    }

    //metode til at logge en bruger in
    public User logIn (User user) {
        String path = "login/"; // sætter en path til vores webResource URI
        String json = new Gson().toJson(user, User.class); //laver java objekter om til Json vha. Gson - her User
        // opretter en String response - bruges i forsøg på at knytte userID til den bruger som logger ind
        String response;

        try {
            response = post(json, path); //kører post metoden med den Json og path vi lige har sat
        }
        catch (Exception ex) { //exception for at sørge for programmet ikke crasher hvis intet tastes
            return null;
        }

        user.setId(new Gson().fromJson(response.toString(), User.class).getId());// forsøg på at få user ID - virker ikke

        return user; // returnerer user

    }
    // metode til at oprette et spil
    public Game playGame (Game game) {
        String path = "games/"; //sætter en path til vores webResource
        String json = new Gson().toJson(game, Game.class); // laver en Json fra game klassen vha. Gson

        try {
            post(json, path); // kører post metoden med den Json og path vi lige har sat
        }
        catch (Exception ex) { //exception for at sørge for programmet ikke crasher hvis intet tastes
            return null;
        }
        return null; //der returneres ikke noget til klienten
    }

    //metode til at join et spil
    public boolean joinGame (Game game) { //boolean da vi skal vide om spillet findes
        String path = "games/join/"; // sætter en path til vores webResource
        String json = new Gson().toJson(game, Game.class); //laver  en Json fra game klassen vha. Gson

        try {
            put(json, path); //kører put metoden med den Json og path vi lige har sat
        }
        catch (Exception ex) { //exception for at sørge for programmet ikke crasher hvis intet tastes
            return false; //i tilfælde af fejl/et spil der ikke findes returneres false
        }
        return true; //findes spillet returneres true
    }

    // metode til at starte spillet
    public Game startGame (Game game) {
        String path = "games/start/"; //sætter en path til vores webResource
        String json = new Gson().toJson(game, Game.class); //laver en Json fra game klassen vha. Gson

        try {
            put(json, path); // kører put metoden med den Json og path vi lige har sat
        }
        catch (Exception ex) { //exception for at sørge for programmet ikke crasher hvis intet tastes
            return null;
        }
        return null; // der returneres ikke noget til klienten
    }

    // metode til at slette et spil
    public boolean deleteGame(String gameId) {
        String path ="games/" +gameId; // sætter en path til webResource, og tilføjer id på spillet der skal slettes

        try {
            delete(path); // kører delete metoden med den path vi har sat (incl. gameID)
        }
        catch (Exception ex) { //exception for at sørge for programmet ikke crasher hvis intet tastes
            return false; //findes spillet ikke returneres false
        }
        return true; //kan den godt finde gameID i databasen returneres true
    }

    // metode til at vise highscore
    public Score[] highScore(){
        String path ="scores/"; // sætter en path til webResource
        String response; // opretter en String, da der skal returneres noget til klienten

        try {
            response = get(path); //kører get metoden med den path vi har sat, og sætter den lig med response
        }
        catch (Exception ex) { //exception for at sørge for programmet ikke crasher hvis intet tastes
            return null;
        }
        return new Gson().fromJson(response, Score[].class); //returnerer en Gson fra den Json der kommer fra serveren
    }
}
