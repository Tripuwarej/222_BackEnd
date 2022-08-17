package sit.int221.oasip.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasip.DTO.CategoryDTO;
import sit.int221.oasip.DTO.EditUserDTO;
import sit.int221.oasip.DTO.EventDTO;
import sit.int221.oasip.DTO.UserDTO;
import sit.int221.oasip.Entity.Event;
import sit.int221.oasip.Entity.User;
import sit.int221.oasip.Repository.UserRepository;
import sit.int221.oasip.Service.EventService;
import sit.int221.oasip.Service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    public List<User> getAllUser(){
        return service.getAllUser();
    }

    @PostMapping("")
    public User create(@RequestBody User newUser){
        return service.save(newUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public EditUserDTO edit(@RequestBody EditUserDTO updateUser, @PathVariable Integer id) {
        return service.updateUser(updateUser, id);
    }

}
