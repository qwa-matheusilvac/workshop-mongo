package github.matheusilvac.workshopmongo.doman.persistence.repository;

import github.matheusilvac.workshopmongo.doman.persistence.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PostRepository extends MongoRepository<Post, String> {
}
