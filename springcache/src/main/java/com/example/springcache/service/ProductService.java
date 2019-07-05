package com.example.springcache.service;

import com.example.springcache.pojo.Product;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 14:25 2019-7-3-0003
 * @company:北京今汇在线
 */
@Service
@CacheConfig(cacheNames = "product")
public class ProductService {
    @Cacheable(cacheNames = "product1",key = "#root.methodName+'['+#id+']'")
    //@Cacheable(cacheNames = {"product1","product2"})// 默认key为参数，多个参数SimpleKey [arg1,arg2]
    //@Cacheable(cacheNames = "product",key = "#root.methodName+'['+#id+']'")
    //@Cacheable(cacheNames = "product",keyGenerator = "myKeyGenerator")
    //@Cacheable(cacheNames = "product",key = "#root.methodName+'['+#id+']'",condition="#a0>10",unless = "#a0==11") //或者condition="#id>10")
    public Product getProductById(Long id){
        System.out.println("service  getProductById "+id);
        Product product =new Product(id,"++"+id);
        System.out.println(product);
        return product;
    }
}
