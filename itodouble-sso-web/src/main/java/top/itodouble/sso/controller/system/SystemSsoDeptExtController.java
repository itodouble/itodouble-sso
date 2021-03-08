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
import top.itodouble.sso.entity.sso.SsoDeptExt;
import top.itodouble.sso.entity.sso.SsoDeptExtExample;
import top.itodouble.sso.service.SsoDeptExtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>说明： 部门扩展表</P>
 *
 */
@Api(value="/system/ssoDeptExt", tags = {"部门扩展表"})
@RestController
@RequestMapping("/system/ssoDeptExt")
public class SystemSsoDeptExtController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SystemSsoDeptExtController.class);

    @Autowired
    private SsoDeptExtService ssoDeptExtService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        return RestResult.success().data(map);
    }

    /**
    * 查询 部门扩展表列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoDeptExt ssoDeptExt) {
//        if (null == ssoDeptExt.getDelFlag()){
//            ssoDeptExt.setDelFlag(YesOrNoEnum.NO.getSnData());
//        }
        return RestResult.success().data(ssoDeptExtService.selectList(ssoDeptExt, null));
    }

    /**
    * 查询 部门扩展表列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "listPage")
    public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException{
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        String orderBy = StringUtils.toString(param.get("orderBy"));
        SsoDeptExt ssoDeptExt = new SsoDeptExt();
        BeanUtils.copyProperties(ssoDeptExt, param);
//        if (null == ssoDeptExt.getDelFlag()){
//            ssoDeptExt.setDelFlag(YesOrNoEnum.NO.getSnData());
//        }
        return RestResult.success().data(ssoDeptExtService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoDeptExt, orderBy));
    }

    /**
     * 用Id查询 部门扩展表 详情（单个）
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(@RequestBody Map param){
        return RestResult.success().data(ssoDeptExtService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
    }

    @ApiOperation(value = "根据部门id查询部门扩展信息")
    @PostMapping(value = "/findByDeptId")
    public RestResult findByDeptId(@RequestBody Map param) {
        String deptId = StringUtils.toString(param.get("deptId"));
        SsoDeptExtExample ssoDeptExtExample = new SsoDeptExtExample();
        ssoDeptExtExample.createCriteria().andDeptIdEqualTo(deptId);
        List<SsoDeptExt> ssoDeptExtList = ssoDeptExtService.selectByExample(ssoDeptExtExample);
        if (CollectionUtils.isNotEmpty(ssoDeptExtList)) {
            return RestResult.success().data(ssoDeptExtList.get(0));
        }
        return RestResult.success().data(new SsoDeptExt());
    }

    /**
    * 添加 部门扩展表
    * @param ssoDeptExt
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoDeptExt ssoDeptExt) {
        ssoDeptExtService.insertSelective(ssoDeptExt);
        return RestResult.success().data(ssoDeptExt);
    }


    /**
    * 删除 部门扩展表
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(@RequestBody Map param) throws Exception{
//        SsoDeptExt ssoDeptExt = new SsoDeptExt();
//        ssoDeptExt.setId(StringUtils.toString(param.get("id")));
//        ssoDeptExt.setDelFlag(YesOrNoEnum.YES.getSnData());
//        ssoDeptExtService.updateByPrimaryKeySelective(ssoDeptExt);
         ssoDeptExtService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
        return RestResult.success();
    }


    /**
    * 编辑 部门扩展表
    * @param ssoDeptExt
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoDeptExt ssoDeptExt) {
        ssoDeptExtService.updateByPrimaryKeySelective(ssoDeptExt);
        return RestResult.success().data(ssoDeptExt);
    }

}