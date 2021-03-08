package top.itodouble.sso.mapper.sso.add;

import top.itodouble.sso.entity.sso.SsoDict;
import org.apache.ibatis.annotations.Param;

public interface SsoDictAddMapper {
    SsoDict getBySystemCodeAndPrefixAndSnAndData(@Param("systemCode") String systemCode, @Param("dictPrefix") String dictPrefix, @Param("dictSn") String dictSn, @Param("dictData") String dictData);

    SsoDict getBySystemCodeAndPrefixAndSnOrData(@Param("systemCode") String systemCode, @Param("dictPrefix") String dictPrefix, @Param("key") String key);
}
