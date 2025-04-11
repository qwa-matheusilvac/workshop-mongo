package github.matheusilvac.workshopmongo.config;

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
        Post post1 = new Post(null, dateFormat.parse("21/03/2018"), "Bom dia", " Irei a São Paulo hoje", new User(null, "Maria", "maria@gmail.com"));
        Post post2 = new Post(null, dateFormat.parse("21/03/2018"), "JJK", "Gojo é o mais forte", new User(null, "Maria", "maria@gmail.com"));
        postRepository.saveAll(Arrays.asList(post1, post2));
        System.out.println("all users saved");
    }
}
