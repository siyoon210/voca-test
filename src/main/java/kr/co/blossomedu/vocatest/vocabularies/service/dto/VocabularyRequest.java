package kr.co.blossomedu.vocatest.vocabularies.service.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class VocabularyRequest {
    protected static final int DEFAULT_SIZE = 30;
    protected static final boolean DEFAULT_DERIVATIVE = false;

    private Long startChapterId;
    private Long endChapterId;
    private int size = DEFAULT_SIZE;
    private boolean isDerivative = DEFAULT_DERIVATIVE;

    @Builder
    public VocabularyRequest(final Long startChapterId, final Long endChapterId, final int size, final boolean isDerivative) {
        this.startChapterId = startChapterId;
        this.endChapterId = endChapterId;
        this.size = size;
        this.isDerivative = isDerivative;
    }

    public void setStartChapterId(final Long startChapterId) {
        this.startChapterId = startChapterId;
    }

    public void setEndChapterId(final Long endChapterId) {
        this.endChapterId = endChapterId;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public void setDerivative(final boolean derivative) {
        isDerivative = derivative;
    }
}
