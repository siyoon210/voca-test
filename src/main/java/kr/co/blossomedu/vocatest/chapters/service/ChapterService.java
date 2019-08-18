package kr.co.blossomedu.vocatest.chapters.service;

import kr.co.blossomedu.vocatest.books.domain.Book;
import kr.co.blossomedu.vocatest.books.domain.BookRepository;
import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import kr.co.blossomedu.vocatest.chapters.domain.ChapterRepository;
import kr.co.blossomedu.vocatest.chapters.service.dto.ChapterCreateRequest;
import kr.co.blossomedu.vocatest.chapters.service.dto.ChapterResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class ChapterService {
    private final ChapterRepository chapterRepository;
    private final BookRepository bookRepository;

    public ChapterService(final ChapterRepository chapterRepository, final BookRepository bookRepository) {
        this.chapterRepository = chapterRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public Set<ChapterResponse> findChapterResponses(Long bookId) {
        final Set<Chapter> chapters = chapterRepository.findByBookId(bookId);
        return ChapterResponse.from(chapters);
    }

    public ChapterResponse save(final ChapterCreateRequest chapterCreateRequest) {
        final Book book = bookRepository.findById(chapterCreateRequest.getBookId())
                .orElseThrow(() -> new IllegalArgumentException(String.valueOf(chapterCreateRequest.getBookId())));

        final Chapter chapter = chapterRepository.save(chapterCreateRequest.toEntity(book));
        return ChapterResponse.from(chapter);
    }
}
