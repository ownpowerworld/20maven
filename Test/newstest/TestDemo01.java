package newstest;

import cn.mldn.pojo.News;
import cn.mldn.service.INewsService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class TestDemo01 {
    public static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @org.junit.Test
    public void testAdd() {
        INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
        News vo = new News();
        vo.setTitle("SSH整合啦!" + System.currentTimeMillis());
        vo.setPubdate(new Date());
        vo.setContent("SSH很丰富!");
        try {
            TestCase.assertEquals(service.add(vo), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void testEdit() {
        INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
        News vo = new News();
        vo.setNid(11);
        vo.setTitle("找工作ing!");
        vo.setPubdate(new Date());
        vo.setContent("兴奋吗?!");
        try {
            TestCase.assertEquals(service.edit(vo), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void testRemove() {
        INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
        Set<Integer> set = new HashSet<>();
        set.add(3);
        try {
            TestCase.assertEquals(service.remove(set), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testList() {
        INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
        try {
            List<News> all = service.list();
            System.out.println(all);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testListIntIntStringString() {
        INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
        try {
            Map<String,Object> map = service.list(1,5,"title","好");
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
