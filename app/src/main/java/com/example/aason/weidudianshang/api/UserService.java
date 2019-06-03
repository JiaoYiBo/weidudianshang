package com.example.aason.weidudianshang.api;

import com.example.aason.weidudianshang.bean.AddBean;
import com.example.aason.weidudianshang.bean.AddressBean;
import com.example.aason.weidudianshang.bean.CartBean;
import com.example.aason.weidudianshang.bean.ChaBean;
import com.example.aason.weidudianshang.bean.DingBean;
import com.example.aason.weidudianshang.bean.FootBean;
import com.example.aason.weidudianshang.bean.HotBean;
import com.example.aason.weidudianshang.bean.MoBean;
import com.example.aason.weidudianshang.bean.PageBean;
import com.example.aason.weidudianshang.bean.PinBean;
import com.example.aason.weidudianshang.bean.PinZhiBean;
import com.example.aason.weidudianshang.bean.QuanBean;
import com.example.aason.weidudianshang.bean.ShouBean;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.bean.TongBean;
import com.example.aason.weidudianshang.bean.UserBean;
import com.example.aason.weidudianshang.bean.WQuanBean;
import com.example.aason.weidudianshang.bean.WanBean;
import com.example.aason.weidudianshang.bean.XiangBean;
import com.example.aason.weidudianshang.bean.XiuBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface UserService {
    //首页
    @GET
    Observable<ShowBean> getShow(@Url String url);
    //圈子
    @GET(ShowApi.Quan_Api)
    Observable<QuanBean> getquan( @QueryMap HashMap<String, String> map);
    //详情
    @GET(ShowApi.Xiang_Api)
    Observable<XiangBean> getxiang( @QueryMap HashMap<String, String> map);
    //搜索
    @GET(ShowApi.USER_API)
    Observable<UserBean> getsou(@QueryMap HashMap<String, String> map);
    //足迹
    @GET(ShowApi.Foot_API)
    Observable<FootBean> getfoot(@HeaderMap HashMap<String,String>params, @QueryMap HashMap<String, String> map);
    //订单
    @GET(ShowApi.Ding_Api)
    Observable<DingBean> getding(@QueryMap HashMap<String, String> map);
    //代付款
    @GET(ShowApi.Pag_Api)
    Observable<PageBean> getpag(@QueryMap HashMap<String, String> map);
    //代收获
    @GET(ShowApi.shou_Api)
    Observable<ShouBean> getshou(@QueryMap HashMap<String, String> map);
    //代评价
    @GET(ShowApi.pin_Api)
    Observable<PinBean> getpin(@QueryMap HashMap<String, String> map);
    //已完成
    @GET(ShowApi.wan_Api)
    Observable<WanBean> getwan(@QueryMap HashMap<String, String> map);
    //热销新品
    @GET(ShowApi.hot_Api)
    Observable<HotBean> gethot(@QueryMap HashMap<String, String> map);
    //魔力时尚
    @GET(ShowApi.Mo_Api)
    Observable<MoBean> getmo(@QueryMap HashMap<String, String> map);
    //品质生活
    @GET(ShowApi.P_Api)
    Observable<PinZhiBean> getPIN(@QueryMap HashMap<String, String> map);
    //查询购物车
    @GET(ShowApi.Cha_Api)
    Observable<ChaBean> getcha(@HeaderMap HashMap<String, String> map);
    //同步购物车
    @FormUrlEncoded
    @PUT(ShowApi.Tong_Api)
    Observable<TongBean> gettong(@HeaderMap HashMap<String, String> map, @Field("data")String tong);
    //我得圈子
    @GET(ShowApi.WQuan_Api)
    Observable<WQuanBean> gettong(@HeaderMap HashMap<String, String> map,@QueryMap HashMap<String,String>param);
    //修改昵称
    @PUT(ShowApi.Name_Api)
    Observable<XiuBean> getName(@HeaderMap HashMap<String, String> map,@QueryMap HashMap<String,String>param);
    //查询我的地址
    @GET(ShowApi.Addaress_Api)
    Observable<AddressBean> getaddress(@HeaderMap HashMap<String, String> map);
    @POST(ShowApi.Add_Api)
    Observable<AddBean> getAdd(@HeaderMap HashMap<String, String> map, @QueryMap HashMap<String,String>param);
}
