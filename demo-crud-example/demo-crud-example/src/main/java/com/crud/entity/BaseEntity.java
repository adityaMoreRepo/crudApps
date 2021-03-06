//package com.crud.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class BaseEntity {
//
//    @Id
//    private int id;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "created", nullable = false)
//    private Date created;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "updated", nullable = false)
//    private Date updated;
//
//    @PrePersist
//    protected void onCreate() {
//        updated = created = new Date();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updated = new Date();
//    }
//}
