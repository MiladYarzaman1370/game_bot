package com.example.bot.gameBot.models;

import com.example.bot.gameBot.ConstVariable;
import org.bson.types.ObjectId;

public class Admin extends RootAdmin{
    public Admin() {
        this.userType=ConstVariable.USER_TYPE_ADMIN;
    }

    public Admin(ObjectId id, String userName, String userType, String userTelegramId, String wallet) {
        super(id, userName, userType, userTelegramId, wallet);
        this.userType=ConstVariable.USER_TYPE_ADMIN;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        return false;
    }
}
