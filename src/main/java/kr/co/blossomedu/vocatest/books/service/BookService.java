package kr.co.blossomedu.vocatest.books.service;

import kr.co.blossomedu.vocatest.books.domain.Book;
import kr.co.blossomedu.vocatest.books.domain.BookRepository;
import kr.co.blossomedu.vocatest.books.service.dto.BookCreateRequest;
import kr.co.blossomedu.vocatest.books.service.dto.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Set<BookResponse> findBookResponses() {
        final List<Book> books = bookRepository.findAll();
        return BookResponse.from(books);
    }

    public BookResponse save(final BookCreateRequest bookCreateRequest) {
        final Book book = bookRepository.save(bookCreateRequest.toEntity());
        return BookResponse.from(book);
    }
}
