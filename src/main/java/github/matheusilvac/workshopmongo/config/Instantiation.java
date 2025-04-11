package github.matheusilvac.workshopmongo.config;

import github.matheusilvac.workshopmongo.doman.dto.AuthorDto;
import github.matheusilvac.workshopmongo.doman.dto.CommentDto;
import github.matheusilvac.workshopmongo.doman.dto.PostReqDto;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        userRepository.deleteAll();
        postRepository.deleteAll();

        UserReqDTO dto1 = new UserReqDTO("John Doe", "john@doe.com" );
        UserReqDTO dto2 = new UserReqDTO("Jane Doe", "jane@doe.com");
        User user = new User(dto1);
        User user2 = new User(dto2);
        userRepository.saveAll(Arrays.asList(user, user2));
        PostReqDto p1 = new PostReqDto(dateFormat.parse("21/03/2018"), "Bom dia", " Irei a São Paulo hoje", new AuthorDto(user));
        PostReqDto p2 = new PostReqDto(dateFormat.parse("21/03/2018"), "JJK", "Gojo é o mais forte", new AuthorDto(user2));


        Post post1 = new Post(p1);
        Post post2 = new Post(p2);
        postRepository.saveAll(Arrays.asList(post1, post2));

        CommentDto c1 = new CommentDto( "Boa viagem mano", dateFormat.parse("22/03/2018"), new AuthorDto(user));
        CommentDto c2 = new CommentDto( "Opa", dateFormat.parse("22/03/2018"), new AuthorDto(user2));

        post1.getComments().add(c1);
        post2.getComments().add(c2);

        user.getPosts().addAll(Arrays.asList(post1, post2));
        postRepository.saveAll(Arrays.asList(post1, post2));
        userRepository.save(user);

        System.out.println("all users saved");
    }
}
