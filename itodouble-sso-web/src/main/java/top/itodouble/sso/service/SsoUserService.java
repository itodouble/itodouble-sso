package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoUser;
import top.itodouble.sso.entity.sso.SsoUserExample;
import top.itodouble.sso.mapper.sso.SsoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 用户service实现层</P>
 */
@Service
public class SsoUserService {

    @Autowired
    private SsoUserMapper ssoUserMapper;

    public long countByExample(SsoUserExample example){
        return ssoUserMapper.countByExample(example);
    }

    public int deleteByExample(SsoUserExample example){
        return ssoUserMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoUserMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoUser record){
        return ssoUserMapper.insert(record);
    }

    public int insertSelective(SsoUser record){
        return ssoUserMapper.insertSelective(record);
    }

    public List<SsoUser> selectList(SsoUser record, String orderBy) {
        return ssoUserMapper.selectList(record, orderBy);
    }

    public List<SsoUser> selectByExample(SsoUserExample example){
        return ssoUserMapper.selectByExample(example);
    }

    public SsoUser selectByPrimaryKey(String id){
        return ssoUserMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoUser record, SsoUserExample example){
        return ssoUserMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoUser record, SsoUserExample example){
        return ssoUserMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoUser record){
        return ssoUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoUser record){
        return ssoUserMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoUser> listPage(Integer pageNum, Integer pageSize, SsoUserExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserMapper.selectByExample(example));
    }

    public PageInfo<SsoUser> listPage(Integer pageNum, Integer pageSize, SsoUser record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserMapper.selectList(record, orderBy));
    }
}