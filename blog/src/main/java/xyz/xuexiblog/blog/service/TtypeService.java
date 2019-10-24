package xyz.xuexiblog.blog.service;

import xyz.xuexiblog.blog.pojp.Ttype;
import xyz.xuexiblog.blog.util.Page;

import java.util.List;

public interface TtypeService {
    int deleteByPrimaryKey(Long id);

    int insert(Ttype record);

    Ttype selectByPrimaryKey(Long id);

    List<Ttype> selectAll();

    int updateByPrimaryKey(Ttype record);

    int selectByBlog();

    List<Ttype> selectAllByTypeId(Page page);

    List<Ttype> selectById(Long id);
}
