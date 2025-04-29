package com.esen.bookstore.shell;


import com.esen.bookstore.model.Book;
import com.esen.bookstore.repository.BookRepository;
import com.esen.bookstore.repository.BookstoreRepository;
import com.esen.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ShellComponent
@ShellCommandGroup
@RequiredArgsConstructor
public class BookHandler {

    private final BookService bookService;

    @ShellMethod(value = "create book", key="create book")
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

    @ShellMethod(value = "delete book by id", key="delete book")
    public void deleteBook(Long id){
        bookService.delete(id);
    }

    @ShellMethod(value = "update book ", key="update book")
    public String updateBook(
            @ShellOption(defaultValue = ShellOption.NULL) Long id,
            @ShellOption(defaultValue = ShellOption.NULL) String title,
            @ShellOption(defaultValue = ShellOption.NULL) String author,
            @ShellOption(defaultValue = ShellOption.NULL) String publisher,
            @ShellOption(defaultValue = ShellOption.NULL) Double price
    ){
        return bookService.update(id,title,author,publisher,price).toString();
    }

}
