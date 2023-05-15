package com.ikub.libraryonline.project.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "book_findBookByCategory"
                , query = "select b from Book b where b.category.id=: categoryId")
}
)

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
    private Double price;
    @CreatedDate
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}

