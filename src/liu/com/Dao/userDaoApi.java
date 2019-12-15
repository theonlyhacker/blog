package liu.com.Dao;

import liu.com.Entity.User;

import java.util.List;

public interface userDaoApi {
    //添加用户
    User addUser(User user);

    //更新用户部分信息
    User update(User user);

    //查找用户信息
    User findByUserInfo(String username);

    //查找所有用户信息
    List<User> findAllUsers();

    //禁用用户，考虑到该功能只有一个userId参数，就不用这里的update方法了，重新写一个
    int prohibitUser(String id, String status);
}
