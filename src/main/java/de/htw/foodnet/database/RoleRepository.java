package de.htw.foodnet.database;

import de.htw.foodnet.database.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public
interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);
    @Override
    <S extends Role> S save(S entity);
}
