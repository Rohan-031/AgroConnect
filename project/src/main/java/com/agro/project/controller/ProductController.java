package com.agro.project.controller;

import com.agro.project.entity.Product;
import com.agro.project.entity.Seller;
import com.agro.project.service.ProductDaoImpl;
import com.agro.project.service.SellerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDaoImpl productDoaImpl;
    @Autowired
    private SellerDaoImpl sellerDaoImpl;

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productDoaImpl.getProducts();
    }

    @PostMapping("/add/{sellerId}")
    public Product add(@RequestBody Product product, @PathVariable int sellerId) {
        Product product1=new Product();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setCategory(product.getCategory());
        product1.setDescription(product.getDescription());
        product1.setSellingDescription(product.getSellingDescription());
        product1.setQuantity(product.getQuantity());
        Seller seller=sellerDaoImpl.findById(sellerId);
        product1.setSeller(seller);
        return productDoaImpl.save(product1);
    }
}
