package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoUserJob;
import top.itodouble.sso.entity.sso.SsoUserJobExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 用户任职记录 数据访问层</p>
 */
public interface SsoUserJobMapper {

    long countByExample(SsoUserJobExample example);

    int deleteByExample(SsoUserJobExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoUserJob record);

    int insertSelective(SsoUserJob record);

    List<SsoUserJob> selectList(@Param("record") SsoUserJob record, @Param("orderBy") String orderBy);

    List<SsoUserJob> selectByExample(SsoUserJobExample example);

    SsoUserJob selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoUserJob record, @Param("example") SsoUserJobExample example);

    int updateByExample(@Param("record") SsoUserJob record, @Param("example") SsoUserJobExample example);

    int updateByPrimaryKeySelective(SsoUserJob record);

    int updateByPrimaryKey(SsoUserJob record);

}
