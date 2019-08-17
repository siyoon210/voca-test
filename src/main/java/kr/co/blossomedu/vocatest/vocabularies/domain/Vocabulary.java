package kr.co.blossomedu.vocatest.vocabularies.domain;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import kr.co.blossomedu.vocatest.commons.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
    private Chapter chapter;
}
