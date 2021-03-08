package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.entity.sso.SsoRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明：  数据访问层</p>
 */
public interface SsoRoleMapper {

    long countByExample(SsoRoleExample example);

    int deleteByExample(SsoRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoRole record);

    int insertSelective(SsoRole record);

    List<SsoRole> selectList(@Param("record") SsoRole record, @Param("orderBy") String orderBy);

    List<SsoRole> selectByExample(SsoRoleExample example);

    SsoRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoRole record, @Param("example") SsoRoleExample example);

    int updateByExample(@Param("record") SsoRole record, @Param("example") SsoRoleExample example);

    int updateByPrimaryKeySelective(SsoRole record);

    int updateByPrimaryKey(SsoRole record);

}
