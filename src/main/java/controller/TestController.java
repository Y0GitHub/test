package controller;

import Dao.CommodityDao;
import entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import util.PageUitl;
import utlis.CustomerJsonSerializer;
import utlis.Json;

import java.io.IOException;
import java.util.List;

/**
 * @Author: ky
 * @Date: 2018/10/15 13:26
 */
@Controller
public class TestController {
    @Autowired
    private CommodityDao commodityDao;
    @RequestMapping("aaa")
    @ResponseBody
    //@Json(type = Commodity.class,include = "commodityId")
    public /*ModelAndView*/ List<Commodity> aaa() throws IOException {
      /* ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");*/
        List<Commodity> list= commodityDao.findAllCommodities(null,new PageUitl(0,4));
        CustomerJsonSerializer customerJsonSerializer=new CustomerJsonSerializer();
        customerJsonSerializer.filter(Commodity.class,"commodityId",null);
        List<Commodity> list2=(List<Commodity>) customerJsonSerializer.toObject(list,Commodity.class);
       // modelAndView.addObject("list",list2);
        //return modelAndView;
        return list2;
    }
}
