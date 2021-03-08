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
import top.itodouble.sso.entity.sso.SsoSystem;
import top.itodouble.sso.service.SsoSystemService;
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
 * <p>说明： 关联系统</P>
 *
 */
@Api(value="/system/ssoSystem", tags = {"关联系统"})
@RestController
@RequestMapping("/system/ssoSystem")
public class SystemSsoSystemController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SystemSsoSystemController.class);

    @Autowired
    private SsoSystemService ssoSystemService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        return RestResult.success().data(map);
    }

    /**
    * 查询 关联系统列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoSystem ssoSystem) {
//        ssoSystem.setDelFlag(YesOrNoEnum.NO.getSnData());
        return RestResult.success().data(ssoSystemService.selectList(new SsoSystem(), null));
    }

    /**
    * 查询 关联系统列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "/listPage")
    public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException{
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        String orderBy = StringUtils.toString(param.get("orderBy"));
        SsoSystem ssoSystem = new SsoSystem();
        BeanUtils.copyProperties(ssoSystem, param);
//        ssoSystem.setDelFlag(YesOrNoEnum.NO.getSnData());
        return RestResult.success().data(ssoSystemService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoSystem, orderBy));
    }

    /**
     * 用Id查询 关联系统 详情（单个）
     * @param id
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(String id){
        return RestResult.success().data(ssoSystemService.selectByPrimaryKey(id));
    }

    /**
    * 添加 关联系统
    * @param ssoSystem
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoSystem ssoSystem) {
        ssoSystemService.insertSelective(ssoSystem);
        return RestResult.success();
    }


    /**
    * 删除 关联系统
    * @param id
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(String id) throws Exception{
//        SsoSystem ssoSystem = new SsoSystem();
//        ssoSystem.setId(id);
//        ssoSystem.setDelFlag(YesOrNoEnum.YES.getSnData());
//        ssoSystemService.updateByPrimaryKeySelective(ssoSystem);
         ssoSystemService.deleteByPrimaryKey(id);
        return RestResult.success();
    }


    /**
    * 编辑 关联系统
    * @param ssoSystem
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoSystem ssoSystem) {
        ssoSystemService.updateByPrimaryKeySelective(ssoSystem);
        return RestResult.success();
    }

}