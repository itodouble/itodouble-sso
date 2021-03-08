package top.itodouble.sso.apiService;

import top.itodouble.sso.entity.sso.SsoDict;

import java.util.List;

public interface SsoDictApi {
    /**
     * 根据系统 分组以及sn 查询某一个
     *
     * @param systemCode
     * @param dictPrefix
     * @param dictSn
     * @return
     */
    SsoDict getBySystemCodeAndPrefixAndSn(String systemCode, String dictPrefix, String dictSn);

    /**
     * 根据系统 分组以及
     *
     * @param systemCode
     * @param dictPrefix
     * @param dictData
     * @return
     */
    SsoDict getBySystemCodeAndPrefixAndDictData(String systemCode, String dictPrefix, String dictData);

    SsoDict getBySystemCodeAndPrefixAndSnOrData(String systemCode, String dictPrefix, String dictSnOrData);

    List<SsoDict> ListBySystemCodeAndPrefix(String systemCode, String dictPrefix);
}
