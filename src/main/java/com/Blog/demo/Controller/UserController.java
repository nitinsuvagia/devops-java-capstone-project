package com.Blog.demo.Controller;

import com.Blog.demo.Repository.UserRepository;
import com.Blog.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index( Model model){
        List<User> userList=userRepository.findAll();
        model.addAttribute("UserList",userList);
        return "index";
    }

    @RequestMapping("/AddUser")
    public String AddUser(@ModelAttribute User user){
        return "AddUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute User user){
        userRepository.save(user);
        System.out.print("Saved Successfully");
        return "redirect:/";
    }
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id){
        userRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") Long id,Model model){
        model.addAttribute("userInfo",userRepository.findById(id));
        return "updateUser";
    }

    @RequestMapping("/updateUser")
   public String UpdateUser(HttpServletRequest request,@ModelAttribute("userInfo") User user){
        userRepository.save(user);
        return "redirect:/";

    }

}
