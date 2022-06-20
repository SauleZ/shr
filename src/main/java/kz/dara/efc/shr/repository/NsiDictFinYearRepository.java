package kz.dara.efc.shr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.dara.efc.shr.model.NsiDictFinYearEntity;

@Repository
public interface NsiDictFinYearRepository extends JpaRepository<NsiDictFinYearEntity, Long> {
	NsiDictFinYearEntity findFirstById(Long id);
}
