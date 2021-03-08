package top.itodouble.sso.mapper.sso.add;

import top.itodouble.sso.entity.sso.SsoUser;
import top.itodouble.sso.entity.sso.add.SsoUserAdd;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SsoUserAddMapper {
	/**
	 * 根据手机号码或工号获取用户信息
	 *
	 * @param keyword
	 * @return
	 */
	SsoUserAdd selectByMobileOrCodeWithPassword(String keyword);

	SsoUser selectByMobileOrCode(String keyword);

	@MapKey("id")
	Map<String, String> selectUserName(@Param("userId") List<String> userId);

	/**
	 * 给 selectUserListByKeywordCount 分页
	 * @param param
	 * @return
	 */
	int selectUserListByKeywordCount(Map param);
	List<Map<String, String>> selectUserListByKeyword(Map param);
}
