package Dao;

import entity.User;
import entity.User2;

import java.util.List;

/**
 * @Author: ky
 * @Date: 2018/10/2 17:02
 */
public interface UserDao  {
    List<User> findOne(String condition);
}
