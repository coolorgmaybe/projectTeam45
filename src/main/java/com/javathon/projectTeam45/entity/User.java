package com.javathon.projectTeam45.entity;

import com.javathon.projectTeam45.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Set;

/**
 * Класс пользователей <br>
 *     Пользователи хранятся в БД
 */
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Username can not be empty")
    @Column(name = "uname")
    private String username;

    @NotBlank(message = "Password can not be empty")
    @Column(name = "pwd")
    private String password;

    @Transient
    @NotBlank(message = "Password confirm can not be empty")
    private String password_2;

    @NotBlank(message = "Email can not be empty")
    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
            "+(?:[a-zA-Z]){2,}\\.?)$")

    @Column(name = "email")
    private String email;

    @Column(name = "region")
    private String region;

    private boolean isActive;

    @Column(name = "home_location")
    private String homeLocation;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "mostfrequency_location")
    private String mostFrequencyLocation;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Пользователь получает права, исходя из имеющихся ролей.
     *
     * @return роли пользователя
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Проверка на роль администратора
     *
     * @return true - если пользователь админ, fasle в ином другом случае
     */
    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getMostFrequencyLocation() {
        return mostFrequencyLocation;
    }

    public void setMostFrequencyLocation(String mostFrequencyLocation) {
        this.mostFrequencyLocation = mostFrequencyLocation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPassword_2() {
        return password_2;
    }

    public void setPassword_2(String password_2) {
        this.password_2 = password_2;
    }
}
