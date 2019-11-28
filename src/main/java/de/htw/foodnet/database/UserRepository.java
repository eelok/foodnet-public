package de.htw.foodnet.database;

import de.htw.foodnet.database.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    <S extends User> S save(S entity);
    User findByName(String name);
}
