package Controller;

import com.example.final_back_3.Exceptions.userAlreadyExistsException;
import com.example.final_back_3.Model.userEntity;
import com.example.final_back_3.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class userController {
    private final userService UserService;

    public userController(userService UserService) {
        this.UserService = UserService;
    }


    @PostMapping
    public ResponseEntity registration(@RequestBody userEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }
        //catch (userAlreadyExistsException e) {
        //    return ResponseEntity.badRequest().body(e.getMessage());
        //}
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }




}
