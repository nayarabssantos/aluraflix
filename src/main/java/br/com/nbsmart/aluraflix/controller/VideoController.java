package br.com.nbsmart.aluraflix.controller;

import br.com.nbsmart.aluraflix.domain.video.Video;
import br.com.nbsmart.aluraflix.domain.video.VideoDetailsDTO;
import br.com.nbsmart.aluraflix.domain.video.VideoInsertDTO;
import br.com.nbsmart.aluraflix.domain.video.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public VideoDetailsDTO insert(@RequestBody @Valid VideoInsertDTO data){

       var video = repository.save(new Video(data));
       return new VideoDetailsDTO(video);
    }
}
