package com.keyin.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;



    public Author createNewAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Iterable<Author> getALlAuthors() {
         return authorRepository.findAll();

    }

    public Author findByAuthorName(String authorName) {
        return authorRepository.findByAuthorName(authorName);

    }
}
