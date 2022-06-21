package kz.dara.efc.shr.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "nsi", name = "nsi_dict_budget_ver_status")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BudgetVerStatusEntity {
	@Id
	private Long id;
	
	@Column(name = "name_ru")
	private String nameRu;
	
	@Column(name = "name_kz")
	private String nameKz;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "begin_date")
	private Date beginDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@Column(name = "last_update_date")
	private Date updateDate;
	
	@ManyToOne
	@JoinColumn(name = "create_by")
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(name = "last_update_by")
	private User updatedBy;
}
