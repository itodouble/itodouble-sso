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
import top.itodouble.sso.entity.sso.SsoUserLoginHistory;
import top.itodouble.sso.service.SsoUserLoginHistoryService;
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
 * <p>说明： 登录历史</P>
 *
 */
@Api(value="/system/ssoUserLoginHistory", tags = {"登录历史"})
@RestController
@RequestMapping("/system/ssoUserLoginHistory")
public class SystemSsoUserLoginHistoryController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SystemSsoUserLoginHistoryController.class);

    @Autowired
    private SsoUserLoginHistoryService ssoUserLoginHistoryService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        return RestResult.success().data(map);
    }

    /**
    * 查询 登录历史列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoUserLoginHistory ssoUserLoginHistory) {
//        if (null == ssoUserLoginHistory.getDelFlag()){
//            ssoUserLoginHistory.setDelFlag(YesOrNoEnum.NO.getSnData());
//        }
        return RestResult.success().data(ssoUserLoginHistoryService.selectList(ssoUserLoginHistory, null));
    }

    /**
    * 查询 登录历史列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "/listPage")
    public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException{
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        String orderBy = StringUtils.toString(param.get("orderBy"));
        SsoUserLoginHistory ssoUserLoginHistory = new SsoUserLoginHistory();
        BeanUtils.copyProperties(ssoUserLoginHistory, param);
//        if (null == ssoUserLoginHistory.getDelFlag()){
//            ssoUserLoginHistory.setDelFlag(YesOrNoEnum.NO.getSnData());
//        }
        return RestResult.success().data(ssoUserLoginHistoryService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoUserLoginHistory, orderBy));
    }

    /**
     * 用Id查询 登录历史 详情（单个）
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(@RequestBody Map param){
        return RestResult.success().data(ssoUserLoginHistoryService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
    }

    /**
    * 添加 登录历史
    * @param ssoUserLoginHistory
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoUserLoginHistory ssoUserLoginHistory) {
        ssoUserLoginHistoryService.insertSelective(ssoUserLoginHistory);
        return RestResult.success();
    }


    /**
    * 删除 登录历史
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(@RequestBody Map param) throws Exception{
//        SsoUserLoginHistory ssoUserLoginHistory = new SsoUserLoginHistory();
//        ssoUserLoginHistory.setId(StringUtils.toString(param.get("id")));
//        ssoUserLoginHistory.setDelFlag(YesOrNoEnum.YES.getSnData());
//        ssoUserLoginHistoryService.updateByPrimaryKeySelective(ssoUserLoginHistory);
         ssoUserLoginHistoryService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
        return RestResult.success();
    }


    /**
    * 编辑 登录历史
    * @param ssoUserLoginHistory
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoUserLoginHistory ssoUserLoginHistory) {
        ssoUserLoginHistoryService.updateByPrimaryKeySelective(ssoUserLoginHistory);
        return RestResult.success();
    }

}