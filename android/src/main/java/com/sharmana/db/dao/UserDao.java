package com.sharmana.db.dao;

import android.util.Log;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.sharmana.db.SharmanaDBHelper;
import com.sharmana.db.domain.User;
import com.sharmana.db.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by strusov on 12.10.2014.
 */
public class UserDao {

    private static final String LOG_TAG = "com.sharmana.UserDao";

    private Dao<User, Integer> usersDao;
    public UserDao(SharmanaDBHelper sharmanaDBHelper) throws SQLException {
        usersDao = sharmanaDBHelper.getUsersDao();
    }

    public void insertUser(UserDTO userDTO) throws SQLException {
        User u = new User();
        u.setExternalId(userDTO.get_id());
        u.setName(userDTO.getName());
        u.setEmail(userDTO.getEmail());
        u.setYandexId(userDTO.getYandex_id());
        usersDao.create(u);
    }

    public User getByExternalId(String externalId) throws SQLException {
        List<User> users = usersDao.queryForEq("externalId", externalId);
        if(users != null && users.size() > 0 ) {
            return users.get(0);
        }
        return null;
    }

    public void setActive(User user) {
        try {
            UpdateBuilder<User, Integer> builder = usersDao.updateBuilder();
            builder.updateColumnValue("isActive", false);
            builder.update();

            user.setIsActive(true);
            usersDao.update(user);
        } catch (SQLException e) {
            Log.e(LOG_TAG, "can't update user isActive");
        }
    }

    public User getActiveUser() {
        User user = null;

        try {
            List<User> users = usersDao.queryForEq("isActive", true);
            if (users.size() > 0){
                user = users.get(0);
            }
        } catch (SQLException e) {
            Log.e(LOG_TAG, "Can't find active user");
        }

        return user;
    }


    public List<User> getAllUser() throws SQLException {
        return usersDao.queryForAll();
    }
}
