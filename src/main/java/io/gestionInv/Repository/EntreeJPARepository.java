package io.gestionInv.Repository;

import io.gestionInv.Persistance.EntreeJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntreeJPARepository extends JpaRepository<EntreeJPAEntity,Long> {

}
