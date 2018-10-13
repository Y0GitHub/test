package controller;

import Dao.CommodityDao;
import entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import util.PageUitl;

import javax.validation.Valid;

/**
 * @Author: ky
 * @Date: 2018/10/2 16:43
 */
@Controller
public class CommodityController {
    @Autowired
    private CommodityDao commodityDao;
    @RequestMapping("/list")
    public String index(Model model, @ModelAttribute("condition") String condition,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "4") int size){
        System.out.println("/list");
        PageUitl pageUitl=new PageUitl(page,size);
        pageUitl.setList(commodityDao.findAllCommodities(condition,pageUitl));
        model.addAttribute("list",pageUitl);
        return "index";
    }
    @PostMapping(value = {"/updateCommodity"})
    public String update(@Valid Commodity commodity, BindingResult result){

        commodityDao.updateCommodity(commodity);
        return "redirect:/list";
    }

    @PostMapping(value = {"/addCommodity"})
    public String add(@Valid Commodity commodity, BindingResult result){

        commodityDao.addCommodity(commodity);
        return "redirect:/list";
    }
    @GetMapping("/deleteCommodity")
    @ResponseBody
    public String delete(@Valid Commodity commodity, BindingResult result){
        commodityDao.deleteCommoditiy(commodity);
        return "success";
    }
}
