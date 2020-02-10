package cn.mldn.action;

import cn.mldn.pojo.News;
import cn.mldn.service.INewsService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Repository
public class NewsAction extends ActionSupport {
    @Resource
    private INewsService newsService;
    private News news = new News();

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public void show() {
        System.out.println(newsService);
        System.out.println("SHOW!!");
    }

    public void add() throws Exception {
        System.out.println("新闻数据增加" + this.news);
        System.out.println("新闻数据增加结果" + this.newsService.add(this.news));
    }

    public void edit() throws Exception {
        System.out.println("新闻数据修改:" + this.news);
        System.out.println("新闻数据修改结果" + this.newsService.edit(this.news));
    }

    public void remove() throws Exception {
        String ids = ServletActionContext.getRequest().getParameter("ids");
        System.out.println("新闻删除数据:" + ids);
        Set<Integer> set = new HashSet<>();
        String result[] = ids.split("-");
        for (int x = 0; x < result.length; x++) {
            set.add(Integer.parseInt(result[x]));
        }
        System.out.println("新闻数据修改结果" + this.newsService.remove(set));
    }

    public void get() throws Exception {
        System.out.println("新闻删除数据取得:" + this.news);
        System.out.println("新闻删除数据取得" + this.newsService.get(this.news.getNid()));
    }

    public void list() throws Exception {
        System.out.println("新闻删除数据列表:" + this.news);
        System.out.println("新闻删除数据列表" + this.newsService.list());
    }

    public void listsplit() throws Exception {
        System.out.println("新闻删除数据列表:" + this.news);
        System.out.println("新闻删除数据列表" + this.newsService.list(1, 5, "title", ""));
    }

}
