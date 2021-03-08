package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoArea;
import top.itodouble.sso.entity.sso.SsoAreaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明：  数据访问层</p>
 */
public interface SsoAreaMapper {

    long countByExample(SsoAreaExample example);

    int deleteByExample(SsoAreaExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoArea record);

    int insertSelective(SsoArea record);

    List<SsoArea> selectList(@Param("record") SsoArea record, @Param("orderBy") String orderBy);

    List<SsoArea> selectByExample(SsoAreaExample example);

    SsoArea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoArea record, @Param("example") SsoAreaExample example);

    int updateByExample(@Param("record") SsoArea record, @Param("example") SsoAreaExample example);

    int updateByPrimaryKeySelective(SsoArea record);

    int updateByPrimaryKey(SsoArea record);

}
