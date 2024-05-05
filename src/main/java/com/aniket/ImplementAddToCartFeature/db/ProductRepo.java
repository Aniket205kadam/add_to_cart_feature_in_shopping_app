package com.aniket.ImplementAddToCartFeature.db;

import com.aniket.ImplementAddToCartFeature.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepo {

    private JdbcTemplate template;
    private Product product;

    @Autowired
    public void setProduct(Product product) {
        this.product = product;
    }

    @Autowired
    private void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Integer save(Product product) throws IOException {
        String sql = "INSERT INTO products (productImage, productName, productPrice, productDescription)" +
                "VALUES (?, ?, ?, ?)";
        return template.update(sql, product.getProductImage().getBytes(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductDescription());
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        RowMapper<Product> mapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
//                product.setProductImage(rs.("productImage"));
                return null;
            }
        };

        return template.query(sql, mapper);
    }
}
