package sdk;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Peter on 23/10/15.
 */
public class ServerConnection {

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

        Client client = Client.create(); // opretter et instans af Client

        // Opretter et objekt af WebResource med URI der passer til serverens adresse
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);

        //Bruger get() metoden fra WebResource klassen til at lave en HTTP GET forespørgesel  til vores web resource
        //dvs. hvis vores URI til WebResource svare til serverens adresse
        //så sendes der en HTTP GET forespørgelse til den resource der har adresse svarene til URI'en (altså serveren)
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        //Exception i tilgælde af der ikke returneres 200 eller 201 fra serveren
        if (response.getStatus() != 200 && response.getStatus() !=201) {
            throw new RuntimeException("Failed! Error: " + response.getStatus());
        }
        //ClientResponse objektet (response) repræsenterer et HTTP response i klienten, som her returneres
        return response.getEntity(String.class);
    }

    public String post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        if (response.getStatus() != 200 && response.getStatus() !=201) {
            throw new RuntimeException("Failed! Error: " + response.getStatus());
        }
        return response.getEntity(String.class);

    }

    public String put(String json, String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        if (response.getStatus() != 200 && response.getStatus() !=201) {
            throw new RuntimeException("Failed! Error: " + response.getStatus());
        }

            return response.getEntity(String.class);
        }

    public String delete(String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        if (response.getStatus() != 200 && response.getStatus() !=201) {
            throw new RuntimeException("Failed! Error: " + response.getStatus());
        }

        return response.getEntity(String.class);

    }

    public User logIn (User user) {
        String path = "login/";
        String json = new Gson().toJson(user, User.class);
        String response;

        try {
            response = post(json, path);
        }
        catch (Exception ex) {
            return null;
        }

        user.setId(new Gson().fromJson(response.toString(), User.class).getId());
        return user;

    }
    public Game playGame (Game game) {
        String path = "games/";
        String json = new Gson().toJson(game, Game.class);

        try {
            post(json, path);
        }
        catch (Exception ex) {
            return null;
        }
        return null;
    }

    public boolean joinGame (Game game) {
        String path = "games/join/";
        String json = new Gson().toJson(game, Game.class);

        try {
            put(json, path);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Game startGame (Game game) {
        String path = "games/start/";
        String json = new Gson().toJson(game, Game.class);

        try {
            put(json, path);
        }
        catch (Exception ex) {
            return null;
        }
        return null;
    }

    public boolean deleteGame(String gameId) {
        String path ="games/" +gameId;

        try {
            delete(path);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Score[] highScore(){
        String path ="scores/";
        String response;

        try {
            response = get(path);
        }
        catch (Exception ex) {
            return null;
        }
        return new Gson().fromJson(response, Score[].class);
    }
}
