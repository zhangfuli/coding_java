package dao.impl;

import dao.UserDao;
import entity.ZflUserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    Configuration conf = new Configuration();
    SessionFactory sFactory = conf.configure("hibernate.cfg.xml").buildSessionFactory();
    Session session = sFactory.openSession();
    Transaction transaction = session.beginTransaction();
    public String addUser(ZflUserEntity user) {
        session.save(user);
        transaction.commit();
        return "success";
    }

    public String findUser() {
       // List<ZflUserEntity> list = session.createQuery("from ZflUserEntity").list();
        List<ZflUserEntity> list=session.createCriteria(ZflUserEntity.class).list();

        for (ZflUserEntity user : list) {
            System.out.println(user.getName());
            System.out.println(user.getPassword());
        }

        return "success";
    }
}
