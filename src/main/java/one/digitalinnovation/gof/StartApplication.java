package one.digitalinnovation.gof;

import one.digitalinnovation.gof.model.User;
import one.digitalinnovation.gof.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = repository.findByUsername("admin");
        if(user == null) {
            user = new User();
            user.setName("Administrador");
            user.setUsername("admin");
            user.setPassword("adm123");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
    }
}
