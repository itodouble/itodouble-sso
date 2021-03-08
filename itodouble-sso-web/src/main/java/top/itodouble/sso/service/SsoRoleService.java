package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.entity.sso.SsoRoleExample;
import top.itodouble.sso.mapper.sso.SsoRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： service实现层</P>
 */
@Service
public class SsoRoleService {

    @Autowired
    private SsoRoleMapper ssoRoleMapper;

    public long countByExample(SsoRoleExample example){
        return ssoRoleMapper.countByExample(example);
    }

    public int deleteByExample(SsoRoleExample example){
        return ssoRoleMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoRoleMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoRole record){
        return ssoRoleMapper.insert(record);
    }

    public int insertSelective(SsoRole record){
        return ssoRoleMapper.insertSelective(record);
    }

    public List<SsoRole> selectList(SsoRole record, String orderBy) {
        return ssoRoleMapper.selectList(record, orderBy);
    }

    public List<SsoRole> selectByExample(SsoRoleExample example){
        return ssoRoleMapper.selectByExample(example);
    }

    public SsoRole selectByPrimaryKey(String id){
        return ssoRoleMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoRole record, SsoRoleExample example){
        return ssoRoleMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoRole record, SsoRoleExample example){
        return ssoRoleMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoRole record){
        return ssoRoleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoRole record){
        return ssoRoleMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoRole> listPage(Integer pageNum, Integer pageSize, SsoRoleExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoRoleMapper.selectByExample(example));
    }

    public PageInfo<SsoRole> listPage(Integer pageNum, Integer pageSize, SsoRole record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoRoleMapper.selectList(record, orderBy));
    }
}