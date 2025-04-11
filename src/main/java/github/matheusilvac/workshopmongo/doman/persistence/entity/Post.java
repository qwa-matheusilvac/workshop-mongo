package github.matheusilvac.workshopmongo.doman.persistence.entity;

import github.matheusilvac.workshopmongo.doman.dto.AuthorDto;
import github.matheusilvac.workshopmongo.doman.dto.PostReqDto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document
public class Post {
    private String id;

    private Date date;

    private String title;

    private String body;

    private AuthorDto author;

    public Post(PostReqDto post) {
        this.date = post.date();
        this.title = post.title();
        this.body = post.body();
        this.author = post.authorDto();
    }
}
