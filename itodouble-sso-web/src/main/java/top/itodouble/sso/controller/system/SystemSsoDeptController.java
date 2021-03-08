package top.itodouble.sso.controller.system;

import top.itodouble.common.enums.YesOrNoEnum;
import top.itodouble.common.page.TableSupport;
import top.itodouble.common.pojo.PageablePojo;
import top.itodouble.common.pojo.RestResult;
import top.itodouble.common.utils.EnumHelper;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.controller.base.BaseController;
import top.itodouble.sso.entity.sso.SsoDept;
import top.itodouble.sso.entity.sso.SsoDeptExample;
import top.itodouble.sso.enums.DeptTypeEnum;
import top.itodouble.sso.service.SsoDeptService;
import top.itodouble.sso.service.add.SsoDeptAddService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>说明： 部门</P>
 */
@Api(value = "/system/ssoDept", tags = {"部门"})
@RestController
@RequestMapping("/system/ssoDept")
public class SystemSsoDeptController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(SystemSsoDeptController.class);

	@Autowired
	private SsoDeptService ssoDeptService;
	@Autowired
	private SsoDeptAddService ssoDeptAddService;

	@ApiOperation(value = "获取数据字典")
	@PostMapping(value = "/translate")
	public RestResult translate() {
		Map map = new HashMap();
		map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
		map.put("DeptTypeEnum", EnumHelper.enumToList(DeptTypeEnum.class));
		return RestResult.success().data(map);
	}

	/**
	 * 查询 部门列表（无分页）
	 *
	 * @return
	 */
	@ApiOperation(value = "查询 列表 无分页")
	@PostMapping(value = "/list")
	public RestResult list(@RequestBody Map param) {
		if (null == param.get("delFLag")) {
			param.put("delFlag", YesOrNoEnum.NO.getSnData());
		}
		return RestResult.success().data(ssoDeptAddService.selectList(param));
	}

	@ApiOperation(value = "根据id查询部门名称")
	@PostMapping(value = "/listByIds")
	public RestResult listByIds(@RequestBody Map param) {
		if (null != param.get("ids")) {
			List<String> ids = Arrays.asList(StringUtils.toString(param.get("ids")).split(","));
			SsoDeptExample ssoDeptExample = new SsoDeptExample();
			ssoDeptExample.createCriteria().andIdIn(ids);
			List<SsoDept> ssoDeptList = ssoDeptService.selectByExample(ssoDeptExample);
			return RestResult.success().data(ssoDeptList);
		}
		return RestResult.success();
	}

	@ApiOperation(value = "公司")
	@PostMapping(value = "/orgList")
	public RestResult orgList(@RequestBody Map param) {
		SsoDept ssoDept = new SsoDept();
		ssoDept.setOrgFlag(YesOrNoEnum.YES.getSnData());
		ssoDept.setDelFlag(YesOrNoEnum.NO.getSnData());
		if (StringUtils.isNotNull(param.get("parentDeptId"))) {
			ssoDept.setParentDeptId(StringUtils.toString(param.get("parentDeptId")));
		}
		return RestResult.success().data(ssoDeptService.selectList(ssoDept, " order_id desc "));
	}

	/**
	 * 查询 部门列表（有分页）
	 *
	 * @return
	 */
	@ApiOperation(value = "查询 列表 有分页")
	@PostMapping(value = "/listPage")
	public RestResult listPage(@RequestBody Map param) {
		PageablePojo pageablePojo = TableSupport.buildPageRequest();
		if (null == param.get("delFlag")) {
			param.put("delFlag", YesOrNoEnum.NO.getSnData());
		}
		return RestResult.success().data(ssoDeptAddService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), param));
	}

	/**
	 * 用Id查询 部门 详情（单个）
	 *
	 * @return
	 */
	@ApiOperation(value = "用Id查询 详情（单个）")
	@PostMapping(value = "/findById")
	public RestResult findById(@RequestBody Map param) {
		return RestResult.success().data(ssoDeptService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
	}

	/**
	 * 添加 部门
	 *
	 * @param ssoDept
	 * @return
	 */
	@ApiOperation(value = "添加")
	@PostMapping(value = "/add")
	public RestResult add(@RequestBody SsoDept ssoDept) {
		ssoDeptService.insertSelective(ssoDept);
		return RestResult.success().data(ssoDept);
	}


	/**
	 * 删除 部门
	 *
	 * @return
	 */
	@ApiOperation(value = "删除")
	@PostMapping(value = "/delete")
	public RestResult delete(@RequestBody Map param) throws Exception {
//        SsoDept ssoDept = new SsoDept();
//        ssoDept.setId(StringUtils.toString(param.get("id")));
//        ssoDept.setDelFlag(YesOrNoEnum.YES.getSnData());
//        ssoDeptService.updateByPrimaryKeySelective(ssoDept);
		ssoDeptService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
		return RestResult.success();
	}


	/**
	 * 编辑 部门
	 *
	 * @param ssoDept
	 * @return
	 */
	@ApiOperation(value = "编辑")
	@PostMapping(value = "/edit")
	public RestResult edit(@RequestBody SsoDept ssoDept) {
		ssoDeptService.updateByPrimaryKeySelective(ssoDept);
		return RestResult.success().data(ssoDept);
	}

	@ApiOperation(value = "获取所有父级")
	@PostMapping(value = "/getAllParent")
	public RestResult getAllParent(@RequestBody SsoDept ssoDept) {
		Map map = ssoDeptAddService.getAllParent(ssoDept);
		return RestResult.success().data(map);
	}

}