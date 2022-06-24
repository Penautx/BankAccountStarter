package com.example.start.currencies.currencyApp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "applicationuserrole")
public class ApplicationUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Long id;
    private String name;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<ApplicationUser> users;
}
