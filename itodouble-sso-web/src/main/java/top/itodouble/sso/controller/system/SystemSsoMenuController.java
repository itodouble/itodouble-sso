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
import top.itodouble.sso.entity.sso.SsoMenu;
import top.itodouble.sso.enums.MenuUrlTypeEnum;
import top.itodouble.sso.service.SsoMenuService;
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
 * <p>说明： 菜单按钮</P>
 *
 */
@Api(value="/system/ssoMenu", tags = {"菜单按钮"})
@RestController
@RequestMapping("/system/ssoMenu")
public class SystemSsoMenuController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SystemSsoMenuController.class);
    @Autowired
    private SsoMenuService ssoMenuService;
    @Autowired
    private SsoSystemService ssoSystemService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        map.put("systemCode", ssoSystemService.selectByExample(null));
        map.put("MenuUrlTypeEnum", EnumHelper.enumToList(MenuUrlTypeEnum.class));
        return RestResult.success().data(map);
    }

    /**
    * 查询 菜单按钮列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoMenu ssoMenu) {
        return RestResult.success().data(ssoMenuService.selectList(ssoMenu, null));
    }

    /**
    * 查询 菜单按钮列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "/listPage")
    public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException{
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        String orderBy = StringUtils.toString(param.get("orderBy"));
        SsoMenu ssoMenu = new SsoMenu();
        BeanUtils.copyProperties(ssoMenu, param);
        ssoMenu.setDelFlag(YesOrNoEnum.NO.getSnData());
        return RestResult.success().data(ssoMenuService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoMenu, orderBy));
    }

    /**
     * 用Id查询 菜单按钮 详情（单个）
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(@RequestBody Map param){
        return RestResult.success().data(ssoMenuService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
    }

    /**
    * 添加 菜单按钮
    * @param ssoMenu
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoMenu ssoMenu) {
        ssoMenuService.insertSelective(ssoMenu);
        return RestResult.success();
    }


    /**
    * 删除 菜单按钮
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(@RequestBody Map param) throws Exception{
        SsoMenu ssoMenu = new SsoMenu();
        ssoMenu.setId(StringUtils.toString(param.get("id")));
        ssoMenu.setDelFlag(YesOrNoEnum.YES.getSnData());
        ssoMenuService.updateByPrimaryKeySelective(ssoMenu);
        // ssoMenuService.deleteByPrimaryKey(id);
        return RestResult.success();
    }


    /**
    * 编辑 菜单按钮
    * @param ssoMenu
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoMenu ssoMenu) {
        ssoMenuService.updateByPrimaryKeySelective(ssoMenu);
        return RestResult.success();
    }

}