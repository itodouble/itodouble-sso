package top.itodouble.sso.service.add;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.add.SsoMenuAdd;
import top.itodouble.sso.entity.sso.add.SsoPermissionAdd;
import top.itodouble.sso.entity.sso.add.SsoUserAdd;
import top.itodouble.sso.mapper.sso.add.SsoPermissionAddMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SsoPermissionAddService {
	@Autowired
	private SsoPermissionAddMapper ssoPermissionAddMapper;

	public List<SsoPermissionAdd> list(Map param) {
		return ssoPermissionAddMapper.list(param);
	}

	public PageInfo<SsoPermissionAdd> listPage(Integer pageNum, Integer pageSize,Map param) {
		return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoPermissionAddMapper.list(param));
	}

	public Map<String, Object> menuRoleLeft(Map param) {
		Map<String, Object> map = new HashMap<>();
		List<SsoMenuAdd> parent = ssoPermissionAddMapper.menuRoleLeft(param);
		List<String> checkedIds = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(parent)){
			checkedIds = parent.stream().filter(each->each.getChecked()).map(each->each.getId()).collect(Collectors.toList());
		}
		menuRoleSub(parent, checkedIds, param);
		map.put("menuList", parent);
		map.put("checkIds", checkedIds);
		return map;
	}

	public void menuRoleSub(List<SsoMenuAdd> parentList, List<String> checkedIds, Map param) {
		if (CollectionUtils.isNotEmpty(parentList)){
			parentList.forEach(each->{
				param.put("parentId", each.getId());
				List<SsoMenuAdd> sub = ssoPermissionAddMapper.menuRoleLeft(param);
				if (CollectionUtils.isNotEmpty(sub)){
					checkedIds.addAll(sub.stream().filter(subEach->subEach.getChecked()).map(subEach->subEach.getId()).collect(Collectors.toList()));
				}
				menuRoleSub(sub,checkedIds, param);
				each.setChildren(sub);
			});
		}
	}

	/**
	 * 角色->用户列表分页
	 * @param pageNum
	 * @param pageSize
	 * @param param
	 * @return
	 */
	public PageInfo<SsoUserAdd> userRoleListPage(Integer pageNum, Integer pageSize, Map param){
		return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoPermissionAddMapper.userRoleList(param));
	}
}
