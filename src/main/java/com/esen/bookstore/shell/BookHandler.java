package com.esen.bookstore.shell;


import com.esen.bookstore.model.Book;
import com.esen.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@ShellCommandGroup
@RequiredArgsConstructor
public class BookHandler {

    private final BookService bookService;

    @ShellMethod(value = "List all books", key="list books")
    public void createBook(String title, String author, String publisher, Double price){
        bookService.save(Book.builder()
                .title(title)
                .author(author)
                .publisher(publisher)
                .price(price)
                .build());
    }

    @ShellMethod(value = "List all books", key="list books")
    public  String listBooks(){
        return bookService.findAll()
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
