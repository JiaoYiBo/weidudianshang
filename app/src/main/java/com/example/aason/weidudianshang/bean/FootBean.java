package com.example.aason.weidudianshang.bean;

import java.util.List;

public class FootBean {


    /**
     * result : [{"browseNum":1,"browseTime":1553702530000,"commodityId":5,"commodityName":"双头两用修容笔","masterPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg","price":39,"userId":523},{"browseNum":1,"browseTime":1553702524000,"commodityId":21,"commodityName":"【加绒休闲 舒适轻便】秋冬增高休闲鞋厚底棉鞋运动户外通勤简约韩版女鞋","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/4/1.jpg","price":189,"userId":523},{"browseNum":1,"browseTime":1553701224000,"commodityId":29,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/ddx/5/1.jpg","price":278,"userId":523},{"browseNum":1,"browseTime":1553700792000,"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg","price":139,"userId":523}]
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
         * browseNum : 1
         * browseTime : 1553702530000
         * commodityId : 5
         * commodityName : 双头两用修容笔
         * masterPic : http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg
         * price : 39
         * userId : 523
         */

        private int browseNum;
        private long browseTime;
        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int userId;

        public int getBrowseNum() {
            return browseNum;
        }

        public void setBrowseNum(int browseNum) {
            this.browseNum = browseNum;
        }

        public long getBrowseTime() {
            return browseTime;
        }

        public void setBrowseTime(long browseTime) {
            this.browseTime = browseTime;
        }

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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
