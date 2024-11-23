package br.com.nbsmart.aluraflix.domain.video;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="videos")
@Entity(name="Videos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;

    public Video(VideoInsertDTO data){
        this.title = data.title();
        this.description = data.description();
        this.url = data.url();
    }

    public void updateData(VideoUpdateDTO data) {

        if(data.title() != null){
            this.title = data.title();
        }

        if(data.description() != null){
            this.description = data.description();
        }

        if(data.url() != null){
            this.url = data.url();
        }
    }
}
