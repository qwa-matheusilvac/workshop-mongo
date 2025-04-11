package github.matheusilvac.workshopmongo.doman.persistence.entity;

import github.matheusilvac.workshopmongo.doman.dto.AuthorDto;
import github.matheusilvac.workshopmongo.doman.dto.UserReqDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(UserReqDTO user) {
        this.name = user.name();
        this.email = user.email();
    }

    public User(Object o, String name, String email) {
        this.name = name;
        this.email = email;
    }
}
