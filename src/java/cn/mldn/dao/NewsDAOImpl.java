package cn.mldn.dao;

import cn.mldn.pojo.News;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Component
public class NewsDAOImpl implements INewsDAO {
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public boolean doCreate(News vo) throws Exception {
        System.out.println(vo);
        return this.sessionFactory.getCurrentSession().save(vo) != null;
    }

    @Override
    public boolean doUpdate(News vo) throws Exception {
        String hql = "UPDATE News SET title=:title,pubdate=:pubdate,content=:content WHERE nid=:nid";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("title", vo.getTitle());
        query.setParameter("pubdate", vo.getPubdate());
        query.setParameter("content", vo.getContent());
        query.setParameter("nid", vo.getNid());
        return query.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM News WHERE nid IN( ");
        Iterator<Integer> iter = ids.iterator();
        while (iter.hasNext()) {
            sql.append(iter.next() + ",");
        }
        sql.delete(sql.length() - 1, sql.length()).append(")");
        Query query = this.sessionFactory.getCurrentSession().createQuery(sql.toString());
        return query.executeUpdate() > 0;
    }

    @Override
    public News findById(Integer id) throws Exception {
        return this.sessionFactory.getCurrentSession().get(News.class, id);
    }

    @Override
    public List<News> findAll() throws Exception {
        CriteriaBuilder criteriaBuilder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<News> criteriaQuery = criteriaBuilder.createQuery(News.class);
        criteriaQuery.from(News.class);
        Query<News> query = this.sessionFactory.getCurrentSession().createQuery(criteriaQuery);
        List<News> all = query.getResultList();
        return all;
    }

    @Override
    public List<News> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        String hql = "FROM News As n WHERE n." + column + " LIKE :kw";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("kw", "%" + keyWord + "%");
        query.setFirstResult((currentPage - 1) * lineSize);
        query.setMaxResults(lineSize);
        return query.list();
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String hql = "SELECT COUNT(*) FROM News AS n WHERE n." + column + " LIKE :kw";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("kw", "%" + keyWord + "%");
        Long count = (Long) query.uniqueResult();
        return count.intValue();
    }
}
