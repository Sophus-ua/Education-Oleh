package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import task_02.FileHandler;
import task_02.UserInformation;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class FormDataController {
    @RequestMapping(value = "/pass-data", method = RequestMethod.GET)
    public String passDataForm() {
        return "pass-data";
    }

    @PostMapping(value = "/pass-data")
    public ModelAndView passDataFromUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        System.out.println(user);
        new FileHandler().recordUserToFile(user);
        NumberOfRegistered.increaseCountOfUsers();

        modelAndView.setViewName("summary");
        modelAndView.addObject("user", user);
        modelAndView.addObject("countOfUsers", NumberOfRegistered.getCountOfUsers());
        return modelAndView;
    }

    @GetMapping(value = "/users-list")
    public ModelAndView userList() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInformation> usersCatalog = new FileHandler().getUsersDatabaseCatalog().getUsers();

        List<User> users = usersCatalog.stream()
                .map(x -> new User(x.getUserName(), x.getUserPassword()))
                .collect(Collectors.toList());

        for (User user: users){
            System.out.println(user.getName());
            System.out.println(user.getPassword());
        }

        modelAndView.setViewName("users-list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}




