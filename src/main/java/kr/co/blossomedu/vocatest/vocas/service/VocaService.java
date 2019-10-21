package kr.co.blossomedu.vocatest.vocas.service;

import kr.co.blossomedu.vocatest.vocas.domain.Voca;
import kr.co.blossomedu.vocatest.vocas.domain.VocaRepository;
import kr.co.blossomedu.vocatest.vocas.service.dto.VocaResponse;
import kr.co.blossomedu.vocatest.vocas.service.dto.VocaTestRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VocaService {
    private final VocaRepository vocaRepository;

    public VocaService(final VocaRepository vocaRepository) {
        this.vocaRepository = vocaRepository;
    }

    @Transactional(readOnly = true)
    public List<VocaResponse> finAllByChapterRange(final VocaTestRequest vocaTestRequest) {
        List<Voca> vocas;
        if (vocaTestRequest.isIncludeDerivative()) {
            vocas = vocaRepository.findAllByChapterBetweenAndIncludeDerivative(vocaTestRequest.getBookId(), vocaTestRequest.getStartChapter(), vocaTestRequest.getEndChapter());
        } else {
            vocas = vocaRepository.findAllByChapterBetweenAndExcludeDerivative(
                    vocaTestRequest.getBookId(), vocaTestRequest.getStartChapter(), vocaTestRequest.getEndChapter());
        }

        //TODO 요청한 size가 데이터보다 많은 경우 처리
        Collections.shuffle(vocas);

        return VocaResponse.from(vocas.stream().limit(vocaTestRequest.getSize()).collect(Collectors.toList()));
    }
}
