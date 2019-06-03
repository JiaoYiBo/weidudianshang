package com.example.aason.weidudianshang.bean;

import java.util.List;

public class CartBean {

    /**
     * result : [{"commodityId":135,"commodityName":"青春时尚 潮流男鞋 韩版舒适简约百搭板鞋男士休闲鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/1/1.jpg","price":149,"saleNum":0},{"commodityId":143,"commodityName":"素雅净色男士套脚帆布鞋懒人鞋平底休闲鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/2/1.jpg","price":44,"saleNum":0},{"commodityId":151,"commodityName":"明星同款西装商务皮鞋男韩版潮真皮头层牛皮系带英伦正装鞋布洛克雕花男鞋男士皮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/px/3/1.jpg","price":498,"saleNum":0},{"commodityId":159,"commodityName":"富贵鸟 头层牛皮系带百搭商务休闲鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/4/1.jpg","price":249,"saleNum":0},{"commodityId":167,"commodityName":"鸿星尔克 新款气垫跑鞋复古轻便休闲鞋男款革面针织运动鞋 男鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/5/1.jpg","price":138,"saleNum":0},{"commodityId":140,"commodityName":"小白鞋男时尚新款运动休闲男鞋韩版潮流厚底原宿风板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/6/1.jpg","price":398,"saleNum":0},{"commodityId":148,"commodityName":"Vernonsabin维斯国货粤潮原创撞色潮流时尚青年高帮男士休闲鞋男帆布鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/7/1.jpg","price":389,"saleNum":0},{"commodityId":156,"commodityName":"黑色加绒牛皮商务休闲皮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/1/1.jpg","price":99,"saleNum":0},{"commodityId":164,"commodityName":"耐克Nike KAISHI RUN 奥利奥轻便透气 男款运动休闲鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/2/1.jpg","price":258,"saleNum":0},{"commodityId":137,"commodityName":"唐狮冬季男士冬休闲鞋高帮男鞋男士板鞋休闲男鞋子高帮男鞋百搭休闲板鞋男","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/3/1.jpg","price":79,"saleNum":0},{"commodityId":145,"commodityName":"如熙新款男鞋韩版学生时尚百搭潮流低帮男帆布鞋简约英伦风舒适男板鞋轻便耐磨系带潮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/4/1.jpg","price":119,"saleNum":0},{"commodityId":153,"commodityName":"红蜻蜓季系带布洛克雕花牛皮革男士英伦商务正装皮鞋绅士商务鞋男士皮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/px/5/1.jpg","price":239,"saleNum":0},{"commodityId":161,"commodityName":"新款牛皮系带圆头车缝线耐磨舒适商务休闲男鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/6/1.jpg","price":44,"saleNum":0},{"commodityId":169,"commodityName":"冬季新款简约轻便男款跑步鞋男运动鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/7/1.jpg","price":148,"saleNum":0},{"commodityId":142,"commodityName":"秋季爆款高帮帆布鞋 街头防滑双色阴阳鞋 男士高帮帆布鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/1/1.jpg","price":109,"saleNum":0},{"commodityId":150,"commodityName":"秋季真皮系带男款婚鞋尖头英伦男士正装商务鞋男鞋男士皮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/px/2/1.jpg","price":328,"saleNum":0},{"commodityId":158,"commodityName":"系带商务鞋休闲鞋皮鞋棉鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/3/1.jpg","price":99,"saleNum":0},{"commodityId":166,"commodityName":"耐磨减震 男款篮球鞋 乔丹","masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/4/1.jpg","price":189,"saleNum":0},{"commodityId":139,"commodityName":"秋季男鞋简约百搭男小白鞋韩版潮流男板鞋跑步鞋子ins超火的运动鞋学生时尚嘻哈潮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/5/1.jpg","price":109,"saleNum":0},{"commodityId":147,"commodityName":"森马男鞋高帮帆布鞋时尚百搭男士高帮帆布鞋男迷彩印花男士休闲鞋韩版百搭男士休闲鞋原宿男鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/6/1.jpg","price":79,"saleNum":0},{"commodityId":155,"commodityName":"AUXTUN男鞋韩版商务典雅尖头男士皮鞋潮流英伦系带正装休闲皮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/px/7/1.jpg","price":129,"saleNum":0},{"commodityId":163,"commodityName":"骆驼运动男鞋【秋冬爆款】柔韧耐磨 型潮复古 男士跑步鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/1/1.jpg","price":129,"saleNum":0},{"commodityId":136,"commodityName":"板鞋休闲鞋男男士休闲运动鞋男士鞋子休闲皮鞋男士休闲鞋男鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/2/1.jpg","price":99,"saleNum":0},{"commodityId":144,"commodityName":"冬季新款高帮帆布鞋加绒保暖平底百搭时尚气质绑带字母经典款帆布鞋男士系带休闲靴","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/3/1.jpg","price":148,"saleNum":0},{"commodityId":152,"commodityName":"皮鞋男真皮黑色透气男士休闲皮鞋男鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/px/4/1.jpg","price":119,"saleNum":0},{"commodityId":160,"commodityName":"简约百搭商务休闲鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/5/1.jpg","price":459,"saleNum":0},{"commodityId":168,"commodityName":"李宁 狼塔低帮 男款跑步鞋ARHN205耐磨防滑运动鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/6/1.jpg","price":298,"saleNum":0},{"commodityId":141,"commodityName":"AUXTUN港仔原宿男鞋秋季鞋子男潮鞋百搭韩版潮流男士休闲鞋板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/7/1.jpg","price":99,"saleNum":0},{"commodityId":149,"commodityName":"新品蛇纹商务正装系带皮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/px/1/1.jpg","price":258,"saleNum":0},{"commodityId":157,"commodityName":"舒适百搭套脚商务休闲鞋男士皮鞋男鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/2/1.jpg","price":249,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 135
         * commodityName : 青春时尚 潮流男鞋 韩版舒适简约百搭板鞋男士休闲鞋
         * masterPic : http://172.17.8.100/images/small/commodity/nx/nbx/1/1.jpg
         * price : 149
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;


        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
