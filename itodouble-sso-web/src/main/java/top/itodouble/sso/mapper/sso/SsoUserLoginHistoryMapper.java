package top.itodouble.sso.mapper.sso;

import top.itodouble.sso.entity.sso.SsoUserLoginHistory;
import top.itodouble.sso.entity.sso.SsoUserLoginHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>说明： 登录历史 数据访问层</p>
 */
public interface SsoUserLoginHistoryMapper {

    long countByExample(SsoUserLoginHistoryExample example);

    int deleteByExample(SsoUserLoginHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsoUserLoginHistory record);

    int insertSelective(SsoUserLoginHistory record);

    List<SsoUserLoginHistory> selectList(@Param("record") SsoUserLoginHistory record, @Param("orderBy") String orderBy);

    List<SsoUserLoginHistory> selectByExample(SsoUserLoginHistoryExample example);

    SsoUserLoginHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsoUserLoginHistory record, @Param("example") SsoUserLoginHistoryExample example);

    int updateByExample(@Param("record") SsoUserLoginHistory record, @Param("example") SsoUserLoginHistoryExample example);

    int updateByPrimaryKeySelective(SsoUserLoginHistory record);

    int updateByPrimaryKey(SsoUserLoginHistory record);

}
