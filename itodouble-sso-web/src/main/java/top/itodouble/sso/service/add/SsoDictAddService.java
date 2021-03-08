package top.itodouble.sso.service.add;

import top.itodouble.sso.entity.sso.SsoDict;
import top.itodouble.sso.mapper.sso.add.SsoDictAddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsoDictAddService {
    @Autowired
    private SsoDictAddMapper ssoDictAddMapper;

    public SsoDict getBySystemCodeAndPrefixAndSn(String systemCode, String dictPrefix, String dictSn) {
        return ssoDictAddMapper.getBySystemCodeAndPrefixAndSnAndData(systemCode, dictPrefix, dictSn, null);
    }

    public SsoDict getBySystemCodeAndPrefixAndDictData(String systemCode, String dictPrefix, String dictData) {
        return ssoDictAddMapper.getBySystemCodeAndPrefixAndSnAndData(systemCode, dictPrefix, null, dictData);
    }

    public SsoDict getBySystemCodeAndPrefixAndSnOrData(String systemCode, String dictPrefix, String keyword) {
        return ssoDictAddMapper.getBySystemCodeAndPrefixAndSnOrData(systemCode, dictPrefix, keyword);
    }
}
