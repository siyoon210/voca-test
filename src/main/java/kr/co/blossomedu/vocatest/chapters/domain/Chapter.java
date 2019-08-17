package kr.co.blossomedu.vocatest.chapters.domain;

import kr.co.blossomedu.vocatest.books.domain.Book;
import kr.co.blossomedu.vocatest.commons.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Chapter extends BaseEntity {
    @Column
    private long sequence;

    @Column
    private String name;

    @ManyToOne
    private Book book;
}
