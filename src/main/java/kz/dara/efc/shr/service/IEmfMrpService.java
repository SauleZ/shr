package kz.dara.efc.shr.service;

import kz.dara.efc.shr.model.EmfMrpEntity;

public interface IEmfMrpService {
	EmfMrpEntity search(Long finYearId, Long year, Long budgetVerId);
}
