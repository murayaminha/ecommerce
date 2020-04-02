package br.com.rd.ecommerce.Service;


import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;


@Component
public class CustomUserDetailsService implements UserDetailsService {


    private final ClientRepository clientRepository;

    @Autowired
    public CustomUserDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = Optional.ofNullable(clientRepository.findByMail(email)).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");


        return new User(client.getMail(), client.getPassword(), client.isAdmin() ? authorityListUser : authorityListAdmin);
    }

}