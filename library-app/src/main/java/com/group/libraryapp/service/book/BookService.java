package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.dto.book.BookCreateRequestDto;
import com.group.libraryapp.repository.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void saveBook(BookCreateRequestDto requestDto) {
        Book book = new Book(requestDto.getName());
        bookRepository.save(book);
    }
}
