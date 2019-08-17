package kr.co.blossomedu.vocatest.books.domain;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import kr.co.blossomedu.vocatest.commons.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Getter
@NoArgsConstructor
public class Book  extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "book")
    private Set<Chapter> chapters = new TreeSet<>();

    @Builder
    public Book(final String name) {
        this.name = name;
    }
}
