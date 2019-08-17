package kr.co.blossomedu.vocatest.chapters.service.dto;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ChapterResponse {
    public static ChapterResponse from(final Chapter chapter) {
        return null;
    }

    public static Set<ChapterResponse> from(final Collection<Chapter> chapters) {
        return chapters.stream()
                .map(ChapterResponse::from)
                .collect(Collectors.toSet());
    }
}
