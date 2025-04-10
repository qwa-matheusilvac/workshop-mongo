package github.matheusilvac.workshopmongo.doman.persistence.repository;

import github.matheusilvac.workshopmongo.doman.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
}
