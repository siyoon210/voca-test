package kr.co.blossomedu.vocatest.vocabularies.service.dto;

import kr.co.blossomedu.vocatest.vocabularies.domain.Vocabulary;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class VocabularyResponse {
    private Long id;
    private String english;
    private String korean;
    private boolean isDerivative;
    private String chapterName;

    @Builder
    public VocabularyResponse(final Long id, final String english, final String korean, final boolean isDerivative, final String chapterName) {
        this.id = id;
        this.english = english;
        this.korean = korean;
        this.isDerivative = isDerivative;
        this.chapterName = chapterName;
    }

    public static VocabularyResponse from(final Vocabulary vocabulary) {
        return VocabularyResponse.builder()
                .id(vocabulary.getId())
                .english(vocabulary.getEnglish())
                .korean(vocabulary.getKorean())
                .isDerivative(vocabulary.isDerivative())
                .chapterName(vocabulary.getChapter().getName())
                .build();
    }

    public static List<VocabularyResponse> from(final Collection<Vocabulary> vocabularies) {
        return vocabularies.stream()
                .map(VocabularyResponse::from)
                .collect(Collectors.toList());
    }
}
