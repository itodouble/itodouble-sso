package top.itodouble.sso.apiServiceImpl;

import top.itodouble.sso.apiService.SsoDictApi;
import top.itodouble.sso.constant.FinanceSsoConst;
import top.itodouble.sso.entity.sso.SsoDict;
import top.itodouble.sso.service.SsoDictService;
import top.itodouble.sso.service.add.SsoDictAddService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(version = FinanceSsoConst.dubboVersion)
@Component
public class SsoDictApiImpl implements SsoDictApi {
    @Autowired
    private SsoDictService ssoDictService;
    @Autowired
    private SsoDictAddService ssoDictAddService;

    @Override
    public SsoDict getBySystemCodeAndPrefixAndSn(String systemCode, String dictPrefix, String dictSn) {
        return ssoDictAddService.getBySystemCodeAndPrefixAndSn(systemCode, dictPrefix, dictSn);
    }

    @Override
    public SsoDict getBySystemCodeAndPrefixAndDictData(String systemCode, String dictPrefix, String dictData) {
        return ssoDictAddService.getBySystemCodeAndPrefixAndDictData(systemCode, dictPrefix, dictData);
    }

    @Override
    public SsoDict getBySystemCodeAndPrefixAndSnOrData(String systemCode, String dictPrefix, String dictSnOrData) {
        return ssoDictAddService.getBySystemCodeAndPrefixAndSnOrData(systemCode, dictPrefix, dictSnOrData);
    }

    @Override
    public List<SsoDict> ListBySystemCodeAndPrefix(String systemCode, String dictPrefix) {
        SsoDict ssoDict = new SsoDict();
        ssoDict.setSystemCode(systemCode);
        ssoDict.setDictPrefix(dictPrefix);
        return ssoDictService.selectList(ssoDict, "order_id desc");
    }
}
