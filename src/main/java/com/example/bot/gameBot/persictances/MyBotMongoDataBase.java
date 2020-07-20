package com.example.bot.gameBot.persictances;




import com.example.bot.gameBot.models.Admin;
import com.example.bot.gameBot.models.RootAdmin;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MyBotMongoDataBase {
    private static MyBotMongoDataBase myBotMongoDataBase;
    private final CodecRegistry pojoCodecRegistry;
    private MongoDatabase mongoDatabase;
    private MongoCollection<RootAdmin> rootAdminCollection;
    private MongoCollection<Admin> adminCollection;


    private MyBotMongoDataBase(){
        pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient= MongoClients.create("mongodb://localhost");
        mongoDatabase=mongoClient.getDatabase("examBotDB").withCodecRegistry(pojoCodecRegistry);
    }
    public static MyBotMongoDataBase getInstance(){
        if(myBotMongoDataBase ==null){
            myBotMongoDataBase =new MyBotMongoDataBase();
            return myBotMongoDataBase;
        }else{
            return myBotMongoDataBase;
        }
    }
    public MongoCollection<RootAdmin> getRootAdminCollection(){
        rootAdminCollection=mongoDatabase.getCollection("rootAdmin",RootAdmin.class);
        rootAdminCollection.withCodecRegistry(pojoCodecRegistry);
        return rootAdminCollection;
    }

    public MongoCollection<Admin> getAdminCollection(){
        adminCollection=mongoDatabase.getCollection("admin",Admin.class);
        adminCollection.withCodecRegistry(pojoCodecRegistry);
        return adminCollection;
    }

}