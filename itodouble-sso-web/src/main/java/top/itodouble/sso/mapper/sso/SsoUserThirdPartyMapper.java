package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoUserThirdParty;
import top.itodouble.sso.entity.sso.SsoUserThirdPartyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 用户第三方平台信息 数据访问层</p>
 */
public interface SsoUserThirdPartyMapper {

    long countByExample(SsoUserThirdPartyExample example);

    int deleteByExample(SsoUserThirdPartyExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoUserThirdParty record);

    int insertSelective(SsoUserThirdParty record);

    List<SsoUserThirdParty> selectList(@Param("record") SsoUserThirdParty record, @Param("orderBy") String orderBy);

    List<SsoUserThirdParty> selectByExample(SsoUserThirdPartyExample example);

    SsoUserThirdParty selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoUserThirdParty record, @Param("example") SsoUserThirdPartyExample example);

    int updateByExample(@Param("record") SsoUserThirdParty record, @Param("example") SsoUserThirdPartyExample example);

    int updateByPrimaryKeySelective(SsoUserThirdParty record);

    int updateByPrimaryKey(SsoUserThirdParty record);

}
