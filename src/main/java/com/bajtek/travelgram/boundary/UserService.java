package com.bajtek.travelgram.boundary;

import com.bajtek.travelgram.entity.Authority;
import com.bajtek.travelgram.entity.AuthorityEnum;
import com.bajtek.travelgram.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    public void save(User user) {
        userRepository.save(user);
    }

    public void createUser(User userDraft) {
        User user = new User();
        user.setUsername(userDraft.getUsername());
        user.setPassword(preparePassword(userDraft.getPassword()));
        user.setEnabled(Boolean.TRUE);
        save(user);

        Authority authority = new Authority();
        authority.setUserId(user.getId());
        authority.setAuthority(AuthorityEnum.ROLE_USER);
        authorityService.save(authority);
    }

    private String preparePassword(String password) {
        return "{noop}" + password;
    }
}