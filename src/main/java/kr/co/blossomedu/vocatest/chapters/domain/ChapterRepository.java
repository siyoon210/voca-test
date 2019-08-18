package kr.co.blossomedu.vocatest.chapters.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    Set<Chapter> findByBookId(Long bookId);
}
