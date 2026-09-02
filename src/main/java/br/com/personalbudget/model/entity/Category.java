package br.com.personalbudget.model.entity;

import br.com.personalbudget.model.base.BasicRegistration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="category")
@Getter
@Setter
public class Category extends BasicRegistration{
    @Column (name = "color", nullable = false)
    private String color;

    @Column (name = "icon", nullable = false)
    private String icon;
}
