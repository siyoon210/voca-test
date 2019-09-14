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
    @Column //unique = true 설정을 두면 워드마스터 샘플데이터에 중복된 단어가 있어서 충돌남
    private String english;

    @Column
    private String korean;

    @Column
    private boolean isDerivative;

    @ManyToOne(optional = false)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;
}
