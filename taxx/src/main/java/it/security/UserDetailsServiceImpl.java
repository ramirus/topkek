package it.security;

import it.model.Driver;
import it.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Lazy
@Service(value = "detailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Lazy
    @Qualifier(value = "driverRepositoryImpl")
    private DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Driver> optionalDriver = driverRepository.findOneByEmail(s);
        if (optionalDriver.isPresent()) {
            return new UserDetailsImpl(optionalDriver.get());
        } else throw new SecurityException("Driver with that email not found");
    }
}
