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
import top.itodouble.sso.entity.sso.SsoUserThirdParty;
import top.itodouble.sso.service.SsoUserThirdPartyService;
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
 * <p>说明： 用户第三方平台信息</P>
 *
 */
@Api(value="/system/ssoUserThirdParty", tags = {"用户第三方平台信息"})
@RestController
@RequestMapping("/system/ssoUserThirdParty")
public class SystemSsoUserThirdPartyController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SystemSsoUserThirdPartyController.class);

    @Autowired
    private SsoUserThirdPartyService ssoUserThirdPartyService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        return RestResult.success().data(map);
    }

    /**
    * 查询 用户第三方平台信息列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoUserThirdParty ssoUserThirdParty) {
//        if (null == ssoUserThirdParty.getDelFlag()){
//            ssoUserThirdParty.setDelFlag(YesOrNoEnum.NO.getSnData());
//        }
        return RestResult.success().data(ssoUserThirdPartyService.selectList(ssoUserThirdParty, null));
    }

    /**
    * 查询 用户第三方平台信息列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "/listPage")
    public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException{
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        String orderBy = StringUtils.toString(param.get("orderBy"));
        SsoUserThirdParty ssoUserThirdParty = new SsoUserThirdParty();
        BeanUtils.copyProperties(ssoUserThirdParty, param);
//        if (null == ssoUserThirdParty.getDelFlag()){
//            ssoUserThirdParty.setDelFlag(YesOrNoEnum.NO.getSnData());
//        }
        return RestResult.success().data(ssoUserThirdPartyService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoUserThirdParty, orderBy));
    }

    /**
     * 用Id查询 用户第三方平台信息 详情（单个）
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(@RequestBody Map param){
        return RestResult.success().data(ssoUserThirdPartyService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
    }

    /**
    * 添加 用户第三方平台信息
    * @param ssoUserThirdParty
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoUserThirdParty ssoUserThirdParty) {
        ssoUserThirdPartyService.insertSelective(ssoUserThirdParty);
        return RestResult.success();
    }


    /**
    * 删除 用户第三方平台信息
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(@RequestBody Map param) throws Exception{
//        SsoUserThirdParty ssoUserThirdParty = new SsoUserThirdParty();
//        ssoUserThirdParty.setId(StringUtils.toString(param.get("id")));
//        ssoUserThirdParty.setDelFlag(YesOrNoEnum.YES.getSnData());
//        ssoUserThirdPartyService.updateByPrimaryKeySelective(ssoUserThirdParty);
         ssoUserThirdPartyService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
        return RestResult.success();
    }


    /**
    * 编辑 用户第三方平台信息
    * @param ssoUserThirdParty
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoUserThirdParty ssoUserThirdParty) {
        ssoUserThirdPartyService.updateByPrimaryKeySelective(ssoUserThirdParty);
        return RestResult.success();
    }

}