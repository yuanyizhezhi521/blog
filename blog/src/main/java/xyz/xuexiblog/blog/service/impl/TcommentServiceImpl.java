package xyz.xuexiblog.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xuexiblog.blog.dao.TcommentMapper;
import xyz.xuexiblog.blog.pojp.Tcomment;
import xyz.xuexiblog.blog.service.TcommentService;

import java.util.List;

@Service
public class TcommentServiceImpl implements TcommentService {
    @Autowired
    TcommentMapper tcommentMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Tcomment record) {
        return tcommentMapper.insert(record);
    }

    @Override
    public int insertSelective(Tcomment record) {
        return 0;
    }

    @Override
    public Tcomment selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Tcomment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Tcomment record) {
        return 0;
    }

    @Override
    public List<Tcomment> selectAll() {
        return null;
    }
    @Override
    public List<Tcomment> selectAllCommentId() {
        return tcommentMapper.selectAllCommentId();
    }

    @Override
    public List<Tcomment> selectblogId(Long id) {
        return tcommentMapper.selectblogId(id);
    }

    @Override
    public List<Tcomment> selectparent(Long id) {
        return tcommentMapper.selectparent(id);
    }

    @Override
    public List<Tcomment> selectparent_comment_id(Long id) {
        return tcommentMapper.selectparent_comment_id(id);
    }
}
