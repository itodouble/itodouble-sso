package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoPost;
import top.itodouble.sso.entity.sso.SsoPostExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 岗位 数据访问层</p>
 */
public interface SsoPostMapper {

    long countByExample(SsoPostExample example);

    int deleteByExample(SsoPostExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoPost record);

    int insertSelective(SsoPost record);

    List<SsoPost> selectList(@Param("record") SsoPost record, @Param("orderBy") String orderBy);

    List<SsoPost> selectByExample(SsoPostExample example);

    SsoPost selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoPost record, @Param("example") SsoPostExample example);

    int updateByExample(@Param("record") SsoPost record, @Param("example") SsoPostExample example);

    int updateByPrimaryKeySelective(SsoPost record);

    int updateByPrimaryKey(SsoPost record);

}
