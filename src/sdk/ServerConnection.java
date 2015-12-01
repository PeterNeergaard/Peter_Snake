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

    private String hostAddress;
    private int port;

    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }

    public String get(String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class);


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

        if (response != null) {
            return response.getEntity(String.class);

        }
        return "";
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

        User currentUser = new User();
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setId(new Gson().fromJson(response.toString(), User.class).getId());

        return currentUser;

    }
    public Game playGame (Game game) {
        String path = "games/";
        String json = new Gson().toJson(game, Game.class);
        String response;

        try {
            response = post(json, path);
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
        Score[] scores = new Gson().fromJson(response, Score[].class);
        return scores;
    }




}
