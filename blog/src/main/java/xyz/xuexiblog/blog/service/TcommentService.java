package xyz.xuexiblog.blog.service;

import xyz.xuexiblog.blog.pojp.Tcomment;

import java.util.List;

public interface TcommentService {
    int deleteByPrimaryKey(Long id);

    int insert(Tcomment record);

    int insertSelective(Tcomment record);

    Tcomment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tcomment record);

    int updateByPrimaryKey(Tcomment record);
    public List<Tcomment> selectAll();
    public List<Tcomment> selectAllCommentId();
    public List<Tcomment> selectblogId(Long id);
    public List<Tcomment> selectparent(Long id);
}
