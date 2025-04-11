package github.matheusilvac.workshopmongo.doman.dto;

import github.matheusilvac.workshopmongo.doman.persistence.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto {
    private String id;
    private String name;

    public AuthorDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
