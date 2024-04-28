package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.entity.Keypad;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeypadRepository extends JpaRepository<Keypad, Long> {

    //Optional<Keypad> findOneByKeypadSeq(Long keypadSeq);

    Keypad findOneByKeypadSeq(Long keypadSeq);
}
