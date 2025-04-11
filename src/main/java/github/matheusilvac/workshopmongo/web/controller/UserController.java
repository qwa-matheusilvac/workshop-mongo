package github.matheusilvac.workshopmongo.web.controller;

import github.matheusilvac.workshopmongo.doman.dto.UserReqDTO;
import github.matheusilvac.workshopmongo.doman.persistence.entity.User;
import github.matheusilvac.workshopmongo.doman.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public Page<User> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return  userService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserReqDTO user, UriComponentsBuilder ucBuilder) {
        User newUser = userService.save(user);
        URI uri = ucBuilder.path("/users/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserReqDTO user, @PathVariable String id) {
        User newUser = userService.update(user, id);
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
