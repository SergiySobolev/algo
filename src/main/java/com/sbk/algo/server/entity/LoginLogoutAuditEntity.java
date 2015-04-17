package com.sbk.algo.server.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loginlogoutaudit")
@SequenceGenerator(name = "loginlogoutaudit_seq", sequenceName = "loginlogoutaudit_seq")
public class LoginLogoutAuditEntity extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "loginlogoutaudit_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "principal_id", nullable = false)
    private PrincipalEntity principal;

    @Column(name = "in_time")
    @Type(type = "timestamp")
    private Date inTime = new Date();

    @Column(name = "out_time")
    @Type(type = "timestamp")
    private Date outTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PrincipalEntity getPrincipal() {
        return principal;
    }

    public void setPrincipal(PrincipalEntity principal) {
        this.principal = principal;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}
