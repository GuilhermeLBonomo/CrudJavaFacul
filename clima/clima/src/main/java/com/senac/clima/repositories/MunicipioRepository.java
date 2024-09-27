package com.senac.clima.repositories;

import com.senac.clima.entities.Municipio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
    @Transactional
    @Query(value = "UPDATE municipio SET municipio_status = -1 WHERE municipio_id = :id", nativeQuery = true)
    void apagarLogicoMunicipioPorId(@Param("id") Long id);
}
