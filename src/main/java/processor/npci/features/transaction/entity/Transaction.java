package processor.npci.features.transaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String senderVpa;

    @Column(nullable = false)
    private String receiverVpa; // Corrected typo

    @Column(nullable = false)
    private LocalDateTime initiatedAt; // Corrected typo

    private LocalDateTime completedAt; // Corrected typo

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
