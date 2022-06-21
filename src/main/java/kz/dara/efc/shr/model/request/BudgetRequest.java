package kz.dara.efc.shr.model.request;

import java.util.List;

import lombok.Data;

@Data
public class BudgetRequest {
	private List<Long> statusIds;
	private Boolean isEbk;
	private Boolean isIncome;
	private Long parentId;
	private Long sourceBudgetVerId;
	private Long budgetVerId;
}
