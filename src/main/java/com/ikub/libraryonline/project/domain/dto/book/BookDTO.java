package com.ikub.libraryonline.project.domain.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Integer id;
    private String title;

    private String description;
    private String status;

    private CategoryDTO categoryDTO;
    private Double price;
    private LocalDateTime createdAt;
}
