package github.matheusilvac.workshopmongo.doman.persistence.entity;

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
    private User author;

}
