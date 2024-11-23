package br.com.nbsmart.aluraflix.controller;

import br.com.nbsmart.aluraflix.domain.video.*;
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

    @PutMapping
    @Transactional
    public VideoDetailsDTO update(@RequestBody VideoUpdateDTO data){
        var video =  repository.getReferenceById(data.id());

        video.updateData(data);

        return new VideoDetailsDTO(video);

    }
}
