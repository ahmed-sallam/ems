package com.techpeak.ems.employee.models;

import com.techpeak.ems.company.models.Department;
import com.techpeak.ems.core.models.Address;
import com.techpeak.ems.core.models.Phone;
import com.techpeak.ems.employee.enumerations.GenderEnum;
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
@Entity(name="Personal")
@Table(name="personal")
@EntityListeners(AuditingEntityListener.class)
public class Personal {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;
    @Column( nullable = false)
    private String country;
    @Column(name="passport_no", nullable = false)
    private String passportNo;
    @Column( nullable = false)
    private String email;
    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    @ToString.Exclude
    private Department  department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personal", cascade =
            CascadeType.ALL)
    @ToString.Exclude
    private Set<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personal", cascade =
            CascadeType.ALL)
    @ToString.Exclude
    private Set<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personal", cascade =
            CascadeType.ALL)
    @ToString.Exclude
    private Set<Contract> contracts;

    @OneToOne(mappedBy = "personal", cascade = CascadeType.ALL)
    private Salary salary;

    @OneToOne(mappedBy = "personal", cascade = CascadeType.ALL)
    private Work work;
// todo: re check the relations
    @OneToOne(mappedBy = "manager")
    private Work manager;


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
        Personal personal = (Personal) o;
        return getId() != null && Objects.equals(getId(), personal.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}

