package com.esen.bookstore.shell;

import com.esen.bookstore.model.BookStore;
import com.esen.bookstore.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@ShellCommandGroup
@RequiredArgsConstructor
public class BookStoreHandler {

    private final BookStoreService bookStoreService;

    @ShellMethod(value = "list all bookstores", key="list stores")
    public String findAll(){
        return bookStoreService.findAll()
                .stream().map(bookstore -> {
                bookstore.setInventory(null);
                return bookstore;
                }).map(BookStore::toString).collect(Collectors.joining(System.lineSeparator()));

    }

    @ShellMethod(value = "delete bookstore by id", key="delete bookstore")
    public void deleteBookStore(Long id){
        bookStoreService.delete(id);
    }

}
