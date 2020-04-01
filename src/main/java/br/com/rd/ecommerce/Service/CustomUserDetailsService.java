//package br.com.rd.ecommerce.Service;
//
//
//import br.com.rd.ecommerce.model.Client;
//import br.com.rd.ecommerce.repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    ClientRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
//
//        Client cliente = repository.findByMail(mail);
//
//        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList();
//        return new User(
//                cliente.getMail(),
//                cliente.getPassword(),
//                authorityList
//        );
//    }
//}