package com.example.demoflyway;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class DemoFlywayApplication extends BaseJavaMigration {

    public static void main(String[] args) {
        SpringApplication.run(DemoFlywayApplication.class, args);
    }

    @Override
    public void migrate(Context context) throws Exception {
        String query = "SELECT * FROM USER";
        PreparedStatement ps = context.getConnection().prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(0));
            System.out.println(resultSet.getString(1));
        }
    }
}
