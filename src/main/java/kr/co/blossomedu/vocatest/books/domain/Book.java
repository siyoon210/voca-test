package kr.co.blossomedu.vocatest.books.domain;

import kr.co.blossomedu.vocatest.chapters.domain.Chapter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Book {
    @Column
    private String name;

    @OneToMany
    private Set<Chapter> chapters = new HashSet<>();
}
