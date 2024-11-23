package br.com.nbsmart.aluraflix.controller;

import br.com.nbsmart.aluraflix.domain.video.Video;
import br.com.nbsmart.aluraflix.domain.video.VideoDetailsDTO;
import br.com.nbsmart.aluraflix.domain.video.VideoInsertDTO;
import br.com.nbsmart.aluraflix.domain.video.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<VideoDetailsDTO> listAll(){
        return repository.findAll().stream().map(VideoDetailsDTO::new).toList();
    }

   @GetMapping("/{id}")
    public VideoDetailsDTO getOne(@PathVariable Long id){
        var video =  repository.getReferenceById(id);

       return new VideoDetailsDTO(video);
    }
}
