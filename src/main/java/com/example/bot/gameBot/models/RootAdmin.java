package com.example.bot.gameBot.models;

import com.example.bot.gameBot.ConstVariable;
import org.bson.types.ObjectId;

public class RootAdmin  extends User {
    public RootAdmin() {
        this.userType= ConstVariable.USER_TYPE_ADMIN;
    }

    public RootAdmin(ObjectId id, String userName, String userType, String userTelegramId, String wallet) {
        super(id, userName, userType, userTelegramId, wallet);
        this.userType= ConstVariable.USER_TYPE_ADMIN;
    }
public boolean addAdmin(Admin admin)
{
    return false;
}
public boolean addExam(Exam exam){
        return false;
}
public boolean addTeacher(Teacher teacher){
        return false;
}
public  boolean addCourse(Course course){
        return false;
}
}
