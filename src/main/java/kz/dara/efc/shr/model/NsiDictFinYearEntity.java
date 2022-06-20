package kz.dara.efc.shr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema = "nsi", name = "nsi_dict_fin_year")
@Data
public class NsiDictFinYearEntity {
	@Id
	@SequenceGenerator(name = "NSI_DICT_FIN_YEAR_ID_GENERATOR", schema = "NSI", sequenceName = "NSI_DICT_FIN_YEAR_S", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NSI_DICT_FIN_YEAR_ID_GENERATOR")
	private Long id;
	
	private Long year;
}
