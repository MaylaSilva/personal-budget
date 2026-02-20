package br.com.personalbudget.model.base;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BasicRegistration extends Base{
    @Column(nullable=false)
    private String name;
}
