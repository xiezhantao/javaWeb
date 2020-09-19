package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xzt
 * @create 2020-07-23 11:07
 */
public class TestBookDao {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void testAddBook(){
        Book book = new Book(null,"所有的遗憾都是成全","林清玄",new BigDecimal("69.00"),9999,9999,null);
        bookDao.addBook(book);
    }

    @Test
    public void testUpdateAndQueryForOneBook(){
        Book book = bookDao.queryBookById(43);
        System.out.println(book);
        book.setPrice(new BigDecimal("999.00"));
        bookDao.updateBook(book);
    }

    @Test
    public void testDeleteBook(){
        bookDao.deleteBookById(43);
    }

    @Test
    public void testQueryForList(){
        List<Book> books = bookDao.queryBooks();
        System.out.println(books);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForItems() {
        for (Book book : bookDao.queryForItems(8, 4)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        Integer integer = bookDao.queryForPageTotalCountByPrice(10, 100);
        System.out.println(integer);
    }

    @Test
    public void queryForItemsByPrice() {
        List<Book> books = bookDao.queryForItemsByPrice(0, 4, 10, 100);
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
