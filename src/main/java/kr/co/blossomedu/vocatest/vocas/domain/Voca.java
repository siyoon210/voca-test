package kr.co.blossomedu.vocatest.vocas.domain;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import kr.co.blossomedu.vocatest.commons.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Voca extends BaseEntity {
    @Column(unique = true)
    private String english;

    @Column
    private String korean;

    @Column
    private boolean isDerivative;

    @ManyToOne(optional = false)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;
}
