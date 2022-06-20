package kz.dara.efc.shr.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BudgetVerDto {
	private Long id;
	private String nameRu;
	private String nameKz;
	private String shortNameRu;
	private String shortNameKz;
	private Long parentId;
	private Date beginDate;
	private Date endDate;
	private Date createDate;
	private Date updateDate;
	private Long statusId;
	private Long beginFinYearId;
	private Long beginFinYearValue;	
	private Long endFinYearId;
	private Long endFinYearValue;
	private Long orderNumber;
}
