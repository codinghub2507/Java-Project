package com.smartinventorymanagement.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() throws Exception {
        // Connection string to your MongoDB Atlas cluster
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://inventoryManager:inventory987@cluster0.itufg5f.mongodb.net/SmartInventoryDB?retryWrites=true&w=majority"
        );

        // Force TLS/SSL (Java 25 compatible)
        SSLContext sslContext = SSLContext.getDefault();

        // MongoClient settings
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .applyToSslSettings(builder -> builder.enabled(true).context(sslContext))
                .build();

        return MongoClients.create(settings);
    }
}
