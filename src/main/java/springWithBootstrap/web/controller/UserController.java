package springWithBootstrap.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springWithBootstrap.web.model.Role;
import springWithBootstrap.web.model.User;
import springWithBootstrap.web.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/table")
    public String getTable(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("users", userService.getAllUsers());
        return "table";
    }

    @PostMapping("/admin/table")
    public String addUser(String email, String password, String firstname, String lastname, int age, String roles) {
        Set<Role> roleSet = userService.getRoleForUser(roles);
        userService.addUser(new User(email, password, firstname, lastname, age, roleSet));
        return "redirect:/admin/table";
    }

    @PostMapping("/admin/remove")
    public String removeUser(long id) {
        userService.removeUser(id);
        return "redirect:/admin/table";
    }

    @PostMapping("/admin/update")
    public String updateUser(long id, String email, String password, String firstname, String lastname, int age, String roles) {
//        password = userService.ifPasswordNull(id, password);
        Set<Role> roleSet = userService.getRoleForUser(roles);
        userService.updateUser(new User(id, email, password, firstname, lastname, age, roleSet));
        return "redirect:/admin/table";
    }

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
//        userService.addFirstAdminAndUser();
        return "login";
    }

    @GetMapping(value = "/user")
    public String userPage(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "user";
    }

    @GetMapping(value = "/admin/newUser")
    public String newUser(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "/newUser";
    }

}