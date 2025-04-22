package com.esen.bookstore.service;

import java.util.List;
import com.esen.bookstore.model.Book;
import com.esen.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

}
