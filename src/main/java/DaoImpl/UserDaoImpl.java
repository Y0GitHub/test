package DaoImpl;

import Dao.UserDao;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;
import entity.Test;
import entity.User;
import entity.User2;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ky
 * @Date: 2018/10/2 21:15
 */
@Service
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public List<User> findOne(String condition) {
       /* DetachedCriteria c=DetachedCriteria.forClass(User.class);
        c.add(Restrictions.like("QQ",condition, MatchMode.ANYWHERE));
        return (List<User>) this.getHibernateTemplate().findByCriteria(c);*/
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getIncludes().add("qQ");
        //String o=JSONObject.toJSONString(this.getHibernateTemplate().loadAll(User.class));
        String s= JSONObject.toJSONString(this.getHibernateTemplate().loadAll(User.class),filter);
        List<User> list= JSONObject.parseArray(s,User.class);
       return list;
    }
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }
}
