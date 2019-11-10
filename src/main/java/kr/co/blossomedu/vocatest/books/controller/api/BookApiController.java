package kr.co.blossomedu.vocatest.books.controller.api;

import kr.co.blossomedu.vocatest.books.service.BookService;
import kr.co.blossomedu.vocatest.books.service.dto.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
@RequestMapping("/api/books")
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
    public ResponseEntity<BookResponse> create(
            @RequestParam("name") String name,
            @RequestParam("files") MultipartFile[] uploadfiles) {
        System.out.println("excelFile.length = " + uploadfiles.length);

        System.out.println("bookCreateRequest.getName() = " + name);
//        System.out.println("bookCreateRequest.getName() = " + bookCreateRequest.getName());
//        System.out.println("bookCreateRequest.getExcelFile() = " + bookCreateRequest.getExcelFile());
//        final BookResponse bookResponse = bookService.save(bookCreateRequest);
//        final URI uri = linkTo(BookApiController.class).slash(bookResponse.getId()).toUri();
//        return ResponseEntity.created(uri).body(bookResponse);

        return ResponseEntity.ok(new BookResponse());
    }
}
