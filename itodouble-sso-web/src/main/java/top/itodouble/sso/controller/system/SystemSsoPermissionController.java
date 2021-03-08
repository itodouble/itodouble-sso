package top.itodouble.sso.controller.system;

import com.github.pagehelper.PageInfo;
import top.itodouble.common.enums.YesOrNoEnum;
import top.itodouble.common.page.TableSupport;
import top.itodouble.common.pojo.PageablePojo;
import top.itodouble.common.pojo.RestResult;
import top.itodouble.common.utils.EnumHelper;
import top.itodouble.common.utils.JsonUtils;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.controller.base.BaseController;
import top.itodouble.sso.entity.sso.SsoPermission;
import top.itodouble.sso.entity.sso.SsoPermissionExample;
import top.itodouble.sso.entity.sso.add.SsoUserAdd;
import top.itodouble.sso.service.SsoPermissionService;
import top.itodouble.sso.service.add.SsoPermissionAddService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>说明： </P>
 */
@Api(value = "/system/ssoPermission", tags = {""})
@RestController
@RequestMapping("/system/ssoPermission")
public class SystemSsoPermissionController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(SystemSsoPermissionController.class);

	@Autowired
	private SsoPermissionService ssoPermissionService;
	@Autowired
	private SsoPermissionAddService ssoPermissionAddService;

	@ApiOperation(value = "获取数据字典")
	@PostMapping(value = "/translate")
	public RestResult translate() {
		Map map = new HashMap();
		map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
		return RestResult.success().data(map);
	}

	/**
	 * 查询 列表（无分页）
	 *
	 * @return
	 */
	@ApiOperation(value = "查询 列表 无分页")
	@PostMapping(value = "/list")
	public RestResult list(@RequestBody SsoPermission ssoPermission) {
		if (null == ssoPermission.getDelFlag()) {
			ssoPermission.setDelFlag(YesOrNoEnum.NO.getSnData());
		}
		return RestResult.success().data(ssoPermissionService.selectList(ssoPermission, null));
	}

	/**
	 * 查询 列表（有分页）
	 *
	 * @return
	 */
	@ApiOperation(value = "查询 列表 有分页")
	@PostMapping(value = "/listPage")
	public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException {
		PageablePojo pageablePojo = TableSupport.buildPageRequest();

		if (null == param.get("delFlag")) {
			param.put("delFlag",YesOrNoEnum.NO.getSnData());
		}
		return RestResult.success().data(ssoPermissionAddService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), param));
	}

	/**
	 * 用Id查询  详情（单个）
	 *
	 * @return
	 */
	@ApiOperation(value = "用Id查询 详情（单个）")
	@PostMapping(value = "/findById")
	public RestResult findById(@RequestBody Map param) {
		return RestResult.success().data(ssoPermissionService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
	}

	/**
	 * 添加
	 *
	 * @param ssoPermission
	 * @return
	 */
	@ApiOperation(value = "添加")
	@PostMapping(value = "/add")
	public RestResult add(@RequestBody SsoPermission ssoPermission) {
		if(ssoPermission.getUserId()!=null && ssoPermission.getRoleId()!=null ) {
			ssoPermission.setDelFlag(YesOrNoEnum.NO.getSnData());
			List<SsoPermission> list = ssoPermissionService.selectList(ssoPermission, "");
			if (CollectionUtils.isNotEmpty(list)) {
				return RestResult.error().message("用户已拥有改角色!");
			}
			ssoPermission.setDelFlag(YesOrNoEnum.NO.getSnData());
			ssoPermission.setEnableFlag(YesOrNoEnum.YES.getSnData());
		} else if (null != ssoPermission.getRoleId() && null != ssoPermission.getMenuId()) {

		} else {
			return RestResult.error().message("参数异常!");
		}

		ssoPermissionService.insertSelective(ssoPermission);
		return RestResult.success();
	}


	/**
	 * 删除
	 *
	 * @return
	 */
	@ApiOperation(value = "删除")
	@PostMapping(value = "/delete")
	public RestResult delete(@RequestBody Map param) throws Exception {
		SsoPermission ssoPermission = new SsoPermission();
		ssoPermission.setId(StringUtils.toString(param.get("id")));
		ssoPermission.setDelFlag(YesOrNoEnum.YES.getSnData());
		ssoPermissionService.updateByPrimaryKeySelective(ssoPermission);
		// ssoPermissionService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
		return RestResult.success();
	}


	/**
	 * 编辑
	 *
	 * @param ssoPermission
	 * @return
	 */
	@ApiOperation(value = "编辑")
	@PostMapping(value = "/edit")
	public RestResult edit(@RequestBody SsoPermission ssoPermission) {
		ssoPermissionService.updateByPrimaryKeySelective(ssoPermission);
		return RestResult.success();
	}

	/**
	 * 角色权限
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "角色权限")
	@PostMapping(value = "/menuRoleLeft")
	public RestResult menuRoleLeft(@RequestBody Map param) {
		Map<String, Object> map = ssoPermissionAddService.menuRoleLeft(param);
		return RestResult.success().data(map);
	}

	@ApiOperation(value = "保存角色权限")
	@PostMapping(value = "/savePermission")
	public RestResult savePermission(@RequestBody Map param) {
		logger.error(JsonUtils.beanToString(param));

		String roleId = StringUtils.toString(param.get("roleId"));
		String menuId = StringUtils.toString(param.get("menuId"));
		Integer delFlag = StringUtils.toInteger(param.get("delFlag"));
		if (YesOrNoEnum.YES.getSnData().equals(delFlag)) {
			SsoPermission ssoPermission = new SsoPermission();
			ssoPermission.setDelFlag(YesOrNoEnum.YES.getSnData());
			ssoPermission.setEnableFlag(YesOrNoEnum.NO.getSnData());
			SsoPermissionExample example = new SsoPermissionExample();
			example.createCriteria()
					.andRoleIdEqualTo(roleId)
					.andMenuIdEqualTo(menuId)
					.andDelFlagEqualTo(YesOrNoEnum.NO.getSnData()).andEnableFlagEqualTo(YesOrNoEnum.YES.getSnData());
			List<SsoPermission> permissionList = ssoPermissionService.selectByExample(example);
			if (CollectionUtils.isNotEmpty(permissionList)) {
				permissionList.forEach(each->{
					each.setDelFlag(YesOrNoEnum.YES.getSnData());
					each.setEnableFlag(YesOrNoEnum.NO.getSnData());
					ssoPermissionService.updateByPrimaryKey(each);
				});
			}
		} else {
			SsoPermissionExample example = new SsoPermissionExample();
			example.createCriteria().andRoleIdEqualTo(roleId).andMenuIdEqualTo(menuId).andDelFlagEqualTo(YesOrNoEnum.YES.getSnData()).andEnableFlagEqualTo(YesOrNoEnum.NO.getSnData());
			List<SsoPermission> list = ssoPermissionService.selectByExample(example);
			if (CollectionUtils.isNotEmpty(list)) {
				SsoPermission ssoPermission = list.get(0);
				ssoPermission.setEnableFlag(YesOrNoEnum.YES.getSnData());
				ssoPermission.setDelFlag(YesOrNoEnum.NO.getSnData());
				ssoPermissionService.updateByPrimaryKey(ssoPermission);
			} else {
				SsoPermission ssoPermission = new SsoPermission();
				ssoPermission.setDelFlag(YesOrNoEnum.NO.getSnData());
				ssoPermission.setEnableFlag(YesOrNoEnum.YES.getSnData());
				ssoPermission.setMenuId(menuId);
				ssoPermission.setRoleId(roleId);
				ssoPermissionService.insertSelective(ssoPermission);
			}
		}
		return RestResult.success();
	}

	/**
	 * 角色->用户列表分页
	 * @return
	 */
	@ApiOperation(value = "角色->用户列表分页")
	@PostMapping(value = "/userRoleListPage")
	public RestResult userRoleListPage(@RequestBody Map param){
		logger.error(JsonUtils.beanToString(param));
		PageablePojo pageablePojo = TableSupport.buildPageRequest();
		PageInfo<SsoUserAdd> userPageInfo = ssoPermissionAddService.userRoleListPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), param);
		return RestResult.success().data(userPageInfo);
	}
}