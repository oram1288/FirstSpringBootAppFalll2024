package com.keyin.book;

import com.keyin.author.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    Iterable<Book> findBooksByAuthorAuthorName(String author_authorName);


}
