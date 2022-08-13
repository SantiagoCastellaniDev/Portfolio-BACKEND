
// REPOSITORY Rol

package com.portfolio.sc.security.repository;

import com.portfolio.sc.security.entity.Rol;
import com.portfolio.sc.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}