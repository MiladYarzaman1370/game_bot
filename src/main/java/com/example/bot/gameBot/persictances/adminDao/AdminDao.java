package com.example.bot.gameBot.persictances.adminDao;

import com.example.bot.gameBot.models.Admin;
import com.example.bot.gameBot.models.RootAdmin;
import com.example.bot.gameBot.persictances.MyBotMongoDataBase;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class AdminDao implements AdminDaoI {

    MyBotMongoDataBase mongoDatabase=MyBotMongoDataBase.getInstance();
    MongoCollection<Admin> adminMongoCollection=mongoDatabase.getAdminCollection();

    @Override
    public boolean checkISAdmin(String telegramId) {

        BasicDBObject query = new BasicDBObject("telegramId", telegramId);
        MongoCursor<Admin> cursor= adminMongoCollection.find(query).cursor();
        if(cursor.hasNext())
            return true;
        else
            return false;

    }
}
