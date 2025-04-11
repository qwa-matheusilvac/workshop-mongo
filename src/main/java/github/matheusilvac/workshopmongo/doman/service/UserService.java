package github.matheusilvac.workshopmongo.doman.service;

import github.matheusilvac.workshopmongo.doman.dto.UserReqDTO;
import github.matheusilvac.workshopmongo.doman.persistence.entity.User;
import github.matheusilvac.workshopmongo.doman.persistence.repository.UserRepository;
import github.matheusilvac.workshopmongo.exceptions.ObjectNotFoudException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User findById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoudException("Não encontrado usuario com id: " + id));
    }

    public User save(UserReqDTO user){
        User newUser = new User(user);
        return userRepository.save(newUser);
    }

    public void deleteById(String id){
       User user = findById(id);
       if(user != null){
           userRepository.delete(user);
       } else {
           throw new ObjectNotFoudException("Não encontrado usuario com id: " + id);
       }
    }

    public User update(UserReqDTO user, String id){
        User newUser = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoudException("Não encontrado usuario com id: " + id));
        newUser.setName(user.name());
        newUser.setEmail(user.email());
        return userRepository.save(newUser);
    }

}
