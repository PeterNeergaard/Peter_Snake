package sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

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

        String output = response.getEntity(String.class);
        System.out.println(output);

        return output;
    }

    public ClientResponse post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        return response;

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

    public String stringMessageParser(String json)
    {
        JSONParser jsonParser = new JSONParser();

        String message = "";
        try
        {
            Object obj = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            message = ((String) jsonObject.get("message"));

        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return message;

    }

    public ArrayList<User> getUsers() {
        String jsonData = "users/";

        ArrayList<User> users = new Gson().fromJson(jsonData, new TypeToken<ArrayList<User>>() {

        }.getType());

        return users;
    }

    public ArrayList<Game> getOpenGames() {
        String jsonData = ("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Game>>() {

        }.getType());

        return openGames;
    }

    public String joinGame(Game game)
    {
        String jsonData = put(new Gson().toJson(game), "games/join/");

        return stringMessageParser(jsonData);
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


}
