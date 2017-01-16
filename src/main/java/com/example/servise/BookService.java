package com.example.servise;

import com.example.dao.BookDAO;
import com.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Reza-PC on 1/16/2017.
 */
@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;
    @Transactional
    public List<Book> loadPageEntitys(int pageNumber){

      return bookDAO.getOrderedBooks(pageNumber*9,9,"id");

    }
    @Transactional
    public Book Load(Long id){
        return bookDAO.Load(id);
    }
    @Transactional
    public List<String> loadTopRecentWriter(int count){
        return bookDAO.loadTopRecentWriter(count);
    }
    @Transactional
    public List<String> loadTopRecentCategory(int count){
        return bookDAO.loadTopRecentCategory(count);
    }
}
