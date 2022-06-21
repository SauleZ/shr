package kz.dara.efc.shr.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "emf", name = "emf_budget_type")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BudgetType {
	
	@Id
	private Long id;
	
	@Column(name = "name_ru")
	private String nameRu;
	
	@Column(name = "name_kz")
	private String nameKz;
	
	@Column(name = "budget_code")
	private String budgetCode;
	
	@Column(name = "curator_comment")
	private String curatorComment;
	
	@Column(name = "expert_comment")
	private String expertComment;
	
	@Column(name = "id_cons")
	@JsonIgnore
	private String idCons;
	
	@Column(name = "id_egz")
	@JsonIgnore
	private String idEgz;
	
	@Column(name = "id_iisk")
	@JsonIgnore
	private String idIisk;
	
	@Column(name = "id_isgp")
	@JsonIgnore
	private String idIsgp;
	
	@Column(name = "id_nbrk")
	@JsonIgnore
	private String idNbrk;
	
	@Column(name = "id_nsi")
	@JsonIgnore
	private String idNsi;
	
	@Column(name = "id_sfk")
	@JsonIgnore
	private String idSfk;
	
	@Column(name = "name_eng")
	@JsonIgnore
	private String nameEng;
	
	@Column(name = "budget_ver_id")
	private Long budgetVerId;
	
	@Column(name = "short_name_kz")
	private String shortNameKz;
	
	@Column(name = "short_name_ru")
	private String shortNameRu;
	
	private Timestamp tsmamp;
	
	@Column(name = "begin_date")
	private Date beginDate;
	
	@Column(name = "end_date")
	private Date endDate;
}
