package cn.mldn.service;

import cn.mldn.pojo.News;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface INewsService {
    public boolean add(News vo) throws Exception;

    public boolean edit(News vo) throws Exception;

    public boolean remove(Set<Integer> ids) throws Exception;

    public News get(int id) throws Exception;

    public List<News> list() throws Exception;

    public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception;
}
