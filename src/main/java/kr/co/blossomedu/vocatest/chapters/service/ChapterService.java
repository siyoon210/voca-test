package kr.co.blossomedu.vocatest.chapters.service;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import kr.co.blossomedu.vocatest.chapters.domain.ChapterRepository;
import kr.co.blossomedu.vocatest.chapters.service.dto.ChapterResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ChapterService {
    private final ChapterRepository chapterRepository;

    public ChapterService(final ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public Set<ChapterResponse> findChapterResponses() {
        final List<Chapter> chapters = chapterRepository.findAll();
        return ChapterResponse.from(chapters);
    }
}
