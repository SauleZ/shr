package kz.dara.efc.shr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kz.dara.efc.shr.dto.BudgetVerDto;
import kz.dara.efc.shr.model.BudgetVerEntity;
import kz.dara.efc.shr.model.request.BudgetRequest;
import kz.dara.efc.shr.repository.BudgetVerRepository;
import kz.dara.efc.shr.service.IBudgetVerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BudgetVerService implements IBudgetVerService {
	
	private final BudgetVerRepository budgetVerRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<BudgetVerDto> getAll(BudgetRequest budgetRequest) {
		
		List<BudgetVerDto> budgetVerDtoList = mapList(budgetVerRepository.find(budgetRequest.getStatusIds(),
				budgetRequest.getIsEbk(), budgetRequest.getIsIncome(),
				budgetRequest.getParentId(), budgetRequest.getBudgetVerId()), BudgetVerDto.class);
		
		if (budgetRequest.getSourceBudgetVerId() != null) {
			BudgetVerEntity budgetVer = budgetVerRepository.findById(budgetRequest.getSourceBudgetVerId()).get();
			budgetVerDtoList = budgetVerDtoList.stream()
					.filter(bv ->
							bv.getBeginFinYearValue().equals(budgetVer.getBeginFinYear().getYear()) &&
									bv.getEndFinYearValue().equals(budgetVer.getEndFinYear().getYear()) &&
									bv.getId() != budgetRequest.getSourceBudgetVerId().longValue()
					)
					.collect(Collectors.toList());
		}
		return budgetVerDtoList;
	}
	
	private BudgetVerDto convertToDto(BudgetVerEntity post) {
		return modelMapper.map(post, BudgetVerDto.class);
	}
	
	<S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source
				.stream()
				.map(element -> modelMapper.map(element, targetClass))
				.collect(Collectors.toList());
	}
}
