package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoDept;
import top.itodouble.sso.entity.sso.SsoDeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 部门 数据访问层</p>
 */
public interface SsoDeptMapper {

    long countByExample(SsoDeptExample example);

    int deleteByExample(SsoDeptExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoDept record);

    int insertSelective(SsoDept record);

    List<SsoDept> selectList(@Param("record") SsoDept record, @Param("orderBy") String orderBy);

    List<SsoDept> selectByExample(SsoDeptExample example);

    SsoDept selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoDept record, @Param("example") SsoDeptExample example);

    int updateByExample(@Param("record") SsoDept record, @Param("example") SsoDeptExample example);

    int updateByPrimaryKeySelective(SsoDept record);

    int updateByPrimaryKey(SsoDept record);

}
