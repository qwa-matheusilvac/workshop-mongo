package github.matheusilvac.workshopmongo.web.controller;

import github.matheusilvac.workshopmongo.doman.dto.PostReqDto;
import github.matheusilvac.workshopmongo.doman.persistence.entity.Post;
import github.matheusilvac.workshopmongo.doman.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping
    public Page<Post> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return  postService.findAll(pageable);
    }

    @GetMapping("/titleSearch")
    public Page<Post> findByTitle(@PageableDefault(size = 10) Pageable pageable, @RequestParam(value = "text") String title) {
        return postService.findByTitleContains(title, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Post> save(@RequestBody PostReqDto Post, UriComponentsBuilder ucBuilder) {
        Post newPost = postService.save(Post);
        URI uri = ucBuilder.path("/Posts/{id}").buildAndExpand(newPost.getId()).toUri();
        return ResponseEntity.created(uri).body(newPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@RequestBody PostReqDto Post, @PathVariable String id) {
        Post newPost = postService.update(Post, id);
        return ResponseEntity.ok().body(newPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
