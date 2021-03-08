package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoPermission;
import top.itodouble.sso.entity.sso.SsoPermissionExample;
import top.itodouble.sso.mapper.sso.SsoPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： service实现层</P>
 */
@Service
public class SsoPermissionService {

    @Autowired
    private SsoPermissionMapper ssoPermissionMapper;

    public long countByExample(SsoPermissionExample example){
        return ssoPermissionMapper.countByExample(example);
    }

    public int deleteByExample(SsoPermissionExample example){
        return ssoPermissionMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoPermissionMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoPermission record){
        return ssoPermissionMapper.insert(record);
    }

    public int insertSelective(SsoPermission record){
        return ssoPermissionMapper.insertSelective(record);
    }

    public List<SsoPermission> selectList(SsoPermission record, String orderBy) {
        return ssoPermissionMapper.selectList(record, orderBy);
    }

    public List<SsoPermission> selectByExample(SsoPermissionExample example){
        return ssoPermissionMapper.selectByExample(example);
    }

    public SsoPermission selectByPrimaryKey(String id){
        return ssoPermissionMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoPermission record, SsoPermissionExample example){
        return ssoPermissionMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoPermission record, SsoPermissionExample example){
        return ssoPermissionMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoPermission record){
        return ssoPermissionMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoPermission record){
        return ssoPermissionMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoPermission> listPage(Integer pageNum, Integer pageSize, SsoPermissionExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoPermissionMapper.selectByExample(example));
    }

    public PageInfo<SsoPermission> listPage(Integer pageNum, Integer pageSize, SsoPermission record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoPermissionMapper.selectList(record, orderBy));
    }
}