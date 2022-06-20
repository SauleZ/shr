package kz.dara.efc.shr.controller;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.dara.efc.shr.dto.BudgetVerDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/emf/mrp")
public class BudgetVerController {

	@GetMapping
	public ResponseEntity<List<BudgetVerDto>> getAll(
			@QueryParam("budgetVerStatusId") List<Long> statusIds,
			@QueryParam("isEbk") Boolean isEbk,
			@QueryParam("isIncome") Boolean isIncome,
			@QueryParam("parentId") Long parentId,
            @QueryParam("sourceBudgetVerId") Long sourceBudgetVerId,
            @QueryParam("budgetVerId") Long budgetVerId){
		Query query = Query.builder()
				.set("statusId", IN, statusIds)
				.set("isEbk", isEbk)
				.set("parentId", parentId)
                .set("id",budgetVerId)
				.set("isIncome", isIncome)
				.orderBy("beginFinYear.year")
				.orderBy("beginFinYear.beginDate")
				.build();

		List<BudgetVerDto> budgetVerDtoList = budgetVerService.find(query).stream()
				.filter(bv -> bv.getId() != 0L && bv.getId() != -99 )
				.sorted(Comparator.comparing(BudgetVer::getOrderNumber))
				.map( toBudgetVerDto )
				.collect(Collectors.toList());

		if (sourceBudgetVerId != null) {
			BudgetVer budgetVer = budgetVerService.findById(sourceBudgetVerId);
            budgetVerDtoList = budgetVerDtoList.stream()
                    .filter(bv ->
                        bv.getBeginFinYearValue().equals(budgetVer.getBeginFinYear().getYear()) &&
                        bv.getEndFinYearValue().equals(budgetVer.getEndFinYear().getYear())     &&
                        bv.getId() != sourceBudgetVerId.longValue()
                    )
                    .collect(Collectors.toList());
        }


		return Response.ok()
				.entity(new GenericEntity<Collection<BudgetVerDto>>(budgetVerDtoList){})
				.build();
	}


	@GET
	@Path("{budgetVerId : \\d+}")
	public Response get(@PathParam("budgetVerId") Long budgetVerId) {
		Optional<BudgetVer> budgetVer = Optional.ofNullable(budgetVerService.findById(budgetVerId));
        return Response.ok()
            .entity( budgetVer.map(toBudgetVerDto).orElseThrow( () -> new WebApplicationException(SC_NOT_FOUND)) )
            .build();
	}

	@Inject private BudgetVerService budgetVerService;
}
