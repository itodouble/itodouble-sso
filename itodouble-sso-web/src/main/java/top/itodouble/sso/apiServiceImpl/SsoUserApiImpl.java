package top.itodouble.sso.apiServiceImpl;

import top.itodouble.sso.apiService.SsoUserApi;
import top.itodouble.sso.constant.FinanceSsoConst;
import top.itodouble.sso.entity.sso.SsoMenu;
import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.entity.sso.SsoUser;
import top.itodouble.sso.service.SsoUserService;
import top.itodouble.sso.service.add.SsoUserAddService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(version = FinanceSsoConst.dubboVersion)
@Component
public class SsoUserApiImpl implements SsoUserApi {

	@Autowired
	private SsoUserAddService ssoUserAddService;
	@Autowired
	private SsoUserService ssoUserService;

	@Override
	public List<SsoRole> getUserRoleListByUserIdWithRedis(String userId, String systemCode){
		return ssoUserAddService.getUserRoleListByUserIdWithRedis(userId, systemCode);
	}

	@Override
	public List<SsoRole> getUserRoleListWithRedis(String username, String userId, String systemCode) {
		return ssoUserAddService.getUserRoleListWithRedis(username, userId, systemCode);
	}

	@Override
	public List<SsoRole> getUserRoleListWithRedis(String username, String systemCode) {
		return ssoUserAddService.getUserRoleListWithRedis(username, systemCode);
	}

	@Override
	public List<SsoMenu> getUserRoleMenuListWithRedis(String username, List<String> roleIdList, String userId, String systemCode) {
		return ssoUserAddService.getUserRoleMenuListWithRedis(username, roleIdList, userId, systemCode);
	}

	@Override
	public List<SsoMenu> getUserRoleMenuListWithRedis(String username, String systemCode) {
		return ssoUserAddService.getUserRoleMenuListWithRedis(username, systemCode);
	}

	@Override
	public SsoUser getUserById(String userId) {
		SsoUser ssoUser = ssoUserService.selectByPrimaryKey(userId);
		return ssoUser;
	}
}
