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
import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.service.SsoRoleService;
import top.itodouble.sso.service.add.SsoRoleAddService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>说明： </P>
 *
 */
@Api(value="/system/ssoRole", tags = {""})
@RestController
@RequestMapping("/system/ssoRole")
public class SystemSsoRoleController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SystemSsoRoleController.class);

    @Autowired
    private SsoRoleService ssoRoleService;
    @Autowired
    private SsoRoleAddService ssoRoleAddService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        return RestResult.success().data(map);
    }

    /**
    * 查询 列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoRole ssoRole) {
        if (null == ssoRole.getDelFlag()){
            ssoRole.setDelFlag(YesOrNoEnum.NO.getSnData());
        }
        return RestResult.success().data(ssoRoleService.selectList(ssoRole, null));
    }

    /**
    * 查询 列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "/listPage")
    public RestResult listPage(@RequestBody Map param) {
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        if (null == param.get("delFlag")){
            param.put("delFlag",YesOrNoEnum.NO.getSnData());
        }
        return RestResult.success().data(ssoRoleAddService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), param));
    }

    /**
     * 用Id查询  详情（单个）
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(@RequestBody Map param){
        return RestResult.success().data(ssoRoleService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
    }

    /**
    * 添加 
    * @param ssoRole
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoRole ssoRole) {
        ssoRoleService.insertSelective(ssoRole);
        return RestResult.success();
    }


    /**
    * 删除 
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(@RequestBody Map param) throws Exception{
        SsoRole ssoRole = new SsoRole();
        ssoRole.setId(StringUtils.toString(param.get("id")));
        ssoRole.setDelFlag(YesOrNoEnum.YES.getSnData());
        ssoRoleService.updateByPrimaryKeySelective(ssoRole);
        // ssoRoleService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
        return RestResult.success();
    }


    /**
    * 编辑 
    * @param ssoRole
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoRole ssoRole) {
        ssoRoleService.updateByPrimaryKeySelective(ssoRole);
        return RestResult.success();
    }

}