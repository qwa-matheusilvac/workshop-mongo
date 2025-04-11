package github.matheusilvac.workshopmongo.doman.persistence.repository;

import github.matheusilvac.workshopmongo.doman.persistence.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

    //@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    Page<Post> findByTitleContainsIgnoreCase(String text, Pageable pageable);

//    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
//    Page<Post> fullSearch(String text, Date minDate, Date maxDate, Pageable pageable);
}
