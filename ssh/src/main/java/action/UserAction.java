package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.impl.UserDaoImpl;
import entity.ZflUserEntity;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserAction extends ActionSupport {
    BeanFactory fac = new ClassPathXmlApplicationContext("applicationContext.xml");


    ZflUserEntity user=(ZflUserEntity) fac.getBean("user");
    UserDaoImpl userDao = new UserDaoImpl();

    public String add(){
        userDao.addUser(user);
        System.out.println(user.getId());
        System.out.println("success");
        return "success";
    }
    public String find(){
        userDao.findUser();
        System.out.println(user.getName());
        return "success";
    }
}
