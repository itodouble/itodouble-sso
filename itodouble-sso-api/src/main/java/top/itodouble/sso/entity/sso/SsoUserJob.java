package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import java.util.Date;

/**
 * <p>说明： 用户任职记录实体类</P>
 */
@ApiModel("用户任职记录")
public class SsoUserJob extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "userId", value = "用户")
    private String userId;

    @ApiModelProperty(name = "deptId", value = "部门")
    private String deptId;

    @ApiModelProperty(name = "postId", value = "岗位")
    private String postId;

    @ApiModelProperty(name = "beginTime", value = "开始时间")
    private Date beginTime;

    @ApiModelProperty(name = "endTime", value = "结束时间")
    private Date endTime;

    @ApiModelProperty(name = "lastFlag", value = "是否最新")
    private Integer lastFlag;

    @ApiModelProperty(name = "mainFlag", value = "是否主职")
    private Integer mainFlag;

    @ApiModelProperty(name = "delFlag", value = "是否删除")
    private Integer delFlag;

    public SsoUserJob() {
    }

    /**
     * get 用户
     */
    public String getUserId() {
        return userId;
    }

    /**
     * set 用户
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * get 部门
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * set 部门
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * get 岗位
     */
    public String getPostId() {
        return postId;
    }

    /**
     * set 岗位
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * get 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * set 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * get 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * set 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * get 是否最新
     */
    public Integer getLastFlag() {
        return lastFlag;
    }

    /**
     * set 是否最新
     */
    public void setLastFlag(Integer lastFlag) {
        this.lastFlag = lastFlag;
    }

    /**
     * get 是否主职
     */
    public Integer getMainFlag() {
        return mainFlag;
    }

    /**
     * set 是否主职
     */
    public void setMainFlag(Integer mainFlag) {
        this.mainFlag = mainFlag;
    }

    /**
     * get 是否删除
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * set 是否删除
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
