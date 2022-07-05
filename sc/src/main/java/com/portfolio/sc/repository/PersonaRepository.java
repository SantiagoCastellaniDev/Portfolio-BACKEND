
// Interface Persona Repository

package com.portfolio.sc.repository;

import com.portfolio.sc.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
    
}
