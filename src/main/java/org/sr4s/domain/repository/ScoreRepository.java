package org.sr4s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.sr4s.domain.dto.ScoreDto;
import org.sr4s.domain.entity.GameResult;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<GameResult, Long> {
   /* @Query(nativeQuery = true, value =
            "WITH MaxUserScores AS (" +
                    "    SELECT" +
                    "        gr.user_seq," +
                    "        MAX(gr.score) AS max_score," +
                    "        MAX(gr.update_dt) as update_dt" +
                    "    FROM" +
                    "        game_result gr" +
                    "    WHERE" +
                    "        gr.deleted = false" +
                    "    AND" +
                    "        gr.create_dt between current_date and current_date+1" +
                    "    GROUP BY" +
                    "        gr.user_seq" +
                    ") " +
                    "SELECT" +
                    "    SUM(mus.max_score) AS score, " +
                    "    um.cntry_cd " +
                    "FROM" +
                    "    user_master um " +
                    "JOIN" +
                    "    MaxUserScores mus ON um.user_seq = mus.user_seq " +
                    "WHERE" +
                    "    um.deleted = false " +
                    "GROUP BY" +
                    "    um.cntry_cd " +
                    "ORDER BY" +
                    "    score DESC, MAX(mus.update_dt) ASC")*/
    List<ScoreDto> findCntryScoreList();
}
