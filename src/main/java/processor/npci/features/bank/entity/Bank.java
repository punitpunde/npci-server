package processor.npci.features.bank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import processor.npci.features.bank.enums.CommunicationType;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String shortCode; // Example: SBI, ICICI, HDFC

    @Column(nullable = false, unique = true)
    private String serverUrl; // REST API base URL

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private CommunicationType communicationType; // REST or KAFKA

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
