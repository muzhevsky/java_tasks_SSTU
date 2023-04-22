package com.muzhevsky.spring.jdbc;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("OfficeModel")
public class OfficeModel {
    @Autowired
    @Qualifier("mySqlOfficeConnection")
    Connection connection;

    @SneakyThrows
    public <T> T getObject(Class<T> clazz, int id){
        var table = clazz.getSimpleName().toLowerCase();

        try{
            var statement = connection.prepareStatement("select * from " + table + " where id = ?");
            statement.setInt(1, id);
            var set = statement.executeQuery();
            var metadata = set.getMetaData();

            if (set.next())
                return getObjectHelper(clazz, metadata, set);

            return null;
        }
        finally {
            connection.close();
        }
    }

    @SneakyThrows
    public <T> List<T> getObjects(Class<T> clazz){
        var table = clazz.getSimpleName().toLowerCase();

        try{
            var statement = connection.prepareStatement("select * from " + table);
            var set = statement.executeQuery();
            var metadata = set.getMetaData();

            List<T> result = new ArrayList<>(set.getFetchSize());

            while (set.next())
                result.add(getObjectHelper(clazz, metadata, set));

            return result;
        }
        finally {
            connection.close();
        }
    }

    @SneakyThrows
    private <T> T getObjectHelper(Class<T> clazz, ResultSetMetaData metadata, ResultSet set){
        T result = clazz.newInstance();
        for (int i = 1; i <= metadata.getColumnCount(); i++){
            for (var field : result.getClass().getDeclaredFields()){
                if (field.getName().toLowerCase().equals(metadata.getColumnLabel(i).toLowerCase())) {
                    field.setAccessible(true);
                    field.set(result, set.getObject(i));
                }
            }
        }

        return result;
    }
}
