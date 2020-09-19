package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * @author xzt
 * @create 2020-07-23 13:55
 */
public interface BookService {

    public int addBook(Book book);

    public int updateBook(Book book);

    public int deleteBookById(Integer id);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page page(int pageNo, int pageSize);

    Page pageByPrice(int pageNo, int pageSize, int min, int max);
}
