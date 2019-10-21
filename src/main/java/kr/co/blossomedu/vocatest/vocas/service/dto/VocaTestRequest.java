package kr.co.blossomedu.vocatest.vocas.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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

    @ModelAttribute("bookId")
    public Long prepareBookId(@PathVariable Long bookId) {
        return bookId;
    }

    public void setStart(Integer start) {
        this.startChapter = start;
    }

    public void setEnd(Integer end) {
        this.endChapter = end;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setDerivative(boolean derivative) {
        this.isIncludeDerivative = derivative;
    }
}
