package kr.co.blossomedu.vocatest.chapters.domain;

import kr.co.blossomedu.vocatest.books.domain.Book;
import kr.co.blossomedu.vocatest.commons.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Chapter extends BaseEntity implements Comparable<Chapter>{
    @Column
    private Integer sequence;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @Builder
    public Chapter(final Integer sequence, final String name, final Book book) {
        this.sequence = sequence;
        this.name = name;
        this.book = book;
    }

    @Override
    public int compareTo(final Chapter o) {
        return sequence - o.sequence;
    }
}
