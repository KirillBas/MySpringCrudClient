package ru.basharin.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.basharin.restModel.RestUser;
import ru.basharin.restService.UserService;
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/rest/user/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseBody
    public ResponseEntity<RestUser> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @RequestMapping(value = "/rest/user")
    public String index() {
        return "user";
    }


}
