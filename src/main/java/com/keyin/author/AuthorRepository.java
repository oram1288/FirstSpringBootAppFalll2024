package com.keyin.author;

import com.keyin.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {

    public Author findByAuthorName(String authorName);

}


