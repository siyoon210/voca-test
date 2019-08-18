package kr.co.blossomedu.vocatest.vocabularies.service.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class VocaTestRequest {
    private static final int DEFAULT_SIZE = 30;
    private static final boolean DEFAULT_DERIVATIVE_CASE = false;

    private long bookId;
    private int startChapter;
    private int endChapter;
    private int size = DEFAULT_SIZE;
    private boolean isIncludeDerivative = DEFAULT_DERIVATIVE_CASE;

    @Builder
    public VocaTestRequest(final long bookId, final int startChapter, final int endChapter, final int size, final boolean isIncludeDerivative) {
        this.bookId = bookId;
        this.startChapter = startChapter;
        this.endChapter = endChapter;
        this.size = size;
        this.isIncludeDerivative = isIncludeDerivative;
    }
}
