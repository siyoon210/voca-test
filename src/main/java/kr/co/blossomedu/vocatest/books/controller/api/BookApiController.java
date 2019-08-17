package kr.co.blossomedu.vocatest.books.controller.api;

import kr.co.blossomedu.vocatest.books.service.BookService;
import kr.co.blossomedu.vocatest.books.service.dto.BookCreate;
import kr.co.blossomedu.vocatest.books.service.dto.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/books")
public class BookApiController {
    private final BookService bookService;

    public BookApiController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Set<BookResponse>> list() {
        final Set<BookResponse> bookResponses = bookService.findBookResponses();
        return ResponseEntity.ok(bookResponses);
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookCreate bookCreate) {
        final BookResponse bookResponse = bookService.save(bookCreate);
        final URI uri = linkTo(BookApiController.class).slash(bookResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(bookResponse);
    }
}
