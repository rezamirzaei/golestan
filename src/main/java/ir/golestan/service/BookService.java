package ir.golestan.service;

import ir.golestan.dao.BookDAO;
import ir.golestan.model.Book;
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
    public List loadPageEntitys(int pageNumber) {

        return bookDAO.getOrderedBooks((pageNumber-1 )* 9, 9, "id");

    }

    @Transactional
    public Book Load(int id) {
        return bookDAO.Load(id);
    }

    @Transactional
    public List<String> loadTopRecentWriter(int count) {
        return bookDAO.loadTopRecentWriter(count);
    }

    @Transactional
    public List<String> loadTopRecentCategory(int count) {
        return bookDAO.loadTopRecentCategory(count);
    }
    @Transactional
    public Book search(String name){
        List<Book> list= bookDAO.search(name);
        if(list!=null&&list.size()>0){
            return (Book)list.get(0);
        }
        return null;
    }
}
