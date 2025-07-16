package io.gestionInv.Repository;

import io.gestionInv.Persistance.SortieJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortieJPARepository extends JpaRepository<SortieJPAEntity,Long> {

}
