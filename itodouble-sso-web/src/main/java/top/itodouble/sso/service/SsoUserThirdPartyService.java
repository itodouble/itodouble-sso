package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoUserThirdParty;
import top.itodouble.sso.entity.sso.SsoUserThirdPartyExample;
import top.itodouble.sso.mapper.sso.SsoUserThirdPartyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 用户第三方平台信息service实现层</P>
 */
@Service
public class SsoUserThirdPartyService {

    @Autowired
    private SsoUserThirdPartyMapper ssoUserThirdPartyMapper;

    public long countByExample(SsoUserThirdPartyExample example){
        return ssoUserThirdPartyMapper.countByExample(example);
    }

    public int deleteByExample(SsoUserThirdPartyExample example){
        return ssoUserThirdPartyMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoUserThirdPartyMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoUserThirdParty record){
        return ssoUserThirdPartyMapper.insert(record);
    }

    public int insertSelective(SsoUserThirdParty record){
        return ssoUserThirdPartyMapper.insertSelective(record);
    }

    public List<SsoUserThirdParty> selectList(SsoUserThirdParty record, String orderBy) {
        return ssoUserThirdPartyMapper.selectList(record, orderBy);
    }

    public List<SsoUserThirdParty> selectByExample(SsoUserThirdPartyExample example){
        return ssoUserThirdPartyMapper.selectByExample(example);
    }

    public SsoUserThirdParty selectByPrimaryKey(String id){
        return ssoUserThirdPartyMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoUserThirdParty record, SsoUserThirdPartyExample example){
        return ssoUserThirdPartyMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoUserThirdParty record, SsoUserThirdPartyExample example){
        return ssoUserThirdPartyMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoUserThirdParty record){
        return ssoUserThirdPartyMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoUserThirdParty record){
        return ssoUserThirdPartyMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoUserThirdParty> listPage(Integer pageNum, Integer pageSize, SsoUserThirdPartyExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserThirdPartyMapper.selectByExample(example));
    }

    public PageInfo<SsoUserThirdParty> listPage(Integer pageNum, Integer pageSize, SsoUserThirdParty record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserThirdPartyMapper.selectList(record, orderBy));
    }
}