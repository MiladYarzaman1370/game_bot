package com.example.bot.gameBot.services;

import com.example.bot.gameBot.ConstVariable;
import com.example.bot.gameBot.models.Admin;
import com.example.bot.gameBot.models.RootAdmin;
import com.example.bot.gameBot.models.Teacher;
import com.example.bot.gameBot.persictances.adminDao.AdminDao;
import com.example.bot.gameBot.persictances.rootAdminDao.RootAdminDao;
import com.example.bot.gameBot.persictances.rootAdminDao.RootAdminDaoI;

public class CheckUserType {
    AdminDao adminDao;
    RootAdminDao rootAdminDao;
    Teacher teacher;
    public String check(String telegramId){
        rootAdminDao=new RootAdminDao();
        adminDao=new AdminDao();
        if(rootAdminDao.checkISRootAdmin(telegramId)){
            return ConstVariable.USER_TYPE_ROOT;
        }else if (adminDao.checkISAdmin(telegramId)){
            return ConstVariable.USER_TYPE_ADMIN;
        }else{
            return ConstVariable.USER_TYPE_STUDENT;
        }

    }
}
