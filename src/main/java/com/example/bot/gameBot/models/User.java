package com.example.bot.gameBot.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public  abstract class User {
    @BsonProperty("_id")
    @BsonId
    private ObjectId id;
    private String userName;
    protected String userType;
    private String telegramId;
    private String wallet;

    public User() {
    }
    public User(ObjectId id, String userName, String userType, String telegramId, String wallet) {
        this.id = id;
        this.userName = userName;
        //this.userType = userType;
        this.telegramId = telegramId;
        this.wallet = wallet;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }
}
