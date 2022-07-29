package store.services;

import store.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks ();
    List<Book> getFilteredBooks(String pattern);
}
