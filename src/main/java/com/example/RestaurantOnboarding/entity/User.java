package com.example.RestaurantOnboarding.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(nullable = false , unique = true)
    private String fullname ;

    @Column(nullable = false,unique = true)
    @NonNull
    private String email ;

    @NonNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String status;

    @NotNull
    private Long phoneNo;

    @ManyToOne
    @JoinColumn(name ="role_id")
    private Role role;

}
