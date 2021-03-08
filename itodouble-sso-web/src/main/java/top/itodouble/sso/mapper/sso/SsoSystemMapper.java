package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoSystem;
import top.itodouble.sso.entity.sso.SsoSystemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 关联系统 数据访问层</p>
 */
public interface SsoSystemMapper {

    long countByExample(SsoSystemExample example);

    int deleteByExample(SsoSystemExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoSystem record);

    int insertSelective(SsoSystem record);

    List<SsoSystem> selectList(@Param("record") SsoSystem record, @Param("orderBy") String orderBy);

    List<SsoSystem> selectByExample(SsoSystemExample example);

    SsoSystem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoSystem record, @Param("example") SsoSystemExample example);

    int updateByExample(@Param("record") SsoSystem record, @Param("example") SsoSystemExample example);

    int updateByPrimaryKeySelective(SsoSystem record);

    int updateByPrimaryKey(SsoSystem record);

}
