package com;

import com.dto.ConnectionManager;
import com.dto.Entity.Ads;
import com.dto.ReadFromProperties;
import com.dto.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static spark.Spark.*;

public class Main {

    public static Connection connection;

    static {
        try {
            new ReadFromProperties();
            connection = ConnectionManager.getConnection(ReadFromProperties.getURL(), ReadFromProperties.getUserName(), ReadFromProperties.getPASSWORD());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Ads a = new Ads();
        a.setName("get");
        a.setDescription("Some description");
        a.setLinksPhoto(new String[]{"link1", "link2", "link3"});
        a.setPrice(25);

        Ads b = new Ads();
        b.setName("post");
        b.setDescription("Some description");
        b.setLinksPhoto(new String[]{"link1", "link2", "link3"});
        b.setPrice(25);

        String s = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        System.out.println(s.length());
        get("/get", (request, response) -> a, gson::toJson);
        post("/post", (request, response) -> {
            Request.create(b);
            return response.status();
        });
//        System.out.println(gson.toJson(a));
    }
}

