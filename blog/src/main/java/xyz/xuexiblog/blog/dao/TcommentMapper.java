package xyz.xuexiblog.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.xuexiblog.blog.pojp.Tcomment;

import java.util.List;

@Mapper
public interface TcommentMapper {
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