package com.senac.clima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.senac.clima.entities.RegistroMedicao;
@Repository
public interface RegistroMedicaoRepository extends JpaRepository<RegistroMedicao, Long> {
}
