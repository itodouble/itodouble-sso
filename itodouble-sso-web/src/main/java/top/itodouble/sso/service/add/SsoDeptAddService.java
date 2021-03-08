package top.itodouble.sso.service.add;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.entity.sso.SsoDept;
import top.itodouble.sso.entity.sso.add.SsoDeptAdd;
import top.itodouble.sso.mapper.sso.SsoDeptMapper;
import top.itodouble.sso.mapper.sso.add.SsoDeptAddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SsoDeptAddService {
	@Autowired
	private SsoDeptAddMapper ssoDeptAddMapper;
	@Autowired
	private SsoDeptMapper ssoDeptMapper;

	public List<SsoDeptAdd> selectList(Map param) {
		return ssoDeptAddMapper.selectList(param);
	}

	public PageInfo<SsoDeptAdd> listPage(Integer pageNum, Integer pageSize, Map param) {
		return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoDeptAddMapper.selectList(param));
	}

	/**
	 * 获取所有父级部门
	 * @param ssoDept
	 * @return
	 */
	public Map<String, Object> getAllParent(SsoDept ssoDept) {
		Map<String, Object> map = new HashMap<>();
		List<String> parentDeptIds = new ArrayList<>();

		SsoDeptAdd ssoDeptAdd = null;
		if (null != ssoDept) {
			if (StringUtils.isNotNull(ssoDept.getId())) {
				ssoDept = ssoDeptMapper.selectByPrimaryKey(ssoDept.getId());
				ssoDeptAdd = new SsoDeptAdd(ssoDept);
			}
			if (null != ssoDeptAdd) {
				this.findParent(ssoDeptAdd, parentDeptIds);
			}
		}
		map.put("parentDeptIds", parentDeptIds);
		map.put("dept", ssoDeptAdd);
		return map;
	}

	private void findParent(SsoDeptAdd current, List<String> parentDeptIds){
		if (null != current && StringUtils.isNotNull(current.getId())) {
			parentDeptIds.add(current.getId());
			if (StringUtils.isNotNull(current.getParentDeptId())) {
				SsoDept parent = ssoDeptMapper.selectByPrimaryKey(current.getParentDeptId());
				if (null != parent) {
					SsoDeptAdd parentAdd = new SsoDeptAdd(parent);
					this.findParent(parentAdd, parentDeptIds);
					current.setParent(parentAdd);
				}
			}
		}
	}
}
