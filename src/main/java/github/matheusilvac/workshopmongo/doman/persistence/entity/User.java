package github.matheusilvac.workshopmongo.doman.persistence.entity;

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

}
