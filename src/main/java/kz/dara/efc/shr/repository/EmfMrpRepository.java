package kz.dara.efc.shr.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kz.dara.efc.shr.model.EmfMrpEntity;

@Repository
public interface EmfMrpRepository extends JpaRepository<EmfMrpEntity, Long> {
	
	@Query("SELECT e FROM EmfMrpEntity e " +
			"WHERE e.budgetVerId = :budgetVerId AND e.beginDate <= :endOfYear AND e.endDate >= :beginOfYear " +
			"ORDER BY e.beginDate DESC")
	List<EmfMrpEntity> find(@Param("beginOfYear") Date beginOfYear, @Param("endOfYear") Date endOfYear, @Param("budgetVerId") Long budgetVerId);
}
