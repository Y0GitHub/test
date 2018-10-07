package DaoImpl;

import Dao.CommodityDao;
import entity.Commodity;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import util.PageUitl;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: ky
 * @Date: 2018/10/6 18:21
 */
@Service
public class CommodityDaoImpl extends HibernateDaoSupport implements CommodityDao {
    public List<Commodity> findAllCommodities(Object condition, PageUitl pageUitl) {
        pageUitl.setPage(pageUitl.getPage()<0?0:pageUitl.getPage());
        pageUitl.setSize(pageUitl.getSize()<0?0:pageUitl.getSize());
        DetachedCriteria criteria=DetachedCriteria.forClass(Commodity.class);
        System.out.println("--"+condition+"----");
        if(condition.toString()=="")
        criteria.add(Restrictions.like("commodityName",(String) condition));
        if((pageUitl.getCount())==-1){
            pageUitl.setCount( this.getHibernateTemplate().
                    findByCriteria(criteria).size());
        }
        return (List<Commodity>) this.getHibernateTemplate().
                findByCriteria(criteria,pageUitl.getPage()*pageUitl.getSize(),pageUitl.getSize());
    }

    public void updateCommodity( Commodity commodity) {
        this.getHibernateTemplate().update(commodity);
    }

    public void addCommodity(Commodity commodity) {
        this.getHibernateTemplate().save(commodity);
    }

    public void deleteCommoditiy(Commodity commodity) {
        this.getHibernateTemplate().delete(commodity);
    }

    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }
}
