package com.muzhevsky.spring.configs;

import com.muzhevsky.spring.jdbc.DatabaseSignInData;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class JDBCConfig {
    @Bean("mySqlOfficeSignInData")
    public DatabaseSignInData mySqlOfficeSignInData(){
        return new DatabaseSignInData("jdbc:mysql://localhost:3306/office", "root", "MysqlPassssaP1");
    }

    @Bean("mySqlOfficeConnection")
    @SneakyThrows
    public Connection mySqlConnection(@Qualifier("mySqlOfficeSignInData") DatabaseSignInData data){
        return DriverManager.getConnection(data.getAddress(), data.getLogin(), data.getPassword());
    }
}
