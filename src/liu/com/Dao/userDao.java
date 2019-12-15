package liu.com.Dao;

import liu.com.Entity.User;
import liu.com.common.dbObject;
import liu.com.common.generateID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDao implements userDaoApi {

    private dbObject db = new dbObject();
    private generateID id = new generateID();
    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;


    public User addUser(User user) {
        try {
//            連接數據庫
            cn = db.open();

            String sql1 = "insert into blog.users values (?,?,?,?,?,?,?)";
//
            st = cn.prepareStatement(sql1);
//
//            给用户添加id属性
            user.setUserid(id.getUUid());
            user.setRegisterDate(id.date());
//
            st.setString(1, user.getUserid());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.setString(4, user.getTel());
            st.setString(5, user.getSex());
            st.setString(6, user.getStatus());
            st.setString(7, user.getRegisterDate());

//
            st.executeUpdate();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            db.close(cn, st, rs);
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
            cn = db.open();
//
            String sql = "update  blog.users set usersPassword=?,userTel=?,sex=? ,status=? where usersName = ? ";

            st = cn.prepareStatement(sql);

            st.setString(1, user.getPassword());
            st.setString(2, user.getTel());
            st.setString(3, user.getSex());
            st.setString(4,user.getStatus());
            st.setString(5, user.getUsername());
//            執行語句
//            rs = st.executeQuery();
            st.executeUpdate();
//
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(cn, st, rs);
        }
        return user;
    }

    @Override
    public User findByUserInfo(String username) {
        User user = new User();
//
        try {
//            打開數據庫連接
            cn = db.open();
//
            String sql = "select * from blog.users where usersName = ? or id_Users = ?";
//            預處理sql語句
            st = cn.prepareStatement(sql);
//           插入數據
            st.setString(1, username);
            st.setString(2, username);
//            執行語句
            rs = st.executeQuery();
//
            if (rs.next()) {
                user.setUserid(rs.getString("id_Users"));
                user.setUsername(rs.getString("usersName"));
                user.setPassword(rs.getString("usersPassword"));
                user.setTel(rs.getString("userTel"));
                user.setSex(rs.getString("sex"));
                user.setStatus(rs.getString("status"));
                user.setRegisterDate(rs.getString("registerDate"));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(cn, st, rs);
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        try {
            cn = db.open();

            String sql = "select * from users u order by u.registerDate desc";

            st = cn.prepareStatement(sql);

            rs = st.executeQuery();

            List list = new ArrayList();

            while (rs.next()) {
                String id = rs.getString("id_Users");
                String name = rs.getString("usersName");
                String status = rs.getString("status");
                String registerDate = rs.getString("registerDate");
//
                User user = new User();
                user.setUserid(id);
                user.setUsername(name);
                user.setStatus(status);
                user.setRegisterDate(registerDate);
//
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public int prohibitUser(String id,String status) {
        int i=0;
        try{
            cn = db.open();
            String sql = "update users u set u.status=? where u.id_Users=?";
            st = cn.prepareStatement(sql);
            st.setString(1,status);
            st.setString(2,id);
            i = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return i;
    }
}
