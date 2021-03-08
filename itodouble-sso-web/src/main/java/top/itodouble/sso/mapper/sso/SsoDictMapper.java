package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoDict;
import top.itodouble.sso.entity.sso.SsoDictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 数据字典表 数据访问层</p>
 */
public interface SsoDictMapper {

    long countByExample(SsoDictExample example);

    int deleteByExample(SsoDictExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoDict record);

    int insertSelective(SsoDict record);

    List<SsoDict> selectList(@Param("record") SsoDict record, @Param("orderBy") String orderBy);

    List<SsoDict> selectByExample(SsoDictExample example);

    SsoDict selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoDict record, @Param("example") SsoDictExample example);

    int updateByExample(@Param("record") SsoDict record, @Param("example") SsoDictExample example);

    int updateByPrimaryKeySelective(SsoDict record);

    int updateByPrimaryKey(SsoDict record);

}
