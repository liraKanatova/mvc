package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.User;
import peaksoft.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserApi {
    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userMainPage";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        userService.getUserById(id);
        return "userPage";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editUser", userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/updateUser/{id}")
    public String saveUpdateUser(@ModelAttribute("editUser") User user,
                                 @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/searchUsers")
    public String searchUser(@RequestParam("word") String word,
                             Model model) {
        List<User> users = userService.searchUser(word);
        model.addAttribute("foundedUser", users);
        return "";
    }

    @DeleteMapping("/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}

