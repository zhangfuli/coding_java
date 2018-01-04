package dao;

import entity.ZflUserEntity;

public interface UserDao {
     String addUser(ZflUserEntity user);
     String findUser();
}
