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
import top.itodouble.sso.entity.sso.SsoPost;
import top.itodouble.sso.entity.sso.add.SsoDeptAdd;
import top.itodouble.sso.entity.sso.add.SsoPostAdd;
import top.itodouble.sso.service.SsoPostService;
import top.itodouble.sso.service.add.SsoDeptAddService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>说明： 岗位</P>
 *
 */
@Api(value="/system/ssoPost", tags = {"岗位"})
@RestController
@RequestMapping("/system/ssoPost")
public class SystemSsoPostController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SystemSsoPostController.class);

    @Autowired
    private SsoPostService ssoPostService;
    @Autowired
    private SsoDeptAddService ssoDeptAddService;

    @ApiOperation(value = "获取数据字典")
    @PostMapping(value = "/translate")
    public RestResult translate(){
        Map map = new HashMap();
        map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
        return RestResult.success().data(map);
    }

    /**
    * 查询 岗位列表（无分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 无分页")
    @PostMapping(value = "/list")
    public RestResult list(@RequestBody SsoPost ssoPost) {
        if (null == ssoPost.getDelFlag()){
            ssoPost.setDelFlag(YesOrNoEnum.NO.getSnData());
        }
        return RestResult.success().data(ssoPostService.selectList(ssoPost, null));
    }

    /**
    * 查询 岗位列表（有分页）
    * @return
    */
    @ApiOperation(value = "查询 列表 有分页")
    @PostMapping(value = "/listPage")
    public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException{
        PageablePojo pageablePojo = TableSupport.buildPageRequest();
        String orderBy = StringUtils.toString(param.get("orderBy"));
        SsoPost ssoPost = new SsoPost();
        BeanUtils.copyProperties(ssoPost, param);
        if (null == ssoPost.getDelFlag()){
            ssoPost.setDelFlag(YesOrNoEnum.NO.getSnData());
        }
        return RestResult.success().data(ssoPostService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoPost, orderBy));
    }

    /**
     * 用Id查询 岗位 详情（单个）
     * @return
     */
    @ApiOperation(value = "用Id查询 详情（单个）")
    @PostMapping(value = "/findById")
    public RestResult findById(@RequestBody Map param){
        return RestResult.success().data(ssoPostService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
    }

    /**
    * 添加 岗位
    * @param ssoPost
    * @return
    */
    @ApiOperation(value = "添加")
    @PostMapping(value = "/add")
    public RestResult add(@RequestBody SsoPost ssoPost) {
        ssoPostService.insertSelective(ssoPost);
        return RestResult.success();
    }


    /**
    * 删除 岗位
    * @return
    */
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete")
    public RestResult delete(@RequestBody Map param) throws Exception{
        SsoPost ssoPost = new SsoPost();
        ssoPost.setId(StringUtils.toString(param.get("id")));
        ssoPost.setDelFlag(YesOrNoEnum.YES.getSnData());
        ssoPostService.updateByPrimaryKeySelective(ssoPost);
        // ssoPostService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
        return RestResult.success();
    }


    /**
    * 编辑 岗位
    * @param ssoPost
    * @return
    */
    @ApiOperation(value = "编辑")
    @PostMapping(value = "/edit")
    public RestResult edit(@RequestBody SsoPost ssoPost) {
        ssoPostService.updateByPrimaryKeySelective(ssoPost);
        return RestResult.success();
    }

    /**
     * orgFlag
     * @param param
     * @return
     */
    @ApiOperation(value = "组织列表带岗位")
    @PostMapping(value = "/listWithDept")
    public RestResult listWithDept(@RequestBody Map param){
        Map deptParam = new HashMap();
        deptParam.put("delFlag", YesOrNoEnum.NO.getSnData());
        deptParam.put("orgFlag", param.get("orgFlag"));
        if (StringUtils.isNotNull(param.get("deptId"))){
            deptParam.put("parentDeptId", StringUtils.toString(param.get("deptId")));
        }
        List<SsoDeptAdd> deptAddList = ssoDeptAddService.selectList(deptParam);
        List<SsoPostAdd> treeList = coverSsoDeptAdd(deptAddList);
        if (StringUtils.isNotNull(param.get("deptId"))) {
            SsoPost postParam = new SsoPost();
            postParam.setDeptId(StringUtils.toString(param.get("deptId")));
            List<SsoPost> ssoPostList = ssoPostService.selectList(postParam, " order_id desc ");
            List<SsoPostAdd> postList = coverSsoPost(ssoPostList);
            if (CollectionUtils.isNotEmpty(postList)) {
                treeList.addAll(postList);
            }
        }
        return RestResult.success().data(treeList);
    }

    private List<SsoPostAdd> coverSsoPost(List<SsoPost> postList) {
        List<SsoPostAdd> list = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(postList)) {
            postList.forEach(each->{
                SsoPostAdd item = new SsoPostAdd();
                item.setHasChildren(false);
                item.setName(each.getName());
                item.setCode(each.getCode());
                item.setCreationTime(each.getCreationTime());
                item.setId(each.getId());
                item.setDeptId(each.getDeptId());
                item.setOrgId(each.getOrgId());
                item.setOrgName(null);
                item.setIsPost(YesOrNoEnum.YES.getSnData());
                item.setEnableFlag(each.getEnableFlag());
                item.setDelFlag(each.getDelFlag());
                list.add(item);
            });
        }
        return list;
    }

    private List<SsoPostAdd> coverSsoDeptAdd(List<SsoDeptAdd> deptAddList) {
        List<SsoPostAdd> treeList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(deptAddList)) {
            deptAddList.forEach(each->{
                if (null != each) {
                    SsoPostAdd item = new SsoPostAdd();
                    item.setHasChildren(true);
                    item.setOrgName(each.getOrgName());
                    item.setDeptName(each.getName());
                    item.setDeptId(each.getId());
                    item.setOrgId(each.getOrgId());
                    item.setId(each.getId());
                    if (YesOrNoEnum.YES.getSnData().equals(each.getOrgFlag())) {
                        item.setOrgName(each.getName());
                        item.setName(null);
                        item.setDeptName(null);
                    }
                    treeList.add(item);
                }
            });
        }
        return treeList;
    }
}