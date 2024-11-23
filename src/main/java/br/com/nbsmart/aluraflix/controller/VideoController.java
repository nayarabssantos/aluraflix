package br.com.nbsmart.aluraflix.controller;

import br.com.nbsmart.aluraflix.domain.video.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid VideoInsertDTO data, UriComponentsBuilder uriBuilder){

       var video = repository.save(new Video(data));

       var uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();

       return ResponseEntity.created(uri).body(new VideoDetailsDTO(video));
    }

    @GetMapping
    public List<VideoDetailsDTO> listAll(){
        return repository.findAll().stream().map(VideoDetailsDTO::new).toList();
    }

   @GetMapping("/{id}")
    public ResponseEntity<VideoDetailsDTO> getOne(@PathVariable Long id){
        var video =  repository.getReferenceById(id);

       return ResponseEntity.ok(new VideoDetailsDTO(video));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<VideoDetailsDTO> update(@RequestBody VideoUpdateDTO data){
        var video =  repository.getReferenceById(data.id());

        video.updateData(data);

        return ResponseEntity.ok(new VideoDetailsDTO(video));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }
}
