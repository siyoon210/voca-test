package kr.co.blossomedu.vocatest.chapters.service.dto;

import kr.co.blossomedu.vocatest.books.domain.Book;
import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ChapterCreateRequest {
    private Integer sequence;
    private String name;
    private Long bookId;

    public ChapterCreateRequest(final Integer sequence, final String name, final Long bookId) {
        this.sequence = sequence;
        this.name = name;
        this.bookId = bookId;
    }

    public Chapter toEntity(final Book book) {
        return Chapter.builder()
                .book(book)
                .name(name)
                .sequence(sequence)
                .build();
    }
}
