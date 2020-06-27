package com.zszdevelop.planman.bean;

import com.zszdevelop.planman.base.BaseBean;


public class Sport extends BaseBean{

    private String id;
    private String name;
    private double mets;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
