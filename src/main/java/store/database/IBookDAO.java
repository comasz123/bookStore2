package store.database;

import store.model.Book;

import java.util.ArrayList;
import java.util.List;

public interface IBookDAO  {
    List<Book> getBooks();
}
