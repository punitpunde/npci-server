package processor.npci.features.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @UuidGenerator
    private String userId;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true, length = 15)
    private String mobileNumber;

    @Column(unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
