package com.example.aason.weidudianshang.api;

public class ShowApi {
    //.首页
    public static final String Show_Api = "small/commodity/v1/commodityList";
    //圈子
    public static final String Quan_Api = "small/circle/v1/findCircleList";
    //详情
    public static final String Xiang_Api = "small/commodity/v1/findCommodityDetailsById";
    //搜索
    public static final String USER_API="small/commodity/v1/findCommodityByKeyword";
    //足迹
    public static final String Foot_API="small/commodity/verify/v1/browseList";
    //全部订单
    public static final String Ding_Api = "small/commodity/v1/commodityList";
    //代付款
    public static final String Pag_Api = "small/commodity/v1/commodityList";
    //代收获
    public static final String shou_Api = "small/commodity/v1/commodityList";
    //代评价
    public static final String pin_Api = "small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=女装";
    //完成
    public static final String wan_Api ="small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=手机";
    //热销新品
    public static final String hot_Api = "small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=女鞋";
    //魔力时尚
    public static final String Mo_Api = "small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=女装";
    //品质生活
    public static final String P_Api = "small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=男鞋";
    //查询购物车
    public static final String Cha_Api = "small/order/verify/v1/findShoppingCart";
    //同步购物车数据
    public static final String Tong_Api = "small/order/verify/v1/syncShoppingCart";
    //我的圈子
    public static final String WQuan_Api = "small/circle/verify/v1/findMyCircleById";
    //修改昵称
    public static final String Name_Api = "small/circle/verify/v1/findMyCircleById";
    //我的收货地址
    public static final String Addaress_Api = "small/user/verify/v1/receiveAddressList";
    //添加收获地址
    public static final String Add_Api = "small/user/verify/v1/addReceiveAddress";
}
