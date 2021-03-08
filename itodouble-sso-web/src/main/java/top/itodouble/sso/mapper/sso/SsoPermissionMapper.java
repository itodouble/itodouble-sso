package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoPermission;
import top.itodouble.sso.entity.sso.SsoPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明：  数据访问层</p>
 */
public interface SsoPermissionMapper {

    long countByExample(SsoPermissionExample example);

    int deleteByExample(SsoPermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoPermission record);

    int insertSelective(SsoPermission record);

    List<SsoPermission> selectList(@Param("record") SsoPermission record, @Param("orderBy") String orderBy);

    List<SsoPermission> selectByExample(SsoPermissionExample example);

    SsoPermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoPermission record, @Param("example") SsoPermissionExample example);

    int updateByExample(@Param("record") SsoPermission record, @Param("example") SsoPermissionExample example);

    int updateByPrimaryKeySelective(SsoPermission record);

    int updateByPrimaryKey(SsoPermission record);

}
