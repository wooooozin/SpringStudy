package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserLoanHistory;
import com.group.libraryapp.dto.book.BookCreateRequestDto;
import com.group.libraryapp.dto.book.BookLoanRequestDto;
import com.group.libraryapp.dto.book.BookReturnRequestDto;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.user.UserLoanHistoryRepository;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository,
        UserLoanHistoryRepository userLoanHistoryRepository,
        UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }


    public void saveBook(BookCreateRequestDto requestDto) {
        Book book = new Book(requestDto.getName());
        bookRepository.save(book);
    }

    @Transactional
    public void loanBook(BookLoanRequestDto requestDto) {
        Book book = bookRepository.findBookByName(requestDto.getBookName())
            .orElseThrow(IllegalArgumentException::new);

        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(requestDto.getBookName(), false)) {
            throw new IllegalArgumentException("대여중인 책입니다.");
        }
        User user = userRepository.findByName(requestDto.getUserName())
            .orElseThrow(IllegalArgumentException::new);

        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName()));
    }

    @Transactional
    public void returnBook(BookReturnRequestDto requestDto) {
        User user = userRepository.findByName(requestDto.getUserName())
            .orElseThrow(IllegalArgumentException::new);

        UserLoanHistory userLoanHistory = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(),
            requestDto.getBookName())
            .orElseThrow(IllegalArgumentException::new);
        userLoanHistory.doReturn();
        }

}
