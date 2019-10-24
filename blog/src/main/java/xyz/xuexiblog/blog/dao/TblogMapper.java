package xyz.xuexiblog.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.xuexiblog.blog.pojp.Tblog;
import xyz.xuexiblog.blog.util.Page;

import java.util.List;

/**
 *
 */
@Mapper
public interface TblogMapper {
    /**
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @param record
     * @return
     */
    int insert(Tblog record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Tblog record);

    /**
     *
     * @param id
     * @return
     */
    Tblog selectByPrimaryKey(Long id);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Tblog record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Tblog record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Tblog record);

    /**
     *
     * @return
     */
    List<Tblog> selectAll();

    /**
     *
     * @return
     */
    List<Tblog> selectAllOrText();

    /**
     *
     * @return
     */
    int selectcount();

    /**
     *
     * @return
     */
    List<Tblog>   selectByBlogId();

    /**
     *
     * @param id
     * @return
     */
    Tblog selectByUserId(Long id);

    /**
     *
     * @param name
     * @return
     */
    Tblog selectByName(String name);

    /**
     *
     * @return
     */
    String[]  selectYer();

    /**
     *
     * @return
     */
    List<Tblog> selectTime();

    List<Tblog> selecttitle(Page tblog);

    List<Tblog> selectRecommend();
}