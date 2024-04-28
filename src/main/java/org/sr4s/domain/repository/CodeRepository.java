package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.entity.ComCdDtl;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository<ComCdDtl, Long> {

    //Optional<List<ComCdDtl>> findByCdGrp(String cdGrp);
    List<ComCdDtl> findByCdGrp(String cdGrp);
}
