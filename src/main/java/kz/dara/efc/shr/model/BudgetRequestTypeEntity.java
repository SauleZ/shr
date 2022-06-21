package kz.dara.efc.shr.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "nsi", name = "nsi_dict_budget_request_type")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BudgetRequestTypeEntity {

    @Id
    private Long id;

    private String code;

    @Column(name = "name_ru", insertable = false, updatable = false)
    private String nameRu;

    @Column(name = "name_ru", insertable = false, updatable = false)
    private String nameKz;
    
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        final BudgetRequestTypeEntity that = (BudgetRequestTypeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
