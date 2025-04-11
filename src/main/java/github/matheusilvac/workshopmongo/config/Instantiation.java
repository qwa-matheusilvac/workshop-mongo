package github.matheusilvac.workshopmongo.config;

import github.matheusilvac.workshopmongo.doman.dto.AuthorDto;
import github.matheusilvac.workshopmongo.doman.dto.UserReqDTO;
import github.matheusilvac.workshopmongo.doman.persistence.entity.Post;
import github.matheusilvac.workshopmongo.doman.persistence.entity.User;
import github.matheusilvac.workshopmongo.doman.persistence.repository.PostRepository;
import github.matheusilvac.workshopmongo.doman.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@AllArgsConstructor
@Component
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        UserReqDTO dto1 = new UserReqDTO("John Doe", "john@doe.com" );
        UserReqDTO dto2 = new UserReqDTO("Jane Doe", "jane@doe.com");
        User user = new User(dto1);
        User user2 = new User(dto2);
        userRepository.saveAll(Arrays.asList(user, user2));


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Post post1 = new Post(null, dateFormat.parse("21/03/2018"), "Bom dia", " Irei a São Paulo hoje", new AuthorDto(user));
        Post post2 = new Post(null, dateFormat.parse("21/03/2018"), "JJK", "Gojo é o mais forte", new AuthorDto(user2));
        postRepository.saveAll(Arrays.asList(post1, post2));

        user.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(user);

        System.out.println("all users saved");
    }
}
