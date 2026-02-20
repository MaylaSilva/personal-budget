package br.com.personalbudget.model.base;
import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Base {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    protected UUID id;

    @Column(updatable=false)
    private OffsetDateTime createdAt;

    @PrePersist
    protected void onCreate (){
        this.createdAt= OffsetDateTime.now();
    }
}
