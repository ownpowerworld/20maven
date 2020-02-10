package cn.mldn.service;

import cn.mldn.dao.INewsDAO;
import cn.mldn.pojo.News;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class NewsServiceImpl implements INewsService {
    @Resource
    private INewsDAO newsDAO;

    @Override
    public boolean add(News vo) throws Exception {
        return this.newsDAO.doCreate(vo);
    }

    @Override
    public boolean edit(News vo) throws Exception {
        return this.newsDAO.doUpdate(vo);
    }

    @Override
    public boolean remove(Set<Integer> ids) throws Exception {
        if (ids.size() == 0) {
            return false;
        }
        return this.newsDAO.doRemoveBatch(ids);
    }

    @Override
    public News get(int id) throws Exception {
        return this.newsDAO.findById(id);
    }

    @Override
    public List<News> list() throws Exception {
        return this.newsDAO.findAll();
    }

    @Override
    public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("allNews", this.newsDAO.findAllSplit(currentPage, lineSize, column, keyWord));
        map.put("newsCount", this.newsDAO.getAllCount(column, keyWord));
        return map;
    }
}
