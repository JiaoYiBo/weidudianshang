package com.example.aason.weidudianshang.bean;

public class ShangpinBean {
    private int count;
    private int commodityId;

    public ShangpinBean(int count, int commodityId) {
        this.count = count;
        this.commodityId = commodityId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }
}
