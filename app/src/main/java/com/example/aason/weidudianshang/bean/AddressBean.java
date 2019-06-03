package com.example.aason.weidudianshang.bean;

import java.util.List;

public class AddressBean {

    /**
     * result : [{"address":"北京八维","createTime":1553891832000,"id":2124,"phone":"15134972345","realName":"朱砂","userId":342,"whetherDefault":1,"zipCode":"100000"},{"address":"北京八维","createTime":1553891845000,"id":2125,"phone":"15134972345","realName":"石子玉","userId":342,"whetherDefault":2,"zipCode":"100000"},{"address":"北京医科大学","createTime":1553891862000,"id":2126,"phone":"13614782345","realName":"石子玉","userId":342,"whetherDefault":2,"zipCode":"100000"},{"address":"北京邮电大学","createTime":1553891906000,"id":2127,"phone":"13332088864","realName":"黄帅","userId":342,"whetherDefault":2,"zipCode":"100000"},{"address":"家里蹲大学","createTime":1553891927000,"id":2128,"phone":"13225697752","realName":"樊景辉","userId":342,"whetherDefault":2,"zipCode":"100000"}]
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
         * address : 北京八维
         * createTime : 1553891832000
         * id : 2124
         * phone : 15134972345
         * realName : 朱砂
         * userId : 342
         * whetherDefault : 1
         * zipCode : 100000
         */

        private String address;
        private long createTime;
        private int id;
        private String phone;
        private String realName;
        private int userId;
        private int whetherDefault;
        private String zipCode;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherDefault() {
            return whetherDefault;
        }

        public void setWhetherDefault(int whetherDefault) {
            this.whetherDefault = whetherDefault;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
