package com.techpeak.ems.employee.models;

import com.techpeak.ems.core.models.Address;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Salary")
@Table(name="salary")
@EntityListeners(AuditingEntityListener.class)
public class Salary {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private Integer amount;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personal_id", nullable = false)
    private Personal personal;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salary", cascade =
            CascadeType.ALL)
    @ToString.Exclude
    private Set<SalaryAddition> salaryAdditions;


    @CreatedDate
    @Column(name="created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Salary salary = (Salary) o;
        return getId() != null && Objects.equals(getId(), salary.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
