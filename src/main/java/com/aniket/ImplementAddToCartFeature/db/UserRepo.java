package com.aniket.ImplementAddToCartFeature.db;

import com.aniket.ImplementAddToCartFeature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepo {

    private JdbcTemplate template;

    @Autowired
    private void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Integer save(User user) {
        String sql = "INSERT INTO users(userName, email, password) VALUES (?, ?, ?)";

        return template.update(sql, user.getUserName(),
                user.getEmail(),
                user.getPassword());
    }

    private String originalPassword;
    public String findPassword(String email) {
        String sql = "SELECT password FROM users WHERE email = ?";


        template.query(sql, new String[] {email},
                (rs, rowNum) -> {
                    originalPassword = rs.getString("password");
                    return null;
                }
        );

        return originalPassword;
    }
}
