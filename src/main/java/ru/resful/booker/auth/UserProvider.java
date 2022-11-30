package ru.resful.booker.auth;

import com.google.gson.Gson;
import ru.resful.booker.models.UserModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UserProvider {

    private static HashMap<String,Map<String,String>> users;

    static {
        try {
            //todo разобраться с путем к resources
            users = new Gson().fromJson(Files.newBufferedReader(Paths.get("src/test/resources/users.json")), HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserModel getUserByName(String name){

        return new UserModel(users.get(name).get("username"),users.get(name).get("password"));
    }

}
