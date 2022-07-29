package store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.database.IBookDAO;
import store.model.Book;
import store.services.IBookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookDAO bookDAO;

    public List<Book> getAllBooks () {
        return this.bookDAO.getBooks();
    }

    @Override
    public List<Book> getFilteredBooks(String pattern) {
        List<Book> allBooks = this.bookDAO.getBooks();
        List<Book> result = new ArrayList<>();

        for (Book book: allBooks) {
            if(book.getTitle().toLowerCase().contains(pattern.toLowerCase())
                    ||book.getAuthor().toLowerCase().contains(pattern.toLowerCase())){
                result.add(book);
            }
        }
        return result;
    }
}
