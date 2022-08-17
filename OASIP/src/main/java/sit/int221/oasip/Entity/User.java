package sit.int221.oasip.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private role role;

    @CreationTimestamp
    @Column(name = "createdOn", nullable = false, insertable = false)
    private Timestamp createdOn;

    @UpdateTimestamp
    @Column(name = "updatedOn", nullable = false, updatable = false)
    private Timestamp updatedOn;

//    @OneToMany(mappedBy = "userUserid")
//    private Set<Event> events = new LinkedHashSet<>();

}