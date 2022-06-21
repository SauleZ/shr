package kz.dara.efc.shr.model;


import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(schema = "nsi", name = "nsi_dict_fin_year")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FinYearEntity {

    @Id
    private Long id;
    private Long year;
    private Long beginDate;
    private Long endDate;
    
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        final FinYearEntity that = (FinYearEntity) o;
        return id != null && Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
