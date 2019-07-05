package com.example.springcache.pojo;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 14:26 2019-7-3-0003
 * @company:北京今汇在线
 */

public class Product {
    private String name,desc;
    private Long id;

    public Product() {
    }

    public Product(Long id, String name) {
        this.name = name;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
