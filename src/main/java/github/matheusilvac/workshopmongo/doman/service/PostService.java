package github.matheusilvac.workshopmongo.doman.service;

import github.matheusilvac.workshopmongo.doman.dto.PostReqDto;
import github.matheusilvac.workshopmongo.doman.persistence.entity.Post;
import github.matheusilvac.workshopmongo.doman.persistence.repository.PostRepository;
import github.matheusilvac.workshopmongo.exceptions.ObjectNotFoudException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;

    public Page<Post> findAll(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Post findById(String id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoudException("Não encontrado usuario com id: " + id));
    }

    public Post save(PostReqDto Post){
        Post newPost = new Post(Post);
        return postRepository.save(newPost);
    }

    public void deleteById(String id){
       Post Post = findById(id);
       if(Post != null){
           postRepository.delete(Post);
       } else {
           throw new ObjectNotFoudException("Não encontrado usuario com id: " + id);
       }
    }

    public Post update(PostReqDto Post, String id){
        Post newPost = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoudException("Não encontrado usuario com id: " + id));
        newPost.setTitle(Post.title());
        newPost.setBody(Post.body());
        return postRepository.save(newPost);
    }

}
