package kz.dara.efc.shr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kz.dara.efc.shr.model.BudgetVerEntity;

@Repository
public interface BudgetVerRepository extends JpaRepository<BudgetVerEntity, Long> {
	@Query(nativeQuery = true, value = "SELECT b FROM nsi.nsi_dict_budget_ver b " +
			"WHERE b.status_id IN :budgetVerStatusId AND b.is_ebk = :isEbk AND b.is_income = :isIncome " +
			"AND b.parent_id = :parentId AND b.id = :budgetVerId AND b.id != 0  AND b.id != -99 " +
			"ORDER BY b.begin_date DESC NULLS LAST")
	List<BudgetVerEntity> find(@Param("budgetVerStatusId") List<Long> statusIds,
							   @Param("isEbk") Boolean isEbk,
							   @Param("isIncome") Boolean isIncome,
							   @Param("parentId") Long parentId,
							   @Param("budgetVerId") Long budgetVerId);
}
