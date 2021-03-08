package top.itodouble.sso.controller.system;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.itodouble.common.enums.YesOrNoEnum;
import top.itodouble.common.page.TableSupport;
import top.itodouble.common.pojo.PageablePojo;
import top.itodouble.common.pojo.RestResult;
import top.itodouble.common.utils.EnumHelper;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.controller.base.BaseController;
import top.itodouble.sso.entity.sso.SsoUser;
import top.itodouble.sso.enums.SsoUserStatusEnum;
import top.itodouble.sso.service.SsoUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>说明： 用户</P>
 *
 */
@Api(value="/system/ssoUser", tags = {"用户"})
@RestController
@RequestMapping("/system/ssoUser")
public class SystemSsoUserController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SystemSsoUserController.class);

    @Autowired
    private SsoUserService ssoUserService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        map.put("SsoUserStatusEnum", EnumHelper.enumToList(SsoUserStatusEnum.class));
        return RestResult.success().data(map);
    }

    /**
    * 查询 用户列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoUser ssoUser) {
        if (null == ssoUser.getDelFlag()){
            ssoUser.setDelFlag(YesOrNoEnum.NO.getSnData());
        }
        return RestResult.success().data(ssoUserService.selectList(ssoUser, null));
    }

    /**
    * 查询 用户列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "/listPage")
    public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException{
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        String orderBy = StringUtils.toString(param.get("orderBy"));
        SsoUser ssoUser = new SsoUser();
        BeanUtils.copyProperties(ssoUser, param);
        if (null == ssoUser.getDelFlag()){
            ssoUser.setDelFlag(YesOrNoEnum.NO.getSnData());
        }
        return RestResult.success().data(ssoUserService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoUser, orderBy));
    }

    /**
     * 用Id查询 用户 详情（单个）
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(@RequestBody Map param){
        return RestResult.success().data(ssoUserService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
    }

    /**
    * 添加 用户
    * @param ssoUser
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoUser ssoUser) {
        ssoUserService.insertSelective(ssoUser);
        return RestResult.success();
    }


    /**
    * 删除 用户
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(@RequestBody Map param) throws Exception{
        SsoUser ssoUser = new SsoUser();
        ssoUser.setId(StringUtils.toString(param.get("id")));
        ssoUser.setDelFlag(YesOrNoEnum.YES.getSnData());
        ssoUserService.updateByPrimaryKeySelective(ssoUser);
        // ssoUserService.deleteByPrimaryKey(id);
        return RestResult.success();
    }


    /**
    * 编辑 用户
    * @param ssoUser
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoUser ssoUser) {
        ssoUserService.updateByPrimaryKeySelective(ssoUser);
        return RestResult.success();
    }

}