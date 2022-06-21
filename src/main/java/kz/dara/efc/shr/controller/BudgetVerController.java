package kz.dara.efc.shr.controller;

import java.util.List;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.dara.efc.shr.dto.BudgetVerDto;
import kz.dara.efc.shr.model.request.BudgetRequest;
import kz.dara.efc.shr.service.IBudgetVerService;
import lombok.RequiredArgsConstructor;

/******* GET http://192.168.204.93:8080/isbp-staff/webapi/budgetVers?isEbk=false&isIncome=false&parentId=65 *******/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/emf/mrp/budgetVers")
public class BudgetVerController {
	private final IBudgetVerService budgetVerService;
	
	@GetMapping
	public ResponseEntity<List<BudgetVerDto>> getAll(@ParameterObject BudgetRequest budgetRequest){
		return ResponseEntity.ok(budgetVerService.getAll(budgetRequest));
	}


//	@GET
//	@Path("{budgetVerId : \\d+}")
//	public Response get(@PathParam("budgetVerId") Long budgetVerId) {
//		Optional<BudgetVer> budgetVer = Optional.ofNullable(budgetVerService.findById(budgetVerId));
//        return Response.ok()
//            .entity( budgetVer.map(toBudgetVerDto).orElseThrow( () -> new WebApplicationException(SC_NOT_FOUND)) )
//            .build();
//	}
//
//	@Inject private BudgetVerService budgetVerService;
}
