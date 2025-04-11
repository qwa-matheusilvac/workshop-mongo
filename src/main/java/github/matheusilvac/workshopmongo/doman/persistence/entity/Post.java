package github.matheusilvac.workshopmongo.doman.persistence.entity;

import github.matheusilvac.workshopmongo.doman.dto.AuthorDto;
import github.matheusilvac.workshopmongo.doman.dto.CommentDto;
import github.matheusilvac.workshopmongo.doman.dto.PostReqDto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private List<CommentDto> comments = new ArrayList<>();

    public Post(PostReqDto post) {
        this.date = post.date();
        this.title = post.title();
        this.body = post.body();
        this.author = post.authorDto();
    }
}
