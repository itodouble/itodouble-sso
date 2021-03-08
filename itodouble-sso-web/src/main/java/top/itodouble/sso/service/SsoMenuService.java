package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoMenu;
import top.itodouble.sso.entity.sso.SsoMenuExample;
import top.itodouble.sso.mapper.sso.SsoMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 菜单按钮service实现层</P>
 */
@Service
public class SsoMenuService {

    @Autowired
    private SsoMenuMapper ssoMenuMapper;

    public long countByExample(SsoMenuExample example){
        return ssoMenuMapper.countByExample(example);
    }

    public int deleteByExample(SsoMenuExample example){
        return ssoMenuMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoMenuMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoMenu record){
        return ssoMenuMapper.insert(record);
    }

    public int insertSelective(SsoMenu record){
        return ssoMenuMapper.insertSelective(record);
    }

    public List<SsoMenu> selectList(SsoMenu record, String orderBy) {
        return ssoMenuMapper.selectList(record, orderBy);
    }

    public List<SsoMenu> selectByExample(SsoMenuExample example){
        return ssoMenuMapper.selectByExample(example);
    }

    public SsoMenu selectByPrimaryKey(String id){
        return ssoMenuMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoMenu record, SsoMenuExample example){
        return ssoMenuMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoMenu record, SsoMenuExample example){
        return ssoMenuMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoMenu record){
        return ssoMenuMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoMenu record){
        return ssoMenuMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoMenu> listPage(Integer pageNum, Integer pageSize, SsoMenuExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoMenuMapper.selectByExample(example));
    }

    public PageInfo<SsoMenu> listPage(Integer pageNum, Integer pageSize, SsoMenu record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoMenuMapper.selectList(record, orderBy));
    }
}