//package com.example.codereviewstudy.domain.common;
//
//
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public class baseEntity {
//
//    @CreatedDate
//    @Column(updatable = false)
//    private String createdAt;
//
//    @LastModifiedDate
//    private String modifiedAt;
//
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getModifiedAt() {
//        return modifiedAt;
//    }
//
//    public void setModifiedAt(String modifiedAt) {
//        this.modifiedAt = modifiedAt;
//    }
//
//    @PrePersist
//    public void onPrePersist() {
//        createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
//        modifiedAt = createdAt;
//    }
//
//    @PreUpdate
//    public void onPreUpdate() {
//        modifiedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
//    }
//}
