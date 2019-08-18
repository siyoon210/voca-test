package kr.co.blossomedu.vocatest.chapters.service.dto;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
public class ChapterResponse {
    private Integer sequence;
    private String name;

    @Builder
    public ChapterResponse(final Integer sequence, final String name) {
        this.sequence = sequence;
        this.name = name;
    }


    public static ChapterResponse from(final Chapter chapter) {
        return ChapterResponse.builder()
                .name(chapter.getName())
                .sequence(chapter.getSequence())
                .build();
    }

    public static Set<ChapterResponse> from(final Collection<Chapter> chapters) {
        return chapters.stream()
                .map(ChapterResponse::from)
                .collect(Collectors.toSet());
    }
}
