package kr.co.blossomedu.vocatest.vocabularies.domain;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import kr.co.blossomedu.vocatest.commons.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Vocabulary extends BaseEntity {
    @Column(unique = true)
    private String english;

    @Column
    private String korean;

    @Column
    private boolean isDerivative;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;
}
