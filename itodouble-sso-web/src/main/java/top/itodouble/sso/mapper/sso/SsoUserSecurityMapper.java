package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoUserSecurity;
import top.itodouble.sso.entity.sso.SsoUserSecurityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 保存密码私密信息 数据访问层</p>
 */
public interface SsoUserSecurityMapper {

    long countByExample(SsoUserSecurityExample example);

    int deleteByExample(SsoUserSecurityExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoUserSecurity record);

    int insertSelective(SsoUserSecurity record);

    List<SsoUserSecurity> selectList(@Param("record") SsoUserSecurity record, @Param("orderBy") String orderBy);

    List<SsoUserSecurity> selectByExample(SsoUserSecurityExample example);

    SsoUserSecurity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoUserSecurity record, @Param("example") SsoUserSecurityExample example);

    int updateByExample(@Param("record") SsoUserSecurity record, @Param("example") SsoUserSecurityExample example);

    int updateByPrimaryKeySelective(SsoUserSecurity record);

    int updateByPrimaryKey(SsoUserSecurity record);

}
