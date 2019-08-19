package kr.co.blossomedu.vocatest.vocas.service.dto;

import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class VocaTestRequest {
    private static final Integer DEFAULT_SIZE = 30;
    private static final boolean DEFAULT_DERIVATIVE_CASE = false;

    private Long bookId;
    private Integer startChapter;
    private Integer endChapter;
    private Integer size = DEFAULT_SIZE;
    private boolean isIncludeDerivative = DEFAULT_DERIVATIVE_CASE;

    @Builder
    public VocaTestRequest(final Long bookId, final Integer startChapter, final Integer endChapter, final Integer size, final boolean isIncludeDerivative) {
        this.bookId = bookId;
        this.startChapter = startChapter;
        this.endChapter = endChapter;
        this.size = size;
        this.isIncludeDerivative = isIncludeDerivative;
    }

    @ModelAttribute("bookId")
    public Long prepareBookId(@PathVariable Long bookId) {
        return bookId;
    }
}
