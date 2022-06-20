package kz.dara.efc.shr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kz.dara.efc.shr.model.EmfMrpEntity;
import kz.dara.efc.shr.service.IEmfMrpService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/emf/mrp")
public class EmfMrpController {
	private final IEmfMrpService service;
	
	@GetMapping()
	public ResponseEntity<EmfMrpEntity> search(@RequestParam(value = "finYearId", required = false) Long finYearId,
											   @RequestParam(value = "year", required = false) Long year,
											   @RequestParam("budgetVerId") Long budgetVerId) {
		return ResponseEntity.ok(service.search(finYearId, year, budgetVerId));
	}
}
