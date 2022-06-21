package kz.dara.efc.shr.service;

import java.util.List;

import kz.dara.efc.shr.dto.BudgetVerDto;
import kz.dara.efc.shr.model.request.BudgetRequest;

public interface IBudgetVerService {
	List<BudgetVerDto> getAll(BudgetRequest budgetRequest);
}
