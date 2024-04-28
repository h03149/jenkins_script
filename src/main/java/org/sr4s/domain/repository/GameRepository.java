package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.dto.ScoreDto;
import org.sr4s.domain.entity.GameResult;
import org.sr4s.domain.repository.wrapper.GameRepositoryWrapper;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameResult, Long>, QuerydslPredicateExecutor<GameResult> {

}
