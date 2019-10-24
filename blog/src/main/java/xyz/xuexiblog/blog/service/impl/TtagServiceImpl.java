package xyz.xuexiblog.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xuexiblog.blog.dao.TtagMapper;
import xyz.xuexiblog.blog.pojp.Ttag;
import xyz.xuexiblog.blog.service.TtagService;
import xyz.xuexiblog.blog.util.Page;

import java.util.List;
@Service
public class TtagServiceImpl implements TtagService {
    @Autowired
    TtagMapper ttagMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return ttagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Ttag record) {
        return ttagMapper.insert(record);
    }

    @Override
    public Ttag selectByPrimaryKey(Long id) {
        return ttagMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ttag> selectAll() {
        return ttagMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Ttag record) {
        return ttagMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectByBlog() {
        return ttagMapper.selectByBlog();
    }

    @Override
    public List<Ttag> selectAllByTagId(Page page) {
        return ttagMapper.selectAllByTagId(page);
    }
}
