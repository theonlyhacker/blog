package liu.com.Service;

import liu.com.Dao.userDao;
import liu.com.Entity.User;

import java.util.List;

public class userService {
    //    添加用户
    public User adduser(User user) {
        userDao dao = new userDao();
        User newuser = dao.addUser(user);
        return newuser;
    }

    //  用獲取信息的方法直接判斷當前是否有該用戶,
    //  2019/11/27,删除该方法，直接用查找用户信息函数可以完成该目标
    /*public boolean login(String userName, String password) {
        User user = getUserByUserName(userName);
        if (user == null)
            return false;
        if (!user.getPassword().equals(password))
            return false;
        return true;
    }*/

    //    根据用户名或用户id獲取用戶信息
    public User getUserByUserName(String userName) {
        userDao dao = new userDao();
        return dao.findByUserInfo(userName);
    }

    //  添加用户之前先看看是否存在该用户
    public boolean isExistUser(String userName) {
        userDao userDao = new userDao();
        boolean exist = userDao.exist(userName);
        return exist;
    }

    //    更新用户信息
    public User update(User user) {
        userDao userDao = new userDao();
        User newuser = userDao.update(user);
        return newuser;
    }

    //    查找所有用户信息
    public List<User> findAllUsers() {
        userDao userDao = new userDao();
        List<User> list = userDao.findAllUsers();
        return list;
    }

    //    禁用/恢复用户
    public int prohibitPerson(String id, String status) {
        userDao userDao = new userDao();
        int ret = userDao.prohibitUser(id, status);
        return ret;
    }
}
