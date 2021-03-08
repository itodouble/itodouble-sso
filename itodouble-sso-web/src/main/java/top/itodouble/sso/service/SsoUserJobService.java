package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoUserJob;
import top.itodouble.sso.entity.sso.SsoUserJobExample;
import top.itodouble.sso.mapper.sso.SsoUserJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 用户任职记录service实现层</P>
 */
@Service
public class SsoUserJobService {

    @Autowired
    private SsoUserJobMapper ssoUserJobMapper;

    public long countByExample(SsoUserJobExample example){
        return ssoUserJobMapper.countByExample(example);
    }

    public int deleteByExample(SsoUserJobExample example){
        return ssoUserJobMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoUserJobMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoUserJob record){
        return ssoUserJobMapper.insert(record);
    }

    public int insertSelective(SsoUserJob record){
        return ssoUserJobMapper.insertSelective(record);
    }

    public List<SsoUserJob> selectList(SsoUserJob record, String orderBy) {
        return ssoUserJobMapper.selectList(record, orderBy);
    }

    public List<SsoUserJob> selectByExample(SsoUserJobExample example){
        return ssoUserJobMapper.selectByExample(example);
    }

    public SsoUserJob selectByPrimaryKey(String id){
        return ssoUserJobMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoUserJob record, SsoUserJobExample example){
        return ssoUserJobMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoUserJob record, SsoUserJobExample example){
        return ssoUserJobMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoUserJob record){
        return ssoUserJobMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoUserJob record){
        return ssoUserJobMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoUserJob> listPage(Integer pageNum, Integer pageSize, SsoUserJobExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserJobMapper.selectByExample(example));
    }

    public PageInfo<SsoUserJob> listPage(Integer pageNum, Integer pageSize, SsoUserJob record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoUserJobMapper.selectList(record, orderBy));
    }
}