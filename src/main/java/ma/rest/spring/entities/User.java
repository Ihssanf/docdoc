package ma.rest.spring.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Keeping the TABLE_PER_CLASS strategy
@Table(name = "app_user") // Rename table to avoid conflict with H2 reserved keyword
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO is recommended for TABLE_PER_CLASS
    private long id;

    private String nom;
    private String email;
    private String password;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Document> documents;
}
