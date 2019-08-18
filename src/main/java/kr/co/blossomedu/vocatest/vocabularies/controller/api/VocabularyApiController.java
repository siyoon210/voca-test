package kr.co.blossomedu.vocatest.vocabularies.controller.api;

import kr.co.blossomedu.vocatest.vocabularies.service.VocabularyService;
import kr.co.blossomedu.vocatest.vocabularies.service.dto.VocabularyRequest;
import kr.co.blossomedu.vocatest.vocabularies.service.dto.VocabularyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/vocabularies")
public class VocabularyApiController {

    private final VocabularyService vocabularyService;

    public VocabularyApiController(final VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping
    public ResponseEntity<Set<VocabularyResponse>> list(@ModelAttribute final VocabularyRequest vocabularyRequest) {
        final Set<VocabularyResponse> vocabularyResponses = vocabularyService.finAllByChapterRange(vocabularyRequest);
        return ResponseEntity.ok(vocabularyResponses);
    }
}
