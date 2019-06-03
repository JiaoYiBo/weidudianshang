package com.example.aason.weidudianshang.bean;

import java.util.List;

public class WQuanBean {

    /**
     * result : []
     * message : 查詢成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<?> result;

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

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
