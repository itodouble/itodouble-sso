package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoUserSecurity;
import top.itodouble.sso.entity.sso.SsoUserSecurityExample;
import top.itodouble.sso.mapper.sso.SsoUserSecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 保存密码私密信息service实现层</P>
 */
@Service
public class SsoUserSecurityService {

    @Autowired
    private SsoUserSecurityMapper ssoUserSecurityMapper;

    public long countByExample(SsoUserSecurityExample example){
        return ssoUserSecurityMapper.countByExample(example);
    }

    public int deleteByExample(SsoUserSecurityExample example){
        return ssoUserSecurityMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoUserSecurityMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoUserSecurity record){
        return ssoUserSecurityMapper.insert(record);
    }

    public int insertSelective(SsoUserSecurity record){
        return ssoUserSecurityMapper.insertSelective(record);
    }

    public List<SsoUserSecurity> selectList(SsoUserSecurity record, String orderBy) {
        return ssoUserSecurityMapper.selectList(record, orderBy);
    }

    public List<SsoUserSecurity> selectByExample(SsoUserSecurityExample example){
        return ssoUserSecurityMapper.selectByExample(example);
    }

    public SsoUserSecurity selectByPrimaryKey(String id){
        return ssoUserSecurityMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoUserSecurity record, SsoUserSecurityExample example){
        return ssoUserSecurityMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoUserSecurity record, SsoUserSecurityExample example){
        return ssoUserSecurityMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoUserSecurity record){
        return ssoUserSecurityMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoUserSecurity record){
        return ssoUserSecurityMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoUserSecurity> listPage(Integer pageNum, Integer pageSize, SsoUserSecurityExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserSecurityMapper.selectByExample(example));
    }

    public PageInfo<SsoUserSecurity> listPage(Integer pageNum, Integer pageSize, SsoUserSecurity record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserSecurityMapper.selectList(record, orderBy));
    }
}