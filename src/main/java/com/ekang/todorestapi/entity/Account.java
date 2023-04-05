package com.ekang.todorestapi.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(length = 120)
    private String password;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(nullable = false)
    private boolean isActive;

    public static Account createInstance(String email, String password, String firstName, String lastName) {
        Account account = new Account();
        account.email = email;
        account.password = password;
        account.firstName = firstName;
        account.lastName = lastName;
        return account;
    }

    public String getFullName() {
        if (!StringUtils.hasText(firstName) && !StringUtils.hasText(lastName)) return "";

        return (getFirstName() + " " + getLastName()).trim();
    }
}
