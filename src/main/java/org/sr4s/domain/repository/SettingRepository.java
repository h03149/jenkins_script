package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.entity.Setting;
import org.sr4s.domain.entity.UserMaster;

import java.util.List;
import java.util.Optional;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {

   //Optional<Setting> findOneByUser(UserMaster user);
   Setting findOneByUser(UserMaster user);

}
