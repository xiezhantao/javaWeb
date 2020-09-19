package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xzt
 * @create 2020-07-23 13:57
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public int addBook(Book book) {
        int i = bookDao.addBook(book);
        int j = 10 / 0;
        return i;
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page page(int pageNo, int pageSize) {
        Page page = new Page();


        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        /*在PageTotal设置之后再设置PageNo set方法里面做了数据边界的有效检车*/
        page.setPageNo(pageNo);

        Integer begin = (page.getPageNo() - 1) * pageSize;

        List<Book> items = bookDao.queryForItems(begin,pageSize);

        page.setItems(items);

        return page;
    }

    @Override
    public Page pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page page = new Page();

        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        /*在PageTotal设置之后再设置PageNo set方法里面做了数据边界的有效检车*/
        page.setPageNo(pageNo);

        Integer begin = (page.getPageNo() - 1) * pageSize;

        List<Book> items = bookDao.queryForItemsByPrice(begin,pageSize,min,max);

        page.setItems(items);

        return page;
    }
}
