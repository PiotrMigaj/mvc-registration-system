package pl.migibud.mvcregistrationsystem.security.user;

import org.springframework.security.core.userdetails.UserDetailsService;

interface UserService extends UserDetailsService {

    User save(CreateUserRequest request);

}
