package kr.co.blossomedu.vocatest.books.service.dto;

import kr.co.blossomedu.vocatest.books.domain.Book;
import kr.co.blossomedu.vocatest.chapters.service.dto.ChapterResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private Set<ChapterResponse> chapterResponses;

    @Builder
    public BookResponse(final Long id, final String name, final Set<ChapterResponse> chapterResponses) {
        this.id = id;
        this.name = name;
        this.chapterResponses = chapterResponses;
    }

    public static BookResponse from(final Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .chapterResponses(ChapterResponse.from(book.getChapters()))
                .build();
    }

    public static Set<BookResponse> from(final Collection<Book> books) {
        return books.stream()
                .map(BookResponse::from)
                .collect(Collectors.toSet());
    }
}
