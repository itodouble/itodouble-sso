package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 保存密码私密信息实体类</P>
 */
@ApiModel("保存密码私密信息")
public class SsoUserSecurity extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "userId", value = "")
    private String userId;

    @ApiModelProperty(name = "loginAble", value = "")
    private Integer loginAble;

    @ApiModelProperty(name = "password", value = "")
    private String password;

    public SsoUserSecurity() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLoginAble() {
        return loginAble;
    }

    public void setLoginAble(Integer loginAble) {
        this.loginAble = loginAble;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
