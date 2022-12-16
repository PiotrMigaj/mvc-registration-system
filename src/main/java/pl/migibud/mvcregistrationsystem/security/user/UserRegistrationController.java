package pl.migibud.mvcregistrationsystem.security.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
class UserRegistrationController {

    private final UserService userService;

    @GetMapping
    String getRegistrationForm(Model model){
        model.addAttribute("user",new CreateUserRequest());
        return "registration";
    }

    @PostMapping
    String registerUserAccount(@ModelAttribute("user") CreateUserRequest request){
        userService.save(request);
        return "redirect:/registration?success";
    }
}
