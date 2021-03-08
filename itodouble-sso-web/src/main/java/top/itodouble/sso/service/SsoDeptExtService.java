package top.itodouble.sso.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.itodouble.sso.entity.sso.SsoDeptExt;
import top.itodouble.sso.entity.sso.SsoDeptExtExample;
import top.itodouble.sso.mapper.sso.SsoDeptExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>说明： 部门扩展表service实现层</P>
 */
@Service
public class SsoDeptExtService {

    @Autowired
    private SsoDeptExtMapper ssoDeptExtMapper;

    public long countByExample(SsoDeptExtExample example){
        return ssoDeptExtMapper.countByExample(example);
    }

    public int deleteByExample(SsoDeptExtExample example){
        return ssoDeptExtMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return ssoDeptExtMapper.deleteByPrimaryKey(id);
    }

    public int insert(SsoDeptExt record){
        return ssoDeptExtMapper.insert(record);
    }

    public int insertSelective(SsoDeptExt record){
        return ssoDeptExtMapper.insertSelective(record);
    }

    public List<SsoDeptExt> selectList(SsoDeptExt record, String orderBy) {
        return ssoDeptExtMapper.selectList(record, orderBy);
    }

    public List<SsoDeptExt> selectByExample(SsoDeptExtExample example){
        return ssoDeptExtMapper.selectByExample(example);
    }

    public SsoDeptExt selectByPrimaryKey(String id){
        return ssoDeptExtMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(SsoDeptExt record, SsoDeptExtExample example){
        return ssoDeptExtMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SsoDeptExt record, SsoDeptExtExample example){
        return ssoDeptExtMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SsoDeptExt record){
        return ssoDeptExtMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SsoDeptExt record){
        return ssoDeptExtMapper.updateByPrimaryKey(record);
    }

    public PageInfo<SsoDeptExt> listPage(Integer pageNum, Integer pageSize, SsoDeptExtExample example){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoDeptExtMapper.selectByExample(example));
    }

    public PageInfo<SsoDeptExt> listPage(Integer pageNum, Integer pageSize, SsoDeptExt record, String orderBy){
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->ssoDeptExtMapper.selectList(record, orderBy));
    }
}