package com.aniket.ImplementAddToCartFeature.AllControllers;

import com.aniket.ImplementAddToCartFeature.db.ProductRepo;
import com.aniket.ImplementAddToCartFeature.db.SellerRepo;
import com.aniket.ImplementAddToCartFeature.db.UserRepo;
import com.aniket.ImplementAddToCartFeature.models.Product;
import com.aniket.ImplementAddToCartFeature.models.Seller;
import com.aniket.ImplementAddToCartFeature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeController {

    private UserRepo userRepo;
    private SellerRepo sellerRepo;
    private ProductRepo productRepo;

    @Autowired
    private void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Autowired
    private void setSellerRepo(SellerRepo sellerRepo) {
        this.sellerRepo = sellerRepo;
    }

    @Autowired
    private void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping("/")
    public ModelAndView homePage(ModelAndView modelAndView) {
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @RequestMapping("/registerUser")
    public ModelAndView registerUser(User user, ModelAndView modelAndView) {
        Integer rowsAffected = userRepo.save(user);

        modelAndView.addObject("userName", user.getUserName());
        modelAndView.addObject("operation", "sign up");
        
        if(rowsAffected.equals(0)) {
            //failed to save the user
            modelAndView.addObject("status", "failed");
        }
        else {
            //successfully save the user
            modelAndView.addObject("status", "successfully");
        }
        modelAndView.setViewName("userStatus.jsp");

        return modelAndView;
    }

    @RequestMapping("/userLogin")
    public ModelAndView userLogin(User user, ModelAndView modelAndView) {
        modelAndView.addObject("operation", "login");

        if(userRepo.findPassword(user.getEmail()).equals(user.getPassword())) {
            //password correct
            modelAndView.addObject("status", "successfully");
        } else {
            //password wrong
            modelAndView.addObject("status", "failed");
        }

        modelAndView.setViewName("userStatus.jsp");
        return modelAndView;
    }

    @RequestMapping("/registerSeller")
    public ModelAndView registerSeller(Seller seller, ModelAndView modelAndView) {
        Integer rowsAffected = sellerRepo.save(seller);

        modelAndView.addObject("sellerName", seller.getSellerName());
        modelAndView.addObject("operation", "sign up");

        if(rowsAffected.equals(0)) {
            //failed to save the user
            modelAndView.addObject("status", "failed");
        }
        else {
            //successfully save the user
            modelAndView.addObject("status", "successfully");
        }
        modelAndView.setViewName("sellerStatus.jsp");

        System.out.println(seller.getSellerName());
        return modelAndView;
    }

    @RequestMapping("/loginSeller")
    public ModelAndView loginSeller(Seller seller, ModelAndView modelAndView) {
        modelAndView.addObject("operation", "login");

        if(sellerRepo.findPassword(seller.getEmail()).equals(seller.getPassword())) {
            //password correct
            modelAndView.addObject("status", "successfully");
        } else {
            //password wrong
            modelAndView.addObject("status", "failed");
        }

        modelAndView.setViewName("sellerStatus.jsp");
        return modelAndView;
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(Product product, ModelAndView modelAndView) throws IOException {

        Integer rowsAffected = productRepo.save(product);

        if (rowsAffected.equals(0)) {
            //failed to save
            modelAndView.addObject("status", "failed");
        }
        else {
            //successfully to save
            modelAndView.addObject("status", "successfully");
        }
        modelAndView.setViewName("productStatus.jsp");
        return modelAndView;
    }

    @RequestMapping("/products")
    public ModelAndView products(ModelAndView modelAndView) {
        //add the product list
        List<Product> productList = productRepo.findAll();
        return modelAndView;
    }
}
