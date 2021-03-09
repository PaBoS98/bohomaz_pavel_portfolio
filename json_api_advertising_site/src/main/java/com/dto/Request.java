package com.dto;

import com.Main;
import com.dto.Entity.Ads;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Request {

    private static PreparedStatement preparedStatement;

    public static void create(Ads ad) throws SQLException {
        preparedStatement = Main.connection.prepareStatement("insert into ads(name, description, price) values(?, ?, ?)");
        preparedStatement.setString(1, ad.getName());
        preparedStatement.setString(2, ad.getDescription());
        preparedStatement.setInt(3, ad.getPrice());
        preparedStatement.executeUpdate();
        addLinks(getLastId(), ad.getLinksPhoto());
    }

    private static void addLinks(int id, String[] links) throws SQLException {
        preparedStatement = Main.connection.prepareStatement("insert into photo values(?, ?, ?, ?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, links[0]);
        preparedStatement.setString(3, links[1]);
        preparedStatement.setString(4, links[2]);
        preparedStatement.executeUpdate();
    }

    public static int getLastId() throws SQLException {
        Statement statement = Main.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select id from ads");
        int id = 1;
        if (resultSet.last()) {
            id = resultSet.getInt("id");
        }
        return id;
    }
}
