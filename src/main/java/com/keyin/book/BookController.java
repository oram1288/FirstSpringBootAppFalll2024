package com.keyin.book;

import com.keyin.author.Author;
import com.keyin.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/listAllBooks")
    public Iterable<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/addNewBook")
    public Book addNewBook(@RequestBody Book book) {
        Optional<Author> authorOptional = Optional.ofNullable(authorService.findByAuthorName(book.getAuthor().getAuthorName()));

        Author author;
        if (authorOptional.isPresent()) {
            author = authorOptional.get();
        } else {
            // Save the new author if it doesn't exist
            author = book.getAuthor();
            authorService.createNewAuthor(author);
        }

        book.setAuthor(author); // Set the persisted author on the book
        return bookService.AddBook(book);

    }

    @GetMapping("/getBooksForAuthor")
    public Iterable<Book> getBooksForAuthor(@RequestParam("authorName") String authorName) {
        return bookService.findByAuthor(authorName);
    }


}
