package controller;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import com.fasterxml.jackson.annotation.JsonView;
import entity.Test;
import entity.User;
import entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: ky
 * @Date: 2018/10/2 16:43
 */
@Controller
public class CommodityController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/")
    public String index(Model model){

        System.out.println("asd");
        model.addAttribute("list",userDao.findOne(""));
        return "index";
    }
}
