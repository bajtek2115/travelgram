package com.bajtek.travelgram.boundary;

import com.bajtek.travelgram.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public void save(Authority authority) {
        authorityRepository.save(authority);
    }
}
