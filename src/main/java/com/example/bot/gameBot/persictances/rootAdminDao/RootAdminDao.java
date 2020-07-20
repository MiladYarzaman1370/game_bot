package com.example.bot.gameBot.persictances.rootAdminDao;

import com.example.bot.gameBot.models.RootAdmin;
import com.example.bot.gameBot.persictances.MyBotMongoDataBase;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class RootAdminDao implements RootAdminDaoI {
    MyBotMongoDataBase mongoDatabase=MyBotMongoDataBase.getInstance();
    MongoCollection<RootAdmin> rootAdminMongoCollection=mongoDatabase.getRootAdminCollection();

    @Override
    public boolean checkISRootAdmin(String telegramId) {

        BasicDBObject query = new BasicDBObject("telegramId", telegramId);
        MongoCursor<RootAdmin> cursor= rootAdminMongoCollection.find(query).cursor();
        if(cursor.hasNext())
            return true;
        else
        return false;
    }
}
