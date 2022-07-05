
// Interface Skill Repository

package com.portfolio.sc.repository;

import com.portfolio.sc.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <Skill, Long> {
    
}
