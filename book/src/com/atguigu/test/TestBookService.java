package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author xzt
 * @create 2020-07-23 13:59
 */
public class TestBookService {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void test1(){
//        Book book = new Book(44,"所有的遗憾都是成全","林清玄",new BigDecimal("969.00"),9999,9999,null);
//        bookService.addBook(book);
//        bookService.updateBook(book);
//        System.out.println(bookService.queryBookById(44));
//        for(Book book1 : bookService.queryBooks()){
//            System.out.println(book1);
//        }
//        bookService.deleteBookById(44);
        Page page = bookService.page(1, 4);
        System.out.println(page);
        System.out.println(page.getItems().size());
    }

    @Test
    public void pageByPrice() {

        Page page = bookService.pageByPrice(0, 4, 10, 100);
        for (Object item : page.getItems()) {
            System.out.println(item);
        }

    }

}
