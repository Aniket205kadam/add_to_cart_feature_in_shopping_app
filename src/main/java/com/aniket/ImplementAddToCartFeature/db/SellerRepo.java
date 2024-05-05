package com.aniket.ImplementAddToCartFeature.db;

import com.aniket.ImplementAddToCartFeature.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class SellerRepo {

    private JdbcTemplate template;

    @Autowired
    private void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Integer save(Seller seller) {
        String sql = "INSERT INTO sellers (sellerName, email, password) VALUES (?, ?, ?)";

        return template.update(sql, seller.getSellerName(),
                seller.getEmail(),
                seller.getPassword());
    }

    private String originalPassword;
    public Object findPassword(String email) {
        String sql = "SELECT password FROM sellers WHERE email = ?";


        template.query(sql, new String[] {email},
                (rs, rowNum) -> {
                    originalPassword = rs.getString("password");
                    return null;
                }
        );

        return originalPassword;
    }
}
