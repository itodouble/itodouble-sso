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
import top.itodouble.sso.entity.sso.SsoDict;
import top.itodouble.sso.service.SsoDictService;
import top.itodouble.sso.service.SsoSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据字典表
 *
 */
@Api(value="/system/ssoDict", tags = {"数据字典表"})
@RestController
@RequestMapping("/system/ssoDict")
public class SystemSsoDictController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(SystemSsoDictController.class);

    @Autowired
    private SsoDictService ssoDictService;
    @Autowired
    private SsoSystemService ssoSystemService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        map.put("systemCode", ssoSystemService.selectByExample(null));
        return RestResult.success().data(map);
    }

    /**
    * 查询 数据字典表列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoDict ssoDict) {
        String orderBy = StringUtils.toString(ssoDict.getParams().get("orderBy"));
        if (null == ssoDict.getDelFlag()){
            ssoDict.setDelFlag(YesOrNoEnum.NO.getSnData());
        }
        return RestResult.success().data(ssoDictService.selectList(ssoDict, orderBy));
    }

    /**
    * 查询 数据字典表列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "/listPage")
    public RestResult listPage(@RequestBody SsoDict ssoDict) {
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        String orderBy = StringUtils.toString(ssoDict.getParams().get("orderBy"));
        if (null == ssoDict.getDelFlag()){
            ssoDict.setDelFlag(YesOrNoEnum.NO.getSnData());
        }
        return RestResult.success().data(ssoDictService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoDict, orderBy));
    }

    /**
     * 用Id查询 数据字典表 详情（单个）
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(@RequestBody Map param){
        return RestResult.success().data(ssoDictService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
    }

    /**
    * 添加 数据字典表
    * @param ssoDict
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoDict ssoDict) {
        ssoDictService.insertSelective(ssoDict);
        return RestResult.success().data(ssoDict);
    }


    /**
    * 删除 数据字典表
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(@RequestBody Map param) throws Exception{
        SsoDict ssoDict = new SsoDict();
        ssoDict.setId(StringUtils.toString(param.get("id")));
        ssoDict.setDelFlag(YesOrNoEnum.YES.getSnData());
        ssoDictService.updateByPrimaryKeySelective(ssoDict);
        // ssoDictService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
        return RestResult.success();
    }


    /**
    * 编辑 数据字典表
    * @param ssoDict
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoDict ssoDict) {
        ssoDictService.updateByPrimaryKeySelective(ssoDict);
        return RestResult.success().data(ssoDict);
    }

}