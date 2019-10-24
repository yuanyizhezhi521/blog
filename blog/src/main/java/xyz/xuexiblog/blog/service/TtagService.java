package xyz.xuexiblog.blog.service;

import xyz.xuexiblog.blog.pojp.Ttag;
import xyz.xuexiblog.blog.util.Page;

import java.util.List;

public interface TtagService {
    int deleteByPrimaryKey(Long id);

    int insert(Ttag record);

    Ttag selectByPrimaryKey(Long id);

    List<Ttag> selectAll();

    int updateByPrimaryKey(Ttag record);
    int selectByBlog();
    List<Ttag> selectAllByTagId(Page page);
}
