package com.esen.bookstore.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.esen.bookstore.model.Book;
import com.esen.bookstore.repository.BookRepository;
import com.esen.bookstore.repository.BookstoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookStoreService bookStoreService;

    public void save(Book book){
        bookRepository.save(book);
    }
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public void  delete(Long id){
        if (!bookRepository.existsById(id)){
            throw  new IllegalArgumentException("Cannot find");
        }
       // bookRepository.deleteById(id);

        var book = bookRepository.findById(id).get();
        bookStoreService.removeBookFromInvertories(book);
        bookRepository.delete(book);
    }



    public Book update(Long id, String title, String author, String publisher, Double price){
        if (Stream.of(id,title,author,publisher,price).allMatch(Objects::isNull)){
            throw new IllegalArgumentException("Need at least one input");
        }
        if (!bookRepository.existsById(id)){
            throw  new IllegalArgumentException("Cannot find");
        }
        var book = bookRepository.findById(id).get();


        if (title != null){
            book.setTitle(title);
        }

        if (author != null){
            book.setAuthor(author);
        }

        if (publisher != null){
            book.setPublisher(publisher);
        }

        if (price != null){
            book.setPrice(price);
        }

        return bookRepository.save(book);
    }



}
