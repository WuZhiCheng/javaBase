package com.example.springcache.controller;

import com.example.springcache.pojo.Product;
import com.example.springcache.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")  //读取第一次之后,第二次service里不会打印日志,表示从redis里获取
    public Product getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return product;
    }

   /* @GetMapping("/product")
    public Product updateProduct(Product product) {
        productService.updateProduct(product);
        return product;
    }

    @GetMapping("/delproduct")
    public String delProduct(@RequestParam(value="id") Long id) {

        productService.deleteProductById(id);
        return "ok";
    }

    @GetMapping("/product/name/{productName}")
    public Product getEmpByLastName(@PathVariable("productName") String productName){
        return productService.getProductByName(productName);
    }*/
}