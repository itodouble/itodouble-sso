package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoMenu;
import top.itodouble.sso.entity.sso.SsoMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 菜单按钮 数据访问层</p>
 */
public interface SsoMenuMapper {

    long countByExample(SsoMenuExample example);

    int deleteByExample(SsoMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoMenu record);

    int insertSelective(SsoMenu record);

    List<SsoMenu> selectList(@Param("record") SsoMenu record, @Param("orderBy") String orderBy);

    List<SsoMenu> selectByExample(SsoMenuExample example);

    SsoMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoMenu record, @Param("example") SsoMenuExample example);

    int updateByExample(@Param("record") SsoMenu record, @Param("example") SsoMenuExample example);

    int updateByPrimaryKeySelective(SsoMenu record);

    int updateByPrimaryKey(SsoMenu record);

}
