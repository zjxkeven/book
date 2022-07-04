package com.flying.book.service;

import com.flying.book.dao.BookRepo;
import com.flying.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo dao;

    @Autowired
    public BookService(BookRepo dao) {
        this.dao = dao;
    }

    public Book findById(Long id){
        return dao.findById(id).get();
    }

    public List<Book> findAll(){
        return dao.findAll();
    }

    public void save(Book book){
        dao.save(book);
    }

    public void deleteById(Long id){
        dao.deleteById(id);
    }

}
