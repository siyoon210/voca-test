package kr.co.blossomedu.vocatest.chapters.service.dto;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import lombok.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ChapterResponse {
    private Long sequence;
    private String name;

    @Builder
    public ChapterResponse(final Long sequence, final String name) {
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
