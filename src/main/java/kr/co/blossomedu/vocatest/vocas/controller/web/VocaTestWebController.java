package kr.co.blossomedu.vocatest.vocas.controller.web;

import kr.co.blossomedu.vocatest.books.service.BookService;
import kr.co.blossomedu.vocatest.books.service.dto.BookResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VocaTestWebController {
    private final BookService bookService;

    public VocaTestWebController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String main(final Model model) {
        final BookResponse bookResponse = bookService.findBook(1L);
        model.addAttribute("book", bookResponse);
        return "main";
    }
}
