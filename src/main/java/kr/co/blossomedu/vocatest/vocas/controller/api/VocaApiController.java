package kr.co.blossomedu.vocatest.vocas.controller.api;

import kr.co.blossomedu.vocatest.vocas.service.VocaService;
import kr.co.blossomedu.vocatest.vocas.service.dto.VocaResponse;
import kr.co.blossomedu.vocatest.vocas.service.dto.VocaTestRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vocas")
public class VocaApiController {

    private final VocaService vocaService;

    public VocaApiController(final VocaService vocaService) {
        this.vocaService = vocaService;
    }

    @GetMapping
    public ResponseEntity<List<VocaResponse>> list(@ModelAttribute final VocaTestRequest vocaTestRequest) {
        final List<VocaResponse> vocaRespons = vocaService.finAllByChapterRange(vocaTestRequest);
        return ResponseEntity.ok(vocaRespons);
    }
}
