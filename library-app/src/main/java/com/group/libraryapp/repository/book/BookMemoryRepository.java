package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.book.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookMemoryRepository implements BookRepository {

    @Override
    public void saveBook() {
        System.out.println("BookMemoryRepository");
    }
}
