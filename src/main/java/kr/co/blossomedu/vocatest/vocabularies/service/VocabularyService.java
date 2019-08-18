package kr.co.blossomedu.vocatest.vocabularies.service;

import kr.co.blossomedu.vocatest.vocabularies.domain.Vocabulary;
import kr.co.blossomedu.vocatest.vocabularies.domain.VocabularyRepository;
import kr.co.blossomedu.vocatest.vocabularies.service.dto.VocaTestRequest;
import kr.co.blossomedu.vocatest.vocabularies.service.dto.VocabularyResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class VocabularyService {
    private final VocabularyRepository vocabularyRepository;

    public VocabularyService(final VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    @Transactional(readOnly = true)
    public List<VocabularyResponse> finAllByChapterRange(final VocaTestRequest vocaTestRequest) {
        List<Vocabulary> vocabularies;
        if (vocaTestRequest.isIncludeDerivative()) {
            vocabularies = vocabularyRepository.findAllByChapterBetweenAndIncludeDerivative(vocaTestRequest.getBookId(), vocaTestRequest.getStartChapter(), vocaTestRequest.getEndChapter());
        } else {
            vocabularies = vocabularyRepository.findAllByChapterBetweenAndExcludeDerivative(
                    vocaTestRequest.getBookId(), vocaTestRequest.getStartChapter(), vocaTestRequest.getEndChapter());
        }

        //TODO 요청한 size가 데이터보다 많은 경우 처리
        Collections.shuffle(vocabularies);

        return VocabularyResponse.from(vocabularies);
    }
}
