package top.itodouble.sso.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;

/**
 * websocket 消息实体封装
 */
@ApiModel(description = "websocket 消息实体封装")
public class WsMessagePojo<T> implements Serializable {
    /**
     * 操作
     */
    @ApiModelProperty("操作")
    private String operation;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 用户手机号码
     */
    @ApiModelProperty("用户手机号码")
    private String mobile;
    /**
     * 登录时token
     */
    @ApiModelProperty("登录时token")
    private String token;
    /**
     * 客户端信息 例如：浏览器ua
     */
    @ApiModelProperty("客户端信息 例如：浏览器ua")
    private HashMap<String, Object> clientData;
    /**
     * 返回或接收数据
     */
    @ApiModelProperty("返回或接收数据")
    private T data;

    public WsMessagePojo() {
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public HashMap<String, Object> getClientData() {
        return clientData;
    }

    public void setClientData(HashMap<String, Object> clientData) {
        this.clientData = clientData;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
