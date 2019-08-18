package kr.co.blossomedu.vocatest.vocabularies.service;

import kr.co.blossomedu.vocatest.vocabularies.domain.Vocabulary;
import kr.co.blossomedu.vocatest.vocabularies.domain.VocabularyRepository;
import kr.co.blossomedu.vocatest.vocabularies.service.dto.VocaTestRequest;
import kr.co.blossomedu.vocatest.vocabularies.service.dto.VocabularyResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class VocabularyService {
    private final VocabularyRepository vocabularyRepository;

    public VocabularyService(final VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    public Set<VocabularyResponse> finAllByChapterRange(final VocaTestRequest vocaTestRequest) {
        List<Vocabulary> vocabularies;
        if (vocaTestRequest.isIncludeDerivative()) {
            vocabularies = vocabularyRepository.findAllByChapterBetween(vocaTestRequest.getBookId(), vocaTestRequest.getStartChapter(), vocaTestRequest.getEndChapter());
        } else {
            vocabularies = vocabularyRepository.findAllByChapterBetweenAndDerivativeIsFalse(
                    vocaTestRequest.getBookId(), vocaTestRequest.getStartChapter(), vocaTestRequest.getEndChapter());
        }

        final int size = vocabularies.size();
        Set<VocabularyResponse> vocabularyResponses = new HashSet<>();

        //TODO 요청한 size가 데이터보다 많은 경우 처리
        //TODO 최적 알고리즘
        while (vocabularyResponses.size() < vocaTestRequest.getSize()) {
            final int index = ThreadLocalRandom.current().nextInt(size);
            vocabularyResponses.add(VocabularyResponse.from(vocabularies.get(index)));
        }
        return vocabularyResponses;
    }
}
