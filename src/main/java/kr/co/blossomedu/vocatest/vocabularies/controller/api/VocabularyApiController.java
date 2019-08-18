package kr.co.blossomedu.vocatest.vocabularies.controller.api;

import kr.co.blossomedu.vocatest.vocabularies.service.VocabularyService;
import kr.co.blossomedu.vocatest.vocabularies.service.dto.VocaTestRequest;
import kr.co.blossomedu.vocatest.vocabularies.service.dto.VocabularyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vocabularies")
public class VocabularyApiController {

    private final VocabularyService vocabularyService;

    public VocabularyApiController(final VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping
    public ResponseEntity<List<VocabularyResponse>> list(@ModelAttribute final VocaTestRequest vocaTestRequest) {
        final List<VocabularyResponse> vocabularyResponses = vocabularyService.finAllByChapterRange(vocaTestRequest);
        return ResponseEntity.ok(vocabularyResponses);
    }
}
