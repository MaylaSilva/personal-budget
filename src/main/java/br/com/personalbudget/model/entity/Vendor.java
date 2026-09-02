package br.com.personalbudget.model.entity;

//import java.util.List;

import br.com.personalbudget.model.base.BasicRegistration;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vendors")
@Getter
@Setter
public class Vendor extends BasicRegistration{

    //@Column (name = "categories")
    //@OneToMany (mappedBy = "vendor")
    //private List<Category> categories;
}
