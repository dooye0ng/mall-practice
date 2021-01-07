package com.megait.shoppingmall.controller;

import com.megait.shoppingmall.entity.Product;
import com.megait.shoppingmall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String productHome(){
        return "view/product-home";
    }

    @RequestMapping("list")
    public String productList(Model model){

        List<Product> productList= productService.getAllProducts();
        model.addAttribute("productList", productList);

        return "view/product-list";
    }

    @RequestMapping("cart.do")
    public String cart(@RequestParam("id") int id,
                       HttpServletRequest req,
                       HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart_" + String.valueOf(id))) {
                    int val = Integer.parseInt(cookie.getValue());
                    cookie.setValue(String.valueOf(++val));
                    resp.addCookie(cookie);
                    logger.info(cookie.getName() + " " + String.valueOf(val));
                    return "view/product-list";
                }
            }
        }

        Cookie cookie = new Cookie("cart_" + id, "1");
        resp.addCookie(cookie);

        return "view/product-list";
    }

    @RequestMapping("register")
    public String productRegister(){

        //////////////////////////////////////
        // For Test
        Product product = new Product();

        product.setName("사과");
        product.setContent("맛있는 사과입니다.");
        product.setPrice(30000L);
        product.setStock(10);

        productService.saveProduct(product);
        ///////////////////////////////////////
        return "view/product-register";
    }

    @RequestMapping("payment")
    public String productPayment(HttpServletRequest req, Model model){
        String cookieName;
        String cookieValue;
        int totalPrice = 0;

        Cookie[] cookies = req.getCookies();
        List<Product> productList = new ArrayList<>();
        Product product = null;

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                cookieName = cookie.getName();
                cookieValue = cookie.getValue();

                if (cookieName.substring(0, 4).equals("cart")) {
                    Long id = Long.parseLong(String.valueOf(cookieName.charAt(5)));

                    product = productService.getProductById(id);
                    logger.info(String.valueOf(id));
                    product.setStock(Integer.parseInt(cookieValue));
                    productList.add(product);
                    totalPrice += product.getPrice();
                }
            }
        }

        model.addAttribute("productList", productList);
        model.addAttribute("totalPrice", totalPrice);

        return "view/product-payment";
    }

}
