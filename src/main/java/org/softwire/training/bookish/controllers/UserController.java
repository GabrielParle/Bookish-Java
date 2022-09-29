package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.database.User;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.models.page.UserPageModel;
import org.softwire.training.bookish.services.TechnologyService;
import org.softwire.training.bookish.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;




    @Controller
    @RequestMapping("/user")
    public class UserController {

        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @RequestMapping("")
        ModelAndView aboutUs() {

            List<User> allUser = userService.getAllUsers();

            UserPageModel userPageModel = new UserPageModel();
            userPageModel.setUsers(allUser);

            return new ModelAndView("User", "model", userPageModel);
        }

        @RequestMapping("/add-user")
        RedirectView addTechnology(@ModelAttribute User user) {

            userService.addUser(user);

            return new RedirectView("/user");
        }

        @RequestMapping("/delete-user")
        RedirectView deleteUser(@RequestParam int userID) {

            userService.deleteUser(userID);

            return new RedirectView("/user");
        }

        @RequestMapping("/update-user")
        RedirectView updateUser(@ModelAttribute  User user) {

            userService.updateUser(user);

            return new RedirectView("/user");
        }
    }

