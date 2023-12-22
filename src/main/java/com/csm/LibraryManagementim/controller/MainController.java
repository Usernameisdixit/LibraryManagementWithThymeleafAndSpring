package com.csm.LibraryManagementim.controller;

import java.util.*;

import com.csm.LibraryManagementim.model.Library;
import com.csm.LibraryManagementim.model.User;
import com.csm.LibraryManagementim.repository.LibraryRepository;
import com.csm.LibraryManagementim.repository.UserRepository;
import com.csm.LibraryManagementim.service.LibraryService;
import com.csm.LibraryManagementim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    LibraryService libraryService;

    @Autowired
    UserService userService;
    
    @Autowired
    LibraryRepository libraryRepository;

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        //List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        //
        // model.addAttribute("listProfession", listProfession);

        //Library library=new Library();
        //model.addAttribute("library",library);

        List<Library> libraries = libraryService.findAll();
        model.addAttribute("libraries", libraries);


        //Double fee=libraryService.getFeeBySubscriptionType()

        return "register_form";
    }


    @GetMapping("/get-fee")
    @ResponseBody
    public ResponseEntity<Double> getFee(@RequestParam(name = "subscription_type", required = false) String subscription_type) {
        try {
            System.out.println("value of subscription type"+subscription_type);
            if (subscription_type == null) {
                return ResponseEntity.badRequest().body(null);
            }
            System.out.println("going to service to get the fee value");
            Optional<Double> feeOptional = libraryService.getFeeBySubscriptionType(subscription_type);

            if (feeOptional.isPresent()) {
                Double subscription_fee = feeOptional.get();
                System.out.println("value of subscription fee" + subscription_fee);
                return ResponseEntity.ok(subscription_fee);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


        @PostMapping("/register")
        public String submitForm(@ModelAttribute("user") User user) {
            System.out.println(user);
            userRepository.save(user);
            //libraryRepository.save(library);
            return "register_success";
        }


    @GetMapping("/viewAll")
    public String displayLibraries(Model model) {
        //List<Library> libraries = libraryService.findAll();
        List<User> users = userService.getAllUsers();

        //model.addAttribute("libraries", libraries);
        model.addAttribute("users", users);

        return "redirect:/filerResults"; // Name of the Thymeleaf template
    }
    
    
    @GetMapping("/filerResults")
    public String getAllUsersWithLibraries(@RequestParam(name = "lib_name", required = false) String lib_name,
                                           @RequestParam(name = "subscription_type", required = false) String subscription_type,
                                           Model model) {
    
    
    List<User> users;
    List<Library> libraries1=libraryRepository.findAll();

    // Fetch based on both library name and type if both are provided
    if (lib_name != null && !lib_name.isEmpty() && subscription_type != null && !subscription_type.isEmpty()) {
        List<Library> libraries = libraryRepository.findByLib_nameAndSubscription_typeContainingIgnoreCase(lib_name, subscription_type);
        users = userRepository.findByLibraryIn(libraries);
    } 
    // Fetch based on library name only if it's provided
    else if (lib_name != null && !lib_name.isEmpty()) {
        List<Library> libraries = libraryRepository.findByLib_nameContainingIgnoreCase(lib_name);
        users = userRepository.findByLibraryIn(libraries);
    } 
    // Fetch based on library type only if it's provided
    else if (subscription_type != null && !subscription_type.isEmpty()) {
        List<Library> libraries = libraryRepository.findByLib_TypeContainingIgnoreCase(subscription_type);
        users = userRepository.findByLibraryIn(libraries);
    } 
    // Fetch all users if no filter is applied
    else {
        users = userRepository.findAll();
    }

    model.addAttribute("users", users);
    model.addAttribute("lib_name", lib_name); 
    model.addAttribute("subscription_type", subscription_type); 
   // model.addAttribute("refreshPage", true);
    model.addAttribute("libraries1", libraries1);

    return "view";



    }
}