package top.itodouble.sso.service.add;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.add.SsoRoleAdd;
import top.itodouble.sso.mapper.sso.add.SsoRoleAddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SsoRoleAddService {

	@Autowired
	private SsoRoleAddMapper ssoRoleAddMapper;

	public List<SsoRoleAdd> selectList(Map param) {
		return ssoRoleAddMapper.selectList(param);
	}

	public PageInfo<SsoRoleAdd> listPage(Integer pageNum, Integer pageSize, Map param) {
		return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoRoleAddMapper.selectList(param));
	}
}
