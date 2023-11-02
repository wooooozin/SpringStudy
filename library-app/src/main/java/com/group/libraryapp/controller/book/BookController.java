package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.BookCreateRequestDto;
import com.group.libraryapp.dto.book.BookLoanRequestDto;
import com.group.libraryapp.dto.book.BookReturnRequestDto;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequestDto requestDto) {
        bookService.saveBook(requestDto);
    }

    @PostMapping("/book/loan")
    public void loanBook(
        @RequestBody BookLoanRequestDto requestDto
    ) {
        bookService.loanBook(requestDto);
    }

    @PostMapping("/book/return")
    public void returnBook(
        @RequestBody BookReturnRequestDto requestDto
    ) {
        bookService.returnBook(requestDto);
    }

}
