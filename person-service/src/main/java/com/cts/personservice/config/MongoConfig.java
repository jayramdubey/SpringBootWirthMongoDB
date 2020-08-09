package com.cts.personservice.config;


import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongo.database}")
    private String dataBaseName;

    @Value("${mongo.url}")
    private String mongoUrl;

    @Override
    @Bean
    public MongoClient mongoClient() {
        ConnectionString connection = new ConnectionString(mongoUrl);
        return MongoClients.create(connection);
    }

    @Override
    protected String getDatabaseName() {
        return dataBaseName;
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(),getDatabaseName());
    }


}
