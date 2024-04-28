package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.entity.Keypad;
import org.sr4s.domain.entity.Theme;

import java.util.Optional;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    //Optional<Theme> findOneByThemeSeq(Long themeSeq);
    Theme findOneByThemeSeq(Long themeSeq);

}
