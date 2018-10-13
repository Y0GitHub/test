package controller;

import Dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ky
 * @Date: 2018/10/12 8:57
 */
@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;
    @PostMapping("/login")
    @ResponseBody
    public String login(User user){
        System.out.println(user.getQQ()+"======"+user.getPassword());
        if(userDao.login(user).size()==1){
            return "ok";
        }
        else{
            return "no";
        }
    }
    @RequestMapping("/")
    public String a(){
        return "QQ";
    }
}
