package github.matheusilvac.workshopmongo.doman.persistence.entity;

import github.matheusilvac.workshopmongo.doman.dto.UserReqDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public User(UserReqDTO user) {
        this.name = user.name();
        this.email = user.email();
    }
}
