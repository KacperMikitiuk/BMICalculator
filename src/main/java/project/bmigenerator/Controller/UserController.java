package project.bmigenerator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.bmigenerator.Model.User;
import project.bmigenerator.Repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    private String create(ModelMap map){
        map.put("user", new User());
        return "home";
    }
    @GetMapping("/result")
    public String result(ModelMap map){
        map.put("users", userRepository.findAll());
        return "result";
    }
    @GetMapping("/result/add")
    public String add(@ModelAttribute User user, @RequestParam String sex, ModelMap map){
        user.setSex(sex);
        user.bmiCounter();
        userRepository.save(user);
        map.put("users", userRepository.findAll());
        return "redirect:/result";
    }
    @GetMapping("/{id}/deleting")
    private String delete(@PathVariable Integer id){
        userRepository.deleteById(id);
        return "redirect:/result";
    }
}
