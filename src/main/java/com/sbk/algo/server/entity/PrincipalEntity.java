package com.sbk.algo.server.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "principal")
@SequenceGenerator(name = "principal_seq", sequenceName = "principal_seq")
public class PrincipalEntity extends BaseEntity {

    @Id
    @Column(name = "principal_id")
    @GeneratedValue(generator = "principal_seq")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int hashCode() {
        return Objects.hashCode(this.getLogin());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PrincipalEntity)) {
            return false;
        }
        PrincipalEntity that = (PrincipalEntity) o;
        return Objects.equals(that.getLogin(), this.getLogin());
    }
}
