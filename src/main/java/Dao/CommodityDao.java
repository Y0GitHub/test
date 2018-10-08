package Dao;

import entity.Commodity;
import util.PageUitl;

import java.util.List;

/**
 * @Author: ky
 * @Date: 2018/10/6 18:20
 */
public interface CommodityDao {
    void addCommodity(Commodity commodity);
    List<Commodity> findAllCommodities(String condition, PageUitl pageUitl);
    void updateCommodity(Commodity commodity);
    void deleteCommoditiy(Commodity commodity);
}
