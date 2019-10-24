package xyz.xuexiblog.blog.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName page
 * @Description: TODO
 * @Author xuexi
 * @Date 2019/10/10
 * @Version V1.0
 **/
public class Page {
    // 1.当前页数 从页面获取
    private int currentPage=0;
    // 2.每页显示数据个数，赋初值或者setter获取
    private int currentCount=10;
    // 3.总条数，从数据库获取
    private int totalRecord;
    // 4.总页数，计算得到
    private int totalPage;
    // 5.每页的显示数据，数据库得到
    List<?> list = new ArrayList<>();
    Long tid;
    Long taid;
    String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getTaid() {
        return taid;
    }

    public void setTaid(Long taid) {
        this.taid = taid;
    }




    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public static int TotalPage(int totalRecord, int currentCount){
        if (totalRecord%currentCount==0){
            return totalRecord/currentCount;
        }else {
            return totalRecord/currentCount+1;
        }
    }


}
