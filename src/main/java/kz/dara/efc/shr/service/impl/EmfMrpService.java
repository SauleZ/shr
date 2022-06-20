package kz.dara.efc.shr.service.impl;

import static kz.dara.efc.shr.util.CommonUtils.beginOfYear;
import static kz.dara.efc.shr.util.CommonUtils.endOfYear;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import kz.dara.efc.shr.model.EmfMrpEntity;
import kz.dara.efc.shr.model.NsiDictFinYearEntity;
import kz.dara.efc.shr.repository.EmfMrpRepository;
import kz.dara.efc.shr.repository.NsiDictFinYearRepository;
import kz.dara.efc.shr.service.IEmfMrpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmfMrpService implements IEmfMrpService {
	
	private final NsiDictFinYearRepository nsiDictFinYearRepository;
	private final EmfMrpRepository emfMrpRepository;
	
	@Override
	public EmfMrpEntity search(final Long finYearId, final Long year, Long budgetVerId) {
		NsiDictFinYearEntity finYear = finYearId == null ? new NsiDictFinYearEntity() : nsiDictFinYearRepository.findFirstById(finYearId);
		Long actualYear = year == null ? finYear.getYear() : year;
		Date beginOfYear = beginOfYear(actualYear);
		Date endOfYear = endOfYear(actualYear);
		List<EmfMrpEntity> checkList = emfMrpRepository.find(beginOfYear, endOfYear, budgetVerId);
		if (checkList.isEmpty()){
			budgetVerId = 0L;
		}
		List<EmfMrpEntity> list = emfMrpRepository.find(beginOfYear, endOfYear, budgetVerId);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
