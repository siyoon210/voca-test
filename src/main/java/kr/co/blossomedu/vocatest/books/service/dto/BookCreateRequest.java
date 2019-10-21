package kr.co.blossomedu.vocatest.books.service.dto;

import kr.co.blossomedu.vocatest.books.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookCreateRequest {

    private String name;

    public BookCreateRequest(final String name) {
        this.name = name;
    }

    public Book toEntity() {
        return Book.builder()
                .name(name)
                .build();
    }
}
