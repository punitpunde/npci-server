package processor.npci.features.bank_transaction.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import processor.npci.features.bank.entity.Bank;
import processor.npci.features.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank; // Linking with the Bank entity

    @Column(nullable = false, unique = true, length = 20)
    private String accountNumber;

    @Column(nullable = false, length = 11)
    private String ifscCode;

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
