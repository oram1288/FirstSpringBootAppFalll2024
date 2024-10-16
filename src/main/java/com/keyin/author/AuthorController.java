package com.keyin.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/getAllAuthors")
    public Iterable<Author> getListOfAuthorsInDB() {
       return authorService.getALlAuthors();

    }
}
