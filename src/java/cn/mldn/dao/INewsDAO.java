package cn.mldn.dao;

import cn.mldn.pojo.News;

import java.util.List;
import java.util.Set;

public interface INewsDAO {
    public boolean doCreate(News vo) throws Exception;

    public boolean doUpdate(News vo) throws Exception;

    public boolean doRemoveBatch(Set<Integer> ids) throws Exception;

    public News findById(Integer id) throws Exception;

    public List<News> findAll() throws Exception;

    public List<News> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception;

    public Integer getAllCount(String column, String keyWord) throws Exception;
}
