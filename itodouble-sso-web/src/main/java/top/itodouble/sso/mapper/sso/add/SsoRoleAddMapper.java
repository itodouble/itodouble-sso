package top.itodouble.sso.mapper.sso.add;

import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.entity.sso.add.SsoRoleAdd;

import java.util.List;
import java.util.Map;

public interface SsoRoleAddMapper {
	List<SsoRole> getUserRoleList(Map param);

	List<SsoRoleAdd> selectList(Map param);
}