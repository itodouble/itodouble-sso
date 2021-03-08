package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoDeptExt;
import top.itodouble.sso.entity.sso.SsoDeptExtExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 部门扩展表 数据访问层</p>
 */
public interface SsoDeptExtMapper {

    long countByExample(SsoDeptExtExample example);

    int deleteByExample(SsoDeptExtExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoDeptExt record);

    int insertSelective(SsoDeptExt record);

    List<SsoDeptExt> selectList(@Param("record") SsoDeptExt record, @Param("orderBy") String orderBy);

    List<SsoDeptExt> selectByExample(SsoDeptExtExample example);

    SsoDeptExt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoDeptExt record, @Param("example") SsoDeptExtExample example);

    int updateByExample(@Param("record") SsoDeptExt record, @Param("example") SsoDeptExtExample example);

    int updateByPrimaryKeySelective(SsoDeptExt record);

    int updateByPrimaryKey(SsoDeptExt record);

}
