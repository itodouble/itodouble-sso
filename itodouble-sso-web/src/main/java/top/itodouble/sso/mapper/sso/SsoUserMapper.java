package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoUser;
import top.itodouble.sso.entity.sso.SsoUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 用户 数据访问层</p>
 */
public interface SsoUserMapper {

    long countByExample(SsoUserExample example);

    int deleteByExample(SsoUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoUser record);

    int insertSelective(SsoUser record);

    List<SsoUser> selectList(@Param("record") SsoUser record, @Param("orderBy") String orderBy);

    List<SsoUser> selectByExample(SsoUserExample example);

    SsoUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoUser record, @Param("example") SsoUserExample example);

    int updateByExample(@Param("record") SsoUser record, @Param("example") SsoUserExample example);

    int updateByPrimaryKeySelective(SsoUser record);

    int updateByPrimaryKey(SsoUser record);

}
