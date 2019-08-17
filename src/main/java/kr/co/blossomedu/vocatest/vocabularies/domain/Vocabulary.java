package kr.co.blossomedu.vocatest.vocabularies.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Vocabulary {
    @Column(unique = true)
    private String english;

    @Column
    private String korean;

    @Column
    private boolean isDerivative;

    @ManyToOne
    private Unit unit;
}
