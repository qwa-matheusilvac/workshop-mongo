package github.matheusilvac.workshopmongo.doman.dto;

import java.util.Date;

public record PostReqDto(
        Date date,
        String title,
        String body,
        AuthorDto authorDto

) {
}
