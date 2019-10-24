package xyz.xuexiblog.blog.service;


import xyz.xuexiblog.blog.pojp.Tblog;
import xyz.xuexiblog.blog.util.Page;

import java.util.List;
import java.util.Map;

public interface TblogService {
    int deleteByPrimaryKey(Long id);

    int insert(Tblog record);

    int insertSelective(Tblog record);

    Tblog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tblog record);

    int updateByPrimaryKeyWithBLOBs(Tblog record);

    int updateByPrimaryKey(Tblog record);

    List<Tblog> selectAll();

    List<Tblog> selectAllOrText();

    int selectcount();
    List<Tblog>   selectByBlogId();

    Tblog selectByUserId(Long id);

    Tblog selectByName(String name);

    Map<String,List<Tblog>> selectordecDate();

    List<Tblog> selectLikeTitle(Page tblog);

    List<Tblog> selectRecommend();
}
