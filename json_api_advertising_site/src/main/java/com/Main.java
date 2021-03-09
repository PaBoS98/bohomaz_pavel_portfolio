package com;

import com.dto.AppInter;
import com.dto.ConnectionManager;
import com.dto.Entity.Ads;
import com.dto.ReadFromProperties;
import com.dto.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

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
//
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Ads a = new Ads();
        a.setName("get");
        a.setDescription("Some description");
        a.setLinksPhoto(new String[]{"link1", "link2", "link3"});
        a.setPrice(25);

//        get("/get", (request, response) -> a, gson::toJson);
//        post("/post", (request, response) -> {
//            Request.create(createAd());
//            return "ID: " + Request.getLastId() + " | " + response.status();
//        });

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AppInter();
            }
        });
    }

    private static Ads createAd(){
        Scanner scanner = new Scanner(System.in);
        Ads newAd = new Ads();
        String name;
        while (true) {
            System.out.println("Specify name (max 200 symbols)");
            name = scanner.nextLine();
            if (name.length() <= 200) {
                newAd.setName(name);
                break;
            }
        }

        String description;
        while (true) {
            System.out.println("Specify description (max 1000 symbols)");
            description = scanner.nextLine();
            if (name.length() <= 1000) {
                newAd.setDescription(description);
                break;
            }
        }

        String[] photoLinks = new String[3];
        System.out.println("Specify 3 links to photo (through a gap or separately)");
        photoLinks[0] = scanner.next();
        photoLinks[1] = scanner.next();
        photoLinks[2] = scanner.next();
        newAd.setLinksPhoto(photoLinks);

        while (true) {
            System.out.println("Specify price");
            if (scanner.hasNextInt()) {
                newAd.setPrice(scanner.nextInt());
                break;
            }
        }
        return newAd;
    }
}

