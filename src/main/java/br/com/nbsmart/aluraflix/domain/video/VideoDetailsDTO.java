package br.com.nbsmart.aluraflix.domain.video;

public record VideoDetailsDTO(
        Long Id,
        String title,
        String description,
        String url
) {
    public VideoDetailsDTO(Video video){
        this(video.getId(),
                video.getTitle(),
                video.getDescription(),
                video.getUrl());
    }
}
