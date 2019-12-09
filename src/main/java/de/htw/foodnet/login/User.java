package de.htw.foodnet.login;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@EnableAutoConfiguration
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String name;

    @NotEmpty
    private String password;

    private boolean enabled;


    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
        )
    )
    private Collection<Role> roles;

}
