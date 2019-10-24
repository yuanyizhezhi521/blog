package xyz.xuexiblog.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xuexiblog.blog.dao.TtypeMapper;
import xyz.xuexiblog.blog.pojp.Ttype;
import xyz.xuexiblog.blog.service.TtypeService;
import xyz.xuexiblog.blog.util.Page;

import java.util.List;

@Service
public class TtypeServiceImpl implements TtypeService {
    @Autowired
    TtypeMapper ttypeMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return ttypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Ttype record) {
        return ttypeMapper.insert(record);
    }

    @Override
    public Ttype selectByPrimaryKey(Long id) {
        return ttypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ttype> selectAll() {
        return ttypeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Ttype record) {
        return ttypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectByBlog() {
        return ttypeMapper.selectByBlog();
    }

    @Override
    public List<Ttype> selectAllByTypeId(Page page) {
        return ttypeMapper.selectAllByTypeId(page);
    }

    @Override
    public List<Ttype> selectById(Long id) {
        return ttypeMapper.selectById(id);
    }
}
