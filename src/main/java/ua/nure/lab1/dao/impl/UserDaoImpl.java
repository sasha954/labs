package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ua.nure.lab1.dao.UserDao;
import ua.nure.lab1.domain.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static final String INSERT_USER = "insert into user values (default, ?, ?)";
    private static final String UPDATE_USER = "update user set name=?, range=? where id=?";
    private static final String GET_ALL_USERS = "select * from user";
    private static final String GET_USER_BY_ID = "select * from user where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User createUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
             PreparedStatement preparedStatement = con.prepareStatement(INSERT_USER, new String[] {"id"});
             preparedStatement.setString(1, user.getUserName());
             preparedStatement.setString(2, user.getRole());
             return preparedStatement;
        }, keyHolder);

        int userId = (int) Optional.ofNullable(keyHolder.getKeys().get("id")).orElse(0);
        user.setId(userId);
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER, user.getUserName(), user.getRole(), user.getId());
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(GET_ALL_USERS, (rs, rowNum) -> constructUser(rs));
    }

    private User constructUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("name"));
        user.setRole(rs.getString("range"));
        return user;
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.query(GET_USER_BY_ID, this::extractUser, id);
    }

    private User extractUser(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            return constructUser(resultSet);
        }
        return null;
    }
}
