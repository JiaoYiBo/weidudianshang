package com.example.aason.weidudianshang.bean;

import java.util.List;

public class PinBean {

    /**
     * result : [{"commodityId":92,"commodityName":"冬季新款女款轻薄羽绒服女短款外套女纯色简约百搭保暖女上衣新品女装外套","masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/7/1.jpg","price":229,"saleNum":0},{"commodityId":83,"commodityName":"秋季新款韩版女装淑女风荷叶边短款长袖连衣裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/5/1.jpg","price":168,"saleNum":0},{"commodityId":97,"commodityName":"秋季新款韩版女装卫衣秋冬装春秋休闲宽松字母套头连帽加绒长袖卫衣","masterPic":"http://172.17.8.100/images/small/commodity/nz/wy/5/1.jpg","price":139,"saleNum":0},{"commodityId":94,"commodityName":"秋冬新款宽松套头绣花纯色连帽加绒加厚卫衣女装外套","masterPic":"http://172.17.8.100/images/small/commodity/nz/wy/2/1.jpg","price":129,"saleNum":0},{"commodityId":87,"commodityName":"秋季新款韩版女装短外套秋装春秋冬学院风休闲简约宽松拼接长袖短外套","masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/2/1.jpg","price":358,"saleNum":0},{"commodityId":80,"commodityName":"秋季新款韩版女装连衣裙春秋冬学院风气质休闲时尚显瘦字母印花拼接荷叶边短裙子长袖连衣裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/2/1.jpg","price":178,"saleNum":0},{"commodityId":96,"commodityName":"秋季新款韩版女装卫衣秋装学院风街头刺绣基础百搭连帽套头宽松女款卫衣","masterPic":"http://172.17.8.100/images/small/commodity/nz/wy/4/1.jpg","price":129,"saleNum":0},{"commodityId":93,"commodityName":"秋季新款韩版女装秋装甜美通勤字母印花宽松长袖女款卫衣女","masterPic":"http://172.17.8.100/images/small/commodity/nz/wy/1/1.jpg","price":94,"saleNum":0},{"commodityId":85,"commodityName":"秋冬女装新款长袖连衣裙女中长款气质打底毛衣裙鱼尾显瘦内搭裙韩版时尚宽松针织裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/7/1.jpg","price":99,"saleNum":0},{"commodityId":95,"commodityName":"秋冬加绒拼接色 不规则套头 假两件休闲短款保暖女装卫衣上衣","masterPic":"http://172.17.8.100/images/small/commodity/nz/wy/3/1.jpg","price":99,"saleNum":0},{"commodityId":66,"commodityName":"秋冬新品韩版女装毛衣纯色时尚简约花边领半高领套头打底上衣长袖针织衫","masterPic":"http://172.17.8.100/images/small/commodity/nz/ddmy/2/1.jpg","price":49,"saleNum":0},{"commodityId":70,"commodityName":"衣香丽影毛衣套头打底衫长袖修身冬季高领针织衫女装","masterPic":"http://172.17.8.100/images/small/commodity/nz/ddmy/6/1.jpg","price":158,"saleNum":0}]
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
         * commodityId : 92
         * commodityName : 冬季新款女款轻薄羽绒服女短款外套女纯色简约百搭保暖女上衣新品女装外套
         * masterPic : http://172.17.8.100/images/small/commodity/nz/wt/7/1.jpg
         * price : 229
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
