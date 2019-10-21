package kr.co.blossomedu.vocatest.vocas.service.dto;

import kr.co.blossomedu.vocatest.vocas.domain.Voca;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class VocaResponse {
    private Long id;
    private String english;
    private String korean;
    private boolean isDerivative;
    private String chapterName;

    @Builder
    public VocaResponse(final Long id, final String english, final String korean, final boolean isDerivative, final String chapterName) {
        this.id = id;
        this.english = english;
        this.korean = korean;
        this.isDerivative = isDerivative;
        this.chapterName = chapterName;
    }

    public static VocaResponse from(final Voca voca) {
        return VocaResponse.builder()
                .id(voca.getId())
                .english(voca.getEnglish())
                .korean(voca.getKorean())
                .isDerivative(voca.isDerivative())
                .chapterName(voca.getChapter().getName())
                .build();
    }

    public static List<VocaResponse> from(final Collection<Voca> vocas) {
        return vocas.stream()
                .map(VocaResponse::from)
                .collect(Collectors.toList());
    }
}
