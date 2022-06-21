package kz.dara.efc.shr.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
public class NsiDictFinYearEntity {
	
	@Id
	@SequenceGenerator(name = "NSI_DICT_FIN_YEAR_ID_GENERATOR", schema = "NSI", sequenceName = "NSI_DICT_FIN_YEAR_S", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NSI_DICT_FIN_YEAR_ID_GENERATOR")
	private Long id;
	
	private Long year;
	
	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		final NsiDictFinYearEntity that = (NsiDictFinYearEntity) o;
		return id != null && Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
