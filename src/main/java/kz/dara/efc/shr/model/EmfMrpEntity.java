package kz.dara.efc.shr.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "emf", name = "emf_mrp")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmfMrpEntity {
	@Id
	private Long id;
	
	
	@Column(name = "curator_comments")
	private String curatorComments;
	
	@Column(name = "experts_comments")
	private String expertsComments;
	
	@Column(name = "budget_ver_id")
	private Long budgetVerId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tsmamp")
	private Date tsmamp;
	@Temporal(TemporalType.DATE)
	@Column(name = "begin_date")
	protected Date beginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	protected Date endDate;
	
	private Long value;
	
	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		final EmfMrpEntity emfMrp = (EmfMrpEntity) o;
		return id != null && Objects.equals(id, emfMrp.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
