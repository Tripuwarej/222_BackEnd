package sit.int221.oasip.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.DTO.CategoryDTO;
import sit.int221.oasip.DTO.EditUserDTO;
import sit.int221.oasip.DTO.EventDTO;
import sit.int221.oasip.DTO.UserDTO;
import sit.int221.oasip.Entity.Category;
import sit.int221.oasip.Entity.Event;
import sit.int221.oasip.Entity.User;
import sit.int221.oasip.Repository.EventRepository;
import sit.int221.oasip.Repository.UserRepository;
import sit.int221.oasip.Utils.ListMapper;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    public List<User> getAllUser() {
        return repository.findAll();
//        return listMapper.mapList(user, User.class, modelMapper);
    }

    public User save(User newUser) {
        User u = modelMapper.map(newUser, User.class);
        return repository.saveAndFlush(u);
    }

    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        id + " does not exist !!!"));
        repository.deleteById(id);
    }



    public EditUserDTO updateUser(EditUserDTO updateUser, Integer id){
        User user = repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, id + "does not exist!!!"));

        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        user.setRole(updateUser.getRole());

        repository.saveAndFlush(user);
        return updateUser;
    }

}
