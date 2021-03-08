package top.itodouble.sso.controller.system;

import top.itodouble.common.enums.YesOrNoEnum;
import top.itodouble.common.page.TableSupport;
import top.itodouble.common.pojo.PageablePojo;
import top.itodouble.common.pojo.RestResult;
import top.itodouble.common.utils.EnumHelper;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.controller.base.BaseController;
import top.itodouble.sso.entity.sso.SsoArea;
import top.itodouble.sso.entity.sso.SsoAreaExample;
import top.itodouble.sso.pojo.AreaPojo;
import top.itodouble.sso.service.SsoAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 省市区 地址信息
 */
@Api(value = "/system/ssoArea", tags = {"省市区 地址信息"})
@RestController
@RequestMapping("/system/ssoArea")
public class SystemSsoAreaController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(SystemSsoAreaController.class);

	@Autowired
	private SsoAreaService ssoAreaService;

	@ApiOperation(value = "获取数据字典")
	@PostMapping(value = "/translate")
	public RestResult translate() {
		Map map = new HashMap();
		map.put("YesOrNoEnum", EnumHelper.enumToList(YesOrNoEnum.class));
		return RestResult.success().data(map);
	}

	/**
	 * 查询 省市区 地址信息列表（无分页）
	 *
	 * @return
	 */
	@ApiOperation(value = "查询 列表 无分页")
	@PostMapping(value = "/list")
	public RestResult list(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException {
		String orderBy = StringUtils.toString(param.get("orderBy"));
		SsoArea ssoArea = new SsoArea();
		BeanUtils.copyProperties(ssoArea, param);
		if (null == ssoArea.getDelFlag()) {
			ssoArea.setDelFlag(YesOrNoEnum.NO.getSnData());
		}
		return RestResult.success().data(ssoAreaService.selectList(ssoArea, orderBy));
	}

	/**
	 * 查询 省市区 地址信息列表（有分页）
	 *
	 * @return
	 */
	@ApiOperation(value = "查询 列表 有分页")
	@PostMapping(value = "/listPage")
	public RestResult listPage(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException {
		PageablePojo pageablePojo = TableSupport.buildPageRequest();
		String orderBy = StringUtils.toString(param.get("orderBy"));
		SsoArea ssoArea = new SsoArea();
		BeanUtils.copyProperties(ssoArea, param);
		if (null == ssoArea.getDelFlag()) {
			ssoArea.setDelFlag(YesOrNoEnum.NO.getSnData());
		}
		return RestResult.success().data(ssoAreaService.listPage(pageablePojo.getPageNum(), pageablePojo.getPageSize(), ssoArea, orderBy));
	}

	/**
	 * 用Id查询 省市区 地址信息 详情（单个）
	 *
	 * @return
	 */
	@ApiOperation(value = "用Id查询 详情（单个）")
	@PostMapping(value = "/findById")
	public RestResult findById(@RequestBody Map param) {
		return RestResult.success().data(ssoAreaService.selectByPrimaryKey(StringUtils.toString(param.get("id"))));
	}

	/**
	 * 添加 省市区 地址信息
	 *
	 * @param ssoArea
	 * @return
	 */
	@ApiOperation(value = "添加")
	@PostMapping(value = "/add")
	public RestResult add(@RequestBody SsoArea ssoArea) {
		ssoAreaService.insertSelective(ssoArea);
		return RestResult.success().data(ssoArea);
	}


	/**
	 * 删除 省市区 地址信息
	 *
	 * @return
	 */
	@ApiOperation(value = "删除")
	@PostMapping(value = "/delete")
	public RestResult delete(@RequestBody Map param) {
		ssoAreaService.deleteByPrimaryKey(StringUtils.toString(param.get("id")));
		return RestResult.success();
	}


	/**
	 * 编辑 省市区 地址信息
	 *
	 * @param ssoArea
	 * @return
	 */
	@ApiOperation(value = "编辑")
	@PostMapping(value = "/edit")
	public RestResult edit(@RequestBody SsoArea ssoArea) {
		ssoAreaService.updateByPrimaryKeySelective(ssoArea);
		return RestResult.success().data(ssoArea);
	}

	/**
	 * 传入当前id或code
	 * @param ssoArea
	 * @return
	 */
	@ApiOperation(value = "获取父级信息")
	@PostMapping(value = "/getAllParent")
	public RestResult getAllParent(@RequestBody SsoArea ssoArea){
		SsoAreaExample ssoAreaExample = null;
		if (StringUtils.isNotNull(ssoArea.getId())){
			ssoAreaExample = new SsoAreaExample();
			ssoAreaExample.createCriteria().andIdEqualTo(ssoArea.getId());
		} else if (StringUtils.isNotNull(ssoArea.getCode())) {
			ssoAreaExample = new SsoAreaExample();
			ssoAreaExample.createCriteria().andCodeEqualTo(ssoArea.getCode());
		}
		if (null != ssoAreaExample) {
			List<SsoArea> areaList = ssoAreaService.selectByExample(ssoAreaExample);
			AreaPojo areaPojo = new AreaPojo();
			List<String> parentIds = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			if (CollectionUtils.isNotEmpty(areaList)) {
				areaPojo = new AreaPojo(areaList.get(0));
				getParent(areaPojo, areaList.get(0), parentIds);
			}
			map.put("parentInfo", areaPojo);
			map.put("parentIds", parentIds);
			return RestResult.success().data(map);
		}
		return RestResult.success();
	}

	private AreaPojo getParent(AreaPojo areaPojo, SsoArea ssoArea, List<String> parentIds){
		if (null != ssoArea) {
			AreaPojo parentArea = new AreaPojo(ssoArea);
			parentIds.add(ssoArea.getId());
			if (StringUtils.isNotNull(ssoArea.getParentId())) {
				SsoAreaExample ssoAreaExample = new SsoAreaExample();
				ssoAreaExample.createCriteria().andIdEqualTo(ssoArea.getParentId());
				List<SsoArea> parentTempList = ssoAreaService.selectByExample(ssoAreaExample);
				if (CollectionUtils.isNotEmpty(parentTempList)) {
					getParent(parentArea, parentTempList.get(0), parentIds);
				}
			}
			areaPojo.setParent(parentArea);
		}
		return areaPojo;
	}
}