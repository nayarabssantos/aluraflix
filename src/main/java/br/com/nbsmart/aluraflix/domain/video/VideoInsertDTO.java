package br.com.nbsmart.aluraflix.domain.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public record VideoInsertDTO(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotBlank
        @URL
        String url
) {
}
