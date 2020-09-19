package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author xzt
 * @create 2020-07-23 10:55
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForItems(Integer begin,Integer pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForItemsByPrice(Integer begin, int pageSize, int min, int max);
}
