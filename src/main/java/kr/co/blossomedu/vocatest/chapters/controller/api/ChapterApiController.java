package kr.co.blossomedu.vocatest.chapters.controller.api;

import kr.co.blossomedu.vocatest.chapters.service.ChapterService;
import kr.co.blossomedu.vocatest.chapters.service.dto.ChapterCreateRequest;
import kr.co.blossomedu.vocatest.chapters.service.dto.ChapterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/chapters")
public class ChapterApiController {
    private final ChapterService chapterService;

    public ChapterApiController(final ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping
    public ResponseEntity<Set<ChapterResponse>> list() {
        final Set<ChapterResponse> chapterResponses = chapterService.findChapterResponses();
        return ResponseEntity.ok(chapterResponses);
    }

    @PostMapping
    public ResponseEntity<ChapterResponse> create(@RequestBody ChapterCreateRequest chapterCreateRequest) {
        final ChapterResponse chapterResponse = chapterService.save(chapterCreateRequest);
        return ResponseEntity.ok(chapterResponse);
    }
}
