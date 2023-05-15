package com.ikub.libraryonline.project.domain.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookUpdateDTO {
    private String title;
    private String status;

    private Double price;
}
