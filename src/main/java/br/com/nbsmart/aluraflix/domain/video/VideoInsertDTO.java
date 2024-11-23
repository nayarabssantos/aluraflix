package br.com.nbsmart.aluraflix.domain.video;

public record VideoInsertDTO(
        String title,
        String description,
        String url
) {
}
